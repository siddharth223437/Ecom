<div ng-controller="allDetailCtrl">
<div class="jumbotron jumbotron-fluid" ng-show="hideJumbo">
  <div class="container">
    <h1 class="display-3">Fluid jumbotron</h1>
    <p class="lead">This is a modified jumbotron that occupies the entire horizontal space of its parent.</p>
  </div>
</div>
<div class="container-fluid cardpad" style="background-color: #FFFDFD" ng-show="hideJumbo">
<div class="row">
  <div class="col-sm-6 sidenav">
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">Pimary Account Balance</h4>
        <p class="card-text">{{detail.accountBalance}}</p>
        <!-- <a href="#" class="btn btn-primary">Go somewhere</a> -->
        <button type="button" class="btn btn-primary" name="test" ng-click="translist()">Show Transactions</button>
      </div>
    </div>
  </div>
 
  <div class="col-sm-6 sidenav">
    <div class="card">
      <div class="card-body">
        <h4 class="card-title">Account Number</h4>
        <p class="card-text">{{detail.accountNumber}}</p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>

</div>
<br>
<div class="row">
  <div class="col-sm-6 sidenav">
    <div class="card">
      <div class="card-body">
        <h4 class="card-title"></h4>
        <p class="card-text"></p>
        <a href="#" class="btn btn-primary">Go somewhere</a>
      </div>
    </div>
  </div>
</div>
<br>
</div>

<div class="container" ng-show="isShow">
<h3>Transaction List</h3>
<p>Here are all the transactions</p>
<table class="table">
	<thead class="thead-inverse">
		<tr>
			<th>date</th>
			<th>description</th>
			<th>type</th>
			<th>status</th>
			<th>amount</th>
			<th>availableBalance</th>
		</tr>
	</thead>
	<tbody>
		<tr ng-repeat="p in alltranslist">
			<td>{{p.date | date : medium}}</td>
			<td>{{p.description}}</td>
			<td>{{p.type}}</td>
			<td>{{p.status}}</td>
			<td>{{p.amount}}</td>
			<td>{{p.availableBalance}}</td>
		</tr>
	</tbody>
</table>



</div>
</div>

<div class="footer">
      <div class="container">
        <p class="text-muted">Place sticky footer content here.</p>
         </div> 
      </div>