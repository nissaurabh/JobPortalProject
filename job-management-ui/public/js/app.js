'use strict';

/**
 * @ngdoc overview
 * @name sampleApp
 * @description
 * # sampleApp
 *
 * Main module of the application.
 */
angular
  .module('jobMngmtApp', [
    'ngRoute',
    'jobMngmtServices',
    'jobMngmtControllers'
  ])
    .config(['$httpProvider',function ($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        //$httpProvider.defaults.withCredentials = true;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
        $httpProvider.defaults.headers.common["Accept"] = "application/json";
        $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }])

    .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/createJobMngMnt.html',
        controller: 'CreateJobCtrl',
        controllerAs: 'createJob'
      })
      .when('/createJob', {
        templateUrl: 'views/dashboard.html',
        controller: 'DashboardCtrl',
        controllerAs: 'dashboard'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
