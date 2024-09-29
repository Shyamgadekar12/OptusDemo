package com.optusdemo.pageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OptusAllPage {
	
	public OptusAllPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(linkText="Shop iPhone 16 Pro Max")
	 public WebElement shopiphone16promax;
	
	@FindBy(xpath="//span[text()='White Titanium']")
	 public WebElement whitecolour;
	
	@FindBy(xpath="//span[text()='1TB']")
     public WebElement storage1TB;
	
	@FindBy(xpath="//span[text()='Outright']")
    public WebElement optionOutright;
	
	@FindBy(xpath="//a[text()='Select device']")
	public  WebElement buttonSelectdevice;
	
	@FindBy(xpath="//button[text()='Select Plan' and @aria-label='Select Plan Promo Plan']")
	public WebElement PromePlan;
	
	@FindBy(xpath="//button[text()='Continue']")
	public WebElement buttonContinue;
	
	@FindBy(xpath="//input[@type='radio' and @data-index='1']")
	public WebElement IamNewToOptus;
	
	@FindBy(xpath="//label[contains(text(),'eSIM')]")
	public WebElement eSim;
	
	@FindBy(xpath="(//div[@class='cart-summary-header-price']//span)[1]")
	public WebElement newDevicePrice;
	
	@FindBy(xpath="(//div[@class='price summary--totals-charges-cost'])[1]")
	public WebElement dueTodayPrice;	
	
	@FindBy(xpath="//button[@data-automation-id='Configurator - Sim']")
	public WebElement buttonSimContinue;
	
	
	
	public void clickOniPhone16ProMax()
	{
		shopiphone16promax.click();
	}
	
	public void selectWhiteColour()
	{
		whitecolour.click();
	}
	
	public void selectStorage1TB()
	{
		storage1TB.click();
	}
	
	public void selectOutrightPayOption()
	{
		optionOutright.click();
	}
	
	public void clickOnSelectdevice()
	{
		buttonSelectdevice.click();
	}
	
	public void selectPromPlan()
	{
		PromePlan.click();
	}
	
	public void clickOnContinue()
	{
		buttonContinue.click();
	}
	
	
	
	public void clickOnSimContinue()
	{
		buttonSimContinue.click();
	}
	
	public void selectOnIamNewToOptus()
	{
		IamNewToOptus.click();
	}
	
	public String getDuePrice()
	{
		
		String duetodayprice=dueTodayPrice.getText();
		return duetodayprice;
	}

}
