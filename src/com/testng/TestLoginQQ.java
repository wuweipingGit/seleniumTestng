package com.testng;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestLoginQQ {
	
	Common common=new Common();
	String url="http://www.qq.com";
	
    @Test(parameters= {"username","password"})
    public void testLoginQQ(String usrname,String passwd) throws InterruptedException {
    	common.open_url(url);
    	common.click_btn("cssSelector", "#loginGrayLayout");
    	//common.swithToFrame("ui_ptlogin");
    	common.driver.switchTo().frame("ui_ptlogin");
    	common.click_btn("cssSelector", "#switcher_plogin");
    	common.input_data("id", "u", usrname);
    	common.input_data("id", "p", passwd);
    	common.click_btn("cssSelector", "#login_button");
    	common.driver.switchTo().defaultContent();
    	common.tearDown();
    }
}
