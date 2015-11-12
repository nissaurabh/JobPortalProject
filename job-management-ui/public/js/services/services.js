'use strict';

/* Services */

var jobMngmtServices = angular.module('jobMngmtServices', ['ngResource']);

jobMngmtServices.factory('JobDetailsFactory', function ($resource) {


  alert("service");
  return $resource('http://10.81.82.144:8080/job-management-service/jobDetail', {}, {

    create: { method: 'POST',
      url : "http://10.81.82.144:8080/job-management-service/jobDetail",
      transformRequest: function(data, headers){
        console.log(headers);
        headers = angular.extend({}, headers, {'Content-Type': 'application/json'});
        console.log(headers);
        console.log(data);
        console.log(angular.toJson(data));
        return angular.toJson(data); // this will go in the body request
      }

    }
  })
  alert("after call");
});
