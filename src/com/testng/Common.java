package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Common {
	ChromeDriver driver;
	
	//���幹�캯�����г�ʼ������
	public Common() { 
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	
	//��ҳ��
	public void open_url(String url) {
		driver.get(url);
	}
	
	
	//����ҳ��Ԫ�ض�λ��ʽ��������Ԫ�ض���
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
	
	//�����������
	public void input_data(String type,String value,String data) {
		WebElement el=this.locate_element(type, value);
		el.clear();
		el.sendKeys(data);
	}
	
	//����������
	public void click_btn(String type,String value) {
		WebElement el=this.locate_element(type, value);
		el.click();
	}
	
	//������
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	//��ȡ��λ����Ԫ�����ݣ����ڱȽϲ����ɹ���Ľ���Ƚ�
	public String get_string(String type,String value) {
		WebElement el=this.locate_element(type, value);
		String el_toString=el.getText();
		return el_toString;
	}
	
	//ѡ����
	public void swithToFrame(String value) {
		System.out.println(value);
		driver.switchTo().frame(value);
	}
}
