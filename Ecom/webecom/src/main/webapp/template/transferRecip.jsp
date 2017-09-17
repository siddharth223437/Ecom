<div ng-controller="recipTransferCtrl">
<br><br>
<form ng-submit="toRecipent()">
	<label for="accountType">Account Type</label>
	<input type="text" ng-model="recip.primaryTransaction.type">
	<br>
	<label for="amount">Amount</label>
	<input type="text" ng-model="recip.primaryTransaction.amount">
	<br>
	<label for="acountNum">Account Number</label>
	<input type="text" ng-model="recip.recipient.recipientActNum">
	<br>
	<input type="submit">
</form>

</div>