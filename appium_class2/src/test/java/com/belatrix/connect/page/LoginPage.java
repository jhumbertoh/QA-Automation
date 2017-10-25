package com.belatrix.connect.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.belatrix.connect.framework.ParentPage;

public class LoginPage extends ParentPage
{

	By CONTAINER_PAGE = By.id("com.belatrixsf.connect:id/login");
	By TXT_USER_NAME = By.id("com.belatrixsf.connect:id/username");
	By TXT_PASSWORD = By.id("com.belatrixsf.connect:id/password");
	By BTN_LOGIN = By.id("com.belatrixsf.connect:id/log_in");
	By HLNK_FORGOT_PASSWORD = By.id("com.belatrixsf.connect:id/forgot_password");
	By HLNK_NEW_USER = By.id("com.belatrixsf.connect:id/sign_up");
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	public void loginOnApp(String userName, String password)
	{
		sendKeys(TXT_USER_NAME,userName);
		sendKeys(TXT_PASSWORD,password);
		click(BTN_LOGIN);
	}
	
	public void clickForgotPasswordOption()
	{
		click(HLNK_FORGOT_PASSWORD);
	}
	
}
