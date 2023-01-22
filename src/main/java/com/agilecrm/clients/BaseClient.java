package com.agilecrm.clients;

import com.agilecrm.utilities.PropertyUtil;

import java.util.Properties;

public class BaseClient {
  static public Properties commonConfig= PropertyUtil.getProperties("dev.properties");
  static public Properties contactProp= PropertyUtil.getProperties("contacts.properties");
}
