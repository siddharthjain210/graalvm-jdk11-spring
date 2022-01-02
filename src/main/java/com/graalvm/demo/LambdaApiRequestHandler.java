package com.graalvm.demo;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LambdaApiRequestHandler
  implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {
  private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

  static {
    try {
      handler =
        SpringBootLambdaContainerHandler.getAwsProxyHandler(
          DemoApplication.class
        );
      // If you are using HTTP APIs with the version 2.0 of the proxy model, use the getHttpApiV2ProxyHandler
      // method: handler = SpringBootLambdaContainerHandler.getHttpApiV2ProxyHandler(Application.class);
    } catch (ContainerInitializationException e) {
      // if we fail here. We re-throw the exception to force another cold start
      e.printStackTrace();
      throw new RuntimeException(
        "Could not initialize Spring Boot application",
        e
      );
    }
  }

  @Override
  public AwsProxyResponse handleRequest(
    AwsProxyRequest input,
    Context context
  ) {
    log.info("inside Request Handler");
    return handler.proxy(input, context);
  }
}
