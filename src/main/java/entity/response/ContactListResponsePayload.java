package entity.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ContactListResponsePayloadDeserializer;
import entity.common.Contact;

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
