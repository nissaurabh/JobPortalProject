package com.capgemini.job.portal.service.impl;
/**
 * $Id$
 * @author
 * Copyright (c) 2015, Inc.
 */
import java.sql.Timestamp;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.job.portal.constants.JobMngMntConstants;
import com.capgemini.job.portal.dao.JobCandidateDAO;
import com.capgemini.job.portal.dao.JobDetailsDAO;
import com.capgemini.job.portal.dto.CandidateDetail;
import com.capgemini.job.portal.entities.CndtCtg;
import com.capgemini.job.portal.entities.CndtSt;
import com.capgemini.job.portal.entities.CtznshpSt;
import com.capgemini.job.portal.entities.Job;
import com.capgemini.job.portal.entities.JobCndt;
import com.capgemini.job.portal.entities.ResourceTyp;
import com.capgemini.job.portal.jaxb.JobCandidate;
import com.capgemini.job.portal.service.JobCandidateService;
import com.capgemini.job.portal.util.DateUtil;


/**
 * The Class JobCandidateDAO.
 * 
 * @author sbasired
 */
@Component("jobCandidateService")
public class JobCandidateServiceImpl implements JobCandidateService {
	
	@Autowired
	private JobDetailsDAO jobDetailsDAO;
	
	@Autowired
	private JobCandidateDAO jobCandidateDAO;

	@Transactional
	@Override
	public String addJobCandidate(String jobId, JobCandidate jobCandidate, byte bytes[]) {
		final String response = JobMngMntConstants.CREATED;
		final JobCndt jobCndt = new JobCndt();
		populateJobCondidateDetails(jobId, jobCandidate, bytes, jobCndt);
		jobCandidateDAO.addJobCandidate(jobCndt);

		return response;
	}

	@Transactional
	@Override
	public String updateJobCandidate(String jobId, String jobCandidateId,
			JobCandidate jobCandidate, byte bytes[]) {
		String response = JobMngMntConstants.OK_STATUS;
		final int jobIdValue = Integer.parseInt(jobId);
		final int jobCandidateIdValue = Integer.parseInt(jobCandidateId);
		JobCndt jobCndt = jobCandidateDAO.getJobCndtByJobIdAndJobCndtId(jobIdValue, jobCandidateIdValue);

		if (jobCndt != null) {
			jobCndt = populateJobCondidateDetails(jobId, jobCandidate, bytes, jobCndt);
			jobCandidateDAO.updateJobCandidate(jobCndt);
		}else{
			response = JobMngMntConstants.NOT_FOUND;
		}
		return response;
	}

	@Transactional
	@Override
	public String deleteJob(String jobId, String jobCandidateId) {
		String response = JobMngMntConstants.OK_STATUS;
		
		final int jobIdValue = Integer.parseInt(jobId);
		final int jobCandidateIdValue = Integer.parseInt(jobCandidateId);
		JobCndt jobCndt = jobCandidateDAO.getJobCndtByJobIdAndJobCndtId(jobIdValue, jobCandidateIdValue);

		if (jobCndt != null) {
			jobCandidateDAO.deleteJobCandidate(jobCndt);
		}else{
			response = JobMngMntConstants.NOT_FOUND;
		}
		return response;
	}
	
	/**
	 * @param jobId
	 * @param jobCandidate
	 * @param bytes
	 * @param jobCndt
	 * @return
	 */
	private JobCndt populateJobCondidateDetails(String jobId, JobCandidate jobCandidate, byte bytes[], final JobCndt jobCndt){
		
		if(StringUtils.isNotEmpty(jobCandidate.getActualJoiningDate())){
			jobCndt.setActJoinDt(DateUtil.convertStringToTimestamp(jobCandidate.getActualJoiningDate()));
		}
		if(StringUtils.isNotEmpty(jobCandidate.getBuLeadApproval())){
			jobCndt.setBuLdAppr(Boolean.valueOf(jobCandidate.getBuLeadApproval()));
		}
		if(StringUtils.isNotEmpty(jobCandidate.getCapabilityLeadApproval())){
			jobCndt.setCapLdAppr(Boolean.valueOf(jobCandidate.getCapabilityLeadApproval()));
		}
		if(StringUtils.isNotEmpty(jobCandidate.getCandidateCategoryId())){
			CndtCtg cndtCtg = getCndtCtg(Integer.parseInt(jobCandidate.getCandidateCategoryId()));
	
			jobCndt.setCndtCtg(cndtCtg);
		}
		if(StringUtils.isNotEmpty(jobCandidate.getCandidateStatusId())){
			CndtSt cndtSt = getCndtSt(Integer.parseInt(jobCandidate.getCandidateStatusId()));
		
			jobCndt.setCndtSt(cndtSt);
		}
		if(StringUtils.isNotEmpty(jobCandidate.getCitizenshipStatusId())){
			CtznshpSt ctznshpSt = getCtznshpSt(Integer.parseInt(jobCandidate.getCitizenshipStatusId()));
		
			jobCndt.setCtznshpSt(ctznshpSt);
		}
		
		final Job job = jobDetailsDAO.getJob(jobId);
		jobCndt.setJob(job);
		
		if(StringUtils.isNotEmpty(jobCandidate.getResourceTypeId())){
			ResourceTyp resourceTyp = getResourceTyp(Integer.parseInt(jobCandidate.getResourceTypeId()));
		
			jobCndt.setResourceTyp(resourceTyp);
		}
		if(StringUtils.isNotEmpty(jobCandidate.getName())){
			jobCndt.setCndtNm(jobCandidate.getName());
		}
		if(null != bytes){
			jobCndt.setCndtRsm(bytes);
		}
		if(StringUtils.isNotEmpty(jobCandidate.getContractorRate())){
			jobCndt.setCntrctrRt(jobCandidate.getContractorRate());
		}
		if(StringUtils.isNotEmpty(jobCandidate.getJoiningDate())){
			jobCndt.setJoinDt(DateUtil.convertStringToTimestamp(jobCandidate.getJoiningDate()));
		}
		if(StringUtils.isNotEmpty(jobCandidate.getOfferAcceptDate())){
			jobCndt.setOffrAcptDt(DateUtil.convertStringToTimestamp(jobCandidate.getOfferAcceptDate()));
		}
		if(StringUtils.isNotEmpty(jobCandidate.getOfferDate())){
			jobCndt.setOffrDt(DateUtil.convertStringToTimestamp(jobCandidate.getOfferDate()));
		}
		if(StringUtils.isNotEmpty(jobCandidate.getPrimarySkills())){
			jobCndt.setPrmySk(jobCandidate.getPrimarySkills());
		}
		//jobCndt.setCreateDts(new Timestamp(System.currentTimeMillis()));
		jobCndt.setCreateUsrId("jobmngmnt");
		jobCndt.setUpdtDts(new Timestamp(System.currentTimeMillis()));
		jobCndt.setUpdtUsrId("jobmngmnt");
		
		return jobCndt;
		
		
	}
	
	@Transactional
	@Override
	public CndtCtg getCndtCtg(final int cadtCtgId) {
		
		return jobCandidateDAO.getCndtCtg(cadtCtgId);
	}
	
	@Transactional
	@Override
	public CndtSt getCndtSt(final int cndtStId) {
		
		return jobCandidateDAO.getCndtSt(cndtStId);
	}
	
	@Transactional
	@Override
	public CtznshpSt getCtznshpSt(final int ctznshpStId) {
		
		return jobCandidateDAO.getCtznshpSt(ctznshpStId);
	}
	
	@Transactional
	@Override
	public ResourceTyp getResourceTyp(final int resourceTypId) {
		
		return jobCandidateDAO.getResourceTyp(resourceTypId);
	}
	
	@Transactional
	@Override
	public JobCndt getJobCndtByJobCndtId(final int jobCndtId) {
		
		return jobCandidateDAO.getJobCndtByJobCndtId(jobCndtId);
	}
	
	@Transactional
	@Override
	public JobCndt getJobCndtByJobIdAndJobCndtId(final int jobId, final int jobCndtId) {
		
		return jobCandidateDAO.getJobCndtByJobIdAndJobCndtId(jobId,jobCndtId);
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.service.JobCandidateService#getCandidateDetailsById(int)
	 */
	@Override
	public CandidateDetail getCandidateDetailsById(int candidateId) {
		JobCndt candidate = jobCandidateDAO.getJobCndtByJobCndtId(candidateId);
		return formatCndtDetailResponse(candidate);
	}
	
	
	/**
	 * @param candidate
	 * @return
	 */
	private CandidateDetail formatCndtDetailResponse(JobCndt candidate) {
		CandidateDetail detail = null;
		if(null != candidate){
			detail = new CandidateDetail();
			detail.setCndtId(candidate.getCndtId());
			detail.setCndtName(candidate.getCndtNm());
			detail.setResourceType(candidate.getCndtCtg().getCndtCtgNm());
			detail.setPrimarySkills(candidate.getPrmySk());
			detail.setCndtStatus(candidate.getCndtSt().getCndtStsNm());
			detail.setCtznStatus(candidate.getCtznshpSt().getCtznShpNm());
			detail.setJobId(candidate.getJob().getJobId());
		}
		return detail;
	}

}
