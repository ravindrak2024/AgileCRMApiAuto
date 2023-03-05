package com.agilecrm.utilities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class JsonMapper<T> {
  Logger log=LogInitilizer.getLogger();
  private ObjectMapper objectMapper;
  private Class<T> returnType;

  public JsonMapper(Class<T> returnType){
    this.returnType=returnType;
    objectMapper=new ObjectMapper();
    objectMapper.configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
  }

  public Object getData(String json){
    String filepath =json;
    byte[] bytes = null;
    try {
      bytes = json.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Object obj = null;

    try {
        obj = objectMapper.readValue(bytes,returnType);
    } catch (JsonParseException e) {
      // TODO Auto-generated catch block
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();

    } catch (JsonMappingException e) {
      // TODO Auto-generated catch block
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();
    } catch(Exception e) {
      // Need to write Exception
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();
    }
    return obj;
  }

  public String getJsonData(Object data){
    String payload = null;
    try {
      payload=objectMapper.writeValueAsString(data);
    } catch (JsonProcessingException e) {
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();
    }
    return payload;
  }

  public T getDataFromFile(String fileName) {

    InputStream input = JsonMapper.class.getResourceAsStream("/" + fileName);

    Object obj = null;

    try {
      obj = objectMapper.readValue(input,returnType);
    } catch (JsonParseException e) {
      // TODO Auto-generated catch block
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();

    } catch (JsonMappingException e) {
      // TODO Auto-generated catch block
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();
    } catch(Exception e) {
      // Need to write Exception
      log.error("Error occured : "+e.getMessage());
      e.printStackTrace();
    }
    return (T)obj;
  }

}
