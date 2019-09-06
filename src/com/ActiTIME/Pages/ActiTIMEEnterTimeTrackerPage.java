package com.ActiTIME.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActiTIME.Generics.BasePage;

public class ActiTIMEEnterTimeTrackerPage extends BasePage
{
  
	@FindBy(id="logoutLink")
	  private WebElement lgoutBT;
	
	@FindBy(xpath="(//div[@class='popup_menu_icon'])[3]")
	  private WebElement helpBT;
	
	@FindBy(xpath="//a[contains(text(),'About your actiTIME')]")
	  private WebElement actitimeBT;
	
	@FindBy(xpath="//span[contains(text(),'build')]")
	 private WebElement  buildBT;
	
	
	public ActiTIMEEnterTimeTrackerPage(WebDriver driver) 
	{
		super(driver);
	PageFactory.initElements(driver, this);
	}
	
	public void ClickonLogout()
	{
		lgoutBT.click();
	}
	
	public void ClickonHelp()
	{
		helpBT.click();
	}
	
	public void ClickOnACBT()
	{
		actitimeBT.click();
	}
	
	public String  verifyBuild()
	{
		verifyElement(buildBT);
		String abuildbt = buildBT.getText();
		return abuildbt;
	}

}
