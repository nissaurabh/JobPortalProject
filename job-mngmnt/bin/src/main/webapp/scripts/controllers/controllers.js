'use strict';

/* Controllers */

var jobMngmtControllers = angular.module('jobMngmtControllers', []);

jobMngmtControllers.controller('CreateJobCtrl', ['$scope', 'JobDetailsFactory',
  function($scope, jobDetailsFactory) {
    alert("hello");
    $scope.saveJob = function() {
      alert("hello");
      $scope.jsonObj = angular.toJson($scope.vm, false);
      console.log("data: " + $scope.jsonObj);
      jobDetailsFactory.create($scope.vm);
      alert("hello1");
    }
  }]);
