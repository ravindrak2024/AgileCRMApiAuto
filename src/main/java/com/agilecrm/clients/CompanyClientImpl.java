package com.agilecrm.clients;

import com.agilecrm.config.CompanyApi;
import com.agilecrm.core.Command;
import com.agilecrm.core.HttpMethod;
import com.agilecrm.entity.common.Company;
import com.agilecrm.entity.common.Contact;
import com.agilecrm.entity.response.CompanyListResponsePayload;
import com.agilecrm.entity.response.ContactListResponsePayload;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CompanyClientImpl extends BaseClient implements CompanyClient{

  @Autowired
  CompanyApi companyApi;


  @Override
  public Company createCompany(Company company) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");

    Command command= new Command.CommandBuilder(Company.class)
            .withBaseURI(environment.getBaseUri())
            .withBasicAuthScheme(getBasicAuthScheme())
            .withBasePath(env+companyApi.getCreateCompany())
            .withHeaders(headers)
            .withBody(company)
            .withMethod(HttpMethod.POST)
            .build();

    return (Company) command.execute();
  }

  @Override
  public CompanyListResponsePayload getAllCompany() {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
//    headers.put("Content-Type","application/json");
    Command command= new Command.CommandBuilder(CompanyListResponsePayload.class)
            .withBaseURI(environment.getBaseUri())
            .withBasicAuthScheme(getBasicAuthScheme())
            .withBasePath(env+companyApi.getListOfCompany())
            .withHeaders(headers)
            .withMethod(HttpMethod.POST)
            .build();

    return (CompanyListResponsePayload) command.execute();
  }

  @Override
  public void deleteCompany(String id) {
    Command command= new Command.CommandBuilder(Company.class)
            .withBaseURI(environment.getBaseUri())
            .withBasicAuthScheme(getBasicAuthScheme())
            .withBasePath(env+companyApi.getDeleteCompany().replace("{id}",id))
            .withMethod(HttpMethod.DELETE)
            .build();
    Response response=command.executeAndGetResponse();
    Assert.assertEquals(response.getStatusCode(),204);
  }

  @Override
  public Company getCompanyWithId(String id) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");


    Command command= new Command.CommandBuilder(Company.class)
            .withBaseURI(environment.getBaseUri())
            .withBasicAuthScheme(getBasicAuthScheme())
            .withBasePath(env+companyApi.getCompany().replace("{id}",id))
            .withHeaders(headers)
            .withMethod(HttpMethod.GET)
            .build();
    return (Company) command.execute();
  }

  @Override
  public Response executeRaw(HttpMethod httpMethod, Object body, String basePath, Map<String, String> headers) {
    return super.executeRaw(httpMethod,body,basePath,headers);
  }
}
