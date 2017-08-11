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
		 hardWait(3);
		 automation.enterPassword(property.getOptionValue("ipPswdLoc"), "css", property.getOptionValue("password"));
		 automation.clickBtn(property.getOptionValue("nextPswdLoc"), "css");
		 hardWait(5);
		 automation.clickBtn(property.getOptionValue("googleAppIconLoc"), "css");
		 automation.clickBtn(property.getOptionValue("gmailIconLoc"), "css");
		
	}
	@Test(dataProvider="getMailList", dataProviderClass=StaticDataProvider.class)
	public void sendMail(MailMetaData metaData){
		System.out.println(":"+metaData.toString());
		hardWait(2);
		automation.clickBtnByXpath(property.getOptionValue("composeLoc"), "xpath");
		hardWait(2);
		System.out.println("?"+metaData.getTo());
		automation.enterDetail(property.getOptionValue("toLoc"),"css", metaData.getTo());
		hardWait(2);
		automation.enterDetail(property.getOptionValue("subLoc"),"css", metaData.getSubject());
		hardWait(2);
		automation.enterDetail(property.getOptionValue("bodyLoc"),"css", metaData.getBody());
		
		hardWait(5);
		automation.clickBtnByXpath(property.getOptionValue("sendBtnLoc"), "xpath");
		
		
		
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
