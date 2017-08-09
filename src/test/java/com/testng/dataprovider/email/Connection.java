package com.testng.dataprovider.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Connection {
	private WebDriver driver;
	private static Connection ob;
	
	public static Connection getInstance(){
		if(ob==null)
			ob=new Connection();
		return ob;
	}
	
	public void setSystemProperty(String driverName, String Path){
		System.setProperty(driverName,Path);
	}
	public WebDriver getChromeWebDriverInstance(String chromeDriverPath){
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver =new ChromeDriver();
		 return driver;
	}

}
