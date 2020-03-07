package com.cts.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{

	private static By emailLoc = By.id("email");
	private static By passwordLoc = By.id("pass");
	private static By loginLoc = By.xpath("//button[@type='submit']");
	private static By errorLoc = By.xpath("//span[contains(text(),'Invalid')]");
	private static By registerLoc = By.xpath("//button[@type='button']");
	
	public static void enterUsername(WebDriver driver,String username)
	{
		
		driver.findElement(emailLoc).sendKeys(username);
		
	}
	
	
	public static void enterPassword(WebDriver driver,String password)
	{
		
		driver.findElement(passwordLoc).sendKeys(password);
		
	}
	
	
	public static void clickOnLogin(WebDriver driver)
	{
		
		driver.findElement(loginLoc).click();
		
	}
	
	
	
	
	public static String errorAssertion(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(errorLoc));
		
		String error = driver.findElement(errorLoc).getText();
		return error;
		
	}
	
	public static void clickOnRegister(WebDriver driver)
	{
		driver.findElement(registerLoc).click();
	}
	
	
}
