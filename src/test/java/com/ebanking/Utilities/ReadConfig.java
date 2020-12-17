package com.ebanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties configFile;

	 public ReadConfig()
	   {
	 File src = new File ("./Configurations/config.properties");
	 try {
	  FileInputStream fis = new FileInputStream (src);
	  configFile = new Properties();
	  configFile.load(fis);
	  
	 }catch(Exception eta){
	     eta.printStackTrace();
	 }
	   }
	 
	   public String getUrl()
	   {
	 String url =configFile.getProperty("baseUrl");
	 return url;
	   }
	   
	   public String getUsername()
	   {
	 String username = configFile.getProperty("username");
	 return username;
	   }
	   public String getPassword()
	   {
	 String password = configFile.getProperty("password");
	 return password;
	   }
	
	   public String getChromepath()
	   {
	 String chrome = configFile.getProperty("chromepath");
	 return chrome;
	   }
	   public String getIepath()
	   {
	 String iepath = configFile.getProperty("iepath");
	 return iepath;
	   }
	   public String getFirefoxpath()
	   {
	 String firefox = configFile.getProperty("firefoxpath");
	 return firefox;
	   }

}
