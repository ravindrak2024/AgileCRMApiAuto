package com.agilecrm.clients;

import com.agilecrm.core.HttpMethod;
import com.agilecrm.entity.common.Company;
import com.agilecrm.entity.response.CompanyListResponsePayload;
import com.agilecrm.entity.response.ContactListResponsePayload;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CompanyClient {

  public Company createCompany(Company company);
  public CompanyListResponsePayload getAllCompany();
  public void deleteCompany(String id);
  public Company getCompanyWithId(String id);
  public Response executeRaw(HttpMethod httpMethod, Object body, String basePath, Map<String,String> headers);

}
