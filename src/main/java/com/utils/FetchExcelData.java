package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class FetchExcelData
{
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fileInputStream;
	public static Properties properties;
	
	@DataProvider(name="abc")
	public static Object[][] getData()
	{
		try
		{
			
			fileInputStream = new FileInputStream("src/test/resources/DD.xlsx");
			workbook = new XSSFWorkbook(fileInputStream);
			
			sheet = workbook.getSheet("Sheet1");
		}
		catch(Exception e)
		{
			System.out.println("Properties File Not Found");
		}

		int total_Row = sheet.getLastRowNum();
		int total_columns = sheet.getRow(0).getLastCellNum();
		
		
		
		Object[][] data = new Object[total_Row][total_columns];
		
		for(int i=0;i<total_Row;i++)
		{
			
			
			for(int j=0;j<total_columns;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		return data;
	}
	
}




