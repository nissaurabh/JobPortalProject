'use strict';

/* Services */

var jobMngmtServices = angular.module('jobMngmtServices', ['ngResource']);

jobMngmtServices.factory('JobDetailsFactory', function ($resource) {

  var data = $resource('http://10.81.82.144:8080/job-management-service/jobDetail', {}, {
    create: { method: 'POST',
              isArray: false
            }

    });
  return data;

  });

jobMngmtServices.factory('JobAdminFactory', function ($resource) {

    return $resource('http://10.81.82.144:8080/job-management-service/jobUtility/account', {}, {

    });

});

jobMngmtServices.factory('JobSearchFactory', function ($resource) {

        return {status: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/jobStatus', {}),
            account:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/account', {}),
            serviceLine:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLine', {}),
            serviceLineCapability:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLineCapability', {}),
            jobRole:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/jobRole', {}),
            jobSearch:  $resource('http://10.81.82.144:8080/job-management-service/jobSearch', {
                status:'@statusId',
                service_ln:'@serviceLineId',
                role_nm:'@jobRoleId'
            })
        };

});

jobMngmtServices.factory('CandidateSearchFactory', function ($resource) {

    return {candidateStatus: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/candidateStatus', {}),
        citizenshipStatus:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/citizenshipStatus', {}),
        serviceLine:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLine', {}),
        serviceLineCapability:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLineCapability', {}),
        jobRole:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/jobRole', {}),
        candidateReport:  $resource('http://10.81.82.144:8080/job-management-service/candidateSearch?:param', {
            serviceLineId: '@serviceLineId',
            serviceLineCapabilityId:'@serviceLineCapabilityId',
            jobRoleId: '@jobRoleId',
            candidateStatusId: '@candidateStatusId',
            citizenshipStatusId: '@citizenshipStatusId'
        })
    };

});

jobMngmtServices.factory('InterviewSearchFactory', function ($resource) {

    return {
        interviewReport:  $resource('http://10.81.82.144:8080/job-management-service/interviewSearch', {
            interviewDateFrom: '@interviewDateFrom',
            interviewDateTo:'@interviewDateTo',
            result: '@result',
            interviewer: '@interviewer'
        })
    };

});

jobMngmtServices.factory('LoginFactory', function ($resource) {

    var data = $resource('http://10.81.82.144:8080/job-management-service/userDashboard', {}, {
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
       jobReport: $resource('http://10.81.82.144:8080/job-management-service/jobSearch?:param', {}),
       candidateReport:  $resource('http://10.81.82.144:8080/job-management-service/candidateSearch?:param', {}),
       interviewReport:  $resource('http://10.81.82.144:8080/job-management-service/interviewSearch?:param', {})
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


