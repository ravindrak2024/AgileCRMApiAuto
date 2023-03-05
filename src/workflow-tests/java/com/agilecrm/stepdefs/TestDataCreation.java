package com.agilecrm.stepdefs;

import com.agilecrm.clients.CompanyClient;
import com.agilecrm.clients.ContactClient;
import com.agilecrm.config.EnvironmentConfig;
import com.agilecrm.entity.Setup;
import com.agilecrm.entity.common.Company;
import com.agilecrm.entity.common.Contact;
import com.agilecrm.utilities.JsonMapper;
import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration(classes = {EnvironmentConfig.class})
public class TestDataCreation {

  @Autowired
  CompanyClient companyClient;

  @Autowired
  ContactClient contactClient;


  @Autowired
  CompanyDef companyDef;

  @Autowired
  ContactsStepsDef contactsStepsDef;

  public static List<Contact> cachedContacts;
  public static List<Company> cachedCompany;
  public static String lastInitializedFile = "";

  @Given("initialize from {string}")
  public void setupFromFile(String fileName) {
    if (fileName != null && !lastInitializedFile.equalsIgnoreCase(fileName)) {
      JsonMapper<Setup> jsonMapper = new JsonMapper<>(Setup.class);
      Setup setupData = jsonMapper.getDataFromFile(fileName);
      createData(setupData);
      lastInitializedFile = fileName;
    }
  }

  private void createData(Setup setupData) {

    if (setupData.getContacts() != null) {
      contactsStepsDef.cleanAllContacts();
      if (cachedContacts == null) {
        cachedContacts = new ArrayList<>();
      }
      for (Contact contact : setupData.getContacts()) {
        try {
          cachedContacts.add(contactClient.createContact(contact));
        } catch (Exception e) {
          throw new CucumberException("Couldn't create contact " + contact);
        }
      }
    }

    if (setupData.getCompanies() != null) {
      companyDef.cleanAllCompany();
      if (cachedCompany == null) {
        cachedCompany = new ArrayList<>();
      }
      for (Company company : setupData.getCompanies()) {
        try {
          cachedCompany.add(companyClient.createCompany(company));
        } catch (Exception e) {
          throw new CucumberException("Couldn't create company " + company);
        }
      }
    }
  }
}
