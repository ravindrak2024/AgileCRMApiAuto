package com.agilecrm.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ContactsApi {

  @Value("${GetContacts}")
  private String GetContacts;

  @Value("${GetContactById}")
  private String GetContactById;

  @Value("${CreateContact}")
  private String CreateContact;

  @Value("${UpdateContact}")
  private String UpdateContact;

  @Value("${UpdateLeadScore}")
  private String UpdateLeadScore;

  @Value("${UpdateTagById}")
  private String UpdateTagById;

  @Value("${DeleteTagById}")
  private String DeleteTagById;

  @Value("${DeleteContact}")
  private String DeleteContact;

  @Value("${SearchContactByEmail}")
  private String SearchContactByEmail;

  @Value("${AddTagsToContact}")
  private String AddTagsToContact;

  @Value("${DeleteTagsOnContactByEmail}")
  private String DeleteTagsOnContactByEmail;

  @Value("${AddScoreToContact}")
  private String AddScoreToContact;

  @Value("${GetTaskOfContact}")
  private String GetTaskOfContact;

  @Value("${UpdateContactPropertyByEmail}")
  private String UpdateContactPropertyByEmail;

  @Value("${ChangeContactOwner}")
  private String ChangeContactOwner;

  @Value("${AddContactToCampaing}")
  private String AddContactToCampaing;

  @Value("${RemoveContactFromACampaign}")
  private String RemoveContactFromACampaign;

  @Value("${GetContactByPhoneNumber}")
  private String GetContactByPhoneNumber;

  @Value("${GetContactByDynamicFilter}")
  private String GetContactByDynamicFilter;

}
