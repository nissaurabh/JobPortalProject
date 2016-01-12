'use strict';

/* Controllers */

var jobMngmtControllers = angular.module('jobMngmtControllers', []);

jobMngmtControllers.controller('CreateJobCtrl', ['$scope','$routeParams','$cookies','$rootScope','JobDetailsFactory','JobAdminFactory','$location',
  function($scope, $routeParams,$cookies,$rootScope, jobDetailsFactory, jobAdminFactory,$location) {

      $rootScope.loggedIn= $cookies.get('loggedIn');
      $rootScope.userId= $cookies.get('userId');
      $rootScope.userName= $cookies.get('userName');

    $scope.saveJob = function() {
        $scope.jsonObj = angular.toJson($scope.vm, false);
        console.log("data: " + $scope.jsonObj);
        //jobDetailsFactory.create($scope.vm);
        // $scope.createjob = jobDetailsFactory.createJob.create($scope.vm);
        var createJobResp = jobDetailsFactory.createJob.create($scope.vm);
        createJobResp.$promise.then(function (response) {
            if (response.$status == 200) {
                $scope.submissionSuccess = true;
                // $location.path("/dashboard");
            } else {
                alert("Exception from origin server .." + response.$status);
                $scope.submissionSuccess = false;
            }
        }).catch(function (error) {
            alert("Exception from origin server exception.." + error.$status);
            $scope.submissionSuccess = false;
        });
    }
        // console.log($scope.createjob.create.result.$status);    }

        $scope.jobStatuses = jobAdminFactory.status.get();
        $scope.accounts = jobAdminFactory.account.get();
        $scope.serviceLines = jobAdminFactory.serviceLine.get();
        $scope.serviceLineCapabilities = jobAdminFactory.serviceLineCapability.get();
        $scope.jobRoles = jobAdminFactory.jobRole.get();
        $scope.jobStages = jobAdminFactory.jobStage.get();
        $scope.employeeTypes = jobAdminFactory.employeeType.get();

        $scope.jobDetails = jobDetailsFactory.getJob.get({jobId: $routeParams.jobId});

    }]);

jobMngmtControllers.controller('CreateCandidateCtrl', ['$scope','$rootScope','$location','$routeParams', 'CandidateDetailsFactory','InterviewSearchFactory',
  function($scope,$rootScope,$location, $routeParams , candidateDetailsFactory,interviewSearchFactory) {
	$scope.close = function ( path ) {
		$location.path( path );
	};
    /*$scope.saveCandidate = function() {
	  var file = $scope.resume;
	  var fd = new FormData();
	  if(file!=undefined){
			fd.append('file', file);
	  }
	  fd.append('jobCandidate', angular.toJson($scope.vm, false));*/

      /*var candidate = candidateDetailsFactory.createCandidate.create({param:$routeParams.jobId},fd);
	  candidate.$promise.then(function (response) {
		//$location.path("/jobDetailsView/"+$routeParams.jobId);
          $scope.$on("candidateResultObject",function(){
              alert("great");
              $scope.candidateResultObject = candidateDetailsFactory.getCandidatesByJobId.get({jobId: $routeParams.jobId});
              alert("great1");
          });
	   });*/
	   /*alert("here");
		var uploadUrl = 'http://192.168.1.36:8080/job-management-service/candidate/' + $scope.jobDetails.jobId;
		alert(uploadUrl);
		var file = $scope.vm.resume;
	    var fd = new FormData();
		fd.append('jobCandidate', angular.toJson($scope.vm, false));
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(){
        })
        .error(function(){
        });*/
    //}
	/*$scope.candidateDetails = candidateDetailsFactory.getCandidate.get({candidateId:$routeParams.candidateId});
	$scope.interviewDetails = interviewSearchFactory.getInterviewDetByCandidate.get(
                {
                    cndt_id : $routeParams.candidateId
                }
        );
	$scope.saveInterview = function() {
       $scope.jsonObj = angular.toJson($scope.vm, false);
       interviewSearchFactory.createInterview.create({job_id:$scope.candidateDetails.jobId,cndt_id:$scope.candidateDetails.cndtId},$scope.vm);
    }
	$scope.cancelInterview = function() {
       interviewSearchFactory.createInterview.create({jobIntrvwId:$scope.detail.jobIntrvwId});
    }*/
  }]);

jobMngmtControllers.controller('DashboardCtrl', ['$scope','$cookies','$rootScope','JobDashboardFactory',
    function($scope,$cookies,$rootScope,jobDashboardFactory) {

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

            jobDashboard=  response.jobDashboard;
            candidateDashboard=  response.candidateDashboard;
            interviewDashboard=  response.interviewDashboard;

            $rootScope.jobDashboard=  response.jobDashboard;
            $rootScope.candidateDashboard=  response.candidateDashboard;
            $rootScope.interviewDashboard=  response.interviewDashboard;
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
            setJobDefaultValues($scope,$rootScope.jobDashboard);
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
                    service_ln_cap :$scope.serviceLineCapabilityId,
                    clnt_nm : $scope.accountId,
					reqstr_rm : $scope.reqName,
					search_owner_nm : $scope.reqOwnName
            });
        };

        $scope.setDefaultJobDashboard = function() {
           var dashboardURL = getDefaultJobDashboardURL($rootScope.userId,$scope.srcReqDateFromId, $scope.srcReqDateToId,
                $scope.roleStartDateFromId, $scope.roleStartDateTo, $scope.serviceLineId,
                $scope.statusId, $scope.jobRoleId, $scope.serviceLineCapabilityId,$scope.accountId);
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
            setCandidateDefaultValues($scope,$rootScope.candidateDashboard);

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
            setInterviewDefaultValues($scope,$rootScope.interviewDashboard);
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

            $cookies.put("loggedIn",'TRUE');
            $cookies.put("userId",$rootScope.userId);
            $cookies.put("userName",response.userName);
            $rootScope.userName=response.userName;

            $location.path("/dashboard");

        });

        };
    }]);

jobMngmtControllers.controller('LogoutCtrl', ['$scope','$rootScope',
    function($scope,$rootScope) {
                $rootScope.loggedIn = false;

    }]);

jobMngmtControllers.controller('JobDetailsCtrl', ['$scope','$rootScope','$cookies','$routeParams','JobDetailsFactory','CandidateDetailsFactory',
    function($scope,$rootScope,$cookies,$routeParams,jobDetailsFactory, candidateDetailsFactory) {
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');
        $scope.candidateResultObject = [];
        $scope.jobDetails = jobDetailsFactory.getJob.get({jobId: $routeParams.jobId});

       // $scope.candidateResultObject = candidateDetailsFactory.getCandidatesByJobId.get({jobId: $routeParams.jobId});

       /* $scope.$on("candidateResultObject", function () {
            alert("great34");
            $scope.candidateResultObject = candidateDetailsFactory.getCandidatesByJobId.get({jobId: $routeParams.jobId});
            alert("great15456");
        });*/


        $scope.readCandidateList = function(){
            $scope.candidateResultObject = candidateDetailsFactory.getCandidatesByJobId.get({jobId: $routeParams.jobId});
        }

        $scope.readCandidateList();

        $scope.saveCandidate = function() {

            var file = $scope.resume;
            var fd = new FormData();
            if (file != undefined) {
                fd.append('file', file);
            }
            fd.append('jobCandidate', angular.toJson($scope.vm, false));
            var candidate = candidateDetailsFactory.createCandidate.create({param: $routeParams.jobId}, fd);
            candidate.$promise.then(function (response) {
                $scope.readCandidateList();
            });
        }

    }]);


function getDefaultJobDashboardURL(userId,srcReqDateFromId, srcReqDateToId,
                                   roleStartDateFromId, roleStartDateTo, serviceLineId,statusId, jobRoleId,
                                   serviceLineCapabilityId,accountId) {
    var url = 'owner_rm=' + userId;
    if (!isEmpty(srcReqDateFromId)) {
        url = url + '&req_start_from_date=' + formatDate(srcReqDateFromId);
    }
    if (!isEmpty(srcReqDateToId)) {
        url = url + '&req_start_to_date=' + formatDate(srcReqDateToId);
    }

    if (!isEmpty(roleStartDateFromId)) {
        url = url + '&role_start_from_date=' + formatDate(roleStartDateFromId);
    }
    if (!isEmpty(roleStartDateTo)) {
        url = url + '&role_start_to_date=' + formatDate(roleStartDateTo);
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
    if (!isEmpty(serviceLineCapabilityId)) {
        url = url + '&clnt_nm=' + accountId;
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
        url = url + '&start_date=' + formatDate(interviewDateFrom);
    }
    if (!isEmpty(interviewDateTo)) {
        url = url + '&end_date=' + formatDate(interviewDateTo);
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

function setJobDefaultValues($scope,url) {

    var queryString = url.split('&');
    for (var i = 0; i < queryString.length; i++) {
        var parameter = queryString[i].split('=');
        if ('req_start_from_date' == parameter[0]) {
            $scope.srcReqDateFromId = new Date(parameter[1]);
        } else if ('req_start_to_date' == parameter[0]) {
            $scope.srcReqDateToId = new Date(parameter[1]);
        } else if ('role_start_from_date' == parameter[0]) {
            $scope.roleStartDateFromId = new Date(parameter[1]);
        } else if ('role_start_to_date' == parameter[0]) {
            $scope.roleStartDateTo = new Date(parameter[1]);
        } else if ('service_ln' == parameter[0]) {
            $scope.serviceLineId = parameter[1];
        } else if ('status' == parameter[0]) {
            $scope.statusId = parameter[1];
        } else if ('role_nm' == parameter[0]) {
            $scope.jobRoleId = parameter[1];
        } else if ('service_ln_cap' == parameter[0]) {
            $scope.serviceLineCapabilityId = parameter[1];
        } else if ('clnt_nm' == parameter[0]) {
            $scope.accountId = parameter[1];
        }
    }
}
    function setCandidateDefaultValues($scope,url){

        var queryString = url.split('&');
        for(var i = 0; i < queryString.length; i++){
            var parameter = queryString[i].split('=');
            if('service_ln'==parameter[0]){
                $scope.serviceLineId=parameter[1];
            }else if('service_ln_cap'==parameter[0]){
                $scope.serviceLineCapabilityId=parameter[1];
            }else if('role_nm'==parameter[0]){
                $scope.jobRoleId=parameter[1];
            }else if('cndt_sts'==parameter[0]){
                $scope.candidateStatusId=parameter[1];
            }else if('ctznshp_sts'==parameter[0]){
                $scope.citizenshipStatusId=parameter[1];
            }
        }
}

function setInterviewDefaultValues($scope,url){

    var queryString = url.split('&');
    for(var i = 0; i < queryString.length; i++){
        var parameter = queryString[i].split('=');
        if('start_date'==parameter[0]){
            $scope.interviewDateFrom=new Date(parameter[1]);
        }else if('end_date'==parameter[0]){
            $scope.interviewDateTo=new Date(parameter[1]);
        }else if('result'==parameter[0]){
            $scope.result=parameter[1];
        }else if('intrvwr_nm'==parameter[0]){
            $scope.interviewer=parameter[1];
        }
    }

}

function formatDate(value)
{
    return value.getMonth()+1 + "/" + value.getDate() + "/" + value.getFullYear();
}
