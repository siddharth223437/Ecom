'use strict';

var app = angular.module('myApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	.when("/primary",{
		templateUrl: 'template/home-ang.jsp',
		controller: 'allDetailCtrl'
	})
	.when("/register",{
		templateUrl: "template/register.jsp",
		controller: "userCtrl"
	})
	.when("/account/deposit" ,{
		templateUrl: "template/deposit-ang.jsp",
		controller: "depositCtrl"
	})
	.when("/user/appointment",{
		templateUrl: "template/appointment.jsp",
		controller: "appointmentCtrl"
	})
	.when("/user/recipient",{
		templateUrl: "template/recipient.jsp",
		controller: "recipientCtrl"
	})
	.when('/user/transferRecip',{
		templateUrl: 'template/transferRecip.jsp',
		controller: 'recipTransferCtrl'
	})
	.otherwise({
		redirectTo: '/primary'
	});
});

app.controller('mainController',function($scope){
	$scope.message = 'Everyone come and see how good I look!';
});