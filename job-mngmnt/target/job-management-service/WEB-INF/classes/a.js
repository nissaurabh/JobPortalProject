jobMngmtServices.factory('JobSearchFactory', function ($resource) {

        return {
            status: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/jobStatus', {}),
            account: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/account', {}),
            serviceLine: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLine', {}),
            serviceLineCapability: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/serviceLineCapability', {}),
            jobRole: $resource('http://10.81.82.144:8080/job-management-service/jobUtility/jobRole', {}),
            jobReport: $resource('http://10.81.82.144:8080/job-management-service/jobSearch?:param', {}),
            jobSearch: $resource('http://10.81.82.144:8080/job-management-service/jobSearch', {
                req_start_from_date: '@srcReqDateFromId',
                req_start_to_date: '@srcReqDateToId',
                role_start_from_date: '@roleStartDateFromId',
                role_start_to_date: '@roleStartDateTo',
                owner_rm: '@userId',
                service_ln: '@serviceLineId',
                status: '@statusId',
                role_nm: '@jobRoleId',
                service_ln_cap: '@serviceLineCapabilityId'
            }),
            setDefaultJobDashboard: $resource('http://10.81.82.144:8080/job-management-service/jobSearch', {},
                {
                    method: 'POST',
                    isArray: false,
                });
}

});