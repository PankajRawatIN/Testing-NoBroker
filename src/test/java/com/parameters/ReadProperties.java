package com.parameters;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
public class ReadProperties {
	static Properties pro;
	static FileInputStream fis;
	
	public static String homePageURL() {
		return (propertyObject().getProperty("homePageURL"));
	}
	public static String excelFilePath() {
		return (propertyObject().getProperty("excelFilePath"));
	}

	public static Properties propertyObject()
	{
		File f = new File(System.getProperty("user.dir") + "/src/test/java/com/parameters/home.properties");
		try 
		{
			fis = new FileInputStream(f);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pro = new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pro;
	}

}