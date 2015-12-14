'use strict';



var jobMngmtServices = angular.module('jobMngmtServices', ['ngResource']);/* Services */

jobMngmtServices.factory('JobDetailsFactory', function ($resource,config) {

  var data = $resource(config.apiUrl+'jobDetail', {}, {
    create: { method: 'POST',
              isArray: false
            }

    });
  return data;

  });

jobMngmtServices.factory('JobAdminFactory', function ($resource,config) {

    return $resource(config.apiUrl+'jobUtility/account', {}, {

    });

});

jobMngmtServices.factory('CandidateDetailsFactory', function ($resource,config) {

  var data = $resource(config.apiUrl+'candidate', {}, {
    create: { method: 'POST',
              isArray: false
            }

    });
  return data;

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
                service_ln_cap: '@serviceLineCapabilityId'
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
        setInterviewDashboard: $resource(config.apiUrl+'userDashboard/setDashboard/:param', {param:'@userId'},
            {
                update: {method: 'PUT',isArray: false,}
            })
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

  /* var data = $resource('http://10.81.82.144:8080/job-management-service/', {}, {
        jobReport: {
            url:'jobSearch?:param',
            params:{param:'@param'},
            method: 'GET',
            isArray: false
        },
       candidateReport: {
           url:'candidateSearch?:param',
           method: 'GET',
           params:{param:'@param'},
           isArray: false
       }

    });

    return data;*/
   return {
       getUserDashboard: $resource(config.apiUrl+'userDashboard/:param', {}),
       jobReport: $resource(config.apiUrl+'/jobSearch?:param', {}),
       candidateReport:  $resource(config.apiUrl+'candidateSearch?:param', {}),
       interviewReport:  $resource(config.apiUrl+'interviewSearch?:param', {})
    };
   /*return {

        //jobDashboard:  $resource('http://10.81.82.144:8080/job-management-service/:jobDashboardURL', {jobDashboardURL:'@jobDashboardURL'})
       jobDashboard: function(param) {
           alert(param);
           return $resource('http://10.81.82.144:8080/job-management-service/'+param);
       }
        //candidateDashboard:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLine', {}),
        //interviewDashboard:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLineCapability', {})
    };*/
});

/*jobMngmtServices.factory('JobDashboardFactory',['$resource',function($resource){
    return $resource(":param",{},
        {
            get:{

                method: 'GET',
                isArray:true}}
    );
}]);*/


