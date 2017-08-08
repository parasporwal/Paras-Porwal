package com.testng.dataprovider.email;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReder {
   ClassLoader classloader;
   Properties props;
	public String getOptionValue(String key) throws IOException{
		props=new Properties();
		classloader=getClass().getClassLoader();
		InputStream instream=this.getClass().getClassLoader().getResourceAsStream("db.properties");
        props.load(instream);
        return props.getProperty(key);
        
	
		
	}
}
