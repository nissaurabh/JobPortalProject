/**
 * 
 */
package com.capgemini.job.portal.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO;
import com.capgemini.job.portal.dto.CandidateDetail;
import com.capgemini.job.portal.dto.InterviewDetail;
import com.capgemini.job.portal.dto.JobDetail;
import com.capgemini.job.portal.util.DateUtil;

/**
 * @author ppenamak
 *
 */
@SuppressWarnings("unchecked")
@Service("searchByFilterCriteriaDAO")
public class SearchByFilterCriteriaDAOImpl implements SearchByFilterCriteriaDAO {
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO#getJobDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public List<JobDetail> getJobDetailsByFilterCriteria(Map<String, String> jobFilterMap) {
		List<String> paramList = new ArrayList<String>();
		List<JobDetail> jobDetList = new ArrayList<JobDetail>();
		StringBuffer sql = new StringBuffer ("select a.wwsid, f.clnt_nm,c.srvc_ln_nm, d.srvc_ln_cap_nm, b.job_rl_nm,e.job_sts_nm, a.reqstr_rm,a.req_dt "  
				+" from job a, job_role b, service_ln c, service_ln_cap d, job_sts e, account f where b.job_rl_id = a.job_rl_id"
				+ " and d.srvc_ln_cap_id = b.srvc_ln_cap_id"
				+ " and d.srvc_ln_id = c.srvc_ln_id"
				+ " and f.clnt_id = a.clnt_id"
				+ " and a.clsr_dt is null "
				+ " and e.job_sts_id=a.job_sts_id");
		Query q = null;
		if(jobFilterMap.containsKey("owner_rm")){
			sql.append(" and a.own_rm = :owner_rm");
			paramList.add("owner_rm");
		}
		if(jobFilterMap.containsKey("service_ln")){
			sql.append(" and c.srvc_ln_nm = :service_ln");
			paramList.add("service_ln");
		}
		if(jobFilterMap.containsKey("status")){
			sql.append(" and e.job_sts_nm = :status");
			paramList.add("status");
		}
		if(jobFilterMap.containsKey("role_nm")){
			sql.append(" and b.job_rl_nm = :role_nm");
			paramList.add("role_nm");
		}
		if(jobFilterMap.containsKey("clnt_nm")){
			sql.append(" and f.clnt_nm = :clnt_nm");
			paramList.add("clnt_nm");
		}
		q = (Query) entityManager.createNativeQuery(sql.toString());
		for (Iterator<String> iterator = paramList.iterator(); iterator.hasNext();) {
			String param = (String) iterator.next();
			q.setParameter(param, jobFilterMap.get(param));
		}
		List<Object[]> list = q.getResultList();
		for (Object[] temp : list) {
			JobDetail detail = new JobDetail();
			detail.setWwsid((String)temp[0]);
			detail.setClientName((String)temp[1]);
			detail.setServiceLine((String)temp[2]);
			detail.setServiceLineCap((String)temp[3]);
			detail.setRoleName((String)temp[4]);
			detail.setJobStatus((String)temp[5]);
			detail.setReqBy((String)temp[6]);
			detail.setReqDate(DateUtil.convertTimestamptoDate((Timestamp) temp[7]));
			jobDetList.add(detail);
		}
		return jobDetList;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO#getCandidateDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public List<CandidateDetail> getCandidateDetailsByFilterCriteria(
			Map<String, String> candidateFilterMap) {
		List<String> paramList = new ArrayList<String>();
		List<CandidateDetail> cndtDetList = new ArrayList<CandidateDetail>();
		StringBuffer sql = new StringBuffer ("select distinct a.cndt_nm,a.cndt_rsm, b.res_typ_nm, a.cntrctr_rt,c.cndt_sts_nm, d.ctzn_shp_nm, f.job_rl_nm "  
				+" from job_cndt a, resource_typ b, cndt_sts c , ctznshp_sts d, job e, job_role f, service_ln g, service_ln_cap h "
				+ " where a.res_typ_id=b.res_typ_id and a.cndt_sts_id=c.cndt_sts_id and d.ctzn_shp_id = a.ctzn_shp_id "
				+ " and e.job_id=a.job_id and e.job_rl_id = f.job_rl_id and h.srvc_ln_cap_id = f.srvc_ln_cap_id "
				+ " and h.srvc_ln_id = g.srvc_ln_id ");
		Query q = null;
		if(candidateFilterMap.containsKey("service_cap_ln")){
			sql.append(" and h.srvc_ln_cap_nm = :service_cap_ln");
			paramList.add("service_cap_ln");
		}
		if(candidateFilterMap.containsKey("service_ln")){
			sql.append(" and g.srvc_ln_nm = :service_ln");
			paramList.add("service_ln");
		}
		if(candidateFilterMap.containsKey("ctznshp_sts")){
			sql.append(" and d.ctzn_shp_nm = :ctznshp_sts");
			paramList.add("ctznshp_sts");
		}
		if(candidateFilterMap.containsKey("role_nm")){
			sql.append(" and f.job_rl_nm = :role_nm");
			paramList.add("role_nm");
		}
		if(candidateFilterMap.containsKey("cndt_sts")){
			sql.append(" and c.cndt_sts_nm = :cndt_sts");
			paramList.add("cndt_sts");
		}
		q = (Query) entityManager.createNativeQuery(sql.toString());
		for (Iterator<String> iterator = paramList.iterator(); iterator.hasNext();) {
			String param = (String) iterator.next();
			q.setParameter(param, candidateFilterMap.get(param));
		}
		List<Object[]> list = q.getResultList();
		for (Object[] temp : list) {
			CandidateDetail detail = new CandidateDetail();
			detail.setCndtName((String)temp[0]);
			detail.setCndtResume((String)temp[1]);
			detail.setResourceType((String)temp[2]);
			detail.setCntrctrRate((String)temp[3]);
			detail.setCndtStatus((String)temp[4]);
			detail.setCtznStatus((String)temp[5]);
			detail.setRoleName((String)temp[6]);
			cndtDetList.add(detail);
		}
		return cndtDetList;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO#getInterviewDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public List<InterviewDetail> getInterviewDetailsByFilterCriteria(
			Map<String, String> interviewFilterMap) {
		List<String> paramList = new ArrayList<String>();
		List<InterviewDetail> intrvwDetList = new ArrayList<InterviewDetail>();
		StringBuffer sql = new StringBuffer ("select a.intrvr_nm, a.intrvr_pos,b.intrvw_sts_nm, a.intrvr_cmnts, a.intrvw_tm from job_intrvw a, intrvw_sts b  "  
				+"  where a.intrvw_sts_id = b.intrvw_sts_id ");
		Query q = null;
		if(interviewFilterMap.containsKey("start_date") && interviewFilterMap.containsKey("end_date")){
			sql.append(" and a.intrvw_tm >= :start_date and a.intrvw_tm < :end_date");
			paramList.add("start_date");
			paramList.add("end_date");
		}
		if(interviewFilterMap.containsKey("result")){
			sql.append(" and b.intrvw_sts_nm = :result");
			paramList.add("result");
		}
		if(interviewFilterMap.containsKey("intrvwr_nm")){
			sql.append(" and a.intrvr_nm = :intrvwr_nm");
			paramList.add("intrvwr_nm");
		}
		q = (Query) entityManager.createNativeQuery(sql.toString());
		for (Iterator<String> iterator = paramList.iterator(); iterator.hasNext();) {
			String param = (String) iterator.next();
			q.setParameter(param, interviewFilterMap.get(param));
		}
		List<Object[]> list = q.getResultList();
		for (Object[] temp : list) {
			InterviewDetail detail = new InterviewDetail();
			detail.setInterviewerName((String)temp[0]);
			detail.setInterviewerPos((String)temp[1]);
			detail.setStatus((String)temp[2]);
			detail.setIntrvwComments((String)temp[3]);
			detail.setIntrvwDateTime(DateUtil.convertTimestamptoDate((Timestamp) temp[4]));
			intrvwDetList.add(detail);
		}
		return intrvwDetList;
	}

}
