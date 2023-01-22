package com.agilecrm.clients;

import com.agilecrm.core.Command;
import com.agilecrm.core.HttpMethod;

import com.agilecrm.config.ContactsApi;
import com.agilecrm.entity.common.Contact;
import com.agilecrm.entity.response.ContactListResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("contactClientImpl")
public class ContactClientImpl implements ContactClient{

  @Autowired
  ContactsApi contactsApi;


  @Override
  public ContactListResponsePayload getAllContacts() {
    Map<String,String> headers=new HashMap<>();
    headers.put("Accept","application/json");

    Command command= new Command.CommandBuilder(ContactListResponsePayload.class)
            .withBasePath(contactsApi.getGetContacts())
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
            .withBasePath(contactsApi.getGetContacts()+"/"+id)
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
            .withBasePath(contactsApi.getCreateContact())
            .withHeaders(headers)
            .withBody(contact)
            .withMethod(HttpMethod.POST)
            .build();

    return (Contact) command.execute();
  }

  @Override
  public void deleteContactId(String id) {
    Command command= new Command.CommandBuilder(Contact.class)
            .withBasePath(contactsApi.getDeleteContact().replace("{id}",id))
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
            .withBasePath(contactsApi.getUpdateContact())
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
            .withBasePath(contactsApi.getUpdateLeadScore())
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
            .withBasePath(contactsApi.getDeleteTagById())
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
            .withBasePath(contactsApi.getSearchContactByEmail()+emailId)
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
            .withBasePath(contactsApi.getAddTagsToContact())
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
            .withBasePath(contactsApi.getDeleteTagsOnContactByEmail())
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
            .withBasePath(contactsApi.getAddScoreToContact())
            .withHeaders(headers)
            .withFormParams(formParams)
            .withMethod(HttpMethod.POST)
            .build();

    command.executeAndGetResponse();
  }

}
