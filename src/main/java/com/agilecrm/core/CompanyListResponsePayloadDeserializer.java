package com.agilecrm.core;

import com.agilecrm.entity.common.Company;

import com.agilecrm.entity.response.CompanyListResponsePayload;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompanyListResponsePayloadDeserializer extends StdDeserializer<CompanyListResponsePayload> {

  public CompanyListResponsePayloadDeserializer() {
    super(CompanyListResponsePayload.class);
  }

  @Override
  public CompanyListResponsePayload deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
    ObjectMapper objectMapper = (ObjectMapper)jsonParser.getCodec();
    JsonNode node = (JsonNode)objectMapper.readTree(jsonParser);
    Iterator nodeIterator=node.iterator();
    CompanyListResponsePayload companyListResponsePayload=new CompanyListResponsePayload();
    List<Company> allCompanies=new ArrayList<>();
    while(nodeIterator.hasNext()){
      JsonNode obj=(JsonNode) nodeIterator.next();
      ObjectReader objectReader= objectMapper.readerFor(Company.class);
      Company c=(Company)objectReader.readValue(obj);
      allCompanies.add(c);
      System.out.println();
    }

    companyListResponsePayload.setCompanies(allCompanies);
    return companyListResponsePayload;
  }
}
