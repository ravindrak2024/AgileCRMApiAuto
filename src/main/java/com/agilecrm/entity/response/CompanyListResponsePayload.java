package com.agilecrm.entity.response;

import com.agilecrm.core.CompanyListResponsePayloadDeserializer;
import com.agilecrm.entity.common.Company;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Component;

import java.util.List;


@JsonDeserialize(using = CompanyListResponsePayloadDeserializer.class)
@Component
public class CompanyListResponsePayload {

 public List<Company> getCompanies() {
  return companies;
 }

 public void setCompanies(List<Company> companies) {
  this.companies = companies;
 }

 private List<Company> companies;

}
