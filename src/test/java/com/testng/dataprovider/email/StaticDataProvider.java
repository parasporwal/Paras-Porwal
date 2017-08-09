package com.testng.dataprovider.email;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.*;

import exception.UnRequiredCell;

public class StaticDataProvider {
	private static List<?> mailList;
	
	@DataProvider(name="getMailList")
	public static Object[][] createData() throws UnRequiredCell, IOException {
		         
		        
		         Object[][] array=new Object[mailList.size()][1];
		         for(int index=1;index<mailList.size();index++){
		        	 array[index][0]=mailList.get(index);
		         }
		          return  array;
		}
	
	public static void setList(IDataProvider dataprovider){
	    mailList=dataprovider.getListOfData();
	}

	
}
