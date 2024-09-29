package com.optusdemo.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	WebDriver driver;
	public static Logger log;


	public void setup()
	{
		log=LogManager.getLogger("OptusDemo");
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Chrome Browser launched");
		driver.manage().window().maximize();
		driver.get("https://www.optus.com.au/");
		log.info("URL have been Entered");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}


	public void tearDown()
	{
		driver.quit();
		log.info("Chrome Browser Closed");
	}

	public void waitTime(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void scrollToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element );

	}


	public String getTextByJSExecutor(WebDriver driver,WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String text = (String) js.executeScript("return arguments[0].innerText;", element);
		return text;
	}
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
	
		FileUtils.copyFile(src, dest);
	}

}
