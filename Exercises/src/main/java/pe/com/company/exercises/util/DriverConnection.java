/**
 * 
 */
package pe.com.company.exercises.util;

import java.net.URL;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * @author jose-humberto
 *
 */
public class DriverConnection
{
	private static final Logger logger = Logger.getLogger(DriverConnection.class.getName());
	private static WebDriver myDriver;
	
	
	
	public  static WebDriver getDriverConnection() 
	{
		
		try
		{
			ReadConfiguration readConfiguration = new ReadConfiguration();
			Properties properties = readConfiguration.getConfigurationProperties();
			
			String browser = properties.getProperty("driver.browser");
			String configuration = properties.getProperty("driver.configuration");
			
			if("local".equalsIgnoreCase(configuration))
			{
				myDriver = getBrowserLocal(browser);
			}
			else
			{
				myDriver = getBrowserRemote(browser);
			}
			
			
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myDriver;
	}



	private static WebDriver getBrowserRemote(String browser)
	{
		logger.info("Obteniendo browser :"+ browser + " en getBrowserRemote()" );
		
		WebDriver driver = null;
		
		try
		{
			ReadConfiguration readConfiguration = new ReadConfiguration();
			Properties properties = readConfiguration.getConfigurationProperties();
			String ipRemota = properties.getProperty("driver.ipremota");
			
			switch (browser.toLowerCase())	
			{
			case "safari":
				DesiredCapabilities dcs = DesiredCapabilities.safari();
				driver = new RemoteWebDriver(new URL(ipRemota), dcs);			              
				Thread.sleep(3000);  
				break;
			
			case "chrome":
				DesiredCapabilities dcc = DesiredCapabilities.chrome();
				driver = new RemoteWebDriver(new URL(ipRemota), dcc);							  
				Thread.sleep(2000);  
				break;
				
			case "firefox":
				DesiredCapabilities dcf = DesiredCapabilities.firefox();
				driver = new RemoteWebDriver(new URL(ipRemota), dcf);
				Thread.sleep(3000);
				break;
				
			default:
				DesiredCapabilities dci = DesiredCapabilities.internetExplorer();
				driver = new RemoteWebDriver(new URL(ipRemota), dci);
				Thread.sleep(3000);
				break;					
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	}
	

	private static WebDriver getBrowserLocal(String browser)
	{
		logger.info("Obteniendo browser :"+ browser + " en getBrowserLocal()" );
		
		WebDriver driver = null;
		
		try
		{
			ReadConfiguration readConfiguration = new ReadConfiguration();
			Properties properties = readConfiguration.getConfigurationProperties();
			
			switch (browser.toLowerCase())	
			{
			case "safari":
		    	driver = new SafariDriver();			              
				Thread.sleep(3000);  
				break;
			
			case "chrome":
				System.setProperty("webdriver.chrome.driver", properties.getProperty("driver.chrome"));							  
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));							  
				Thread.sleep(2000);  
				driver = new ChromeDriver(capabilities);						  
				Thread.sleep(3000);  
				driver.manage().window().maximize();
				break;
				
			case "firefox":
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				Thread.sleep(3000);
				break;
				
			default:
				System.setProperty("webdriver.ie.driver", properties.getProperty("driver.ie"));
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				Thread.sleep(3000);
				break;					
			}
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return driver;
	}
	

}
