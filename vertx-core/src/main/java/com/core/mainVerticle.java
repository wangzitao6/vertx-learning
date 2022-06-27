package com.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;

/**
 * TODO
 *
 * @Author wangzt29
 * @Date 2022/6/24 14:44
 * @Version 1.0.0
 */
public class mainVerticle  extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
    }

    private void demo(){
        //    Vertx vertx = Vertx.vertx();
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(20));
        vertx.setPeriodic(1000, id -> {
            // This handler will get called every second
            System.out.println("timer fired!");
        });
    }

}
