package com.agilecrm.stepdefs;

import com.agilecrm.clients.CompanyClient;
import com.agilecrm.entity.common.Company;
import com.agilecrm.entity.common.Property;
import com.agilecrm.entity.response.CompanyListResponsePayload;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyDef {

  @Autowired
  CompanyClient companyClient;

  private Company recentCompany;

  @Given("clean all company")
  public void cleanAllCompany() {
    CompanyListResponsePayload companyListResponsePayload=companyClient.getAllCompany();
    List<Long> companyIds=companyListResponsePayload.getCompanies().stream().map(Company::getId).collect(Collectors.toList());
    for(Long companyId:companyIds){
      companyClient.deleteCompany(String.valueOf(companyId));
    }
    System.out.println(companyListResponsePayload);
  }

  @When("I create company with below details")
  public void iCreateCompanyWithBelowDetails(List<Map<String,String>> companyData) {

    for (Map<String, String> companyDetails : companyData) {

      List<Property> companyProperty = new ArrayList<>();

      companyProperty.add(new Property("SYSTEM", "Company Type", companyDetails.get("type")));
      companyProperty.add(new Property("SYSTEM", "name", companyDetails.get("cname")));
      companyProperty.add(new Property("SYSTEM", "url", companyDetails.get("url")));
      companyProperty.add(new Property("SYSTEM", "email", companyDetails.get("email")));

      Company company=new Company();
      company.setProperties(companyProperty);
      company.setType("COMPANY");
      company.setStarValue(10);
      company.setLeadScore(20);
      company.setTags(Arrays.asList("IT Solutions", "Software Industry"));

      Company c = companyClient.createCompany(company);
      recentCompany=c;
      System.out.println(c);

    }
  }

  @Then("I get created company")
  public void iGetCreatedCompany() {
    recentCompany=companyClient.getCompanyWithId(String.valueOf(recentCompany.getId()));
  }

  @Then("company should be created with name {string}")
  public void companyShouldBeCreatedWithName(String cname) {
    Property property=recentCompany.getProperties().stream().filter(data -> data.getName().equals("name")).collect(Collectors.toList()).get(0);
    Assert.assertEquals(cname,property.getValue());
  }
}
