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


jobMngmtControllers.controller('CreateCandidateCtrl', ['$scope', 'CandidateDetailsFactory',
  function($scope, candidateDetailsFactory) {

    $scope.saveJob = function() {
       $scope.jsonObj = angular.toJson($scope.vm, false);
      console.log("data: " + $scope.jsonObj);
      candidateDetailsFactory.create($scope.vm);
    }
  }]);

jobMngmtControllers.controller('DashboardCtrl', ['$scope','$cookies','$rootScope','JobDashboardFactory',
    function($scope,$cookies,$rootScope,jobDashboardFactory) {

        //alert("Hello");
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');

    //job dashboard
        $scope.jobAccountLabels = [];
        $scope.jobAccountData = [[], []];
        $scope.jobAccountSeries = ['Open', 'Aging'];
        $scope.jobBUSeries = ['Open', 'Aging'];
        $scope.jobBUData = [[],[]];
        $scope.jobBULabels = [];
        $scope.jobReportObj = [];

        var jobDashboard='';
        var candidateDashboard = '';
        var interviewDashboard='';
        var userDashboardRes = jobDashboardFactory.getUserDashboard.get({param:$rootScope.userId});
        userDashboardRes.$promise.then(function (response) {
           // alert(response.jobDashboard);
            jobDashboard=  response.jobDashboard;
            candidateDashboard=  response.candidateDashboard;
            interviewDashboard=  response.interviewDashboard;
        });

        var jobReport = jobDashboardFactory.jobReport.get({param:jobDashboard});
        jobReport.$promise.then(function (response) {
           $scope.jobReportObj = response;
            angular.forEach(response.jobAccount, function(item){

                $scope.jobAccountLabels.push(item.clientName);
                $scope.jobAccountData[0].push(item.open);
                $scope.jobAccountData[1].push(item.aging);

            });

            angular.forEach(response.jobBU, function(item){
                //alert(item.clientName);
                $scope.jobBULabels.push(item.buName);
                $scope.jobBUData[0].push(item.open);
                $scope.jobBUData[1].push(item.aging);

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

        var candidateReport = jobDashboardFactory.candidateReport.get({param:candidateDashboard});
        candidateReport.$promise.then(function (response) {
            $scope.candidateReport = response;
            angular.forEach(response.cndtAccount, function (item) {
                $scope.candidateAccountLabels.push(item.clientName);
                $scope.candidateAccountData[0].push(item.active);
                $scope.candidateAccountData[1].push(item.hired);
                $scope.candidateAccountData[2].push(item.rejected);
            });

            angular.forEach(response.cndtBU, function (item) {
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

        var interviewReport = jobDashboardFactory.interviewReport.get({param:interviewDashboard});
        interviewReport.$promise.then(function (response) {
            $scope.interviewReport = response;
            angular.forEach(response.intrvwAccount, function (item) {
                $scope.interviewAccountLabels.push(item.clientName);
                $scope.interviewAccountData[0].push(item.conducted);
                $scope.interviewAccountData[1].push(item.success);
            });

            angular.forEach(response.intrvwBU, function (item) {
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


jobMngmtControllers.controller('JobSearchCtrl', ['$scope','$rootScope','$cookies','JobSearchFactory','$filter','$location',
    function($scope,$rootScope,$cookies,jobSearchFactory,$filter,$location) {
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');
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

        $scope.setDefaultJobDashboard = function() {
           var dashboardURL = getDefaultJobDashboardURL($rootScope.userId,$scope.srcReqDateFromId, $scope.srcReqDateToId,
                $scope.roleStartDateFromId, $scope.roleStartDateTo, $scope.serviceLineId,
                $scope.statusId, $scope.jobRoleId, $scope.serviceLineCapabilityId);
            jobSearchFactory.setJobDashboard.update({param:$rootScope.userId},
                {"type": "jobDashboard","value": dashboardURL});
            $location.path("/dashboard");
        };

    }]);

jobMngmtControllers.controller('CandidateSearchCtrl', ['$scope','$rootScope','$cookies','CandidateSearchFactory','$filter','$location',
    function($scope,$rootScope,$cookies,candidateSearchFactory,$filter,$location) {
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');
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
		
		$scope.exportData = function () {
			alasql('SELECT [cndtName] as CandidateName, [resourceType] as ResourceType,[cntrctrRate] as ContractorRate, [cndtStatus] as CandidateStatus,[ctznStatus] as CitizenshipStatus, [roleName] as RoleName, [clientName] as Account, [buName] as ServiceLine INTO XLS("candidates.xls",{headers:true}) FROM ?',[$scope.candidateResultObject.candidateList]);
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

        $scope.setDefaultCandidateDashboard = function() {
            var cndtDashboardURL = getDefaultCndtDashboardURL($rootScope.userId,$scope.serviceLineId,$scope.serviceLineCapabilityId,
                $scope.jobRoleId, $scope.candidateStatusId, $scope.citizenshipStatusId);
            candidateSearchFactory.setCandidateDashboard.update({param:$rootScope.userId},
                {"type": "cndtDashboard","value": cndtDashboardURL});
            $location.path("/dashboard");
        };

    }]);

jobMngmtControllers.controller('InterviewSearchCtrl', ['$scope','$rootScope','$cookies','InterviewSearchFactory','$filter','$location',
    function($scope,$rootScope,$cookies,interviewSearchFactory,$filter,$location) {

        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');

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

        $scope.setDefaultInterviewDashboard = function() {
            var dashboardURL = getDefaultIntrvwDashboardURL($rootScope.userId,$scope.interviewDateFrom,$scope.interviewDateTo,$scope.result,$scope.interviewer);
            interviewSearchFactory.setInterviewDashboard.update({param:$rootScope.userId},
                {"type": "intrvwDashboard","value": dashboardURL});
            $location.path("/dashboard");
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
            $cookies.put("userName",response.userName);
            $rootScope.userName=response.userName;
            //$window.sessionStorage.loggedIn = true;
            //$window.sessionStorage.userId = $scope.userDashboard.userId;
           // $window.sessionStorage.setItem('loggedIn', true);
           // $window.sessionStorage.setItem('userId', $scope.userDashboard.userId);
            //$cookieStore.put("loggedin", "true");
            //alert($scope.userDashboard.userRole);
            //console.log("data.name"+$rootScope.userDashboard);
              //  alert("Hello");
            $location.path("/dashboard");

        });

        };
    }]);

jobMngmtControllers.controller('LogoutCtrl', ['$scope','$rootScope',
    function($scope,$rootScope) {
                $rootScope.loggedIn = false;

    }]);


function getDefaultJobDashboardURL(userId,srcReqDateFromId, srcReqDateToId,
                                   roleStartDateFromId, roleStartDateTo, serviceLineId,statusId, jobRoleId,
                                   serviceLineCapabilityId) {
    var url = 'owner_rm=' + userId;
    if (!isEmpty(srcReqDateFromId)) {
        url = url + '&req_start_from_date=' + srcReqDateFromId;
    }
    if (!isEmpty(srcReqDateToId)) {
        url = url + '&req_start_to_date=' + srcReqDateToId;
    }

    if (!isEmpty(roleStartDateFromId)) {
        url = url + '&role_start_from_date=' + roleStartDateFromId;
    }
    if (!isEmpty(roleStartDateTo)) {
        url = url + '&role_start_to_date=' + roleStartDateTo;
    }
    if (!isEmpty(serviceLineId)) {
        url = url + '&service_ln=' + serviceLineId;
    }
    if (!isEmpty(statusId)) {
        url = url + '&status=' + statusId;
    }
    if (!isEmpty(jobRoleId)) {
        url = url + '&role_nm=' + jobRoleId;
    }
    if (!isEmpty(serviceLineCapabilityId)) {
        url = url + '&service_ln_cap=' + serviceLineCapabilityId;
    }
    return url;
};


function getDefaultCndtDashboardURL(userId,serviceLineId,serviceLineCapabilityId,jobRoleId,candidateStatusId,citizenshipStatusId) {
    var cndtURL = 'owner_rm=' + userId;

    if (!isEmpty(serviceLineId)) {
        cndtURL = cndtURL + '&service_ln=' + serviceLineId;
    }
    if (!isEmpty(serviceLineCapabilityId)) {
        cndtURL = cndtURL + '&service_ln_cap=' + serviceLineCapabilityId;
    }
    if (!isEmpty(jobRoleId)) {
        cndtURL = cndtURL + '&role_nm=' + jobRoleId;
    }
    if (!isEmpty(candidateStatusId)) {
        cndtURL = cndtURL + '&cndt_sts=' + candidateStatusId;
    }
    if (!isEmpty(citizenshipStatusId)) {
        cndtURL = cndtURL + '&ctznshp_sts=' + citizenshipStatusId;
    }

    return cndtURL;
};


function getDefaultIntrvwDashboardURL(userId,interviewDateFrom,interviewDateTo,result,interviewer) {
    var url = 'owner_rm=' + userId;

    if (!isEmpty(interviewDateFrom)) {
        url = url + '&start_date=' + interviewDateFrom;
    }
    if (!isEmpty(interviewDateTo)) {
        url = url + '&end_date=' + interviewDateTo;
    }
    if (!isEmpty(result)) {
        url = url + '&result=' + result;
    }
    if (!isEmpty(interviewer)) {
        url = url + '&intrvwr_nm=' + interviewer;
    }

    return url;
};


function isEmpty(value){
    return (value == null || value.length === 0);
}