package com.testng.dataprovider.email;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {
   ClassLoader classloader;
   Properties props;
	public String getOptionValue(String key) {
		props=new Properties();
		classloader=getClass().getClassLoader();
		InputStream instream=this.getClass().getClassLoader().getResourceAsStream("db.properties");
        try {
			props.load(instream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return props.getProperty(key);
        
	
		
	}
}
