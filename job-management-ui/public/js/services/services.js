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

/*jobMngmtServices.factory('JobAdminFactory', function ($resource) {

    return $resource('http://10.81.82.144:8080/job-management-service/jobUtility/account', {}, {
        query: { method: 'GET',
            isArray: true
        }
    });

});*/
