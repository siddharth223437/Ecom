'use strict';

app.service('UserService',['$http',function($http){
	
	this.saveUser = function(user)
	{
		$http.post('http://localhost:8080/Ecomweb/register',user).then(function(response){
			alert(response.status);
		});
	}
}]);


app.service('AllDetailService',['$http','$log',function($http,$log){
	
	this.allDetail = function(cb)
	{
		$http.get('http://localhost:8080/Ecomweb/primary').then(function(response){
			$log.log(response.data);
			cb(response.data);
		}).then(function(response){
			$log.error("Cannot Load");
		});
	};
	
	this.transactionList = function(cb)
	{
		$http.get('http://localhost:8080/Ecomweb/primarytransactionlist').then(function(response){
			$log.log(response.data);
			cb(response.data);
		}).then(function(response){
			$log.error('Not FOUND');
		});
	};
}]);

app.service('DepositService',['$http','$log',function($http,$log){
	
	this.depositAmount = function(deposit)
	{
		$http.post('http://localhost:8080/Ecomweb/deposit',deposit).then(function(response){
			
		});
	};
}]);


app.service('AppointmentService',['$http','$log',function($http,$log){
	
	this.createAppointment = function(appoint)
	{
		$http.post('http://localhost:8080/Ecomweb/createappointment',appoint).then(function(response){
			
		});
	};
	
}]);

//add recipient

app.service('recipientService',['$http','$log',function($http,$log){
	
	this.addRecipSer = function(recipt)
	{
		$http.post('http://localhost:8080/Ecomweb/user/saverecipient',recipt).then(function(response){
			
		});
	};
	
	//list recipt
	this.allRecipSer = function(cb)
	{
		$http.get('http://localhost:8080/Ecomweb/user/recipientlist').then(function(response){
			cb(response.data);
		});
	};
}]);

app.service('transferRecip',['$http',function($http){
	this.sendRecip = function(recip)
	{
		$http.post('http://localhost:8080/Ecomweb/user/transfer',recip).then(function(response){
			
		});
	};
}]);




