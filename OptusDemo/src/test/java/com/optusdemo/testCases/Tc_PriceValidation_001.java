package com.optusdemo.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.optusdemo.pageObject.OptusAllPage;

public class Tc_PriceValidation_001 extends BaseClass {
	
	
		
		@BeforeMethod
		public void launchBrowser()
		{
			setup();
		}
		
		@AfterMethod
		public void closeBrowser()
		{
			tearDown();
		}
		

		@Test
		public void pricevalidation() throws InterruptedException
		{
		
			log.info("Execution for test pricevalidation is started...");
			
			OptusAllPage optus= new OptusAllPage(driver);
			
			optus.clickOniPhone16ProMax();
			log.info("clicked on link of Shop iPhone16 Pro Max");
			optus.selectWhiteColour();
			log.info("Colour option: White Titanium is selected");
			optus.selectStorage1TB();
			log.info("Storage Size: 1 TB is selected");
			optus.selectOutrightPayOption();
			log.info("Pay option: Outright is selected");
			optus.clickOnSelectdevice();
			log.info("Select Device Button have been clicked");
			optus.selectPromPlan();
			log.info("Promo Plan option is selected");
			waitTime(driver,optus.buttonContinue);
			optus.clickOnContinue();
			log.info("Contue button have been clicked with Device and Plan added to cart");
			optus.selectOnIamNewToOptus();
			log.info("I am new to Optus radio button is selected");
			optus.clickOnContinue();
			log.info("Continue button have been clicked");
			waitTime(driver,optus.eSim);
			log.info("Physical SIM & eSIM options are available");
			scrollToElement(driver,optus.buttonSimContinue);
			optus.clickOnSimContinue();
			log.info("Continue button have been clicked with Physical SIM option");
			String newDevicePrice =getTextByJSExecutor(driver,optus.newDevicePrice).replaceFirst("/mth", "").replaceFirst(",", "");
			log.info("New Device Price in Cart is :"+newDevicePrice);
			scrollToElement(driver,optus.dueTodayPrice);
			String dueTodayPrice=optus.getDuePrice();
			log.info("Due Today Price on Summary Charges: "+dueTodayPrice);
			
			
			
			if(newDevicePrice.equals(dueTodayPrice))
			{
				log.info("test for Price Validation is passed");
				Assert.assertEquals(newDevicePrice, dueTodayPrice);
			}
			else
			{
				log.info("test for Price Validation is failed");
				Assert.fail();
			}
			
		}
		

}
