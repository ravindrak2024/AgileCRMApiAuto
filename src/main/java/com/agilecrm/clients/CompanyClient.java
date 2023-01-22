package com.agilecrm.clients;

import com.agilecrm.entity.common.Company;
import com.agilecrm.entity.response.CompanyListResponsePayload;
import com.agilecrm.entity.response.ContactListResponsePayload;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface CompanyClient {

  public Company createCompany(Company company);
  public CompanyListResponsePayload getAllCompany();
  public void deleteCompany(String id);

}
