package ipl.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author SUBHAJIT
 *
 */
public class ExtractData {
	
	/**
	 * This method will fetch excel value
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelData(String sheet, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream(TestDataConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheet).getRow(rowNum).getCell(cellNum);
		DataFormatter dataformatter = new DataFormatter();
		return dataformatter.formatCellValue(cell);
	
	}
	
	 /**
	  * 
	  * This method will return property value
	  * @param key
	  * @return
	  * @throws Exception
	  */
	public String getCommonData(String key) throws Exception {
		FileInputStream fis = new FileInputStream(TestDataConstants.propertyPath);
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	
	/**
	 * This method will write in excel sheet
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Exception
	 */
	public void setExcelData(String sheet, int rowNum, int cellNum, String value) throws Exception {
		
		FileInputStream fis = new FileInputStream(TestDataConstants.excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cell = wb.createSheet(sheet).getRow(rowNum).getCell(cellNum);
		cell.setCellValue(sheet);
		FileOutputStream fos = new FileOutputStream(TestDataConstants.excelPath);
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method will stort key va
	 * @param key
	 * @param value
	 * @throws Exception
	 */
	public void setCommonData(String key, String value) throws Exception {
		FileInputStream fis = new FileInputStream(TestDataConstants.propertyPath);
		Properties p = new Properties();
		p.load(fis);
		p.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(TestDataConstants.propertyPath);
		p.store(fos, "stored");
	}
	
}
