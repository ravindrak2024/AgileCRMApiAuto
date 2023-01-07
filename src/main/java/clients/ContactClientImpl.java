package clients;

import core.Command;
import core.HttpMethod;
import entity.common.Contact;
import entity.response.ContactListResponsePayload;

import java.util.HashMap;
import java.util.Map;

public class ContactClientImpl implements ContactClient{


  @Override
  public ContactListResponsePayload getAllContacts() {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");

    Command command= new Command.CommandBuilder(ContactListResponsePayload.class)
            .withBasePath(BaseClient.contactProp.getProperty("GetContacts"))
            .withHeaders(headers)
            .withMethod(HttpMethod.GET)
            .build();

    return (ContactListResponsePayload)command.execute();
  }

  @Override
  public Contact getContactById(String id) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("GetContacts")+"/"+id)
            .withHeaders(headers)
            .withMethod(HttpMethod.GET)
            .build();

    return (Contact) command.execute();

  }

  @Override
  public Contact createContact(Contact contact) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("CreateContact"))
            .withHeaders(headers)
            .withBody(contact)
            .withMethod(HttpMethod.POST)
            .build();

    return (Contact) command.execute();
  }

  @Override
  public void deleteContactId(String id) {
    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("DeleteContact").replace("{id}",id))
            .withMethod(HttpMethod.DELETE)
            .build();
    command.executeAndGetResponse();
  }

  @Override
  public Contact updateContact(Contact contact) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("UpdateContact"))
            .withHeaders(headers)
            .withBody(contact)
            .withMethod(HttpMethod.PUT)
            .build();

    return (Contact) command.execute();
  }

  @Override
  public Contact updateLeadScoreById(Contact contact) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("UpdateLeadScore"))
            .withHeaders(headers)
            .withBody(contact)
            .withMethod(HttpMethod.PUT)
            .build();

    return (Contact) command.execute();
  }

  @Override
  public Contact deleteTagByTags(Contact contact) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("DeleteTagById"))
            .withHeaders(headers)
            .withBody(contact)
            .withMethod(HttpMethod.PUT)
            .build();

    return (Contact) command.execute();
  }

  @Override
  public Contact searchContactByEmailId(String emailId) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");
    headers.put("Content-Type","application/json");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("SearchContactByEmail")+emailId)
            .withHeaders(headers)
            .withMethod(HttpMethod.GET)
            .build();

    return (Contact) command.execute();
  }

  @Override
  public void addTagsToContact(Map<String,Object> formParams) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Content-Type","application/x-www-form-urlencoded");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("AddTagsToContact"))
            .withHeaders(headers)
            .withFormParams(formParams)
            .withMethod(HttpMethod.POST)
            .build();

    command.executeAndGetResponse();
  }

  @Override
  public void deleteTagsByEmail(Map<String, Object> formParams) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Content-Type","application/x-www-form-urlencoded");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("DeleteTagsOnContactByEmail"))
            .withHeaders(headers)
            .withFormParams(formParams)
            .withMethod(HttpMethod.POST)
            .build();

    command.executeAndGetResponse();
  }

  @Override
  public void addScoreToContactUsingEmail(Map<String, Object> formParams) {
    Map<String,String> headers=new HashMap<>();
    headers.put("Content-Type","application/x-www-form-urlencoded");

    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(BaseClient.contactProp.getProperty("AddScoreToContact"))
            .withHeaders(headers)
            .withFormParams(formParams)
            .withMethod(HttpMethod.POST)
            .build();

    command.executeAndGetResponse();
  }

}
