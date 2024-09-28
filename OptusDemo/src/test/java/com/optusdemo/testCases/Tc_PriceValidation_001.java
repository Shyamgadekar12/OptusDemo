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
		
			
			OptusAllPage optus= new OptusAllPage(driver);
			
			optus.clickOniPhone16ProMax();
			optus.selectWhiteColour();
			optus.selectStorage1TB();
			optus.selectOutrightPayOption();
			optus.clickOnSelectdevice();
			optus.selectPromPlan();
			waitTime(driver,optus.buttonContinue);
			optus.clickOnContinue();
			optus.selectOnIamNewToOptus();
			optus.clickOnContinue();
			waitTime(driver,optus.eSim);
			scrollToElement(driver,optus.buttonSimContinue);
			optus.clickOnSimContinue();
			String actualResult=getTextByJSExecutor(driver,optus.newDevicePrice).replaceFirst("/mth", "").replaceFirst(",", "");
			scrollToElement(driver,optus.dueTodayPrice);
			
			String expectedResult=optus.getDuePrice();
			
			System.out.println("actual :"+actualResult);
			System.out.println("expected :"+expectedResult);
			
			Assert.assertEquals(actualResult, expectedResult);
			
		}
		

}
