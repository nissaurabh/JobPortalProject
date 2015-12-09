/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO;
import com.capgemini.job.portal.dto.CandidateDetail;
import com.capgemini.job.portal.dto.CandidateDetails;
import com.capgemini.job.portal.dto.JobDetail;
import com.capgemini.job.portal.dto.JobDetails;
import com.capgemini.job.portal.dto.JobStats;
import com.capgemini.job.portal.service.SearchByFilterCriteriaService;

/**
 * The Class implements SearchByFilterCriteriaService interface to performs search by filter criteria.
 * 
 * @author ppenamak
 */
@Service("searchByFilterCriteriaService")
public class SearchByFilterCriteriaServiceImpl implements SearchByFilterCriteriaService {
	
	@Autowired
	private SearchByFilterCriteriaDAO searchByFilterCriteriaDAO;


	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.SearchByFilterCriteriaService#retriveJobDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public JobDetails retriveJobDetailsByFilterCriteria(Map<String, String> queryMap) throws ParseException {
		JobDetails details = new JobDetails();
		List<JobDetail> jobDetList = searchByFilterCriteriaDAO.getJobDetailsByFilterCriteria(queryMap);
		if(CollectionUtils.isNotEmpty(jobDetList)){
			populateJobCountsByDate(details,jobDetList);
			details.setJobList(jobDetList);
			Map<String,List<JobDetail>> clientMap = populateJobCountsByClient(jobDetList);
			formatResponse(details,clientMap,"clientName");
			
			Map<String,List<JobDetail>> buMap = populateJobCountsByBU(jobDetList);
			formatResponse(details,buMap,"serviceLine");
		}
		return details;
	}

	/**
	 * @param jobDetList
	 */
	private Map<String,List<JobDetail>>	populateJobCountsByClient(List<JobDetail> jobDetList) {
		Map<String,List<JobDetail>> clientMap = new HashMap<String, List<JobDetail>>();
		for (JobDetail jobDetail : jobDetList) {
			if(clientMap.containsKey(jobDetail.getClientName())){
				clientMap.get(jobDetail.getClientName()).add(jobDetail);
			} else {
				List<JobDetail> jobList = new ArrayList<JobDetail>();
				jobList.add(jobDetail);
				clientMap.put(jobDetail.getClientName(), jobList);
			}
		}
		return clientMap;
	}
	
	/**
	 * @param jobDetList
	 */
	private Map<String,List<JobDetail>>	populateJobCountsByBU(List<JobDetail> jobDetList) {
		Map<String,List<JobDetail>> buMap = new HashMap<String, List<JobDetail>>();
		for (JobDetail jobDetail : jobDetList) {
			if(buMap.containsKey(jobDetail.getServiceLine())){
				buMap.get(jobDetail.getServiceLine()).add(jobDetail);
			} else {
				List<JobDetail> jobList = new ArrayList<JobDetail>();
				jobList.add(jobDetail);
				buMap.put(jobDetail.getServiceLine(), jobList);
			}
		}
		return buMap;
	}
	
	/**
	 * @param details
	 * @param clientMap
	 * @param type
	 * @throws ParseException
	 */
	private void formatResponse(JobDetails details,
			Map<String, List<JobDetail>> clientMap, String type) throws ParseException {
		List<JobStats> stats= new ArrayList<JobStats>();
		for (Iterator<String> iterator = clientMap.keySet().iterator(); iterator.hasNext();) {
			JobStats jobStats = new JobStats();
			String key = (String) iterator.next();
			int agedJobCount=0;
			int activeJobCount=0;
			for (JobDetail jobDetail : clientMap.get(key)) {
				SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
				Date reqDate = formatter.parse(jobDetail.getReqDate());
				Date currentDate = Calendar.getInstance().getTime();
				long diffDays = (currentDate.getTime() - reqDate.getTime()) / (24 * 60 * 60 * 1000);
				if(diffDays > 14){
					agedJobCount++;
				}
			}
			activeJobCount = clientMap.get(key).size()-agedJobCount;
			jobStats.setAging(agedJobCount);
			jobStats.setOpen(activeJobCount);
			if("clientName".equalsIgnoreCase(type)){
				jobStats.setClientName(key);
			} else {
				jobStats.setBuName(key);
			}
			stats.add(jobStats);
		}
		if("clientName".equalsIgnoreCase(type)){
			details.setJobAccount(stats);
		} else {
			details.setJobBU(stats);
		}
	}
	
	/**
	 * @param details
	 * @param jobDetList
	 * @throws ParseException
	 */
	private void populateJobCountsByDate(JobDetails details,
			List<JobDetail> jobDetList) throws ParseException {
		int agedJobCount=0;
		int activeJobCount=0;
		for (JobDetail jobDetail : jobDetList) {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date reqDate = formatter.parse(jobDetail.getReqDate());
			Date currentDate = Calendar.getInstance().getTime();
			long diffDays = (currentDate.getTime() - reqDate.getTime()) / (24 * 60 * 60 * 1000);
			if(diffDays > 14){
				agedJobCount++;
			}
		}
		activeJobCount = jobDetList.size()-agedJobCount;
		details.setAgingJobCount(agedJobCount);
		details.setOpenJobCount(activeJobCount);
		details.setTotalJobCount(jobDetList.size());
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.SearchByFilterCriteriaService#retriveCandidateDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public CandidateDetails retriveCandidateDetailsByFilterCriteria(
			Map<String, String> queryMap) {
		CandidateDetails details = new CandidateDetails();
		List<CandidateDetail> candidateDetList = searchByFilterCriteriaDAO.getCandidateDetailsByFilterCriteria(queryMap);
		if(CollectionUtils.isNotEmpty(candidateDetList)){
			populateCountsByCandidateStatus(details,candidateDetList);
			details.setCandidateList(candidateDetList);
		}
		return details;
	}

	/**
	 * @param details
	 * @param candidateDetList
	 */
	private void populateCountsByCandidateStatus(CandidateDetails details,
			List<CandidateDetail> candidateDetList) {
		int activeCount=0;
		int hiredCount=0;
		int rejectCount=0;
		for (CandidateDetail detail : candidateDetList) {
			if(detail.getCndtStatus().equalsIgnoreCase("active")){
				activeCount++;
			} else if(detail.getCndtStatus().equalsIgnoreCase("hired")){
				hiredCount++;
			} else {
				rejectCount++;
			}
		}
		details.setActiveCount(activeCount);
		details.setHiredCount(hiredCount);
		details.setRejectCount(rejectCount);
	}

	@Override
	public void retriveInterviewDetailsByFilterCriteria(
			Map<String, String> queryMap) {
	
	}
}