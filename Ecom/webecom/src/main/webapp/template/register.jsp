<br><br>
<div ng-controller="userCtrl">
<div class="container">
  <div class="page-header">
    <h1>User Register Form</h1>      
  </div>
  <p>Register now to get benifts!!</p>        
</div>
<form name="registerform" ng-submit="registerUser()">
<div class="container">
	<div class="row">
		<div class="col-sm-8">
			<div class="form-group">
			<label for="exampleInputEmail1">User Name</label>
   			 <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Username" ng-model="user.username" required/>
			</div>
			<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" placeholder="Enter Password" ng-model=user.password required />
			</div>
			<div class="form-group">
			<label for="FirstName">First Name</label>
			<input type="text" class="form-control" placeholder="Enter First Name" ng-model=user.firstname required />
			</div>
			<div class="form-group">
			<label for="lastName">Last Name</label>
			<input type="text" class="form-control" placeholder="Enter Last Name" ng-model=user.lastname required />
			</div>
			<input type="submit" ng-disabled="registerform.$invalid" />
		</div>
	</div>
</div>
</form>
</div>