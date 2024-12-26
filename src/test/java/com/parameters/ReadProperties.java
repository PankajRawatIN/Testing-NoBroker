package com.parameters;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
public class ReadProperties {
	static FileInputStream fis;
	public static String[] Values()
	{
		File f=new File("C:\\Users\\MOBAHAUD\\eclipse-workspace\\NoBrokerProject\\src\\test\\java\\com\\parameters\\Home.Properties");
		
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties pro=new Properties();
		try {
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] args=new String[3];
		args[0]=pro.getProperty("value1");
		args[1]=pro.getProperty("value2");
		args[2]=pro.getProperty("value3");
		return args;
	}
 
}
 