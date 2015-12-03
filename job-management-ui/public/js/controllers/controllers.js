'use strict';

/* Controllers */

var jobMngmtControllers = angular.module('jobMngmtControllers', []);

jobMngmtControllers.controller('CreateJobCtrl', ['$scope', 'JobDetailsFactory','JobAdminFactory',
  function($scope, jobDetailsFactory, jobAdminFactory) {

    $scope.saveJob = function() {
       $scope.jsonObj = angular.toJson($scope.vm, false);
      console.log("data: " + $scope.jsonObj);
      jobDetailsFactory.create($scope.vm);
    }

   $scope.accounts = jobAdminFactory.get();
      console.log($scope.accounts);

  }]);

jobMngmtControllers.controller('DashboardCtrl', ['$scope',
    function($scope) {

        $scope.labels =["Open","Closed"];

        $scope.data = [
            65, 59
        ];

        $scope.labels1 = ["Java", "In-Store Sales", "Mail-Order Sales"];
        $scope.data1 = [300, 500, 100];


        //jobs account
        $scope.jobAccountLabels = ["Disney", "Cisco", "AT&T", "Walmart"];
        $scope.jobAccountSeries = ['Open', 'Aging'];
        $scope.jobAccountData = [
            [10, 59, 30, 71],
            [28, 34, 80, 19]
        ];

        //jobs bu
        $scope.jobBULabels = ["Htech", "Govt Services"];
        $scope.jobBUSeries = ['Open', 'Aging'];
        $scope.jobBUData = [
            [65, 59],
            [28, 48]
        ];

        //candidate account
        $scope.candidateAccountLabels = ["Disney", "Cisco", "AT&T", "Walmart"];
        $scope.candidateAccountSeries = ['Active', 'Hired', 'Rejected'];
        $scope.candidateAccountData = [
            [65, 59, 80, 81],
            [28, 48, 40, 19],
            [90, 20, 76, 34]
        ];

        //candidate bu
        $scope.candidateBULabels = ["Htech", "Govt Services"];
        $scope.candidateBUSeries = ['Active', 'Hired', 'Rejected'];
        $scope.candidateBUData = [
            [65, 59],
            [28, 48],
            [56, 86]
        ];

        //interview account
        $scope.interviewAccountLabels = ["Disney", "Cisco", "AT&T", "Walmart"];
        $scope.interviewAccountSeries = ['Conducted', 'Success'];
        $scope.interviewAccountData = [
            [65, 59, 80, 81],
            [28, 48, 40, 19]
        ];

        //interview bu
        $scope.interviewBULabels = ["Htech", "Govt Services"];
        $scope.interviewBUSeries = ['Conducted', 'Success'];
        $scope.interviewBUData = [
            [65, 59],
            [28, 48]
        ];

      /* $scope.colours = [
            { // grey
                fillColor: '#CC7C21',
                strokeColor: 'rgba(204,124,33,1)',
                pointColor: 'rgba(204,124,33,1)',
                pointStrokeColor: 'rgba(204,124,33,1)',
                pointHighlightFill: 'rgba(204,124,33,1)',
                pointHighlightStroke: 'rgba(204,124,33,1)'
            },
           { // grey
               fillColor: '#234B4D',
               strokeColor: 'rgba(35,75,77,1)',
               pointColor: 'rgba(35,75,77,1)',
               pointStrokeColor: 'rgba(35,75,77,1)',
               pointHighlightFill: 'rgba(35,75,77,1)',
               pointHighlightStroke: 'rgba(35,75,77,1)'
           },
            { // dark grey
                fillColor: '#76B0B3',
                strokeColor: 'rgba(118,176,179,1)',
                pointColor: 'rgba(118,176,179,1)',
                pointStrokeColor: 'rgba(118,176,179,1)',
                pointHighlightFill: 'rgba(118,176,179,1)',
                pointHighlightStroke: 'rgba(118,176,179,1)'
            }
        ];*/

    }]);

jobMngmtControllers.controller('AccountReportCtrl', ['$scope',
    function($scope) {

        $scope.labels = ['Disney','Cisco','AT&T','Walmart'];
        $scope.status = ['OPEN', 'AGING'];

        $scope.data = [
            [65, 59,50,90],
            [28, 48,14,75]
        ];
        $scope.colours = [
            { // grey
                fillColor: '#F79256',
                strokeColor: 'rgba(1,159,177,1)',
                pointColor: 'rgba(1,159,177,1)',
                pointStrokeColor: '#',
                pointHighlightFill: '#',
                pointHighlightStroke: 'rgba(1,159,177,0.8)'
            },
            { // dark grey
                fillColor: '#7DCFB6',
                strokeColor: 'rgba(77,83,96,1)',
                pointColor: 'rgba(77,83,96,1)',
                pointStrokeColor: '#fff',
                pointHighlightFill: '#fff',
                pointHighlightStroke: 'rgba(77,83,96,1)'
            }
        ];

    }]);
