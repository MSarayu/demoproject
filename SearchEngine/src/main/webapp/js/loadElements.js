
'use strict';
var myApp=angular.module("myApp",['ngRoute']);
myApp.config(function($routeProvider) {
	$routeProvider
		.when('/home', {
			templateUrl: 'home.jsp',
			controller: 'myController'
		})
		.when('/viewElements', {
			templateUrl: 'viewElements.jsp'
		})
		.otherwise({
			redirectTo: '/home'
		});
		
	});

myApp.factory('SearchService',['$http', '$q', function($http, $q){
 return{
     loadAllElements:function() {
        var deferred = $q.defer();
          $http.get('loadAllElements.do')
            .then(function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching elements');
                deferred.reject(errResponse);
            });
        return deferred.promise;
    }
    }}
    ]);
   
	var myController = function ( $scope,$timeout,SearchService)	{
		
		  $scope.elementList=function(){
			$scope.displayList=true;
			$scope.loadAllElements();
		   }
		
			$scope.loadAllElements =function(){
				SearchService.loadAllElements().then(function(response) {
	        			$scope.elements = response;
			        });
		            
			}
			      
	}
    
    
myApp.controller('myController', [  '$scope','$timeout', 'SearchService',myController ]);
