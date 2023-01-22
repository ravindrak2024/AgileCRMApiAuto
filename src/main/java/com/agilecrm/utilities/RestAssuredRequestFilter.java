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

    Response response = ctx.next(requestSpec, responseSpec);
    List<Integer> errorStatusCodes= Arrays.asList(400,401,403,404,500,503);
    if (errorStatusCodes.contains(response.statusCode())) {
      log.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
              response.getStatusCode() + " " + response.getStatusLine());
    }
    log.info(requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() +"|"+requestSpec.getFormParams()+ "\n Response Status => " +
            response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody());
    return response;


  }
}
