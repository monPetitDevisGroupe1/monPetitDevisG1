package tp.main;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.asyncsql.AsyncSQLClient;
import io.vertx.ext.asyncsql.MySQLClient;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.auth.jwt.JWTOptions;
import io.vertx.ext.web.RoutingContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import java.security.Key;
import java.security.KeyStore;
import java.util.List;

import static io.vertx.core.impl.Arguments.require;

/**
 * Created by Nico on 18/02/2016.
 */
public class VerticleRunner {

    public static void main(String[] args) {
        Vertx vertxVariable = Vertx.vertx();
        Router router = Router.router(vertxVariable);
        Route route = router.route(HttpMethod.POST, "/connexion/:username/:mdp/");




        route.handler(routingContext -> {
            String username = routingContext.request().getParam("pseudo");
            String mdp = routingContext.request().getParam("mdp");
            //mdp = new BCryptPasswordEncoder().encode(mdp);
            JsonObject mySQLClientConfig = new JsonObject();
            mySQLClientConfig.put("host", "localhost");
            mySQLClientConfig.put("port", 3306);
            mySQLClientConfig.put("maxPoolSize", 10);
            mySQLClientConfig.put("username", "root");
            mySQLClientConfig.put("password", "");
            mySQLClientConfig.put("database", "mon-petit-devis");

            AsyncSQLClient mySQLClient = MySQLClient.createShared(vertxVariable, mySQLClientConfig);
            mySQLClient.getConnection(res -> {
                JsonObject reponseVertx = new JsonObject();
                if (res.succeeded()) {
                    SQLConnection connection = res.result();
                    connection.query("SELECT * from mon-petit-vertx WHERE pseudo='"+username+"'", res2 -> {
                        if (res2.succeeded()) {
                            ResultSet resultSet = res2.result();
                            List<JsonArray> results = resultSet.getResults();
                            try {
                                genereKeystore();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            JWTAuth jwt = JWTAuth.create(vertxVariable, new JsonObject()
                                    .put("keyStore", new JsonObject()
                                            .put("type", "jceks")
                                            .put("path", "keystore.jceks")
                                            .put("password", "secret")));

                            for (JsonArray row : results) {
                                String id = row.getString(0);
                                String password = row.getString(2);

                                if (mdp.equals(password)) {
                                    reponseVertx.put("statut", "OK");
                                    reponseVertx.put("id", id);
                                    reponseVertx.put("token", jwt.generateToken(new JsonObject(), new JWTOptions().setExpiresInSeconds(60L)));
                                } else {
                                    reponseVertx.put("statut", "ERROR|mdp");
                                }

                            }
                        } else {
                            reponseVertx.put("statut", "ERROR|username");
                        }});
                } else {
                    reponseVertx.put("statut", "ERROR|reseau");
                }
                routingContext.response().putHeader("content-type", "type/text");
                routingContext.response().end(reponseVertx.encodePrettily());
            });


        });
        vertxVariable.createHttpServer().requestHandler(router::accept).listen(8080);
    }
    public static void genereKeystore() throws Exception {
        File file = new File("keystore.jceks");
        String pw = "secret";
        final KeyStore keyStore = KeyStore.getInstance("JCEKS");
        if (file.exists()) {
            keyStore.load(new FileInputStream(file), pw.toCharArray());
        } else {
            keyStore.load(null, null);
            keyStore.store(new FileOutputStream("keystore.jceks"), pw.toCharArray());
        }
    }
}
