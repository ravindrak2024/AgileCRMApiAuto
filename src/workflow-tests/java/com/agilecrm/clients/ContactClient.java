package com.agilecrm.clients;

import com.agilecrm.core.HttpMethod;
import com.agilecrm.entity.common.Contact;
import com.agilecrm.entity.response.ContactListResponsePayload;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface ContactClient {
  public ContactListResponsePayload getAllContacts();
  public Contact getContactById(String id);
  public Contact createContact(Contact contact);
  public void deleteContactId(String id);
  public Contact updateContact(Contact contact);
  public Contact updateLeadScoreById(Contact contact);
  public Contact deleteTagByTags(Contact contact);
  public Contact searchContactByEmailId(String emailId);
  public void addTagsToContact(Map<String,Object> formParams);
  public void deleteTagsByEmail(Map<String,Object> formParams);
  public void addScoreToContactUsingEmail(Map<String,Object> formParams);
  public Response executeRaw(HttpMethod httpMethod,Object body,String basePath, Map<String,String> headers);

}
