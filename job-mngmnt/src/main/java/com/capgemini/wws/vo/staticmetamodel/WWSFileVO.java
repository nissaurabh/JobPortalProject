/**
 * 
 */
package com.capgemini.wws.vo.staticmetamodel;

import java.util.Map;

/**
 * @author sryarlag
 *
 */
public class WWSFileVO {
	
	private String fileName;
	private String sheetName;
	private Integer noOfColumns;
	private Integer noOfRows;
	private StringBuilder debugMesg;
	private String needFileType;
	private Map<String, Map<Long, String>> sheetData;
	private Integer consideredRecords;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public Integer getNoOfColumns() {
		return noOfColumns;
	}
	public void setNoOfColumns(Integer noOfColumns) {
		this.noOfColumns = noOfColumns;
	}
	public Integer getNoOfRows() {
		return noOfRows;
	}
	public void setNoOfRows(Integer noOfRows) {
		this.noOfRows = noOfRows;
	}
	public StringBuilder getDebugMesg() {
		return debugMesg;
	}
	public void setDebugMesg(StringBuilder debugMesg) {
		this.debugMesg = debugMesg;
	}
	public String getNeedFileType() {
		return needFileType;
	}
	public void setNeedFileType(String needFileType) {
		this.needFileType = needFileType;
	}
	public Map<String, Map<Long, String>> getSheetData() {
		return sheetData;
	}
	public void setSheetData(Map<String, Map<Long, String>> sheetData) {
		this.sheetData = sheetData;
	}
	public Integer getConsideredRecords() {
		return consideredRecords;
	}
	public void setConsideredRecords(Integer consideredRecords) {
		this.consideredRecords = consideredRecords;
	}
	
}
