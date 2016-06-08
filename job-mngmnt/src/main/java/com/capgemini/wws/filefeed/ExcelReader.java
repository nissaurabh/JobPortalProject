package com.capgemini.wws.filefeed;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * @author sryarlag
 * 
 * Make sure all the columns in the excel sheet are strings. 
 * Note: numbers should appear with green triangle at the left top of the cell, then string not number.
 *
 */
public class ExcelReader {
	
	public static Logger log = Logger.getLogger(ExcelReader.class);
	
	public Map<String, Map<Long, String>> getSheetData(String fileName, String sheetName, InputStream bis) {

		DataFormatter dataFormat = new DataFormatter();
		 
		Map<String, Map<Long, String>> sheetData = new HashMap<String, Map<Long,String>>();
		
		try {
			//FileInputStream bis = new FileInputStream(fileName);
			XSSFWorkbook wBook = new XSSFWorkbook((InputStream)bis);
			XSSFSheet wSheet = wBook.getSheet(sheetName);
			XSSFRow rowData = wSheet.getRow(0);
			XSSFCell cellData = null;//rowData.getCell(0);
			
			int noOfRows = wSheet.getLastRowNum();
			int noOfCols = rowData.getLastCellNum();
			log.info("Number of Rows & Cols in file "+fileName+"["+sheetName+"] is: Rows="+noOfRows+" --- Cols="+noOfCols);
			
			int colIdx = 0;
			String colName = null;
			Map<Long, String> colData = null;//new HashMap<Long, String>();
			boolean columnsExist = true;
			while (columnsExist) {
				colData = new HashMap<Long, String>();
				int rowIdx = 0;
				rowData = wSheet.getRow(rowIdx);
				if (rowIdx == 0) {
					colName = dataFormat.formatCellValue(rowData.getCell(colIdx));//rowData.getCell(colIdx).getStringCellValue();
					rowIdx ++;
					if (null == colName || "".equalsIgnoreCase(colName.trim())) {
						//Column name is empty, assuming that as end of data horizontally
						columnsExist = false;
						break;
					}
				}
				
				boolean endOfReport = false;
				while (!endOfReport) {
					rowData = wSheet.getRow(rowIdx);
					//String cellValue = ""+dataFormat.formatCellValue(rowData.getCell(colIdx));
					String cellValue = "";
					if(rowData.getCell(colIdx).getCellType() == Cell.CELL_TYPE_FORMULA) {
						 switch(rowData.getCell(colIdx).getCachedFormulaResultType()) {
				            case Cell.CELL_TYPE_NUMERIC:
				            	cellValue = ""+ rowData.getCell(colIdx).getNumericCellValue();
				                break;
				            case Cell.CELL_TYPE_STRING:
				            	cellValue = rowData.getCell(colIdx).getStringCellValue();
				                break;
				        }
					} else {
						cellValue = ""+dataFormat.formatCellValue(rowData.getCell(colIdx));
					}
					
					if (rowIdx >= (noOfRows-1)) {
						endOfReport = true;
						//row id is equal to no of rows, that is end of file data
						break;
					} else {
						colData.put(0L+rowIdx, cellValue);
					}
					rowIdx ++;
				}
				if (null != colName && !"".equals(colName)) {
					sheetData.put(colName.trim(), colData);
				}
				colIdx ++;
			}
			
			
		} catch (Exception e) {
			log.error("Exception reading sheet '"+sheetName+"' from  '"+fileName+"' :"+e.getMessage());
			e.printStackTrace();
		}
		//log.info("*********Data read from "+fileName+" ["+sheetName+"] is \n"+sheetData);
		return sheetData;
	}
	
	
	public static void readFile() {
		/*ExcelReader er = new ExcelReader();
		Map<String, Map<Long, String>> sd = er.getSheetData("Sheet1", "D:/eclipse-workspace/BulkHTTPRequester/WebContent/TestData/TestFile.xlsx");
		//Map<String, Map<Long, String>> sd = er.getSheetData("Sheet1", "D:/eclipse-workspace/BulkHTTPRequester/WebContent/TestData/GUEST_ALT_BY_EMAIL_dataFile.xlsx");
		//Map<String, Map<Long, String>> sd = er.getSheetData("Sheet1", "D:/eclipse-workspace/BulkHTTPRequester/WebContent/TestData/STORE_ADM_ENTTL_test_data.xlsx");
		
		//System.out.println(sd);
		DataMerger merger = new DataMerger();
		merger.mergeAndInvokeHTTPRequest("NTU_PROVIDE_TICKET_DETAILS_BY_TCOD", sd);
		//merger.mergeAndInvokeHTTPRequest("GUEST_ALT_BY_EMAIL", sd);
		//merger.mergeAndInvokeHTTPRequest("STORE_ADM_ENTTL", sd);
		*/
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExcelReader.readFile();

	}

}
