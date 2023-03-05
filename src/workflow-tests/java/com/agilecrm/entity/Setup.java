package com.agilecrm.entity;

import com.agilecrm.entity.common.Company;
import com.agilecrm.entity.common.Contact;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;


@ToString
@Component
@Getter
@Setter
public class Setup {
  List<Contact> contacts;
  List<Company> companies;
}
