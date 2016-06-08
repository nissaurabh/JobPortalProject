/**
 * 
 */
package com.capgemini.wws.filefeed;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.capgemini.job.portal.entities.Billability;
import com.capgemini.job.portal.entities.Client;
import com.capgemini.job.portal.entities.ClosedNeed;
import com.capgemini.job.portal.entities.Grade;
import com.capgemini.job.portal.entities.Location;
import com.capgemini.job.portal.entities.Need;
import com.capgemini.job.portal.entities.NeedCloseReason;
import com.capgemini.job.portal.entities.OpenNeed;
import com.capgemini.job.portal.entities.Practice;
import com.capgemini.job.portal.service.WWSDataService;

/**
 * This class operates on the data read from excel sheet and populates processed data to master tables.
 * @author sryarlag
 *
 */
public class WWSMasterDataProcessor implements Runnable {
	
	private static Logger log = Logger.getLogger(WWSMasterDataProcessor.class);
	
	//For OpenNeeds 
	private List<OpenNeed> fileRecords;
	
	//For ClosedNeed
	private List<ClosedNeed> closedNeeds;
	
	private String needsFileType;
	
	private WWSDataService wwsDataService;

	public WWSMasterDataProcessor(List<OpenNeed> fileRecords, String needFileType, WWSDataService wwsDataService) {
		this.fileRecords = fileRecords;
		this.needsFileType = needFileType;
		this.wwsDataService = wwsDataService;
	}
	
	public WWSMasterDataProcessor(String needFileType, List<ClosedNeed> fileRecords, WWSDataService wwsDataService) {
		this.closedNeeds = fileRecords;
		this.needsFileType = needFileType;
		this.wwsDataService = wwsDataService;
	}

	@Override
	public void run() {
		log.info("Sync of WWS File Data to Need master is about to begin...");
		
		Map<String, Billability> billabilities = wwsDataService.getBillabilityTypes();
		Map<String, Client> clients = wwsDataService.getClients();
		Map<String, Practice> practices = wwsDataService.getPractices();
		Map<String, Location> locations = wwsDataService.getLocations();
		Map<String, Grade> grades = wwsDataService.getGrades();
		Map<String, NeedCloseReason> closeReasons = wwsDataService.getNeedCloseReasons();
		
		if ("Open".equalsIgnoreCase(needsFileType)) {
			for (OpenNeed on: fileRecords) {
				//Check if need already exists in database.
				Need need = wwsDataService.getNeedByWWSId(on.getWwsId());
				if (null == need) {
					need = new Need();
					need.setWwsId(on.getWwsId());
					need.setNeedStatus("Open");
					need.setCreatedDate(new Date());
				}
				
				//Set Updated Date
				need.setUpdatedDate(new Date());
				
				//Set Project Start Date
				need.setProjectStartDate(on.getProjectStartDate());
				
				//Set Project End Date
				need.setProjectEndDate(on.getProjectEndDate());
				
				//Set Short Description
				need.setShortDescription(on.getShortDescription());
				
				//Check if location exists. use it if exists or persist and use if new 
				if (locations.containsKey(WWSUtil.getWWSComparableString(on.getMissionLocation()+on.getMissionCountry()))) {
					need.setLocation(locations.get(WWSUtil.getWWSComparableString(on.getMissionLocation()+on.getMissionCountry())));
				} else {
					Location location = wwsDataService.persistLocation(on.getMissionLocation(), on.getMissionCountry());
					need.setLocation(location);
					locations.put(WWSUtil.getWWSComparableString(location.getCity()+location.getState()+location.getCountry()), location);
				}
				
				//Check if billability exists
				if (billabilities.containsKey(WWSUtil.getWWSComparableString(on.getProjectType()))) {
					need.setBillability(billabilities.get(WWSUtil.getWWSComparableString(on.getProjectType())));
				} else {
					Billability billability = wwsDataService.persistBillability(on.getProjectType());
					need.setBillability(billability);
					billabilities.put(WWSUtil.getWWSComparableString(billability.getBillabilityDesc()), billability);
				}
				
				//Check if Client exists
				if (clients.containsKey(WWSUtil.getWWSComparableString(on.getClient()))) {
					need.setClient(clients.get(WWSUtil.getWWSComparableString(on.getClient())));
				} else {
					Client client = wwsDataService.persistClient(on.getClient());
					need.setClient(client);
					clients.put(WWSUtil.getWWSComparableString(client.getClientName()), client);
				}
				
				//Check if Practice exists
				if (practices.containsKey(WWSUtil.getWWSComparableString(on.getTagGlobalPractice()))) {
					need.setPractice(practices.get(WWSUtil.getWWSComparableString(on.getTagGlobalPractice())));
				} else {
					Practice practice = wwsDataService.persistPractice(on.getTagGlobalPractice());
					need.setPractice(practice);
					practices.put(WWSUtil.getWWSComparableString(practice.getPracticeName()), practice);
				}
				
				//Check if Grade exists
				if (grades.containsKey(WWSUtil.getWWSComparableString(on.getGrade()))) {
					need.setGrade(grades.get(WWSUtil.getWWSComparableString(on.getGrade())));
				} else {
					Grade grade = wwsDataService.persistGrade(on.getGrade());
					need.setGrade(grade);
					grades.put(WWSUtil.getWWSComparableString(grade.getGradeDescription()), grade);
				}
				
				wwsDataService.persistNeed(need);
				log.info("Persisted OpenNeed to Need: "+need.getWwsId());
			}
			
		} else if ("Closed".equalsIgnoreCase(needsFileType)) {
			log.info("Sync of WWS File Data to Need master (ClosedNeeds) is now started..");
			for (ClosedNeed cn: closedNeeds) {
				//Check if need already exists in database.
				Need need = wwsDataService.getNeedByWWSId(cn.getWwsId());
				if (null == need) {
					need = new Need();
					need.setWwsId(cn.getWwsId());
					need.setNeedStatus("Closed");
					need.setCreatedDate(new Date());
				}
				//Set updated Date
				need.setUpdatedDate(new Date());
				
				//Set Need close Date
				need.setNeedCloseDate(cn.getCloseDate());
				
				//Check if Need Close Reason exists. use it if exists or persist and use if new 
				if (closeReasons.containsKey(WWSUtil.getWWSComparableString(cn.getClosingReason()+cn.getClosingReasonDetails()))) {
					need.setNeedCloseReason(closeReasons.get(WWSUtil.getWWSComparableString(cn.getClosingReason()+cn.getClosingReasonDetails())));
				} else {
					NeedCloseReason closeReason = wwsDataService.persistNeedCloseReason(cn.getClosingReason(), cn.getClosingReasonDetails());
					need.setNeedCloseReason(closeReason);
					closeReasons.put(WWSUtil.getWWSComparableString(cn.getClosingReason()+cn.getClosingReasonDetails()), closeReason);
				}
				
				need.setCloseComments(cn.getClosingReasonComment());
				wwsDataService.persistNeed(need);
				log.info("Persisted OpenNeed to Need: "+need.getWwsId());
			}
		}
		log.info("Sync of WWS File Data to Need master (ClosedNeeds) is now complete...");
	}

}
