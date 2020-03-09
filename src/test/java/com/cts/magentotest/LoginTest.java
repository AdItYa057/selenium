package com.cts.magentotest;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import com.cts.magentopages.HomePage;
import com.cts.magentobase.LaunchWebDriver;
import com.cts.magentopages.MainPage;
import com.cts.magentopages.LoginPage;
import com.cts.utils.ExcelUtils;

public class LoginTest extends LaunchWebDriver
{
	
	
	@DataProvider
	public String[][] validCredentialsData() throws IOException
	{
		String[][] valid = ExcelUtils.getSheetIntoStringArray("src/test/resources/resources/MagentoTestData.xlsx", "validCredentialsData");
		return valid;
	}
	
	
	@Test(dataProvider = "validCredentialsData")
	public void validCredentials(String Username,String Password,String ExpectedErrorMessage)
	{
		
		//click on account icon
		HomePage.clickOnMyAccountIcon(driver);
		
		//enter user name
		LoginPage.enterUsername(driver, Username);
		
		//enter password
		LoginPage.enterPassword(driver, Password);
		
		//click on login button
		LoginPage.clickOnLogin(driver);
		
		//wait for the presence of element in that page
		MainPage.waitForPresenceOfId(driver);
		
		//get actual text from the page
		String actualTitle = MainPage.getCurrentTitle(driver);
		
		//compares the actual and expected text
		Assert.assertEquals(actualTitle,"My Account");
		
		//logout from the page
		MainPage.logout(driver);
	
	}
	
	@DataProvider
	public String[][] invalidCredentialdata() throws IOException
	{
		String[][] main = ExcelUtils.getSheetIntoStringArray("src/test/resources/resources/MagentoTestData.xlsx", "invalidCredentialTest");
		return main;
	}

	@Test(dataProvider = "invalidCredentialdata")
	public void invalidCredentials(String Username,String Password,String ExpectedErrorMessage)
	{
		
		//click on Account icon
        HomePage.clickOnMyAccountIcon(driver);
		
        //enter user name
		LoginPage.enterUsername(driver, Username);
		
		//enter password
		LoginPage.enterPassword(driver, Password);
		
		
		//click on login button
		LoginPage.clickOnLogin(driver);
		
		
		//get the error message
		String errorMsg = LoginPage.errorAssertion(driver);
		
		//Assert.assertEquals(errorMsg,"Invalid login or password.");
		//checks if the error message is equal to expected
		Assert.assertTrue(errorMsg.contains("Invalid login or password."),"Assertion on invalid credentials");
	}
}
