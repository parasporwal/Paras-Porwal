package com.testng.dataprovider.email;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import exception.UnRequiredCell;

public class Mail {
	Reader reader;
	PropReader property;
	Automation automation;
	Connection con;
	@BeforeSuite
	public void setData() throws UnRequiredCell, IOException{
		System.out.println("before suite");
		reader=new Reader();	
		reader.readDataFromOpenDoc();
		StaticDataProvider.setList(reader);
		 property=new PropReader();
		 con=Connection.getInstance();
		 
		 
		 
		
	}
	@BeforeTest
	public void login(){
		System.out.println("before test");
		 automation=new Automation();
		 automation.setDriver(con.getChromeWebDriverInstance(property.getOptionValue("chromedriver")));
		 automation.openGoogle(property.getOptionValue("url"));
		 automation.enterMailID(property.getOptionValue("inputEmailLoc"), "css", property.getOptionValue("email"));
		 automation.clickBtn(property.getOptionValue("nextBtnLoc"), "css");
		 hardWait(5);
		 automation.enterPassword(property.getOptionValue("ipPswdLoc"), "css", property.getOptionValue("password"));
		 automation.clickBtn(property.getOptionValue("nextBtnLoc"), "css");
		
	}
	@Test(dataProvider="getMailList", dataProviderClass=StaticDataProvider.class)
	public void sendMail(MailMetaData metaData){
		System.out.println("!"+metaData.toString());
		
	}
    private void hardWait(int sec){
    	try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
