package com.core;

import io.vertx.core.*;

/**
 * 1、verticle是vert.x中可被部署运行的最小代码块，可以理解为一个verticle就是一个最小化的业务处理引擎。 一个应用程序可以是单个verticle或者由EventBus通信的多个verticles构成。
 * 2、verticle被发布部署后，会调用其内部的start方法，开始业务逻辑处理，完成后会调用stop方法，对该代码块执行销毁动作。
 * 3、Verticles在Vert.x实例中运行。 一个Vertx可以承载多个verticles，每个Vert.x实例在其私有的JVM实例运行。 一台服务器可以运行一个或多个Vert.x实例（建议运行Vertx实例的数量和CPU核数相关）。
 * 4、一个Vert.x实例，保证其承载的verticles实例总是在同一个线程执行， 并发Vert.x 是单线程的。
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
