package utilities;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyUtil {
  public static Properties getProperties(String path) {
    Logger log=LogInitilizer.getLogger();
    Properties prop;
    prop = new Properties();
    FileInputStream fis;
    File file=new ResourceUtil().getFile(path);
    try {
      fis = new FileInputStream(file.getAbsolutePath());
      log.debug("Loading file " +path);
      prop.load(fis);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      log.fatal("File not found ",e);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      log.fatal("Error reading file ",e);
    }
    return prop;
  }
}
