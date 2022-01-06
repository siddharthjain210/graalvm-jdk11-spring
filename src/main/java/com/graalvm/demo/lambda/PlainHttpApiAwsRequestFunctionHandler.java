package com.graalvm.demo.lambda;

import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.model.HttpApiV2ProxyRequest;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PlainHttpApiAwsRequestFunctionHandler
  implements RequestHandler<HttpApiV2ProxyRequest, AwsProxyResponse> {

  @Override
  public AwsProxyResponse handleRequest(
          HttpApiV2ProxyRequest input,
    Context context
  ) {
    log.info("inside Request Handler");
    return new AwsProxyResponse(200);
  }
}
