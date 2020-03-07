package com.cts.magentotest;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cts.magentobase.LaunchWebDriver;
import com.cts.magentopages.RegistrationPage;
import com.cts.magentopages.HomePage;
import com.cts.magentopages.LoginPage;
import com.cts.utils.ExcelUtils;

public class RegistrationTest extends LaunchWebDriver
{

	
	
	@DataProvider
	public String[][] registerData() throws IOException
	{
		String[][] data = ExcelUtils.getSheetIntoStringArray("src/test/resources/resources/MagentoTestData.xlsx","registerData");
		return data;
	}
	
	@Test(dataProvider = "registerData")
	public void registerTest(String FirstName, String LastName, String EmailAddress, String Country, String MyCountryPrimarily, String MyRole, String Password, String Conformpassword  )
	{

		
		HomePage.clickOnMyAccountIcon(driver);

		LoginPage.clickOnRegister(driver);

		RegistrationPage.enterFirstname(driver, FirstName);

		RegistrationPage.enterLastName(driver, LastName);

		RegistrationPage.enterEmail(driver, EmailAddress);

		RegistrationPage.selectCountry(driver, Country);

		RegistrationPage.selectCompany(driver, MyCountryPrimarily);

		RegistrationPage.selectRole(driver, MyRole);

		RegistrationPage.enterPassword(driver, Password, Conformpassword);

		RegistrationPage.selectCheckBox(driver);

	}

}
