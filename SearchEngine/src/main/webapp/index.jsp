
<!DOCTYPE html>
<html>
	<head lang="en">
	  <meta charset="utf-8">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js">

</script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
<script src="js/loadElements.js" type="text/javascript"></script>
</head>
<body  >
<div ng-app="myApp" ng-controller="myController">
<span ng-model="errorMessage"></span>
<ng-view></ng-view>
</div>
<div>
</div>
</body>
</html>