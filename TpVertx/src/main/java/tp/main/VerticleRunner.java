package tp.main;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;

/**
 * Created by Nico on 18/02/2016.
 */
public class VerticleRunner {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(VerticleFront.class.getCanonicalName());
        vertx.deployVerticle(VerticleService.class.getCanonicalName());
    }

}
