package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewTestBAIDU {
	ChromeDriver driver;
	String url;
	
	@BeforeSuite
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		url="http://site.baidu.com/";
		driver=new ChromeDriver();
	}

	
   @Test
   public void testSeleniumTestng() throws InterruptedException {
	   driver.get(url);
	  
   }
}
