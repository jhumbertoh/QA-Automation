package pe.com.company.exercises.testcases;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pe.com.company.exercises.util.DriverConnection;

/**
 * @author jose-humberto
 *
 */
public class ExercisesTest
{

	WebDriver webDriver = null;
	private static final Logger logger = Logger.getLogger(ExercisesTest.class.getName());
	
	 @BeforeTest
     public void Configuracion() 
     {
		 logger.info("Cargar la configuracion...");
		 webDriver = DriverConnection.getDriverConnection();
     }
	
	 @Test
	 public void Exercises()
	 {
		 String url = "https://www.visanet.com.pe/contactanos/";
		 
		 logger.info("Abrir la url: "+url);
		 webDriver.get(url);
		
		 setText("nombres_apellidos", "José Humberto Hurtado Alva");
		 setText("celular", "930731660");
		 setText("email","josehumberto17@gmail.com");
		 setText("dni", "45454670");
		 selectText("asunto","Sugerencias");
		 setText("mensaje", "Hola les sugiero que su página se pueda visualizar correctamente en dispositivos móviles, gracias.");
		 
	 }
	
	public void setText(String objectName, String value)
	{
		logger.info("Ingresar el texto: " +value+ " en el objeto: " +objectName);
		webDriver.findElement(By.id(objectName)).sendKeys(value);
	}
	
	public void selectText(String objectName, String value)
	{
		logger.info("Seleccionar el texto: " +value+ " en el objeto: " +objectName);
		Select select = new Select(webDriver.findElement(By.id(objectName)));
		select.selectByVisibleText(value);
	}
	
	
	/*
	@AfterTest
	public void End ()
	{
	    if (webDriver != null) 
	    {
	    	webDriver.close();
	    	webDriver.quit();
	    }
	}
	*/
	
}
