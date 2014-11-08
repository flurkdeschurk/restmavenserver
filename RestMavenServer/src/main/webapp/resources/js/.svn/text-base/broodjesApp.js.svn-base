var broodjesApp = angular.module('broodjesApp', [ 'ngAnimate', 'ngRoute',
		'ngResource', 'broodjesControllers', 'broodjesServices' ])
		.directive("ddDraggable", Draggable)
		.directive("ddDropTarget", DropTarget);

broodjesApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'home',
		activeTab : 'home',
		pageTitle : 'Home'
	}).when('/broodjes', {
		templateUrl : 'list.html',
		controller : 'BroodjesListController',
		activeTab : 'list',
		pageTitle : 'List'
	}).when('/broodjes/new', {
		templateUrl : 'editNew.html',
		controller : 'BroodjesNewController',
		activeTab : 'new',
		pageTitle : 'New broodje'
	}).when('/broodjes/detail/:id', {
		templateUrl : 'detail.html',
		controller : 'BroodjesDetailController',
		activeTab : 'detail',
		pageTitle : 'Detail'
	}).when('/broodjes/edit/:id', {
		templateUrl : 'editNew.html',
		controller : 'BroodjesEditController',
		activeTab : 'edit',
		pageTitle : 'Edit broodje'
	}).when('/broodjes/compose', {
		templateUrl : 'compose',
		controller : 'BroodjesComposeController',
		activeTab : 'compose',
		pageTitle : 'Compose broodje'
	}).otherwise({
		redirectTo : '/broodjes'
	});
} ]);
