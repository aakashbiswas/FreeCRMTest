package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contacts";
	public ContactsPageTest()
	{
		super();
		
	}
	

	@BeforeMethod
	public void setUp()
	{
		 initialization();
		 testUtil=new TestUtil();
		 loginPage=new LoginPage();
		 contactsPage=new ContactsPage();
		 homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		 testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
		
	}
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		boolean status=contactsPage.verifyContactsLabel();
		Assert.assertTrue(status);
	}
	@Test(priority=2,dataProvider = "getCRMTestData") 
	public void validateCreateNewContact(String title,String  firstName,String lastName,String company)
	{
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
}
