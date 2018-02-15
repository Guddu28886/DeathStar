package org.deathstar.sel.handlers;

import org.apache.regexp.recompile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropDown 
{
	public static void selectDDLByIndex(WebElement ddl, int index)
	{
		Select sct = new Select(ddl);
		sct.selectByIndex(index);
	}
	public static void selectDDLByValue(WebElement ddl, String value)
	{
		Select sct = new Select(ddl);
		sct.selectByValue(value);
	}
	public static void selectDDLByVisibleText(WebElement ddl, 
			String text)
	{
		Select sct = new Select(ddl);
		sct.selectByVisibleText(text);
	}
	public static boolean checkDropDown(WebElement ddl)
	{
		Select sct = new Select(ddl);
		boolean status = sct.isMultiple();
		return status;
	}
	public static void deSelectDDLByIndex(WebElement ddl, int index)
	{
		Select sct = new Select(ddl);
		sct.deselectByIndex(index);
	}
	// Develop methods to de-select option
}
