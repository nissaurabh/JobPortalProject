'use strict';

/* Controllers */

var jobMngmtControllers = angular.module('jobMngmtControllers', []);

jobMngmtControllers.controller('CreateJobCtrl', ['$scope', 'JobDetailsFactory',
  function($scope, jobDetailsFactory) {

    $scope.saveJob = function() {
       $scope.jsonObj = angular.toJson($scope.vm, false);
      console.log("data: " + $scope.jsonObj);
      jobDetailsFactory.create($scope.vm);
    }

   // $scope.accounts = jobAdminFactory.query();

  }]);
