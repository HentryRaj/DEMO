package com.vtiger.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author HenTryRAj
 *
 */
public class FileLib {
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromProperties(String key) throws IOException {
		FileInputStream fileObj = new FileInputStream("./commonData.properties");
		Properties pObj = new Properties();
			pObj.load(fileObj);
			String value = pObj.getProperty(key);
		return value;
	}
/**
 * 
 * This method is used to read the data from the Excel.
 * @param path
 * @param sheet
 * @param row
 * @param cell
 * @return
 * @throws IOException 
 * @throws FileNotFoundException 
 * @throws EncryptedDocumentException 
 */

public  String read_XL_Data(String path,String sheet,int row,int cell) throws EncryptedDocumentException, FileNotFoundException, IOException 
{
	String data="";

	Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	data=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	
	return data;
}

/**
 * This method is used to read the number of DATA rows/RowCount
 * @param path
 * @param sheet
 * @return
 * @throws IOException 
 * @throws FileNotFoundException 
 * @throws EncryptedDocumentException 
 */

public  int read_XL_RowCount(String path,String sheet) throws EncryptedDocumentException, FileNotFoundException, IOException 
{
	int rc=0;
	
	Workbook wb = WorkbookFactory.create(new FileInputStream(path));
	rc=wb.getSheet(sheet).getLastRowNum();
	
	
	return rc;
}

/**
 *
 *This Method is Used to Write ReportData into Excel
 * @param path
 * @param sheet
 * @param row
 * @param cell
 * @param v
 * @return
 * @throws IOException 
 * @throws FileNotFoundException 
 * @throws EncryptedDocumentException 
 */

public static int  write_XL_Data(String path,String sheet,int row,int cell,int v) throws EncryptedDocumentException, FileNotFoundException, IOException 
{
	
	Workbook wb=WorkbookFactory.create(new FileInputStream(path));
	wb.getSheet(sheet).getRow(row).getCell(cell).setCellValue(v);
	wb.write(new FileOutputStream(path));
	return v;
}

}