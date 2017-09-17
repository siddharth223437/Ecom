<div ng-controller="recipientCtrl">
<br>
<div ng-show="recipAdd">
<h3>Add new Recipient !!</h3>
<hr>
<form name="addRecipient" ng-submit="addNewRecipient()">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
				<label for="recipName">Recipient Name</label>
				<input type="text" class="form-control" ng-model="recip.recipientName" required>
				</div>
				
				<div class="form-group">
				<label for="recipEmail">Recipient Email</label>
				<input type="email" class="form-control" ng-model="recip.recipientEmail" required>
				</div>
				
				<div class="form-group">
				<label for="recipActNum">Recipient Account Number</label>
				<input type="text" class="form-control" ng-model="recip.recipientActNum" required>
				</div>
				
				<div class="form-group">
				<label for="recipPhNm">Recipient Phone Number</label>
				<input type="text" class="form-control" ng-model="recip.recipientPhoneNum" required>
				</div>
				<input type="submit" value="Add Recipient" class="btn btn-outline-success btn-lg">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" value="All Recipient" class="btn btn-outline-success btn-lg" ng-click="allUserRecip()">
			</div>
		</div>
	</div>
</form>
</div>
<!-- List of recipient -->
<div class="container" ng-show="recipTable">
	<div class="row">
		<div class="col-sm-12">
			<table class="table">
				<thead>
				<tr class="table-info">
					<th>Name</th>
					<th>Email</th>
					<th>Account Number</th>
					<th>Phone Number</th>
				</tr>
				</thead>
				<tbody>
					<tr ng-repeat="recip in allRecip">
						<td>{{recip.recipientName}}</td>
						<td>{{recip.recipientEmail}}</td>
						<td>{{recip.recipientActNum}}</td>
						<td>{{recip.recipientPhoneNum}}</td>
					</tr>
				</tbody>
				
				
			</table>
		</div>
	</div>
</div>
</div>