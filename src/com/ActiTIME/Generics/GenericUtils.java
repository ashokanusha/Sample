package com.ActiTIME.Generics;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ActiTIME.Pages.ActiTIMEEnterTimeTrackerPage;

public class GenericUtils 
{
	public static void getscreenshot(WebDriver driver,String name) 
    {
       TakesScreenshot ts = (TakesScreenshot) driver;
       File src = ts.getScreenshotAs(OutputType.FILE);
       File dest = new File("./Screenshot/"+name+".png");
       try
       {
         FileUtils.copyFile(src, dest);	 
       }
       catch (Exception e)
       {
			// TODO: handle exception
		}

}

  public void selectByIndexes(WebElement element,int index)
    {
  	Select sel = new Select(element);
  	sel.selectByIndex(index);
    }
  public void selectByvalues(WebElement element,String value)
    {
	Select sel = new Select(element);
	sel.selectByValue(value);
	  }
  public void selectByvisibleTexts(WebElement element,String text)
    {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
    }
  public void JavaScriptAlertPopup(WebDriver driver)
    {
         Alert a = driver.switchTo().alert();
         a.accept();
    }
  public void JavaScriptConfirmationPopup(WebDriver driver)
    {
        Alert a = driver.switchTo().alert();
        a.dismiss();
    }
  public void JavaScriptpromptPopup(WebDriver driver,String text)
    {
        Alert a = driver.switchTo().alert();
        a.sendKeys(text);
        a.accept();
    }
  public void Fileupload(String filepath)
    {
  	StringSelection File =  new StringSelection(filepath);
  	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(File, null);
  	try
  	{
  	  int ctrl = KeyEvent.VK_CONTROL;
  	  int v = KeyEvent.VK_V;
  	  int enter = KeyEvent.VK_ENTER;
  	  Robot r = new Robot();
  	  r.keyPress(ctrl);
  	  r.keyPress(v);
  	  Thread.sleep(2000);
  	  r.keyRelease(v);
  	  r.keyRelease(ctrl);
  	  Thread.sleep(2000);
  	  r.keyPress(enter);
  	  Thread.sleep(2000);
  	  r.keyRelease(enter);
  	}
  	catch (Exception e)
  	{
			// TODO: handle exception
		}
  	
    }
  
public void windowPopup(String filepath)
  {
	   try
	     {
		   Runtime.getRuntime().exec(filepath);  
		    
	     }
    catch (Exception e)
	     {
			// TODO: handle exception
	     } 
  
  }



}
