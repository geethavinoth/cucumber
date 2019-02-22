package com.baseclass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.ss.usermodel.CellType;


public class Excel {
	


	public String excel_read(int rownum, int cellnum) throws Throwable {
		
		File file = new File("C:\\Users\\HP\\Documents\\PHP_Travels_Data.xlsx");
		FileInputStream fileInput = new FileInputStream(file);
		Workbook w = new XSSFWorkbook(fileInput);
		Sheet s = w.getSheet("Input Data");
		Cell cell = s.getRow(rownum).getCell(cellnum);
		String valueOf = null;
		if (cell.getCellType().equals(CellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			valueOf = String.valueOf(numericCellValue);
		} else if (cell.getCellType().equals(CellType.STRING)) {
			valueOf = cell.getStringCellValue();
		}
		return valueOf;
	}

	public static void main(String[] args) {

	}


}
