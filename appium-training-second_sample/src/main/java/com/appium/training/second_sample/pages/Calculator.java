package com.appium.training.second_sample.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Calculator {
	AndroidDriver<AndroidElement> driver;
	
	public Calculator(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="digit_0")
	private MobileElement btnCero;
	
	@AndroidFindBy(id="digit_1")
	private MobileElement btnUno;
	
	//@AndroidFindBy(id="digit_2")
	@AndroidFindBy(xpath="//android.widget.Button[@text='2']")
	private MobileElement btnDos;
	
	//@AndroidFindBy(id="digit_3")
	@AndroidFindBy(xpath="//android.widget.Button[@text='3']")
	private MobileElement btnTres;
	
	@AndroidFindBy(id="digit_4")
	private MobileElement btnCuatro;
	
	@AndroidFindBy(id="digit_5")
	private MobileElement btnCinco;
	
	@AndroidFindBy(id="digit_6")
	private MobileElement btnSeis;
	
	@AndroidFindBy(id="digit_7")
	private MobileElement btnSiete;
	
	@AndroidFindBy(id="digit_8")
	private MobileElement btnOcho;
	
	@AndroidFindBy(id="digit_9")
	private MobileElement btnNueve;
	
	@AndroidFindBy(id="op_div")
	private MobileElement btnDivision;
	
	@AndroidFindBy(id="op_mul")
	private MobileElement btnMultiplicacion;
	
	@AndroidFindBy(id="op_sub")
	private MobileElement btnResta;
	
	//@AndroidFindBy(id="op_add")
	@AndroidFindBy(xpath="//android.widget.Button[@text='+']")
	private MobileElement btnSuma;
	
	@AndroidFindBy(id="del")
	private MobileElement btnBorrar;
	
	//@AndroidFindBy(id="eq")
	@AndroidFindBy(xpath="//android.widget.Button[@text='=']")
	private MobileElement btnIgual;
	
	//@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.android.calculator2:id/result']")
	@AndroidFindBy(xpath="//android.widget.EditText[1]")
	private MobileElement lblResultado;
	
	public void sumDosYTres() {
		btnDos.click();
		btnSuma.click();
		btnTres.click();
		btnIgual.click();
	}
	
	public boolean validarResultado(String num) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElement(lblResultado, num));
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}
}