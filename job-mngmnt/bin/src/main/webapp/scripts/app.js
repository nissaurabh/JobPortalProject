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
