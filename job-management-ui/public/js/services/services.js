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
  
//Added for WWS Data Feed: Begin
jobMngmtServices.factory('WWSFileUploadFactory', function ($resource,config) {
  return {
		uploadOpenNeeds: $resource(config.apiUrl + 'wwsData/open/:param', {param:'@wwsData.sheetName'}, 
		{
			   create: { method: 'POST', headers: {'Content-Type':undefined, enctype:'multipart/form-data'}, isArray: false
		}
		}),
		uploadClosedNeeds: $resource(config.apiUrl + 'wwsData/closed/:param', {param:'@wwsData.sheetName'}, 
		{
			   create: { method: 'POST', headers: {'Content-Type':undefined, enctype:'multipart/form-data'}, isArray: false
		}
		})
   }
});

jobMngmtServices.factory('WWSViewNeedsFactory', function ($resource,config) {
  return {
		getNeedsRequiringSPUpdate: $resource(config.apiUrl + 'wwsData/no-skill-profile-needs', {}), 
		getNeedDetails: $resource(config.apiUrl + 'wwsData/need-details/:param', {param:'@wwsNeedId'}),
		updateSkillProfileForNeed: $resource(config.apiUrl + 'wwsData/update-skill-profile/:param', {param:'@wwsNeedId'}, 
			{
				   create: { method: 'POST', headers: {'Content-Type':'application/json','Accept':'application/json'}, isArray: false
			}
		}),
		getSkillCategories: $resource(config.apiUrl + 'wwsData/skill-categories', {}),
		getNeedRoles: $resource(config.apiUrl + 'wwsData/need-roles', {}),
		getCoreSkillsOfSkillCat: $resource(config.apiUrl + 'wwsData/category-core-skills/:param', {param:'@skillprof.skillCat'}),
		getRoleNamesOfRole: $resource(config.apiUrl + 'wwsData/role-names/:param', {param:'@skillprof.role'})
   }
});

jobMngmtServices.factory('WWSSearchNeedsFactory', function ($resource,config) {
  return {
		getClients: $resource(config.apiUrl + 'wwsData/clients', {}),
		getPractices: $resource(config.apiUrl + 'wwsData/practices', {}),
		getLocations: $resource(config.apiUrl + 'wwsData/locations', {}),
		getProjectTypes: $resource(config.apiUrl + 'wwsData/project-types', {}),
		getCloseReasons: $resource(config.apiUrl + 'wwsData/close-reasons', {}),
		getGrades: $resource(config.apiUrl + 'wwsData/grades', {}),
		getSkills: $resource(config.apiUrl + 'wwsData/skills', {}),
		getRoles: $resource(config.apiUrl + 'wwsData/roles', {}),
		searchMatchingNeeds: $resource(config.apiUrl + 'wwsData/search-needs', {}, 
			{
				   create: { method: 'POST', headers: {'Content-Type':'application/json','Accept':'application/json'}, isArray: true
			}
		}),
		getNeedInformation: $resource(config.apiUrl + 'wwsData/need-information/:param', {param:'@selectedNeedId'}),
		getNeedComments: $resource(config.apiUrl + 'wwsData/need-comments/:param', {param:'@selNeedId'}),
		addNeedComments: $resource(config.apiUrl + 'wwsData/add-need-comment', {}, 
			{
				   create: { method: 'POST', headers: {'Content-Type':'application/json','Accept':'application/json'}, isArray: true
			}
		}),
		deleteNeedComment: $resource(config.apiUrl + 'wwsData/delete-need-comment/:param', {param:'@commentId'},
			{
               delete: {method: 'DELETE', isArray: false}
           })
   }
});
//Added for WWS Data Feed: End


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

