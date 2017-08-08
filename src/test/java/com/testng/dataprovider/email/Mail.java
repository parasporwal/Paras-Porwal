package com.testng.dataprovider.email;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import exception.UnRequiredCell;

public class Mail {
	
	@BeforeTest
	public void setData() throws UnRequiredCell, IOException{
		Reader reader=new Reader();	
		reader.readDataFromOpenDoc();
		StaticDataProvider.setList(reader);
		
	}
	@Test(dataProvider="getMailList", dataProviderClass=StaticDataProvider.class)
	public void sendMail(MailMetaData metaData){
		
		System.out.println("!"+metaData.toString());
	}

}
