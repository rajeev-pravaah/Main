package com.Octopussaas.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./Test data/read.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet(sheetName);
		String data = "";
		if (sheet != null && sheet.getRow(rowNum) != null && sheet.getRow(rowNum).getCell(cellNum) != null) {
			data = sheet.getRow(rowNum).getCell(cellNum).toString().trim();
		} else {
			System.err.println("Warning: Data not found in Excel at Sheet: " + sheetName + ", Row: " + rowNum + ", Cell: " + cellNum);
		}
		wb.close();
		return data;
	}
	  public int GetRowcount(String SheetName) throws EncryptedDocumentException, IOException
	  {
		  FileInputStream fis =new FileInputStream("./Test data/read.xlsx");
		  Workbook wb = WorkbookFactory.create(fis);
		  int rowcount = wb.getSheet(SheetName).getLastRowNum();
		  wb.close();
		  return rowcount;
	  }
	  public void setDataIntoExcel(String sheetName, int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	  {
		  FileInputStream fis=new FileInputStream("./Test data/read.xlsx");
		  Workbook wb = WorkbookFactory.create(fis);
		     wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		     FileOutputStream fos =new FileOutputStream("./Test data/read.xlsx");
		     wb.write(fos);
		     wb.close();
		  
	  }

}
