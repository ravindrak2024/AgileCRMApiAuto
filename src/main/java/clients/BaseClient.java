package clients;

import utilities.PropertyUtil;

import java.util.Properties;

public class BaseClient {
  static public Properties commonConfig= PropertyUtil.getProperties("common.properties");
  static public Properties contactProp= PropertyUtil.getProperties("contacts.properties");
}
