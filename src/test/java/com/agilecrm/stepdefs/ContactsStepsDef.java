package com.agilecrm.stepdefs;

import com.agilecrm.clients.BaseClient;
import com.agilecrm.clients.ContactClient;
import com.agilecrm.config.EnvironmentConfig;
import com.agilecrm.core.Command;
import com.agilecrm.core.HttpMethod;
import com.agilecrm.entity.common.Contact;
import com.agilecrm.entity.common.Property;
import com.agilecrm.entity.response.ContactListResponsePayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ContextConfiguration(classes = {EnvironmentConfig.class})
public class ContactsStepsDef {

  Map<String,Object> responses=new HashMap<>();

  @Autowired
  @Qualifier("contactClientImpl")
  ContactClient contactClient;
          //=new ContactClientImpl();
  Contact lastAccessedProperty;
  ContactListResponsePayload allContacts;

  @When("I create the contact with following details")
  public void iCreateTheContactWithFollowingDetails(List<Map<String,String>> contactDetails) {
    for (Map<String, String> contactDetail : contactDetails) {

      List<Property> contactProperty = new ArrayList<>();

      contactProperty.add(new Property("SYSTEM", "first_name", contactDetail.get("first_name")));
      contactProperty.add(new Property("SYSTEM", "last_name", contactDetail.get("last_name")));
      contactProperty.add(new Property("SYSTEM", "email", contactDetail.get("email")));

      Contact contact = new Contact();
      contact.setStarValue(10);
      contact.setLeadScore(20);
      contact.setTags(Arrays.asList("Lead", "Subject"));
      contact.setProperties(contactProperty);

      Contact responseContact = contactClient.createContact(contact);
      lastAccessedProperty = responseContact;
      responses.put("createContact", responseContact);
    }
  }

  @Given("there should not be any contact in the system")
  public void thereShouldNotBeAnyContactInTheSystem() {

  }

  @Then("user should be created with first_name {string}")
  public void userShouldBeCreatedWithFirst_name(String first_name) {
    Contact contact=(Contact) responses.get("createContact");

    Assert.assertEquals(first_name,contact.getProperties().get(0).getValue());
  }

  @And("owner email should be {string}")
  public void ownerEmailShouldBe(String ownerEmail) {
    Contact contact=(Contact) responses.get("createContact");

    Assert.assertEquals(ownerEmail,contact.getOwner().getEmail());
  }

  @Given("there should not be contact with name")
  public void thereShouldNotBeContactWithName(List<Map<String,String>> contactData) {

    List<Contact> filteredContact=new ArrayList<>();

      for(Map<String,String> cont:contactData) {


        String first_name = cont.get("first_name");
        String last_name = cont.get("last_name");

        ContactListResponsePayload contacts = contactClient.getAllContacts();

        filteredContact = contacts.getContacts().stream()
                .filter(data -> {
                  return data.getProperties().stream().anyMatch(dt -> dt.getValue().equals(first_name));
                }).collect(Collectors.toList());

      }
      for(Contact c:filteredContact){

        contactClient.deleteContactId(String.valueOf(c.getId()));
      }
    System.out.println();
  }

  @When("I create the invalid contact with below details")
  public void iCreateTheInvalidContactWithBelowDetails(List<Map<String,String>> contactData) {


    List<Property> contactProperty=new ArrayList<>();

    contactProperty.add(new Property("SYSTEM","first_name",contactData.get(0).get("first_name")));
    contactProperty.add(new Property("SYSTEM","last_name",contactData.get(0).get("last_name")));
    contactProperty.add(new Property("SYSTEM","email",contactData.get(0).get("email")));

    Contact contact=new Contact();
    contact.setStarValue(10);
    contact.setLeadScore(20);
    contact.setTags(Arrays.asList("Lead","Subject"));
    contact.setProperties(contactProperty);

    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");


    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("CreateContact"))
            .withMethod(HttpMethod.POST)
            .withBody(contact)
            .withHeaders(headers)
            .build();

    Response response=command.executeAndGetResponse();
    responses.put("createContact",response);

  }

  @Then("user should not be created and response should have statuscode {int}")
  public void userShouldNotBeCreatedAndResponseShouldHaveStatuscodeStatus_codes(int statusCode ) {
      Response response=(Response) responses.get("createContact");
      Assert.assertEquals(statusCode,response.getStatusCode());
  }

  @Then("I update {string} of user to {string}")
  public void iUpdateEmailOfUser(String field,String fieldValue) {
    Contact contact= lastAccessedProperty;
    Property property=contact.getProperties().stream().filter(prop -> prop.getName().equals(field)).collect(Collectors.toList()).get(0);
    contact.getProperties().remove(property);
    property=new Property("SYSTEM",field,fieldValue);
    contact.getProperties().add(property);
    lastAccessedProperty =contactClient.updateContact(contact);
    System.out.println();


  }

  @And("I get user and check {string} is {string}")
  public void iGetUserAndCheckEmailIs(String field,String emailId) {
    Property property=lastAccessedProperty.getProperties().stream().filter(prop -> prop.getName().equals(field)).collect(Collectors.toList()).get(0);
    Assert.assertEquals(emailId,property.getValue());

  }

  @Then("I update/delete {string} of contact with value {int}")
  public void iUpdateLead_scoreOfContactWithValue(String field,int value) {
      long contactId=lastAccessedProperty.getId();
      Contact c=new Contact();
      c.setId(contactId);
      c.setLeadScore(value);
      lastAccessedProperty=contactClient.updateLeadScoreById(c);

  }

  @Then("user's lead_score should be {int}")
  public void userSLead_scoreShouldBe(int value) {
    Assert.assertEquals(value,lastAccessedProperty.getLeadScore().intValue());
  }

  @And("I delete {string} of contact")
  public void iDeleteOfContact(String arg0) {
    Contact c=lastAccessedProperty;
    long id=c.getId();
    List<String> tags=c.getTags();
    Contact contact=new Contact();
    contact.setId(id);
    contact.setTags(tags);
    contactClient.deleteTagByTags(contact);


  }

  @Then("I get contact")
  public void iGetContact() {
    lastAccessedProperty=contactClient.getContactById(String.valueOf(lastAccessedProperty.getId()));
  }

  @And("contact {string} should be/contain {string}")
  public void contactShouldBe(String field, String value) {
    String count="empty".equals(value) ? "0" : value;
    if(field.equals("tags") && isNumeric(count)) {
      Assert.assertEquals(String.valueOf(lastAccessedProperty.getTags().size()), count);
    }else if(field.equals("tags") && !isNumeric(count)) {
      Assert.assertTrue(String.join(",",lastAccessedProperty.getTags())
              .contains(value));
    }

    if(field.equals("score") && isNumeric(count)) {
      Assert.assertEquals(String.valueOf(lastAccessedProperty.getLeadScore()), count);
    }


  }

  @Given("clean all contacts")
  public void cleanAllContacts() {
    List<Contact> filteredContact=new ArrayList<>();

    ContactListResponsePayload contacts = contactClient.getAllContacts();
    contacts.getContacts().stream().map(Contact::getId).forEach( contact->
            contactClient.deleteContactId(String.valueOf(contact)));

  }

  @And("get all contacts")
  public void getAllContacts() {
    allContacts= contactClient.getAllContacts();
  }

  @Then("number of contacts should be {int}")
  public void numberOfContactsShouldBe(int contactCount) {
    Assert.assertEquals(allContacts.getContacts().size(),contactCount);
  }

  @When("I search contact by id {string}")
  public void iSearchContactById(String emailId) {
    lastAccessedProperty=contactClient.searchContactByEmailId(emailId);
  }

  @Then("contact with email {string} should be present")
  public void contactWithEmailShouldBePresent(String email) {
     String actualEmailId=lastAccessedProperty.getProperties().stream().filter(property -> property.getName().equals("email")).collect(Collectors.toList()).get(0).getValue();
     Assert.assertEquals(email,actualEmailId);
  }

  @When("I add tags {string} for contact with email {string}")
  public void iAddTagsForContactWithEmail(String commaSeperatedTags, String email) {
    List<String> tags=Arrays.asList(commaSeperatedTags.split(","));
    Map<String,Object> formUrlEncodedBody=new HashMap<>();
    formUrlEncodedBody.put("email",email);
    formUrlEncodedBody.put("tags","["+commaSeperatedTags+"]");
    contactClient.addTagsToContact(formUrlEncodedBody);

  }

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  @When("I delete tags {string} for contact with email {string}")
  public void iDeleteTagsForContactWithEmail(String commaSeperatedTags, String email) {
    List<String> tags=Arrays.asList(commaSeperatedTags.split(","));
    Map<String,Object> formUrlEncodedBody=new HashMap<>();
    formUrlEncodedBody.put("email",email);
    formUrlEncodedBody.put("tags","["+commaSeperatedTags+"]");
    contactClient.deleteTagsByEmail(formUrlEncodedBody);
  }

  @When("I add score value {int} to the contact with email {string}")
  public void iAddScoreValueToTheContactWithEmail(int value, String email) {
    Map<String,Object> formUrlEncodedBody=new HashMap<>();
    formUrlEncodedBody.put("email",email);
    formUrlEncodedBody.put("score",String.valueOf(value));
    contactClient.addScoreToContactUsingEmail(formUrlEncodedBody);

  }
}
