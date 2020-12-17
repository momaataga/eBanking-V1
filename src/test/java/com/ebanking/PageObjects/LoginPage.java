package com.ebanking.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class LoginPage  {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	}
	@FindBy(name= "uid")
	@CacheLookup
	WebElement textUserName;
	
	@FindBy(name= "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name= "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[10]/a[1]")
    @CacheLookup
   WebElement lnkLogout;
	
	
	
	public void setUserName(String uname) {
		textUserName.sendKeys(uname);
	}

	public void setPassword(String pass) {
		txtPassword.sendKeys(pass);
	}

	public void setBtnLogin() {
		btnLogin.click();
	}

	public void clickLogout() {
		
		lnkLogout.click();
		
		
	}
	
	

}
