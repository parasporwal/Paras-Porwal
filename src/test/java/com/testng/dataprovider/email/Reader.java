package com.testng.dataprovider.email;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jopendocument.dom.spreadsheet.MutableCell;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import exception.UnRequiredCell;

public class Reader implements IDataProvider{
	private List<MailMetaData> mailList;
	public  void readDataFromOpenDoc() throws IOException,UnRequiredCell{
		// TODO Auto-generated method stub
		mailList=new ArrayList<MailMetaData>();
		ClassLoader classloader = getClass().getClassLoader();
		File file = new File(classloader.getResource("MailMetaData.ods").getFile());
		SpreadSheet spreasheet = SpreadSheet.createFromFile(file);
		org.jopendocument.dom.spreadsheet.Sheet sheet = spreasheet.getSheet(0);
		int nColCount = sheet.getColumnCount();
		int nRowCount = sheet.getRowCount();

		// Iterating through each row of the selected sheet
		MutableCell<?> cell = null;
		for (int nRowIndex = 0; nRowIndex < nRowCount; nRowIndex++) {
			// Iterating through each column
			MailMetaData mailPOJO = new MailMetaData();

			for (int nColIndex = 0; nColIndex < nColCount; nColIndex++) {
				cell = sheet.getCellAt(nColIndex, nRowIndex);
				switch (nColIndex) {

				case 0:
					mailPOJO.setFrom(cell.getTextValue());
					break;
				case 1:
					mailPOJO.setTo(cell.getTextValue());
					break;
				case 2:
					mailPOJO.setSubject(cell.getTextValue());
					break;
				case 3:
					mailPOJO.setBody(cell.getTextValue());
					break;
					
			   default: throw new UnRequiredCell("Unrequired Cell");
				}

			}
			
		
			mailList.add(mailPOJO);
		}
		
       System.out.println("list : "+mailList);
	}

	public List getListOfData() {
		// TODO Auto-generated method stub
		return mailList;
	}

}
