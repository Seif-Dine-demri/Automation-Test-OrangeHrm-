package com.OrangeHrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfiguration {
	Properties prop;
	public ReadConfiguration()    {
		File srcfile = new File("C:\\Users\\pc\\eclipse-workspace\\OrangeHrm3\\src\\test\\java\\com\\OrangeHrm\\configuration\\configuration.properties"); 
		try {
		FileInputStream fis =new FileInputStream(srcfile);
		prop =new Properties();
		prop.load(fis);} catch(Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url=prop.getProperty("URL");
		return url;
	}
	public String getUserName() {
		String username=prop.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}

}
