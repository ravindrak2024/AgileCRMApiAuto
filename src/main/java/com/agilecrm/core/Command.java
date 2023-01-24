package com.agilecrm.core;

import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import com.agilecrm.utilities.JsonMapper;
import com.agilecrm.utilities.LogInitilizer;

import java.util.Map;


public class Command<T> {


  Logger log= LogInitilizer.getLogger();

  private RequestSpecBuilder requestSpecBuilder;

  private JsonMapper jsonMapper;

  private String commandName;

  private Class<T> returnType;

  private HttpMethod method;

  private Boolean isResponseList;


  private Command(CommandBuilder builder){
    this.returnType=builder.returnType;
    this.requestSpecBuilder = builder.requestSpecBuilder;
    this.method=builder.method;
    this.isResponseList=builder.isResponseList;

    jsonMapper=builder.jsonMapper;
  }

  public T execute(){

    Response response=this.method.execute(requestSpecBuilder);

    return (T) jsonMapper.getData(response.getBody().asPrettyString());
  }

  public Response executeAndGetResponse(){
    return this.method.execute(requestSpecBuilder);
  }

  public static class CommandBuilder<T>{

    private Map<String,String> headers;
    private Map<String,String> queryParams;
    private Class<T> returnType;
    private RequestSpecBuilder requestSpecBuilder;
    private HttpMethod method;
    private JsonMapper jsonMapper;
    private Boolean isResponseList;

    public CommandBuilder(Class<T> returnType){
      requestSpecBuilder=new RequestSpecBuilder();
      this.returnType=returnType;
      jsonMapper=new JsonMapper(returnType);
    }


    public CommandBuilder<T> withBasePath(String basePath){
      requestSpecBuilder.setBasePath(basePath);
      return this;
    }

    public CommandBuilder<T> withBasicAuthScheme(BasicAuthScheme basicAuthScheme){
      requestSpecBuilder.setAuth(basicAuthScheme);
      return this;
    }

    public CommandBuilder<T> withBaseURI(String baseURI){
      requestSpecBuilder.setBaseUri(baseURI);
      return this;
    }

    public CommandBuilder<T> withHeaders(Map<String,String> headers){
      requestSpecBuilder.addHeaders(headers);
      return this;
    }

    public CommandBuilder<T> withQueryParams(Map<String,String> queryParams){
      requestSpecBuilder.addQueryParams(queryParams);
      return this;
    }

    public CommandBuilder<T> withBody(Object body){
      requestSpecBuilder.setBody(jsonMapper.getJsonData(body));
      return this;
    }

    public CommandBuilder<T> withFormParams(Map<String,Object> formParams){
      requestSpecBuilder.addFormParams(formParams);

      return this;
    }

    public CommandBuilder<T> withMethod(HttpMethod method){
      this.method=method;
      return this;
    }

    public Command<T> build(){
      return new Command<T>(this);
    }








  }






}
