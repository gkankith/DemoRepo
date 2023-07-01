package com.actitime.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

/**
 * this is a generic class to read the data from the external files
 * @author Dell
 *
 */
public class FileLib {
	/**
	 * this is a generic method to read the data from the property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
@Test
public String getPropertyData(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./data/procommondata.property");
	Properties p=new Properties();
	p.load(fis);
	String data=p.getProperty(key);
	return data;
}

@Test
public String getExcelData(String sheet,int r,int c) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("./data/protestscript.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	int count=wb.getSheet(sheet).getLastRowNum();
	for(int i=3;i<count;i++) {
	String data=wb.getSheet(sheet).getRow(r).getCell(c).getStringCellValue();
	return data;
	}
	
}

}
