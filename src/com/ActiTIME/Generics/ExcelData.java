package com.ActiTIME.Generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getData(String filepath,String sheetName,int rn,int cn)
	   {
		try 
		{
			FileInputStream file = new FileInputStream(new File(filepath));
			String data = WorkbookFactory.create(file).getSheet(sheetName).getRow(rn).getCell(cn).toString();
		    return data;
		}
		catch (Exception e) 
		{
		return "";
		}
	   }
	public static  int getRowCount(String filepath,String sheetName) 
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(filepath));
			int rc = WorkbookFactory.create(file).getSheet(sheetName).getLastRowNum();
			return rc;
		}
		catch (Exception e) 
		{
		  return 0;
		}
		
	}
	public  static int getCellCount(String filepath,String sheetName,int rn)
	{
		try 
		{
			FileInputStream file = new FileInputStream(new File(filepath));
			int rc = WorkbookFactory.create(file).getSheet(sheetName).getRow(rn).getLastCellNum();
			return rc;
		}
		catch (Exception e) 
		{
		  return 0;
		}
		
	}
}
