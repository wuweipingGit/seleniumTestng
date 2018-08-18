package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
public class NewTestQQ {
	ChromeDriver driver;
	String url;
	
	@BeforeSuite(groups= {"group0"})
	public void setUp() throws Exception{
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		url="http://www.qq.com";
		driver=new ChromeDriver();
	}
	
   
   @Test(groups= {"group1"},parameters= {"usernameQQ","passwordQQ"})
   public void testSeleniumTestng(String usrname,String passwd) throws InterruptedException {
	   driver.get(url);
	   WebElement login=driver.findElement(By.cssSelector("#loginGrayIcon > a[id=\"loginGrayLayout\"]"));
	   login.click();
	   Thread.sleep(2000);
	   driver.switchTo().frame("ui_ptlogin");
	   WebElement login_style=driver.findElement(By.cssSelector("#switcher_plogin"));
	   login_style.click();
	   WebElement input_u=driver.findElement(By.id("u"));
	   input_u.clear();
	   input_u.sendKeys(usrname);
	   WebElement input_p=driver.findElement(By.id("p"));
	   input_p.clear();
	   input_p.sendKeys(passwd);
	   WebElement button=driver.findElement(By.cssSelector("#login_button"));
	   button.click();
	   //System.out.println(button.toString());
   }
   
   @Test(groups= {"group2"})
   	public void search() throws Exception{
	   driver.switchTo().defaultContent();
	   Thread.sleep(5000);
	   WebElement input_search=driver.findElement(By.id("sougouTxt"));
	   input_search.sendKeys("selenium");
	   WebElement button_search=driver.findElement(By.id("searchBtn"));
	   button_search.click();
   }
}
