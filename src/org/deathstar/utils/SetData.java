package org.deathstar.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SetData 
{
	public static void fromExcel(String fileName, String sheetName, int rIndex, int cIndex, String data)
	{
		try
		{
			File f = new File("./data-lib/"+fileName+".xlsx");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(rIndex);
			Cell c = r.getCell(cIndex);
			c.setCellValue(data);
		}
		catch(Exception e)
		{
			
		}
	}
	public static void toProperties(String fileName, String key, String value, String commitMsg)
	{
		try
		{
			File f = new File("./data-lib/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties p = new Properties();
			p.load(fis);
			p.setProperty(key, value);
				FileOutputStream fos = new FileOutputStream(f);
				p.store(fos, commitMsg);
		}
		catch(Exception e)
	{

}
	}
		
}
