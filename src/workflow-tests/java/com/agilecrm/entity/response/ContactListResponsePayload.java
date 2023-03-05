package com.agilecrm.entity.response;

import com.agilecrm.core.ContactListResponsePayloadDeserializer;
import com.agilecrm.entity.common.Contact;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;


@JsonDeserialize(using = ContactListResponsePayloadDeserializer.class)
public class ContactListResponsePayload {


 public List<Contact> getContacts() {
  return contacts;
 }

 public void setContacts(List<Contact> contacts) {
  this.contacts = contacts;
 }

 private List<Contact> contacts;

}
