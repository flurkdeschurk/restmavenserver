<!DOCTYPE html>
<html ng-app="broodjesApp" ng-controller="HomeController">
<head>
	<meta charset="UTF-8">
    <title>{{$route.current.pageTitle}}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular-animate.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular-resource.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.9/angular-route.js"></script>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script type="text/javascript" src="resources/bootstrap/dist/js/bootstrap.min.js" ></script>
    <script src="resources/js/DraggableDirective.js"></script>
    <script src="resources/js/DropTargetDirective.js"></script>
    <script src="resources/js/broodjesApp.js"></script>
    <script src="resources/js/controllers.js"></script>
    <script src="resources/js/services.js"></script>
    <link href="resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/angularDemo.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<ul class="nav nav-pills">
			<li class="nav nav-pills" ng-class="{active: $route.current.activeTab == 'home'}"><a href="#/">Home</a></li>
			<li class="nav nav-pills" ng-class="{active: $route.current.activeTab == 'list'}"><a href="#/broodjes/list">List</a></li>
			<li class="nav nav-pills" ng-class="{active: $route.current.activeTab == 'new'}"><a href="#/broodjes/new">New</a></li>
			<li class="nav nav-pills" ng-class="{active: $route.current.activeTab == 'compose'}"><a href="#/broodjes/compose">Compose</a></li>
			<li class="nav nav-pills" ng-class="{active: $route.current.activeTab == 'detail'}" ng-hide="$route.current.activeTab != 'detail'"><a>Detail</a></li>
			<li class="nav nav-pills" ng-class="{active: $route.current.activeTab == 'edit'}" ng-hide="$route.current.activeTab != 'edit'"><a>Edit</a></li>
		</ul>
    </div>
    <div class="display" ng-view></div>
</body>
</html>