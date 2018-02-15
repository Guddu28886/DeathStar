package org.deathstar.sel.handlers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HandleMouseOperations 
{
	public static void mouseHover(WebDriver driver, 
			WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	// Develop all mouse operations
}
