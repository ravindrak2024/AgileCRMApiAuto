package core;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import entity.common.Contact;
import entity.response.ContactListResponsePayload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactListResponsePayloadDeserializer extends StdDeserializer<ContactListResponsePayload> {

  public ContactListResponsePayloadDeserializer() {
    super(ContactListResponsePayload.class);
  }

  @Override
  public ContactListResponsePayload deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
    ObjectMapper objectMapper = (ObjectMapper)jsonParser.getCodec();
    JsonNode node = (JsonNode)objectMapper.readTree(jsonParser);
    Iterator nodeIterator=node.iterator();
    ContactListResponsePayload contactListResponsePayload=new ContactListResponsePayload();
    List<Contact> allContacts=new ArrayList<>();
    while(nodeIterator.hasNext()){
      JsonNode obj=(JsonNode) nodeIterator.next();
      ObjectReader objectReader= objectMapper.readerFor(Contact.class);
      Contact c=(Contact)objectReader.readValue(obj);
      allContacts.add(c);
      System.out.println();
    }
    contactListResponsePayload.setContacts(allContacts);
    return contactListResponsePayload;
  }
}
