package com.appium.training.second_sample.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.appium.training.second_sample.pages.Calculator;

public class FirstTest extends BaseTest {
	
	@Test
	public void Suma() {
		Calculator calc = new Calculator(driver);
		calc.sumDosYTres();
		Assert.assertTrue(calc.validarResultado("5"), "El resultado no es el esperado");
	}
}