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
        jobRole:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/jobRole', {})
};

});

jobMngmtServices.factory('CandidateSearchFactory', function ($resource) {

    return {candidateStatus: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/candidateStatus', {}),
        citizenshipStatus:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/citizenshipStatus', {}),
        serviceLine:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLine', {}),
        serviceLineCapability:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLineCapability', {}),
        jobRole:  $resource('http://10.81.82.144:8080/job-management-service/jobUtility/jobRole', {})
    };

});
