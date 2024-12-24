package com.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReading {
	static File file;
	static FileInputStream fis;
	static Properties prop;
	public static Properties reader() throws IOException {
		file=new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\parameters\\home.properties");
		fis=new FileInputStream(file);
		prop=new Properties();
		prop.load(fis);
		return  prop;
	}

}
