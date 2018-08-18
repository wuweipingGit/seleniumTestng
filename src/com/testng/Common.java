package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Common {
	ChromeDriver driver;
	
	//定义构造函数进行初始化工作
	public Common() { 
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	//打开页面
	public void open_url(String url) {
		driver.get(url);
	}
	
	
	//设置页面元素定位方式，并返回元素对象
	public WebElement locate_element(String type,String value) {
		WebElement el;
		if(type=="id") {
			el=driver.findElement(By.id(value));
		}else if(type=="className") {
			el=driver.findElement(By.className(value));
		}else if(type=="cssSelector") {
			el=driver.findElement(By.cssSelector(value));
		}else {
			el=driver.findElement(By.xpath(value));
		}
		return el; 
	}
	
	//处理输入操作
	public void input_data(String type,String value,String data) {
		WebElement el=this.locate_element(type, value);
		el.clear();
		el.sendKeys(data);
	}
	
	//处理点击操作
	public void click_btn(String type,String value) {
		WebElement el=this.locate_element(type, value);
		el.click();
	}
	
	//清理工作
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	//获取定位到的元素内容，用于比较操作成功后的结果比较
	public String get_string(String type,String value) {
		WebElement el=this.locate_element(type, value);
		String el_toString=el.getText();
		return el_toString;
	}
	
	//选择框架
	public void swithToFrame(String value) {
		System.out.println(value);
		driver.switchTo().frame(value);
	}
}
