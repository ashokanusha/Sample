package com.ActiTIME.Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ActiTIME.Generics.BaseTest;
import com.ActiTIME.Generics.ExcelData;
import com.ActiTIME.Pages.ActiTIMELoginPage;

public class InvalidLoginTest extends BaseTest
{
  @Test(priority=2)
  public void InvalidLogin() throws InterruptedException
  {
	   String title = ExcelData.getData(file_path, "TC01", 1,2);
	   String errmsg = ExcelData.getData(file_path, "TC02", 1, 2);
	   ActiTIMELoginPage lp = new ActiTIMELoginPage(driver);
	   lp.verifytitle(title);
	   int rc = ExcelData.getRowCount(file_path,"TC02");
	   for(int i=1; i<=rc; i++)
	   {
		  String un = ExcelData.getData(file_path, "TC02", i, 0);
		  String pw = ExcelData.getData(file_path, "TC02", i, 1);
		  Reporter.log("username   "+un,true);
		  lp.EnterUsername(un);
		  Reporter.log("password   "+pw,true);
		  lp.EnterPassword(pw);
		  lp.ClickonLogin();
		  String aerrmsg = lp.verifyErrorMsg();
		  Assert.assertEquals(aerrmsg, errmsg);
		  Reporter.log("_---------------------------",true);
		  Thread.sleep(3000);
	   }
	   
	  
  }
}
