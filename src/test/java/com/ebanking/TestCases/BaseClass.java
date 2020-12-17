package com.ebanking.TestCases;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ebanking.Utilities.ReadConfig;


public class BaseClass {
	
	
	ChromeOptions options = new ChromeOptions();
	ReadConfig readConfig = new ReadConfig();
	
	public String baseUrl = readConfig.getUrl();
	public String username = readConfig.getUsername();
	public String password= readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
    @Parameters ("browser")
	@BeforeClass
	
	public void setup(String br) throws InterruptedException {
		 
    	
    	logger = Logger.getLogger("EBanking-Projekt");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readConfig.getChromepath());
			driver = new ChromeDriver(options);
		} 
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxpath());
			driver = new FirefoxDriver();
			
		}
		else if (br.equals("ie"))
		{
		
		System.setProperty("webdriver.ie.driver",readConfig.getIepath());
		driver = new InternetExplorerDriver();
		}
		driver.get(baseUrl);
		driver.manage().window().maximize();
		options.addArguments("disable-popup-blocking");		

		}
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
	}
	
	


