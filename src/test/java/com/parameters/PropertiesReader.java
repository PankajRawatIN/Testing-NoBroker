package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	 Properties properties=new Properties();
     String propertiesFilePath = "/src/test/java/com/parameters/PropertiesReader.properties"; // Specify the path to your properties file

    public PropertiesReader() {
    	File f=new File(System.getProperty("user.dir")+propertiesFilePath);
        properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(f)) {
            properties.load(inputStream);  // Load properties from the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the URL from the properties file
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
