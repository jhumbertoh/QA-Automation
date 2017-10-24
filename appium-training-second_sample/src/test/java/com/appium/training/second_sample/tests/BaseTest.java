package com.appium.training.second_sample.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	AndroidDriver<AndroidElement> driver;

	@Parameters({"deviceName", "version", "platformName", "appPackage", "appActivity", "url"})
	@BeforeTest
	public void setUp(String deviceName, String version, String platformName, String appPackage, String appActivity, String url) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability(CapabilityType.VERSION, version);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);

		driver = new AndroidDriver<>(new URL(url),	capabilities);
	}

	@AfterTest
	public void End() {
		driver.quit();
	}
}