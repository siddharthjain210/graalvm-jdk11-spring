package com.graalvm.demo.lambda;

import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PlainRestAPIRequestFunctionHandler
  implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {

  @Override
  public AwsProxyResponse handleRequest(
    AwsProxyRequest input,
    Context context
  ) {
    log.info("inside Request Handler");
    return new AwsProxyResponse(200);
  }
}
