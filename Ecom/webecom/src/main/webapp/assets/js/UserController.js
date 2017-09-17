'use strict';

//register user ctrl
app.controller('userCtrl',function($scope,UserService){
	
	$scope.registerUser = function()
	{
		UserService.saveUser($scope.user);
	}
});

//show homepage and transactionlidt ctrl
app.controller('allDetailCtrl',function($scope,AllDetailService){
	
	$scope.isShow = false;
	$scope.hideJumbo=true;
	
	$scope.allDetail = function()
	{
		$scope.hideJumbo;
		AllDetailService.allDetail(function(r){
			$scope.detail = r;
		});
	};
	
	
	$scope.translist = function()
	{
		alert("iuid");
		$scope.isShow=true;
		$scope.hideJumbo=false;
		AllDetailService.transactionList(function(r){
			$scope.alltranslist = r;
		})
	};
	$scope.allDetail();
});

//deposit ctrl
app.controller('depositCtrl',function($scope,DepositService,$location){
	
	$scope.accountType=['Primary','Savings'];
	
	$scope.depositToAct = function()
	{
		DepositService.depositAmount($scope.deposit);
		$location.path('/primary');
	};
});

app.controller('appointmentCtrl',function($scope,AppointmentService,$location){
	
	$scope.userAppointment = function()
	{
		AppointmentService.createAppointment($scope.appoint);
		alert('Your appointment details will be sent to admin');
		$location.path('/primary');
	};
	
});

//recipient ctrl

app.controller('recipientCtrl',function($scope,$location,$log,recipientService){
	$scope.recipAdd = true;
	$scope.recipTable = false;
	//add recipient
	$scope.addNewRecipient = function()
	{
		$scope.recipAdd = true;
		$log.log('in recipient ctrl');
		recipientService.addRecipSer($scope.recip);
		alert('Recipient addedd !!');
	};
	
	//all recipint
	$scope.allUserRecip = function()
	{
		$scope.recipAdd = false;
		$scope.recipTable = true;
		$log.log('in all recip');
		recipientService.allRecipSer(function(r){
			$scope.allRecip = r;
		});
	};
	
});

//to recipient
app.controller('recipTransferCtrl',function($scope,transferRecip){
	$scope.toRecipent = function()
	{
		transferRecip.sendRecip($scope.recip);
	}
})


