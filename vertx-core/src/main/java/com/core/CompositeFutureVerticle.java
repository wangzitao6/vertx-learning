package com.core;

import io.vertx.core.*;

/**
 * TODO
 *
 * @Author wangzt29
 * @Date 2022/7/4 10:40
 * @Version 1.0.0
 */
public class CompositeFutureVerticle extends AbstractVerticle {
    public static void main(String[] args) {
        Vertx.vertx().deployVerticle("com.core.CompositeFutureVerticle");
    }

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        Future<Void> future1 =this.demo1();
        Future<Void> future2 =this.demo2();
        CompositeFuture.all(future1,future2).onComplete(re->{
            if (re.succeeded()){
                System.out.println("success");
            }else {
                System.out.println("fail");
            }
        });
    }



    private Future<Void> demo1(){
        System.out.println("this is one");
        return Future.succeededFuture();
    }
    private  Future<Void> demo2(){
        System.out.println("this is two");
        return Future.succeededFuture();
    }
}
