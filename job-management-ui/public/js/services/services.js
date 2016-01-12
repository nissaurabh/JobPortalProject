'use strict';



var jobMngmtServices = angular.module('jobMngmtServices', ['ngResource']);/* Services */

jobMngmtServices.factory('JobDetailsFactory', function ($resource,config) {

  /*var data = $resource(config.apiUrl+'jobDetail', {}, {
    create: { method: 'POST',
              isArray: false
            },

      get: { method: 'GET',
          isArray: false,
          param:{param:'@param'}
      }

    });
  return data;*/
   return {
       createJob: $resource(config.apiUrl + 'jobDetail', {},
           {
               create: {method: 'POST', isArray: false,interceptor: {
                   response: function(response) {
                       var result = response.resource;
                       result.$status = response.status;
                       return result;
                   }
               }
               }
           }),
       getJob: $resource(config.apiUrl + 'jobDetail/:jobId', {jobId:'@jobId'},
           {
               get: {method: 'GET', isArray: false,}
           })

   }

  });

jobMngmtServices.factory('JobAdminFactory', function ($resource,config) {

    return {
        status: $resource(config.apiUrl+'jobUtility/jobStatus', {}),
        account: $resource(config.apiUrl+'jobUtility/account', {}),
        serviceLine: $resource(config.apiUrl+'jobUtility/serviceLine', {}),
        serviceLineCapability: $resource(config.apiUrl+'jobUtility/serviceLineCapability', {}),
        jobRole: $resource(config.apiUrl+'jobUtility/jobRole', {}),
        jobStage : $resource(config.apiUrl+'jobUtility/jobStage', {}),
        employeeType : $resource(config.apiUrl+'jobUtility/resourceType', {})
    }

});

jobMngmtServices.factory('CandidateDetailsFactory', function ($resource,config) {
  return {
		createCandidate: $resource(config.apiUrl + 'candidate/:param', {param:'@jobId'},
			{
			   create: { method: 'POST', headers: {'Content-Type':undefined, enctype:'multipart/form-data'}, isArray: false}
}),
       getCandidate: $resource(config.apiUrl + 'candidate/retrieveDetails/:candidateId', {candidateId:'@candidateId'},
           {
               get: {method: 'GET', isArray: false,}
           }),
      getCandidatesByJobId: $resource(config.apiUrl + 'candidate/retrieveCandidateDetails/:jobId', {candidateId:'@jobId'},
          {
              get: {method: 'GET'}
          })
   }
  });

jobMngmtServices.factory('JobSearchFactory', function ($resource,config) {

        return {
            status: $resource(config.apiUrl+'jobUtility/jobStatus', {}),
            account: $resource(config.apiUrl+'jobUtility/account', {}),
            serviceLine: $resource(config.apiUrl+'jobUtility/serviceLine', {}),
            serviceLineCapability: $resource(config.apiUrl+'jobUtility/serviceLineCapability', {}),
            jobRole: $resource(config.apiUrl+'jobUtility/jobRole', {}),
            jobReport: $resource(config.apiUrl+'jobSearch?:param', {}),
            jobSearch: $resource(config.apiUrl+'jobSearch', {
                req_start_from_date: '@srcReqDateFromId',
                req_start_to_date: '@srcReqDateToId',
                role_start_from_date: '@roleStartDateFromId',
                role_start_to_date: '@roleStartDateTo',
                owner_rm: '@userId',
                service_ln: '@serviceLineId',
                status: '@statusId',
                role_nm: '@jobRoleId',
                service_ln_cap: '@serviceLineCapabilityId',
				clnt_nm: '@accountId',
				reqstr_rm: '@reqName',
				search_owner_nm: '@reqOwnName'
            }),
            setJobDashboard: $resource(config.apiUrl+'userDashboard/setDashboard/:param', {param:'@userId'},
                {
                    update: {method: 'PUT',isArray: false,}
                })
}

});

jobMngmtServices.factory('CandidateSearchFactory', function ($resource,config) {

    return {candidateStatus: $resource(config.apiUrl+'jobUtility/candidateStatus', {}),
        citizenshipStatus:  $resource(config.apiUrl+'jobUtility/citizenshipStatus', {}),
        serviceLine:  $resource(config.apiUrl+'jobUtility/serviceLine', {}),
        serviceLineCapability:  $resource(config.apiUrl+'jobUtility/serviceLineCapability', {}),
        jobRole:  $resource(config.apiUrl+'jobUtility/jobRole', {}),
        candidateDefaultReport:  $resource(config.apiUrl+'candidateSearch?:param', {}),
        candidateReport:  $resource(config.apiUrl+'candidateSearch?:param', {
            owner_rm : '@userId',
            service_ln: '@serviceLineId',
            service_cap_ln:'@serviceLineCapabilityId',
            role_nm: '@jobRoleId',
            cndt_sts: '@candidateStatusId',
            ctznshp_sts: '@citizenshipStatusId'
        }),
        setCandidateDashboard: $resource(config.apiUrl+'userDashboard/setDashboard/:param', {param:'@userId'},
            {
                update: {method: 'PUT',isArray: false,}
            })
    };

});

jobMngmtServices.factory('InterviewSearchFactory', function ($resource,config) {
    return {
        interviewDefaultReport:  $resource(config.apiUrl+'interviewSearch?:param', {}),
        interviewReport:  $resource(config.apiUrl+'interviewSearch', {
            owner_rm : '@userId',
            start_date: '@interviewDateFrom',
            end_date:'@interviewDateTo',
            result: '@result',
            intrvwr_nm: '@interviewer'
        }),
		createInterview: $resource(config.apiUrl + 'interview/:job_id/:cndt_id', {job_id:'@job_id',cndt_id:'@cndt_id'},
           {
               create: {method: 'POST', isArray: false,}
           }),
		cancelInterview: $resource(config.apiUrl + 'interview/:jobIntrvwId', {jobIntrvwId:'@jobIntrvwId'},
           {
               delete: {method: 'DELETE', isArray: false,}
           }),
        setInterviewDashboard: $resource(config.apiUrl+'userDashboard/setDashboard/:param', {param:'@userId'},
            {
                update: {method: 'PUT',isArray: false,}
            }),
	    getInterviewDetByCandidate: $resource(config.apiUrl + 'interview/retrieveDetails', {cndt_id:'@cndt_id'})
    };

});

jobMngmtServices.factory('LoginFactory',function ($resource,config) {

    var data = $resource(config.apiUrl+'userDashboard', {}, {
        userDashboard: { method: 'POST',
            isArray: false,

        }

    });
    return data;

});

jobMngmtServices.factory('JobDashboardFactory',function ($resource,config) {


   return {
       getUserDashboard: $resource(config.apiUrl+'userDashboard/:param', {}),
       jobReport: $resource(config.apiUrl+'/jobSearch?:param', {}),
       candidateReport:  $resource(config.apiUrl+'candidateSearch?:param', {}),
       interviewReport:  $resource(config.apiUrl+'interviewSearch?:param', {})
    };

});

