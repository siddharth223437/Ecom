<div ng-controller="appointmentCtrl">
<div class="container">
	<div class="page-header">
    		<h1>User Appointment</h1>      
    </div>
    		<p>Make Appointment!!</p>        
</div>
<br>
<form name="appoint" ng-submit="userAppointment()">
<div class="container">
	<div class="row">
		<div class="col-sm-6">
			<div class="form-group">
			<div class='input-group date' id='datetimepicker1'>
			<input type='text' class="form-control" ng-model="appoint.appointmentDate" />
			<span class="input-group-addon">
			<span class="fa fa-calendar"></span>
			</span>
			</div>
			<script type="text/javascript">
        </script>
			</div>
			
			<div class="form-group">
			<label for="location">Location</label>
			<input type="text" class="form-control" placeholder="Location" ng-model="appoint.location">
			</div>
			
			<div class="form-group">
			<label for="description">Description</label>
			<input type="text" class="form-control" placeholder="Description" ng-model="appoint.description">
			</div>
			
			<button type="button" class="btn btn-success" ng-click="userAppointment()" value="Take Appointment">Take Appointment</button>
		</div>
	</div>
</div>
</form>
</div>
