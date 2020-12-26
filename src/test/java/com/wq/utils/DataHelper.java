package com.wq.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataHelper {

	DataFormatter formater = new DataFormatter();
	public Map<String, String> readExcelData(String filePath, String fileName, String sheetName) throws IOException {

		//1. Fetch the excel file location
		//2. Read the file and sheet details
		File file = new File(filePath + "/" + fileName);
		System.out.println(file);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet(sheetName);
		fis.close();

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		
		//convert the excel data into map
		Map<String, String> dataMap = new HashMap<String, String>();
		for(int i = 0; i < rowCount; i++ ) {
			for(int j = 0; j< colCount; j++) {				
				String key = formater.formatCellValue((sheet.getRow(0).getCell(j)));
				String value = formater.formatCellValue(sheet.getRow(i+1).getCell(j));				
				dataMap.put(key, value);
				}
		}
		return dataMap;
	}
}