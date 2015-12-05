/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
package com.capgemini.job.portal.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
		}
		return details;
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
}
