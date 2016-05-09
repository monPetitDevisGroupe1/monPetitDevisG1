package tp.main;


import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
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
import io.vertx.ext.web.handler.BodyHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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

        router.route().handler(BodyHandler.create());
        router.route().handler(context -> {

            context.response().headers().add(HttpHeaders.CONTENT_TYPE, "application/json");
            context.response().headers().add("content-type", "text/html;charset=UTF-8");

            context.response()
                    // do not allow proxies to cache the data
                    .putHeader("Cache-Control", "no-store, no-cache")
                    // prevents Internet Explorer from MIME - sniffing a
                    // response away from the declared content-type
                    .putHeader("X-Content-Type-Options", "nosniff")
                    // Strict HTTPS (for about ~6Months)
                    .putHeader("Strict-Transport-Security", "max-age=" + 15768000)
                    // IE8+ do not allow opening of attachments in the context
                    // of this resource
                    .putHeader("X-Download-Options", "noopen")
                    // enable XSS for IE
                    .putHeader("X-XSS-Protection", "1; mode=block")
                    // deny frames
                    .putHeader("X-FRAME-OPTIONS", "DENY")
                    // Accept all
                    .putHeader("Access-Control-Allow-Origin", "*");

            System.out.println("handle -> " + context.request().path());

            context.next();
        });

        Route route = router.route(HttpMethod.POST, "/login");
        route.handler(routingContext -> {
            System.out.println("handle2 -> " + routingContext.request().path());
            String username = routingContext.getBodyAsJson().getString("username");

            //String mdp = routingContext.getBodyAsJson().getString("password");
            String mdpcible = routingContext.getBodyAsJson().getString("password");
            System.out.println("MDP Cible : " + mdpcible);
            JsonObject mySQLClientConfig = new JsonObject();
            mySQLClientConfig.put("host", "localhost");
            mySQLClientConfig.put("port", 3306);
          //  mySQLClientConfig.put("maxPoolSize", 10);
            mySQLClientConfig.put("username", "MPD");
            mySQLClientConfig.put("password", "kebab");
            mySQLClientConfig.put("database", "mon-petit-vertx");

            AsyncSQLClient mySQLClient = MySQLClient.createShared(vertxVariable, mySQLClientConfig);
            System.out.println("connexion sql creation " + mySQLClient);
            mySQLClient.getConnection(res -> {
                System.out.println(res.cause());
                System.out.println("connexion sql" + res.succeeded() );
                JsonObject reponseVertx = new JsonObject();
                if (res.succeeded()) {
                    System.out.println("connexion reussi username :"+username);
                    SQLConnection connection = res.result();
                    System.out.println("connexion - avant requete  :"+res.result());
                    try {
                        System.out.println("SELECT * from user WHERE pseudo='" + username + "'");
                        connection.query("SELECT * from user WHERE pseudo='" + username + "'", res2 -> {
                            System.out.println("requete  :" + res2.result().getNumRows());
                            if (res2.result().getNumRows() > 0) {
                                ResultSet resultSet = res2.result();
                                List<JsonArray> results = resultSet.getResults();
                                JWTAuth jwt = JWTAuth.create(vertxVariable, new JsonObject()
                                        .put("keyStore", new JsonObject()
                                                .put("type", "jceks")
                                                .put("path", "keystore.jceks")
                                                .put("password", "secret")));

                                for (JsonArray row : results) {
                                    int id = row.getInteger(0);
                                    String password = row.getString(2);
                                    String token = jwt.generateToken(new JsonObject(), new JWTOptions().setExpiresInSeconds(60L));
                                    System.out.println("mdp est :"+password);
                                    PasswordEncoder bcEncoder = new BCryptPasswordEncoder();
                                    Boolean b = bcEncoder.matches(mdpcible, password);
                                    System.out.println(b);
                                    if (b) {
                                        reponseVertx.put("statut", "OK");
                                        reponseVertx.put("id", id);
                                        reponseVertx.put("token", token);
                                        routingContext.response().end(reponseVertx.encode());
                                    } else {
                                        reponseVertx.put("statut", "ERROR");
                                        reponseVertx.put("raison", "mdp");
                                        routingContext.response().end(reponseVertx.encode());
                                    }

                                }
                            } else {
                                reponseVertx.put("statut", "ERROR");
                                reponseVertx.put("raison", "username");
                                routingContext.response().end(reponseVertx.encode());
                            }
                        });
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("echec " + res.result());
                    reponseVertx.put("statut", "ERROR");
                    reponseVertx.put("raison", "RESEAU");
                    routingContext.response().end(reponseVertx.encode());
                }
                routingContext.response().putHeader("content-type", "type/text");
            });


        });

        Route route2 = router.route(HttpMethod.POST, "/signIn");
        route2.handler(routingContext2 -> {

            String username = routingContext2.getBodyAsJson().getString("username");
            String mdp = routingContext2.getBodyAsJson().getString("password");
            String mdpCrypt = new BCryptPasswordEncoder().encode(mdp);
            JsonObject mySQLClientConfig = new JsonObject();
            mySQLClientConfig.put("host", "localhost");
            mySQLClientConfig.put("port", 3306);
            //  mySQLClientConfig.put("maxPoolSize", 10);
            mySQLClientConfig.put("username", "MPD");
            mySQLClientConfig.put("password", "kebab");
            mySQLClientConfig.put("database", "mon-petit-vertx");

            AsyncSQLClient mySQLClient2 = MySQLClient.createShared(vertxVariable, mySQLClientConfig);
            System.out.println("connexion sql creation " + mySQLClient2);
            mySQLClient2.getConnection(sql -> {
                System.out.println(sql.cause());
                System.out.println("connexion sql :" + sql.succeeded() );
                JsonObject reponseVertx2 = new JsonObject();
                if (sql.succeeded()) {

                    SQLConnection connection = sql.result();
                    try {
                        connection.queryWithParams("INSERT INTO user (pseudo, mdp) VALUES (?,?)",
                                new JsonArray().add(username).add(mdpCrypt), res2 -> {
                            System.out.println("requete  :" + res2.result());
                            if (res2.succeeded()) {
                                JWTAuth jwt = JWTAuth.create(vertxVariable, new JsonObject()
                                        .put("keyStore", new JsonObject()
                                                .put("type", "jceks")
                                                .put("path", "keystore.jceks")
                                                .put("password", "secret")));
                                String token = jwt.generateToken(new JsonObject(), new JWTOptions().setExpiresInSeconds(60L));
                                reponseVertx2.put("statut", "OK");
                                reponseVertx2.put("token", token);
                                routingContext2.response().end(reponseVertx2.encode());

                            } else {
                                reponseVertx2.put("statut", "ERROR");
                                reponseVertx2.put("raison", "INSERT");
                                routingContext2.response().end(reponseVertx2.encode());
                            }
                        });
                    } catch ( Exception e ) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("echec " + sql.result());
                    reponseVertx2.put("statut", "ERROR");
                    reponseVertx2.put("raison", "RESEAU");
                    routingContext2.response().end(reponseVertx2.encode());
                }
                routingContext2.response().putHeader("content-type", "type/text");
            });
        });
        vertxVariable.createHttpServer().requestHandler(router::accept).listen(8081);
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
