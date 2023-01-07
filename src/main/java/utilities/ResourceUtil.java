package utilities;

import java.io.File;

public class ResourceUtil {
  public File getFile(String fileName) {

    StringBuilder result = new StringBuilder("");

    // Get file from resources folder
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource(fileName).getFile());
    return file;
  }
}
