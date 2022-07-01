package com.core;

import io.vertx.core.*;

/**
 * TODO
 *
 * @Author wangzt29
 * @Date 2022/6/24 14:44
 * @Version 1.0.0
 */
public class mainVerticle  extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx.vertx().deployVerticle("com.core.mainVerticle");
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
      this.demo1().compose(ig-> this.demo2()).compose(ig-> this.demo3());
    }

    private Future<String> demo1(){
        System.out.println("this is one");
        return Future.succeededFuture("111");
    }
    private  Future<String> demo2(){
        System.out.println("this is two");
        return Future.succeededFuture("222");
    }
    private  Future<String> demo3(){
        System.out.println("this is three");
        return Future.succeededFuture("333");
    }


}
