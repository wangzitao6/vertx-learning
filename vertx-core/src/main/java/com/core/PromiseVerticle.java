package com.core;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;

public class PromiseVerticle extends AbstractVerticle {
  public static void main(String[] args) {
    Vertx.vertx().deployVerticle("com.core.PromiseVerticle");
  }

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Future<String> future = this.world("");
    future.compose(s -> this.your(s)).compose(s -> this.hello(s)).onComplete(re -> {
      if (re.succeeded()) {
        System.out.println("result: " + re.result());
      } else {
        System.out.println("case: " + re.cause());
      }
    });
  }
  private Future<String> hello(String str) {
    Promise<String> promise = Promise.promise();
    promise.complete("hello "+str);
    return promise.future();
  }

  private Future<String> your(String str) {
    Promise<String> promise = Promise.promise();
    promise.complete("your "+str);
    return promise.future();
  }

  private Future<String> world(String str) {
    Promise<String> promise = Promise.promise();
    promise.complete("world "+str);
    return promise.future();
  }

}
