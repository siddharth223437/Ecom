<div ng-controller="depositCtrl">
<div class="container">
	<div class="page-header">
    		<h1>Account Deposit Form</h1>      
    </div>
    		<p>Deposit some dollars!!!</p>        
</div>
<hr>
<form name="depositForm" ng-submit="depositToAct()">
<div class="container">
	<div class="row">
		<div class="col-xs-4">
			<div class="form-group">
			<label for="exampleInputEmail1">Select Account Type</label>
   			 <select ng-options="x for x in accountType" class="form-control" placeholder="Select Account Type" ng-model=deposit.type required></select>
			</div>
			<div class="form-group">
			<label for="FirstName">Enter Amount</label>
			<input type="text" class="form-control" placeholder="Enter Amount" ng-model=deposit.amount required />
			</div>
			<input type="submit" ng-disabled="depositForm.$invalid" />
		</div>
	</div>
</div>
</form>
</div>
