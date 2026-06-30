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
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
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
