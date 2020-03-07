package com.cts.magentopages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage
{
	private static By iconLoc = By.xpath("//i[@class='fa fa-user']");
	
	public static void clickOnMyAccountIcon(WebDriver driver)
	{
		
	driver.findElement(iconLoc).click();
	
	}

}
