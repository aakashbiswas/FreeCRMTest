package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Sign Up']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//img[@class='img-responsive' and @ src=\"https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png\"]")
         WebElement crmLogo;
	public LoginPage()
	{
		PageFactory.initElements(driver, this);//All the elements will be initialized with the driver
	}
	public String validateLoginPageTitle()
	{
		return driver.getTitle();   
	}
	public boolean verifyCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}
