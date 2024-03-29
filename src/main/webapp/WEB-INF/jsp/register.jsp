<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('myapp', []);

	app.controller('StudentController', function($scope, $http) {
		$scope.students = {}
		$scope.studentform = {};
		$scope.countrys={};
	
		getUserDetails();
		getCountryList();
		function getCountryList() {
			$http({
				method : 'POST',
				url : '/allCountrylist',
			}).then(function successCallback(response) {
				$scope.countrys = response.data;
		});
		}
		function getUserDetails() {
			$http({
				method : 'POST',
				url : '/allStudentList'
			}).then(function successCallback(response) {
				$scope.students = response.data;
				
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}
		 $scope.editStudent = function(student) {
			 $scope.studentform = {};
			 $scope.studentform.address={};
			 $scope.studentform.id = student.id;
             $scope.studentform.name = student.name;
             $scope.studentform.department = student.department;
             $scope.studentform.address.street = student.address.street;
             $scope.studentform.address.city = student.address.city;
          };
         
		$scope.deleteStudent = function(student) {
			$http({
				method : 'POST',
				url : '/deleteStudent/'+ student.id,
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getUserDetails);
			  
		};
		
		$scope.processUser = function() {
			$http({
				method : 'POST',
				url : '/savestudent',
				data : angular.toJson($scope.studentform),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getUserDetails, clearForm())
			  .success(function(data){
				$scope.students= data
		    });
		}
		function clearForm() {
			$scope.studentform.id = "";
			$scope.studentform.name = "";
			$scope.studentform.department = "";
			$scope.studentform.address.street="";
			$scope.studentform.address.city=" "
		}
		;
		/* function disableName() {
			/* document.getElementById("name").disabled = true; */
	//	} */
	});
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-app="myapp" ng-controller="StudentController">
	<h3>User Registration Form</h3>
	<form ng-submit="processUserDetails()">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">
			    <!-- <tr>
					<td>Name</td>
					<td><input type="text" id="id" ng-model="studentform.id"
						size="30" /></td>
				</tr> -->
				<tr>
					<td>Name</td>
					<td><input type="text" id="name" ng-model="studentform.name"
						size="30" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><input type="text" id="department" 
						ng-model="studentform.department" size="30" /></td>
				</tr>
				
				<tr>
					<td>Street</td>
					<td><input type="text" id="street"
						ng-model="studentform.address.street" size="30" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" id="city"
						ng-model="studentform.address.city" size="30" /></td>
				</tr>
					<td>Country</td>
					<td>
					<select ng-model="studentform.countryName">
					 <option selected disabled>Select Country</option>
					 <option ng-repeat="country in countrys" >{{country.countryName}}</option>
					</select></td>
            		</tr>
				<tr>
					<td colspan="2"><input type="submit"
						class="btn btn-primary btn-sm" ng-click="processUser()"
						value="Save User" /></td>
				</tr>
			</table>
		</div>
	</form>
	<h3>Registered Users</h3>
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 600px">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Street</th>
				<th>City</th>
				<th>Country</th>
				<th>Actions</th>
				
			</tr>

			<tr ng-repeat="student in students">
				<td>{{ student.id }}</td>
				<td>{{ student.name}}</td>
				<td>{{ student.department }}</td>
				<td>{{ student.address.street }}</td>
				<td>{{ student.address.city }}</td>
				<td>{{ student.countryName }}</td>
				<td><a ng-click="editStudent(student)" class="btn btn-primary btn-sm">Edit</a>
					| <a ng-click="deleteStudent(student)" class="btn btn-danger btn-sm">Delete</a></td>
			</tr>
		</table>
	</div>
</body>
</html>