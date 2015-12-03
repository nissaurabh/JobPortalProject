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
  .module('jobMngmtApp', ['chart.js','ngRoute','jobMngmtServices', 'jobMngmtControllers'])
    .config(['$httpProvider',function ($httpProvider) {
        $httpProvider.defaults.useXDomain = true;
        //$httpProvider.defaults.withCredentials = true;
        delete $httpProvider.defaults.headers.common["X-Requested-With"];
        $httpProvider.defaults.headers.common["Accept"] = "application/json";
        $httpProvider.defaults.headers.common["Content-Type"] = "application/json";
    }])
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
        templateUrl: 'views/createJobMngmnt.html'
      })
        .when('/search', {
            templateUrl: 'views/menu.html'
        })
        .when('/detailsView', {
            templateUrl: 'views/dashboard.html'
        })
        .when('/jobSearchView', {
            templateUrl: 'views/jobSearch.html'
        })
        .when('/jobAdvanceSearchView', {
            templateUrl: 'views/jobAdvanceSearch.html'
        })
        .when('/candidateSearchView', {

            templateUrl: 'views/candidateSearch.html'
        })
        .when('/interviewSearchView', {
            templateUrl: 'views/interviewSearch.html'
        })
      .otherwise({
        redirectTo: '/'
      });
        $locationProvider.html5Mode(true);
  });
