package com.ActiTIME.Generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import com.ActiTime.Generics.GenericUtils;

public class BaseTest implements AutoConstants
{
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
		System.setProperty(ie_key, ie_value);
	}
	 public WebDriver driver;
	 
	 @BeforeMethod
	 public void Precondition()
	 {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://demo.actitime.com");
	 }
	 @AfterMethod
	 public void Postcondition(ITestResult res)
	 {
		 int status = res.getStatus();
		 if(status==2)
		 {
		 String name = res.getMethod().getMethodName();
		 GenericUtils.getscreenshot(driver, name);
		 }
		 driver.close();
	 }

}
