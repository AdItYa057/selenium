package com.cts.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage
{
	private static By idLoc = By.xpath("//span[text()='ID: MAG004563920']");
	private static By logoutLoc = By.linkText("Log Out");
	
	
	public static void waitForPresenceOfId(WebDriver driver)
	{	
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy( idLoc));
	}
	
	
	public static String getCurrentTitle(WebDriver driver)
	{
		String actTitle = driver.getTitle();
		return actTitle;
	}
	
	
	public static void logout(WebDriver driver)
	{
		driver.findElement(logoutLoc).click();	
	}
	

}
