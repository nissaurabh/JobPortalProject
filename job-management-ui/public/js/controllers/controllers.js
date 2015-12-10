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

jobMngmtControllers.controller('DashboardCtrl', ['$scope','$cookies','$rootScope','JobDashboardFactory',
    function($scope,$cookies,$rootScope,jobDashboardFactory) {


        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');

    //job dashboard
        $scope.jobAccountLabels = [];
        $scope.jobAccountData = [[], []];
        $scope.jobAccountSeries = ['Open', 'Aging'];
        $scope.jobBUSeries = ['Open', 'Aging'];
        $scope.jobBUData = [[],[]];
        $scope.jobBULabels = [];
        $scope.jobReportObj = [];
        var jobReport = jobDashboardFactory.jobReport.get({param:$rootScope.jobDashboard});
        jobReport.$promise.then(function (response) {
           $scope.jobReportObj = response;
            angular.forEach(response.jobAccount, function(item){

                $scope.jobAccountLabels.push(item.clientName);
                $scope.jobAccountData[0].push(item.Open);
                $scope.jobAccountData[1].push(item.Aging);

            });

            angular.forEach(response.jobBU, function(item){
                //alert(item.clientName);
                $scope.jobBULabels.push(item.buName);
                $scope.jobBUData[0].push(item.Open);
                $scope.jobBUData[1].push(item.Aging);

            });

       });

        //candidate dashboard
        $scope.candidateAccountLabels = [];
        $scope.candidateAccountData = [[], [],[]];
        $scope.candidateBUSeries = ['Active', 'Hired', 'Rejected'];
        $scope.candidateAccountSeries = ['Active', 'Hired', 'Rejected'];
        $scope.candidateBUData = [[],[],[]];
        $scope.candidateBULabels = [];
        $scope.candidateReport = [];

        var candidateReport = jobDashboardFactory.candidateReport.get({param:$rootScope.candidateDashboard});
        candidateReport.$promise.then(function (response) {
            $scope.candidateReport = response;
            angular.forEach(response.candidateAccount, function (item) {
                $scope.candidateAccountLabels.push(item.clientName);
                $scope.candidateAccountData[0].push(item.active);
                $scope.candidateAccountData[1].push(item.hired);
                $scope.candidateAccountData[2].push(item.rejected);
            });

            angular.forEach(response.candidateBU, function (item) {
                $scope.candidateBULabels.push(item.buName);
                $scope.candidateBUData[0].push(item.active);
                $scope.candidateBUData[1].push(item.hired);
                $scope.candidateBUData[2].push(item.rejected);

            });
        });

        //interview dashboard
        $scope.interviewAccountLabels = [];
        $scope.interviewAccountData = [[], []];
        $scope.interviewBUSeries = ['Conducted', 'Success'];
        $scope.interviewAccountSeries = ['Conducted', 'Success'];
        $scope.interviewBUData = [[],[]];
        $scope.interviewBULabels = [];
        $scope.interviewReport = [];

        var interviewReport = jobDashboardFactory.interviewReport.get({param:$rootScope.interviewDashboard});
        interviewReport.$promise.then(function (response) {
            $scope.interviewReport = response;
            angular.forEach(response.interviewAccount, function (item) {
                $scope.interviewAccountLabels.push(item.clientName);
                $scope.interviewAccountData[0].push(item.conducted);
                $scope.interviewAccountData[1].push(item.success);
            });

            angular.forEach(response.interviewBU, function (item) {
                //alert(item.clientName);
                $scope.interviewBULabels.push(item.buName);
                $scope.interviewBUData[0].push(item.conducted);
                $scope.interviewBUData[1].push(item.success);

            });
        });


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


jobMngmtControllers.controller('JobSearchCtrl', ['$scope','$rootScope','$cookies','JobSearchFactory','$filter',
    function($scope,$rootScope,$cookies,jobSearchFactory,$filter) {
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $scope.serviceLineCapabilityList =[];
        $scope.serviceLineCapabilities = [];
        $scope.jobRolesList =[];
        $scope.jobRoles = [];
        $scope.jobSearchResult = [];
        $scope.jobStatuses = jobSearchFactory.status.get();
        $scope.accounts = jobSearchFactory.account.get();
        $scope.serviceLines = jobSearchFactory.serviceLine.get();
        $scope.serviceLineCapabilities = jobSearchFactory.serviceLineCapability.get();
        $scope.jobRoles = jobSearchFactory.jobRole.get();

        $scope.serviceLineChanged = function(serviceLineId) {
            $scope.serviceLineCapabilityList = ($filter('filter')($scope.serviceLineCapabilities.serviceLineCapability, {serviceLineId: serviceLineId}));
        };

        $scope.serviceLineCapChanged = function(serviceLineCapabilityId) {
            $scope.jobRolesList = ($filter('filter')($scope.jobRoles.jobRole, {serviceLineCapabilityId: serviceLineCapabilityId}));
        };

        var jobReport = jobSearchFactory.jobReport.get({param:$rootScope.jobDashboard});
        jobReport.$promise.then(function (response) {
            $scope.jobSearchResult = response;
        });

        $scope.jobSearch = function(jobSearch) {
            $scope.jobSearchResult = jobSearchFactory.jobSearch.get(
                {
                    req_start_from_date : $scope.srcReqDateFromId,
                    req_start_to_date : $scope.srcReqDateToId,
                    role_start_from_date : $scope.roleStartDateFromId,
                    role_start_to_date : $scope.roleStartDateTo,
                    owner_rm:$rootScope.userId,
                    service_ln:$scope.serviceLineId,
                    status: $scope.statusId,
                    role_nm:$scope.jobRoleId,
                    service_ln_cap :$scope.serviceLineCapabilityId
            });
        };

    }]);

jobMngmtControllers.controller('CandidateSearchCtrl', ['$scope','$rootScope','$cookies','CandidateSearchFactory','$filter',
    function($scope,$rootScope,$cookies,candidateSearchFactory,$filter) {
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $scope.serviceLineCapabilityList =[];
        $scope.serviceLineCapabilities = [];
        $scope.jobRolesList =[];
        $scope.jobRoles = [];
        $scope.candidateStatuses = candidateSearchFactory.candidateStatus.get();
        $scope.citizenshipStatuses = candidateSearchFactory.citizenshipStatus.get();
        $scope.serviceLines = candidateSearchFactory.serviceLine.get();
        $scope.serviceLineCapabilities = candidateSearchFactory.serviceLineCapability.get();
        $scope.jobRoles = candidateSearchFactory.jobRole.get();
        //$scope.recipe = Api.Recipe.get({id: 1});

        $scope.serviceLineChanged = function(serviceLineId) {

            $scope.serviceLineCapabilityList = ($filter('filter')($scope.serviceLineCapabilities.serviceLineCapability, {serviceLineId: serviceLineId}));
        };

        $scope.serviceLineCapChanged = function(serviceLineCapabilityId) {

            $scope.jobRolesList = ($filter('filter')($scope.jobRoles.jobRole, {serviceLineCapabilityId: serviceLineCapabilityId}));
        };
        $scope.candidateResultObject = [];

        var candidateReport = candidateSearchFactory.candidateDefaultReport.get({param:$rootScope.candidateDashboard});
        candidateReport.$promise.then(function (response) {
            $scope.candidateResultObject = response;

        });

            $scope.candidateSearch = function() {
            $scope.candidateResultObject = candidateSearchFactory.candidateReport.get(
                {
                    owner_rm : $rootScope.userId,
                    service_ln: $scope.serviceLineId,
                    service_cap_ln:$scope.serviceLineCapabilityId,
                    role_nm: $scope.jobRoleId,
                    cndt_sts: $scope.candidateStatusId,
                    ctznshp_sts: $scope.citizenshipStatusId
                }
            );
        };

    }]);

jobMngmtControllers.controller('InterviewSearchCtrl', ['$scope','$rootScope','$cookies','InterviewSearchFactory','$filter',
    function($scope,$rootScope,$cookies,interviewSearchFactory,$filter) {

        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');

        $scope.interviewSearchResultObject = [];


        var interviewReport = interviewSearchFactory.interviewDefaultReport.get({param:$rootScope.interviewDashboard});
        interviewReport.$promise.then(function (response) {
            $scope.interviewSearchResultObject = response;
        });

        $scope.interviewSearch = function() {
            $scope.interviewSearchResultObject = interviewSearchFactory.interviewReport.get(
                {
                    owner_rm : $rootScope.userId,
                    start_date: $scope.interviewDateFrom,
                    end_date:$scope.interviewDateTo,
                    result: $scope.result,
                    intrvwr_nm: $scope.interviewer
                }
            );
        };

    }]);

jobMngmtControllers.controller('LoginCtrl', ['$scope','$rootScope','$cookies','$window','$location','LoginFactory',
    function($scope,$rootScope,$cookies, $window,$location,loginFactory) {

        $scope.userDashboard = [];
        $scope.login = function() {
            $scope.userDashboard = loginFactory.userDashboard($scope.user);
            return  $scope.userDashboard.$promise.then(function (response) {
            $scope.userDashboard = response;
            $rootScope.userRole =  $scope.userDashboard.userRole;
            $rootScope.userId=  $scope.userDashboard.userId;
            $rootScope.jobDashboard=  $scope.userDashboard.jobDashboard;
            $rootScope.candidateDashboard=  $scope.userDashboard.candidateDashboard;
            $rootScope.interviewDashboard=  $scope.userDashboard.interviewDashboard;
            //$rootScope.$apply();
           // $sessionStorage.loggedIn= true;
            //$sessionStorage.userId = $scope.userDashboard.userId;
            $cookies.put("loggedIn",'TRUE');
            $cookies.put("userId",$rootScope.userId);
            //$window.sessionStorage.loggedIn = true;
            //$window.sessionStorage.userId = $scope.userDashboard.userId;
           // $window.sessionStorage.setItem('loggedIn', true);
           // $window.sessionStorage.setItem('userId', $scope.userDashboard.userId);
            //$cookieStore.put("loggedin", "true");
            //alert($scope.userDashboard.userRole);
            //console.log("data.name"+$rootScope.userDashboard);
            $location.path("/dashboard");

        });

        };
    }]);

jobMngmtControllers.controller('LogoutCtrl', ['$scope','$rootScope',
    function($scope,$rootScope) {
                $rootScope.loggedIn = false;

    }]);