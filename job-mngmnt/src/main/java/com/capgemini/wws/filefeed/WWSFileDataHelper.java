/**
 * 
 */
package com.capgemini.wws.filefeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.job.portal.entities.ClosedNeed;
import com.capgemini.job.portal.entities.OpenNeed;

/**
 * @author sryarlag
 *
 */
public class WWSFileDataHelper {
	
	private Map<String, String> consideredTagGlobalPractices;
	private String practiceColName;
	
	public WWSFileDataHelper() {
		consideredTagGlobalPractices = new HashMap<String, String>();
		//Since practice name is a key element to consider data. converting the names in upper case with no spaces in it, to avoid any possible data entry errors. 
		consideredTagGlobalPractices.put(("CSD Core Custom Development").replaceAll(" ","").toUpperCase(),"CSD Core Custom Development"); //value is from "Tag Global Practice" field of WWS Feed
		
		//Below column will hold the practice name of the need
		practiceColName = "Tag Global Practice";
	}
	
	/**
	 * returns the OpenNeed records of the sheetData for only configured practice
	 * @param sheetData
	 * @return
	 */
	public List<OpenNeed> getOpenNeedRecords(Map<String, Map<Long, String>> sheetData) {
		List<OpenNeed> records = new ArrayList<OpenNeed>();
		Map.Entry<String, Map<Long, String>> firstEntry=sheetData.entrySet().iterator().next();
		Integer totalRecordsInFile = firstEntry.getValue().keySet().size();
		
		for (Long rowId=1L;rowId<=totalRecordsInFile;rowId++) {
			//considering only the practices configured in consideredTagGlobalPractices
			String practiceNm = (sheetData.get(practiceColName).get(rowId)).replaceAll(" ","").toUpperCase();
			if (consideredTagGlobalPractices.containsKey(practiceNm)) {
				try {
					OpenNeed openNeed = new OpenNeed();
					//TODO: need to set the column names to be in lower case with all spaces removed, to avoid any manual errors of columns change
					openNeed.setWwsId(new Integer(sheetData.get("Id").get(rowId)));
					openNeed.setShortDescription(sheetData.get("Short Description").get(rowId));
					openNeed.setProjectName(sheetData.get("Project Name").get(rowId));
					openNeed.setProjectStartDate(WWSUtil.sdf.parse(sheetData.get("Project Start Date").get(rowId))); 
					openNeed.setProjectEndDate(WWSUtil.sdf.parse(sheetData.get("Project End Date").get(rowId)));
					openNeed.setClient(sheetData.get("Client").get(rowId));
					openNeed.setGrade(sheetData.get("Grade").get(rowId));
					openNeed.setLocalGrades(sheetData.get("Local Grades").get(rowId));
					openNeed.setMissionCountry(sheetData.get("Mission Country").get(rowId));
					openNeed.setMissionLocation(sheetData.get("Mission Location").get(rowId));
					openNeed.setWorkAnywhere(sheetData.get("Work Anywhere").get(rowId));
					openNeed.setInternalDescription(sheetData.get("Internal Description").get(rowId));
					openNeed.setConfidentialDescription(sheetData.get("Confidential Description").get(rowId));
					openNeed.setPrivateComment(sheetData.get("Private Comment").get(rowId));
					openNeed.setRmHandlerFullName(sheetData.get("RM Handler Full Name").get(rowId));
					openNeed.setCreatorFullName(sheetData.get("Creator Full Name").get(rowId));
					openNeed.setRequesterFullName(sheetData.get("Requester Full Name").get(rowId));
					openNeed.setProjectType(sheetData.get("Project Type").get(rowId));
					openNeed.setCreatonDate(WWSUtil.sdf.parse(sheetData.get("Creation Date").get(rowId)));
					openNeed.setTagGlobalPractice(sheetData.get("Tag Global Practice").get(rowId));
					openNeed.setTagsEmailSent(sheetData.get("Tags Email Sent").get(rowId));
					openNeed.setSkillComment(sheetData.get("Skill Comment").get(rowId));
					openNeed.setNeedReason(sheetData.get("Need Reason").get(rowId));
					openNeed.setStatus(sheetData.get("Status").get(rowId));
					openNeed.setRecruitmentNeeds(sheetData.get("Recruitment Needs").get(rowId));
					openNeed.setLeadTime(sheetData.get("Lead Time").get(rowId));
					openNeed.setWeekByStatus(sheetData.get("Week by Status").get(rowId));
					
					records.add(openNeed);
				} catch (Exception e) {
					System.out.println("Exception occured while processing row: "+rowId+"\n Execution: "+e);
				}
				
			}
		}
		
		return records;
	}

	/**
	 * Returns the ClosedNeed records from the excel sheet uploaded
	 * @param sheetData
	 * @return
	 */
	public List<ClosedNeed> getClosedNeedRecords(Map<String, Map<Long, String>> sheetData) {
		List<ClosedNeed> records = new ArrayList<ClosedNeed>();
		Map.Entry<String, Map<Long, String>> firstEntry=sheetData.entrySet().iterator().next();
		Integer totalRecordsInFile = firstEntry.getValue().keySet().size();
		
		for (Long rowId=1L;rowId<=totalRecordsInFile;rowId++) {
			//considering only the practices configured in consideredTagGlobalPractices
			String practiceNm = (sheetData.get(practiceColName).get(rowId)).replaceAll(" ","").toUpperCase();
			if (consideredTagGlobalPractices.containsKey(practiceNm)) {
				try {
					ClosedNeed closedNeed = new ClosedNeed();
					
					closedNeed.setWwsId(new Integer(sheetData.get("Id").get(rowId)));
					closedNeed.setCloseDate(WWSUtil.sdf.parse(sheetData.get("Close Date").get(rowId)));
					closedNeed.setClosingReason(sheetData.get("Closing Reason").get(rowId));
					closedNeed.setClosingReasonComment(sheetData.get("Comment Closing Reason").get(rowId));
					closedNeed.setClosingReasonCommentDtls(sheetData.get("Detail Comment Closing Reason").get(rowId));
					closedNeed.setClosingReasonDetails(sheetData.get("Detail Closing Reason").get(rowId));
					closedNeed.setSkillComment(sheetData.get("Skill Comment").get(rowId));
					closedNeed.setNeedReason(sheetData.get("Need Reason").get(rowId));
					
					records.add(closedNeed);
				} catch (Exception e) {
					System.out.println("Exception occured while processing row: "+rowId+"\n Execution: "+e);
				}
				
			}
		}
		
		return records;
	}

}
