package com.agilecrm.utilities;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

public class RestAssuredRequestFilter implements Filter {
  Logger log=LogInitilizer.getLogger();

  @Override
  public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec, FilterContext ctx) {
    log.info("_______________\n Executing api with "+getLogRecord(requestSpec));
    Response response = ctx.next(requestSpec, responseSpec);
    List<Integer> errorStatusCodes= Arrays.asList(400,401,403,404,500,503);
    if (errorStatusCodes.contains(response.statusCode())) {
      log.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
              response.getStatusCode() + " " + response.getStatusLine());
    }
   /* log.info(requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() +"|"+requestSpec.getFormParams()+ "\n Response Status => " +
            response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody());*/
    log.info("\n Response of api  "+getLogRecord(response));
    return response;


  }

  private String getLogRecord(Object obj){
    String logRecord="\n\t";
    if(obj instanceof FilterableRequestSpecification){
      FilterableRequestSpecification requestSpec=(FilterableRequestSpecification)obj;
      logRecord=logRecord+"with Base URI  : "+requestSpec.getBaseUri()+"\n\t";
      logRecord=logRecord+"with Base path : "+requestSpec.getBasePath()+"\n\t";
      logRecord=logRecord+"with Method    : "+requestSpec.getMethod()+"\n\t";
      logRecord=logRecord+"with Body      : "+requestSpec.getBody()+"\n\t";
      logRecord=logRecord+"with Headers   : "+requestSpec.getHeaders()+"\n\t";
    }else if(obj instanceof Response){
      Response responseSpec=(Response)obj;
      logRecord=logRecord+"status Code       : "+responseSpec.getStatusCode()+"\n\t";
      logRecord=logRecord+"status Message    : "+responseSpec.getStatusLine()+"\n\t";
      logRecord=logRecord+"response Body     : "+responseSpec.getBody()+"\n\t";

    }
    return logRecord;
  }

}
