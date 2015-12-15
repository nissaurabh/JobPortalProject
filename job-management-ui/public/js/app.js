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
  .module('jobMngmtApp', ['chart.js','ngRoute','ngCookies','jobMngmtServices', 'jobMngmtControllers'])
    .config(['$httpProvider',function ($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        //$httpProvider.defaults.withCredentials = true;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
        $httpProvider.defaults.headers.common["Accept"] = "application/json";
        $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }]).constant('config', {
        apiUrl: 'http://10.81.82.85:8080/job-management-service/'
        })
    /*.config(['ChartJsProvider', function(ChartJsProvider) {
        ChartJsProvider.setOptions({
            colours: ['#FF5252', '#FF8A80'],
            responsive: false
        });
        // Configure all line charts
        ChartJsProvider.setOptions('Line', {
            datasetFill: false
        });

    }])*/
    .config(function ($routeProvider,$locationProvider) {
    $routeProvider
      .when('/dashboard', {
        templateUrl: 'views/dashboard1.html',
        controller: 'DashboardCtrl'
      })
        .when('/account', {
            templateUrl: 'views/account_report.html',
            controller: 'AccountReportCtrl'
        })
        .when('/bu', {
            templateUrl: 'views/bu_report.html'
        })
      .when('/createJob', {
        templateUrl: 'views/CreateProfile.html'
      })
        .when('/search', {
            templateUrl: 'views/menu.html'
        })
        .when('/detailsView', {
            templateUrl: 'views/dashboard.html'
        })
        .when('/jobSearchView', {
            templateUrl: 'views/jobSearch.html',
            controller: 'JobSearchCtrl'
        })
        .when('/jobAdvanceSearchView', {
            templateUrl: 'views/jobAdvanceSearch.html',
            controller: 'JobSearchCtrl'
        })
        .when('/candidateSearchView', {
            templateUrl: 'views/candidateSearch.html',
            controller: 'CandidateSearchCtrl'
        })
        .when('/interviewSearchView', {
            templateUrl: 'views/interviewSearch.html',
            controller: 'InterviewSearchCtrl'
        })
        .when('/signoutView', {
            templateUrl: 'views/login-form.html',
            controller: 'LogoutCtrl'
        })
        .when('/jobDetailsView/:jobId', {
            templateUrl: 'views/jobDetails.html',
            controller: 'CreateJobCtrl'
        })
		.when('/createCandidate', {
            templateUrl: 'views/createCandidate.html'
        })
      .otherwise({
        redirectTo: '/login',
          templateUrl: 'views/login-form.html',
          controller: 'LoginCtrl'

      });
        $locationProvider.html5Mode(true);
  });
