package com.cts.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	private static By firstnameLoc = By.name("firstname");
	private static By lastnameLoc = By.id("lastname");
	private static By emailLoc = By.id("email_address");
	private static By countryLoc = By.id("country");
	private static By companyLoc = By.id("customer_company_type");
	private static By roleLoc = By.id("customer_individual_role");
	private static By passLoc = By.id("password");
	private static By conformPassLoc = By.id("confirmation");
	private static By agreeLoc = By.id("agree_terms");
	private static By submitLoc = By.xpath("//span[text()='Submit']");
	
	public static void enterFirstname(WebDriver driver,String firstname)
	{
		driver.findElement(firstnameLoc).sendKeys(firstname);
	}
	
	public static void enterLastName(WebDriver driver, String lastname)
	{
		driver.findElement(lastnameLoc).sendKeys(lastname);

	}
	
	public static void enterEmail(WebDriver driver, String email)
	{
		driver.findElement(emailLoc).sendKeys(email);
	}
	
	public static void selectCountry(WebDriver driver,String countryName)
	{
		WebElement countryEle = driver.findElement(countryLoc);
		Select country = new Select(countryEle);
		country.selectByVisibleText(countryName);
	}
	
	public static void selectCompany(WebDriver driver, String companyName)
	{
		WebElement companyEle = driver.findElement(companyLoc);
		Select company = new Select(companyEle);
		company.selectByVisibleText(companyName);
	}
	
	public static void selectRole(WebDriver driver, String roleName)
	{
		WebElement roleEle = driver.findElement(roleLoc);
		Select role = new Select(roleEle);
		role.selectByVisibleText(roleName);
	}
	
	public static void enterPassword(WebDriver driver, String password,String conformpassword)
	{
		driver.findElement(passLoc).sendKeys(password);
		driver.findElement(conformPassLoc).sendKeys(conformpassword);
	}
	
	public static void selectCheckBox(WebDriver driver)
	{
		driver.findElement(agreeLoc).click();
		driver.findElement(submitLoc).click();
	}
}
