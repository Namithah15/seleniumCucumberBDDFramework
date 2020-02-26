package com.cucmberBDDFramework.testRunner;



import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.cucmberBDDFramework.testBase.PropertiesFileReader;
import com.cucmberBDDFramework.testBase.TestBase;


import cucumber.api.java.Before;

public class ServiceHooks {
	TestBase testBase;
	PropertiesFileReader obj= new PropertiesFileReader();
	private WebDriver driver;

	@Before
	public void initializeTest() throws Throwable {
		testBase = new TestBase();
		Properties properties=obj.getProperty();
		//testBase.selectBrowser(properties.getProperty("browser.name"));
		TestBase.OpenBrowser(driver, properties.getProperty("browser.name"), properties.getProperty("browser.baseURL"));
	}

}
