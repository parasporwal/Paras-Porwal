package com.testng.dataprovider.email;

import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Automation {
	
	private WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void openGoogle(String url){
		driver.get(url);
	}
	
	public void enterMailID(String loc,String locType,String userMail){
		
		WebElement mailId=driver.findElement(By.cssSelector(loc));
		mailId.sendKeys(userMail);
		
	}
	public void enterPassword(String loc, String locType ,String password){
		WebElement pswd=(new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loc))));
		pswd.sendKeys(password);
	}
	public void clickBtn(String loc, String locType){
		WebElement btn=driver.findElement(By.cssSelector(loc));
		btn.click();
	}
	private void genericBy(String loc, String locType){
		
	}
	
	public void selectComposeBtn(String loc, String loctype){
		WebElement compose=(new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath(loc))));
		compose.click();
	}
         
	public void enterDetail(String loc,String sendTo,String data){
		WebElement senderlabel=(new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(loc))));
		senderlabel.click();
		senderlabel.sendKeys(sendTo);
	}
	
	
	
}
