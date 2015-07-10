package com.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib 
{
	static FileInputStream fileObj;
	static Workbook workbook = null;
	 
	public ExcelLib(String path_of_excel) throws FileNotFoundException
	{
		fileObj=new FileInputStream(new File(path_of_excel));
	}
	private static Workbook getWorkBook(FileInputStream fileObj) throws Exception
	{
		
		if(workbook==null)
		{
		   workbook=WorkbookFactory.create(fileObj);
		}
		return workbook;
	}
	private static Sheet getSheet(Workbook workBookObj,String sheetName)
	{
		return workBookObj.getSheet(sheetName);
	}
	
	public String getExcelData(String path_of_excel,String sheetName,int row_num,int col_num) throws Exception
	{
		String data=null;
		Workbook workBook=getWorkBook(fileObj);
		Sheet sheetObj=getSheet(workBook,sheetName);
		Row row=sheetObj.getRow(row_num);
		Cell col=row.getCell(col_num);
		data=col.getStringCellValue();
		fileObj.close();
		return data;
	}
	public void setExcelData(String path_of_excel,String sheetName,int row_num,int col_num,String data) throws Exception
	{
		String data_to_write=data;
		Workbook workBook=getWorkBook(fileObj);
		Sheet sheetObj=getSheet(workBook,sheetName);
		Row row=sheetObj.getRow(row_num);
		Cell col=row.getCell(col_num);
		col.setCellType(Cell.CELL_TYPE_STRING);
		col.setCellValue(data);
		fileObj.close();
	}
	public int getRowCount(String path_of_sheet,String sheetName) throws Exception
	{
		int row_count = 0;
		Workbook workbook=getWorkBook(fileObj);
		System.out.println(workbook);
	    Sheet sheet=getSheet(workbook, sheetName);
	    row_count=sheet.getLastRowNum();
	    fileObj.close();
		return row_count;
	}
	public int getColCount(String path_of_sheet,String sheetName) throws Exception
	{
		int col_count = 0;
		Workbook workbook=getWorkBook(fileObj);
	    Sheet sheet=getSheet(workbook, sheetName);
	    Iterator<Cell>iteCell=sheet.getRow(0).cellIterator();
	    while(iteCell.hasNext())
	    {
	    	String value=iteCell.next().getStringCellValue();
	    	if(value!=null)
	    	{
	    		col_count=col_count+1;
	    	}
	    }
	    fileObj.close();
		return col_count;
	}
}
