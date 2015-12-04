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
import com.capgemini.job.portal.dto.JobDetail;

/**
 * @author ppenamak
 *
 */
@Service("searchByFilterCriteriaDAO")
public class SearchByFilterCriteriaDAOImpl implements SearchByFilterCriteriaDAO {
	
	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO#getJobDetailsByFilterCriteria(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<JobDetail> getJobDetailsByFilterCriteria(Map<String, String> jobFilterMap) {
		List<String> paramList = new ArrayList<String>();
		List<JobDetail> jobDetList = new ArrayList<JobDetail>();
		StringBuffer sql = new StringBuffer ("select a.wwsid, f.clnt_nm,c.srvc_ln_nm, d.srvc_ln_cap_nm, b.job_rl_nm,e.job_sts_nm, a.reqstr_rm,a.req_dt "  
				+" from job a, job_role b, service_ln c, service_ln_cap d, job_sts e, account f where b.job_rl_id = a.job_rl_id"
				+ " and d.srvc_ln_cap_id = b.srvc_ln_cap_id"
				+ " and d.srvc_ln_id = c.srvc_ln_id"
				+ " and f.clnt_id = a.clnt_id"
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
			detail.setClnt_nm((String)temp[1]);
			detail.setSrvc_ln_nm((String)temp[2]);
			detail.setSrvc_ln_cap_nm((String)temp[3]);
			detail.setJob_rl_nm((String)temp[4]);
			detail.setJob_sts_nm((String)temp[5]);
			detail.setReqstr_rm((String)temp[6]);
			detail.setReq_dt((Timestamp) temp[7]);
			jobDetList.add(detail);
		}
		System.out.println(jobDetList.size());
		System.out.println(jobDetList.get(0).getJob_rl_nm());
		return jobDetList;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.job.portal.dao.SearchByFilterCriteriaDAO#getCandidateDetailsByFilterCriteria(java.util.Map)
	 */
	@Override
	public String getCandidateDetailsByFilterCriteria(
			Map<String, String> candidateFilterMap) {
		// TODO Auto-generated method stub
		return null;
	}

}
