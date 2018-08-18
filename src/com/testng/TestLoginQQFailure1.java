package com.testng;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

public class TestLoginQQFailure1 {
	
	Common common=new Common();
	String url="http://www.qq.com";
	
	@Test(parameters= {"username","passwordNull"})
	public void testLoginQQFailure1(String usrname,String passwd) throws InterruptedException {
		common.open_url(url);
    	common.click_btn("cssSelector", "#loginGrayLayout");
    	//common.swithToFrame("ui_ptlogin");
    	Thread.sleep(4000);
    	
    	common.driver.switchTo().frame("ui_ptlogin");
    	Thread.sleep(4000);
    	
    	common.click_btn("cssSelector", "#switcher_plogin");
		common.input_data("id", "u", usrname);
		common.input_data("id", "p", passwd);
		common.click_btn("cssSelector", "#login_button");
		
		String text=common.get_string("id", "err_m");
		System.out.println(text);
		assertEquals("你还没有输入密码！",text);
		System.out.println("test pass");
		common.tearDown();
	}

}
