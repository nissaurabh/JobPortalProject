package com.job.mngmnt.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.cxf.common.util.CollectionUtils;
import org.springframework.stereotype.Service;

import com.job.mngmnt.dao.JobDetailsDAO;
import com.job.mngmnt.entities.Account;
import com.job.mngmnt.entities.EmplTyp;
import com.job.mngmnt.entities.Job;
import com.job.mngmnt.entities.JobRole;
import com.job.mngmnt.entities.JobSt;
import com.job.mngmnt.entities.JobStg;

@Service("jobDetailsDAO")
public class JobDetailsDAOImpl implements JobDetailsDAO {

	@PersistenceContext(unitName = "persistenceUnit")
	private EntityManager entityManager;

	// @Autowired
	/*
	 * @Qualifier("jpaTemplate") private JpaTemplate jpaTemplate = null;
	 */

	public void storeJob(Job job) {
		/*
		 * JobSt jobSts = new JobSt(); jobSts.setJobStsNm(status);
		 * 
		 * jobSts.setCreateDts(new Timestamp(System.currentTimeMillis()));
		 * jobSts.setCreateUsrId("jobmngmnt"); jobSts.setUpdtDts(new
		 * Timestamp(System.currentTimeMillis()));
		 * jobSts.setUpdtUsrId("jobmngmnt");
		 */
		entityManager.persist(job);

	}

	public Account getAccount(int acctId) {
		Account accout = null;
		Query query = entityManager.createNamedQuery("account.findAccount");
		query.setParameter("clntId", acctId);
		List<Account> acctList = (List<Account>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(acctList)){
			accout = acctList.get(0);
		}
		
		return accout;

	}
	
	public EmplTyp getEmplTyp(int emptTypId) {
		EmplTyp emplTyp = null;
		Query query = entityManager.createNamedQuery("emplTyp.findEmplTyp");
		query.setParameter("emptTypId", emptTypId);
		List<EmplTyp> emplTypList = (List<EmplTyp>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(emplTypList)){
			emplTyp = emplTypList.get(0);
		}
		
		return emplTyp;

	}
	
	public JobRole getJobRole(int jobRlId) {
		JobRole jobRole = null;
		Query query = entityManager.createNamedQuery("jobRole.findJobRole");
		query.setParameter("jobRlId", jobRlId);
		List<JobRole> jobRoleList = (List<JobRole>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobRoleList)){
			jobRole = jobRoleList.get(0);
		}
		
		return jobRole;

	}
	
	public JobSt getJobStatus(int jobStsId) {
		JobSt jobSt = null;
		Query query = entityManager.createNamedQuery("jobSt.findJobSt");
		query.setParameter("jobStsId", jobStsId);
		List<JobSt> jobStList = (List<JobSt>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobStList)){
			jobSt = jobStList.get(0);
		}
		
		return jobSt;

	}
	
	public JobStg getJobStage(int jobStgId) {
		JobStg jobStg = null;
		Query query = entityManager.createNamedQuery("jobStg.findJobStgId");
		query.setParameter("jobStgId", jobStgId);
		List<JobStg> jobStgList = (List<JobStg>) query.getResultList();
		
		if(!CollectionUtils.isEmpty(jobStgList)){
			jobStg = jobStgList.get(0);
		}
		
		return jobStg;

	}

}