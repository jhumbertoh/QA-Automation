package com.belatrix.connect.framework;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.belatrix.connect.page.LoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ParentScenario {

	private WebDriver driver;
	protected static LoginPage loginPage;

	public void startAndroid()
	{
		String url = "http://localhost:4723/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.2.2");
		cap.setCapability(MobileCapabilityType.APP, "/home/jose-humberto/Downloads/apk/app-debug.apk");
		cap.setCapability(MobileCapabilityType.APP_PACKAGE, "com.belatrixsf.connect");
		cap.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.belatrixsf.connect.ui.LauncherActivity");
		
		try
		{
			driver = new AndroidDriver<WebElement>(new URL(url), cap);
		}catch (Exception e) 
		{
			System.out.println("Error al momento de generar el Driver" +e);
		}
		
		loginPage = new LoginPage(driver);
				
	}

}
