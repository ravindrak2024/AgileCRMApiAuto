package com.agilecrm.clients;

import com.agilecrm.config.Environment;
import com.agilecrm.core.Command;
import com.agilecrm.core.HttpMethod;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
public class BaseClient {

  @Autowired
  protected Environment environment;

  protected String env="/"+System.getProperty("env");

  protected BasicAuthScheme getBasicAuthScheme(){
    BasicAuthScheme basicAuthScheme=new BasicAuthScheme();
    basicAuthScheme.setPassword(environment.getPassword());
    basicAuthScheme.setUserName(environment.getUsername());
    return basicAuthScheme;
  }


  protected Response executeRaw(HttpMethod httpMethod,Object body,String basePath, Map<String,String> headers) {
    headers.put("Accept","application/json");

    Command command= new Command.CommandBuilder(null)
            .withBaseURI(environment.getBaseUri())
            .withBasicAuthScheme(getBasicAuthScheme())
            .withBasePath(env+basePath)
            .withHeaders(headers)
            .withBody(body)
            .withMethod(httpMethod)
            .build();

    return command.executeAndGetResponse();
  }

}
