package com.testng.dataprovider.email;

import java.io.IOException;
import java.util.List;

import exception.UnRequiredCell;

public interface IODSFILE extends IDataProvider {
   void readDataFromOpenDoc() throws IOException,UnRequiredCell;

}
