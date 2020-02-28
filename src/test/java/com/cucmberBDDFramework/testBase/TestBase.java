package com.cucmberBDDFramework.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
	
	public static WebDriver OpenBrowser(WebDriver driver,String browserName,String url) throws InterruptedException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(url);
			
			Thread.sleep(5000);
			return driver;	
		}else 
		if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/ie.exe");
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("requireWindowFocus", true);//to move mouse manually			
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;	
		} else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;	
		}
			return null;			
	}

}
