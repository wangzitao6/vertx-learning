package com.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

/**
 * TODO
 *
 * @Author wangzt29
 * @Date 2022/6/24 14:44
 * @Version 1.0.0
 */
public class ComposeVerticle extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx.vertx().deployVerticle("com.core.ComposeVerticle");
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      this.demo1().compose(ig-> this.demo2()).compose(ig-> this.demo3());
    }

    private Future<Void> demo1(){
        System.out.println("this is one");
        return Future.succeededFuture();
    }
    private  Future<Void> demo2(){
        System.out.println("this is two");
        return Future.succeededFuture();
    }
    private  Future<Void> demo3(){
        System.out.println("this is three");
        return Future.succeededFuture();
    }


}
