'use strict';

/* Controllers for WWS Data features */

var wwsDataControllers = angular.module('wwsDataControllers', []);
//alert("wws-data-controllers.js loaded");
wwsDataControllers.controller('LoadOpenNeedsController', ['$scope','$rootScope','$cookies','$window','$location','WWSFileUploadFactory',
    function($scope,$rootScope,$cookies, $window,$location, wwsFileUploadFactory) {
		//alert("in LoadOpenNeedsController of wws-data-controllers.js");
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');
		
		$scope.uploadServcResp = [];
        $scope.wwsData = [];
			
		$scope.uploadOpenNeedsFile = function() {
			alert("form data inner: "+ $scope.wwsData.sheetName);
			var file = $scope.wwsData.openNeedsFile;
            var fd = new FormData();
            if (file != undefined) {
				//alert("File is defined");
                fd.append('file', file);
            } else {
				alert("File is UNdefined");
			}
			
			var wwsDataUpld = wwsFileUploadFactory.uploadOpenNeeds.create({param: $scope.wwsData.sheetName}, fd);
            wwsDataUpld.$promise.then(function (response) {
                $scope.uploadServcResp = response;
				alert("Uploaded Successfully: \n"+JSON.stringify(response));
            },
			function (reason) {
				alert("Error Uploading the Open Needs File: \n"+reason);
			});
		}
}]);

wwsDataControllers.controller('LoadClosedNeedsController', ['$scope','$rootScope','$cookies','$window','$location','WWSFileUploadFactory',
    function($scope,$rootScope,$cookies, $window,$location, wwsFileUploadFactory) {
		//alert("in LoadOpenNeedsController of wws-data-controllers.js");
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');
		
		$scope.uploadServcResp = [];
        $scope.wwsData = [];
			
		$scope.uploadClosedNeedsFile = function() {
			alert("form data inner: "+ $scope.wwsData.sheetName);
			var file = $scope.wwsData.closedNeedsFile;
            var fd = new FormData();
            if (file != undefined) {
				//alert("File is defined");
                fd.append('file', file);
            } else {
				alert("File is UNdefined");
			}
			
			var wwsDataUpld = wwsFileUploadFactory.uploadClosedNeeds.create({param: $scope.wwsData.sheetName}, fd);
            wwsDataUpld.$promise.then(function (response) {
                $scope.uploadServcResp = response;
				alert("Uploaded Successfully: \n"+JSON.stringify(response));
            },
			function (reason) {
				alert("Error Uploading the Open Needs File: \n"+reason);
			});
		}
}]);

wwsDataControllers.controller('NeedsRequiringSPController', ['$scope','$rootScope','$cookies','$window','$location','WWSViewNeedsFactory',
    function($scope,$rootScope,$cookies, $window,$location, wwsViewNeedsFactory) {
		//alert("in NeedsRequiringSPController of wws-data-controllers.js");
		//$scope.sortType='projectType';
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');
		
		$scope.needsRequiringSP = [];
		$scope.needDetails = [];
		$scope.skillprof = [];
		$scope.skillCategories = [];
		$scope.needRoles = [];
		$scope.coreSkills = [];
		$scope.roleNames= [];
		
		var wwsNeedsCall = wwsViewNeedsFactory.getNeedsRequiringSPUpdate.query();
		wwsNeedsCall.$promise.then(function (response) {
				$scope.needsRequiringSP = response;
				//alert("Received Needs reuqiring SP Data: \n"+JSON.stringify(response));
			},
			function (reason) {
				alert("Error receiving Needs reuqiring SP Data: \n"+reason);
		});
		
		$scope.attachSkillProfileToNeed = function() {
				alert("Submit the Skill profile to Server - Under Construction..."+$scope.skillprof.wwsId);
				//update-skill-profile/
				var reqBody = {
					wwsId: $scope.skillprof.wwsId,
					skillCategory: $scope.skillprof.newSkillCat,
					skill: $scope.skillprof.newCoreSkill,
					roleName: $scope.skillprof.newRoleNm,
					role: $scope.skillprof.newRole,
					existingSkillId: $scope.skillprof.existingSkillId,
					existingRoleId: $scope.skillprof.existingRoleId,
					defineNewSkill: $scope.skillprof.defineNewSkill,
					defineNewRole: $scope.skillprof.defineNewRole
				};	
				var updateSkillProfileCall = wwsViewNeedsFactory.updateSkillProfileForNeed.create({param:$scope.skillprof.wwsId}, reqBody);
				updateSkillProfileCall.$promise.then(function (response) {
					//alert("Update Skill Profile Response: "+JSON.stringify(response));
					//refresh the needs list requiring skill profile after updating the SP for this need
					$scope.needsRequiringSP = wwsViewNeedsFactory.getNeedsRequiringSPUpdate.query();
				},
				function (reason) {
					alert("Error Updating SkillProfile: \n"+JSON.stringify(reason));
				});

		}
		
		$scope.skillCategoryChanged = function() {
			//alert('Selected Skill Category: '+$scope.skillprof.skillCat);
			$scope.coreSkills = [];
			if (null != $scope.skillprof.skillCat) {
				var coreSkillsCall = wwsViewNeedsFactory.getCoreSkillsOfSkillCat.query({param:$scope.skillprof.skillCat});
				coreSkillsCall.$promise.then(function (response) {
					$scope.coreSkills = response;
					//alert("Core Skills: "+JSON.stringify($scope.coreSkills));
				},
				function (reason) {
					alert("Error receiving Core Skill : \n"+reason);
				});
			}
		}
		
		$scope.needRoleChanged = function() {
			//alert('Selected Role: '+$scope.skillprof.role);
			
			$scope.roleNames = [];
			if (null != $scope.skillprof.role) {
				var roleNamesCall = wwsViewNeedsFactory.getRoleNamesOfRole.query({param:$scope.skillprof.role});
				roleNamesCall.$promise.then(function (response) {
					$scope.roleNames = response;
					//alert("role names: "+JSON.stringify($scope.roleNames));
				},
				function (reason) {
					alert("Error receiving Role Names : \n"+reason);
				});
			}
		}	
		
		$scope.fetchNeedDetails = function(wwsNeedId) {
			$scope.needDetails = [];
			//alert("Need to fetch need Details for :"+wwsNeedId);
			//Fetch the need details for given id
			var needDetailsCall = wwsViewNeedsFactory.getNeedDetails.get({param:wwsNeedId});
			needDetailsCall.$promise.then(function (response) {
				$scope.needDetails = response;
				$scope.skillprof.wwsId = wwsNeedId;
				//alert("Need Details: "+JSON.stringify($scope.needDetails));
			},
			function (reason) {
				alert("Error receiving Need Details: \n"+reason);
			});
			
			//Fetch Skill Categories
			$scope.skillCategories = [];
			var skillCategoriesCall = wwsViewNeedsFactory.getSkillCategories.query();
			skillCategoriesCall.$promise.then(function (response) {
				$scope.skillCategories =  response;
				//alert("Skill Categories: "+JSON.stringify($scope.skillCategories));
			},
			function (reason) {
				alert("Error receiving Skill Categories: \n"+reason);
			});
			
			//Fetch Need Roles
			$scope.needRoles = [];
			var needRolesCall = wwsViewNeedsFactory.getNeedRoles.query();
			needRolesCall.$promise.then(function (response) {
				$scope.needRoles = response;
				//alert("Need Roles: "+JSON.stringify($scope.needRoles));
			},
			function (reason) {
				alert("Error receiving Need Roles: \n"+reason);
			});
		}

}]);

wwsDataControllers.controller('NeedsSearchController', ['$scope','$rootScope','$cookies','$window','$location','WWSSearchNeedsFactory',
    function($scope,$rootScope,$cookies, $window,$location, wwsSearchNeedsFactory) {
		//alert("in LoadOpenNeedsController of wws-data-controllers.js");
		$scope.sortType = 'projectType';
        $rootScope.loggedIn= $cookies.get('loggedIn');
        $rootScope.userId= $cookies.get('userId');
        $rootScope.userName= $cookies.get('userName');
		
		$scope.needSearchObj = [];
		
		$scope.OpenNeedStatuses = ['Open'];
		$scope.ClosedNeedStatuses = ['Closed'];
				
		$scope.clients = [];
		var getClientsCall = wwsSearchNeedsFactory.getClients.query();
			getClientsCall.$promise.then(function (response) {
				$scope.clients =  response;
				//alert("Skill Categories: "+JSON.stringify($scope.skillCategories));
			},
			function (reason) {
				alert("Error receiving Clients: \n"+JSOn.stringify(reason));
		});
		
		$scope.practices = [];
		var getPracticesCall = wwsSearchNeedsFactory.getPractices.query();
			getPracticesCall.$promise.then(function (response) {
				$scope.practices =  response;
			},
			function (reason) {
				alert("Error receiving Practices: \n"+JSOn.stringify(reason));
		});
		
		$scope.locations = [];
		var getLocationsCall = wwsSearchNeedsFactory.getLocations.query();
			getLocationsCall.$promise.then(function (response) {
				$scope.locations =  response;
			},
			function (reason) {
				alert("Error receiving Locations: \n"+JSOn.stringify(reason));
		});
		
		$scope.projecTypes = [];
		var getProjecTypesCall = wwsSearchNeedsFactory.getProjectTypes.query();
			getProjecTypesCall.$promise.then(function (response) {
				$scope.projecTypes =  response;
				//alert('Project Types: '+JSON.stringify($scope.projecTypes));
			},
			function (reason) {
				alert("Error receiving projecTypes: \n"+JSOn.stringify(reason));
		});
		
		$scope.closeReasons = [];
		var getCloseReasonsCall = wwsSearchNeedsFactory.getCloseReasons.query();
			getCloseReasonsCall.$promise.then(function (response) {
				$scope.closeReasons =  response;
				//alert('Project Types: '+JSON.stringify($scope.projecTypes));
			},
			function (reason) {
				alert("Error receiving closeReasons: \n"+JSOn.stringify(reason));
		});
		
		$scope.grades = [];
		var getGradesCall = wwsSearchNeedsFactory.getGrades.query();
			getGradesCall.$promise.then(function (response) {
				$scope.grades =  response;
				//alert('Project Types: '+JSON.stringify($scope.projecTypes));
			},
			function (reason) {
				alert("Error receiving Grades: \n"+JSOn.stringify(reason));
		});
		
		$scope.skills = [];
		var getSkillsCall = wwsSearchNeedsFactory.getSkills.query();
			getSkillsCall.$promise.then(function (response) {
				$scope.skills =  response;
				//alert('Project Types: '+JSON.stringify($scope.projecTypes));
			},
			function (reason) {
				alert("Error receiving Skills: \n"+JSOn.stringify(reason));
		});
		
		$scope.roles = [];
		var getRolesCall = wwsSearchNeedsFactory.getRoles.query();
			getRolesCall.$promise.then(function (response) {
				$scope.roles =  response;
				//alert('Project Types: '+JSON.stringify($scope.projecTypes));
			},
			function (reason) {
				alert("Error receiving Skills: \n"+JSOn.stringify(reason));
		});
		
		
		
		$scope.searchedNeeds = [];
		$scope.searchNeeds = function() {
			//alert('Search Needs - Under Construction...');
			
			var searchCriteria = {
				wwsId: $scope.needSearchObj.wwsId,
				clientId: $scope.needSearchObj.clientId,
				practiceId: $scope.needSearchObj.practiceId,
				locationId: $scope.needSearchObj.locationId,
				projectTypeId: $scope.needSearchObj.projectTypeId,
				closeReasonId: $scope.needSearchObj.closeReasonId,
				gradeId: $scope.needSearchObj.gradeId,
				skillId: $scope.needSearchObj.skillId,
				roleId: $scope.needSearchObj.roleId,
				needStatus: $scope.needSearchObj.needStatus
			};
			
			var searchNeedsCall = wwsSearchNeedsFactory.searchMatchingNeeds.create({},searchCriteria);
				searchNeedsCall.$promise.then(function (response) {
					//alert("Matching Needs: "+JSON.stringify(response));
					//refresh the needs list requiring skill profile after updating the SP for this need
					$scope.searchedNeeds = response;
				},
				function (reason) {
					alert("Error In Searching Needs: \n"+JSON.stringify(reason));
				});
		}
		$scope.selectedNeedDetails = [];
		$scope.getSelectedNeedDetails = function(selectedNeedId) {
			$scope.selectedNeedDetails = [];
			//alert("Need to fetch need Details for :"+wwsNeedId);
			//Fetch the need details for given id
			var selectedNeedDetailsCall = wwsSearchNeedsFactory.getNeedInformation.get({param:selectedNeedId});
			selectedNeedDetailsCall.$promise.then(function (response) {
				$scope.selectedNeedDetails = response;
				//alert("Need Details: "+JSON.stringify($scope.selectedNeedDetails));
			},
			function (reason) {
				alert("Error receiving Need Information: \n"+reason);
			});
		}
		$scope.selectedNeedComments = [];
		$scope.selectedNeedForComments = 'Yet to Assign';
		$scope.viewNeedComments = function (selNeedId) {
			//alert('View Add Comments  - Under Construction: '+selNeedId);
			$scope.selectedNeedForComments = selNeedId;
			
			var selectedNeedCommentsCall = wwsSearchNeedsFactory.getNeedComments.query({param:selNeedId});
			selectedNeedCommentsCall.$promise.then(function (response) {
				$scope.selectedNeedComments = response;
				//alert("Need Details: "+JSON.stringify($scope.selectedNeedComments));
			},
			function (reason) {
				alert("Error receiving Need Comments: \n"+JSON.stringify(reason));
			});
		}
		$scope.addComment = function(selectNeedId) {
			//alert("Add Comments - Selected NeedId: "+selectNeedId);
			var needCommentBody = {
				wwsId: selectNeedId,
				commentDate: $scope.needComment.commentDate,
				comment: $scope.needComment.comment
			};
			
			var addCommentToNeedsCall = wwsSearchNeedsFactory.addNeedComments.create({}, needCommentBody);
				addCommentToNeedsCall.$promise.then(function (response) {
					//alert("Matching Needs: "+JSON.stringify(response));
					//alert("Comment Added Successfully ");
					$scope.selectedNeedComments = wwsSearchNeedsFactory.getNeedComments.query({param:selectNeedId});
				},
				function (reason) {
					alert("Error in Add Need Comment: \n"+JSON.stringify(reason));
				});
			//alert("Comment Date: "+$scope.needComment.commentDate);
		}
		
		$scope.deleteNeedComment = function(commentId, selectNeedId) {
			//alert("Delete Comment - Under Construction: "+commentId+"\n For WWSID: "+selectNeedId);
			var delNeedCmntCall = wwsSearchNeedsFactory.deleteNeedComment.delete({param:commentId});
			delNeedCmntCall.$promise.then(function (response) {
				alert("Comment Deleted Successfully: "+JSON.stringify(response));
				$scope.selectedNeedComments = wwsSearchNeedsFactory.getNeedComments.query({param:selectNeedId});
			},
			function (reason) {
				alert("Error Deleting the Need Comment: \n"+JSON.stringify(reason));
				
			});
		}
		//Adding below line to load the results based on open/closed need search pages.
		$scope.searchNeeds();
}]);