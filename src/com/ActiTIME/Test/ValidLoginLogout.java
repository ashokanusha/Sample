package com.ActiTIME.Test;

import org.testng.annotations.Test;

import com.ActiTIME.Generics.BaseTest;
import com.ActiTIME.Generics.ExcelData;
import com.ActiTIME.Pages.ActiTIMEEnterTimeTrackerPage;
import com.ActiTIME.Pages.ActiTIMELoginPage;

public class ValidLoginLogout extends BaseTest
{
  @Test(priority=1)
  public void validLoginLogout()
  {
    String un = ExcelData.getData(file_path, "TC01", 1, 0);
    String pw = ExcelData.getData(file_path, "TC01", 1, 1);
    String lgtitle = ExcelData.getData(file_path, "TC01", 1, 2);
    String hptitle = ExcelData.getData(file_path, "TC01", 1, 3);
    ActiTIMELoginPage lp = new ActiTIMELoginPage(driver);
    ActiTIMEEnterTimeTrackerPage ep = new ActiTIMEEnterTimeTrackerPage(driver);
    
    // verify login page title
    lp.verifytitle(lgtitle);
    
    // enter the username
    lp.EnterUsername(un);
    
    // enter password
    lp.EnterPassword(pw);
    
    //click on login button
    lp.ClickonLogin();
    
    // verify the home page title
    lp.verifytitle(hptitle);
    
    // click on logout button
    ep.ClickonLogout();
    
    // verify the login page title
     lp.verifytitle(lgtitle);   
    
  }
}
