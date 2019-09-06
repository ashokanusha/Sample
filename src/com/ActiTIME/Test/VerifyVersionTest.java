package com.ActiTIME.Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ActiTIME.Generics.BaseTest;
import com.ActiTIME.Generics.ExcelData;
import com.ActiTIME.Pages.ActiTIMELoginPage;

public class VerifyVersionTest  extends BaseTest
{
 @Test(priority=3)
 public void VerifyVersion()
 {
	 String title = ExcelData.getData(file_path, "TC01", 1, 2);
	 ActiTIMELoginPage lp = new ActiTIMELoginPage(driver);
	 lp.verifytitle(title);
	 String aversion = lp.verifyVersion();
	 String eversion = ExcelData.getData(file_path, "TC03", 1, 0);
	 
	 if(aversion.equals(eversion))
	 {
		 Reporter.log("version is matching",true);
	 }
	 else
	 {
		 Reporter.log("version is not matching",true);
	 }
 }
 }
