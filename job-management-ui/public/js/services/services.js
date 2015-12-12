'use strict';

/* Services */

var jobMngmtServices = angular.module('jobMngmtServices', ['ngResource']);

jobMngmtServices.factory('JobDetailsFactory', function ($resource) {

  var data = $resource('http://192.168.2.6:8080/job-management-service/jobDetail', {}, {
    create: { method: 'POST',
              isArray: false
            }

    });
  return data;

  });

jobMngmtServices.factory('JobAdminFactory', function ($resource) {

    return $resource('http://192.168.2.6:8080/job-management-service/jobUtility/account', {}, {

    });

});

jobMngmtServices.factory('JobSearchFactory', function ($resource) {

        return {
            status: $resource('http://192.168.2.6:8080/job-management-service/jobUtility/jobStatus', {}),
            account: $resource('http://192.168.2.6:8080/job-management-service/jobUtility/account', {}),
            serviceLine: $resource('http://192.168.2.6:8080/job-management-service/jobUtility/serviceLine', {}),
            serviceLineCapability: $resource('http://192.168.2.6:8080/job-management-service/jobUtility/serviceLineCapability', {}),
            jobRole: $resource('http://192.168.2.6:8080/job-management-service/jobUtility/jobRole', {}),
            jobReport: $resource('http://192.168.2.6:8080/job-management-service/jobSearch?:param', {}),
            jobSearch: $resource('http://192.168.2.6:8080/job-management-service/jobSearch', {
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
            setJobDashboard: $resource('http://192.168.2.6:8080/job-management-service/userDashboard/setDashboard/:param', {param:'@userId'},
                {
                    update: {method: 'PUT',isArray: false,}
                })
}

});

jobMngmtServices.factory('CandidateSearchFactory', function ($resource) {

    return {candidateStatus: $resource('http://192.168.2.6:8080/job-management-service/jobUtility/candidateStatus', {}),
        citizenshipStatus:  $resource('http://192.168.2.6:8080/job-management-service/jobUtility/citizenshipStatus', {}),
        serviceLine:  $resource('http://192.168.2.6:8080/job-management-service/jobUtility/serviceLine', {}),
        serviceLineCapability:  $resource('http://192.168.2.6:8080/job-management-service/jobUtility/serviceLineCapability', {}),
        jobRole:  $resource('http://192.168.2.6:8080/job-management-service/jobUtility/jobRole', {}),
        candidateDefaultReport:  $resource('http://192.168.2.6:8080/job-management-service/candidateSearch?:param', {}),
        candidateReport:  $resource('http://192.168.2.6:8080/job-management-service/candidateSearch?:param', {
            owner_rm : '@userId',
            service_ln: '@serviceLineId',
            service_cap_ln:'@serviceLineCapabilityId',
            role_nm: '@jobRoleId',
            cndt_sts: '@candidateStatusId',
            ctznshp_sts: '@citizenshipStatusId'
        }),
        setCandidateDashboard: $resource('http://192.168.2.6:8080/job-management-service/userDashboard/setDashboard/:param', {param:'@userId'},
            {
                update: {method: 'PUT',isArray: false,}
            })
    };

});

jobMngmtServices.factory('InterviewSearchFactory', function ($resource) {

    return {
        interviewDefaultReport:  $resource('http://192.168.2.6:8080/job-management-service/interviewSearch?:param', {}),
        interviewReport:  $resource('http://192.168.2.6:8080/job-management-service/interviewSearch', {
            owner_rm : '@userId',
            start_date: '@interviewDateFrom',
            end_date:'@interviewDateTo',
            result: '@result',
            intrvwr_nm: '@interviewer'
        }),
        setInterviewDashboard: $resource('http://192.168.2.6:8080/job-management-service/userDashboard/setDashboard/:param', {param:'@userId'},
            {
                update: {method: 'PUT',isArray: false,}
            })
    };

});

jobMngmtServices.factory('LoginFactory', function ($resource) {

    var data = $resource('http://192.168.2.6:8080/job-management-service/userDashboard', {}, {
        userDashboard: { method: 'POST',
            isArray: false,

        }

    });
    return data;

});

jobMngmtServices.factory('JobDashboardFactory', function ($resource) {

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
       getUserDashboard: $resource('http://192.168.2.6:8080/job-management-service/userDashboard/:param', {}),
       jobReport: $resource('http://192.168.2.6:8080/job-management-service/jobSearch?:param', {}),
       candidateReport:  $resource('http://192.168.2.6:8080/job-management-service/candidateSearch?:param', {}),
       interviewReport:  $resource('http://192.168.2.6:8080/job-management-service/interviewSearch?:param', {})
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


