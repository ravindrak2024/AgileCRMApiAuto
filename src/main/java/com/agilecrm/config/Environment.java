package com.agilecrm.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Environment {
  @Value("$baseUri}")
  private String $baseUri;

  @Value("$username}")
  private String $username;

  @Value("$password}")
  private String $password;

}
