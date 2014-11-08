var broodjesControllers = angular.module('broodjesControllers', []);

broodjesControllers.controller('HomeController', [ '$scope', '$route',
		function($scope, $route) {
			$scope.$route = $route;
		} ]);

broodjesControllers.controller('BroodjesListController', [ '$scope', '$http',
		'$route', '$location', 'Broodjes',
		function($scope, $http, $route, $location, Broodjes) {
			$scope.$route = $route;
			$scope.broodjes = Broodjes.query();

			$scope.detailBroodje = function(id) {
				$location.path("/broodjes/detail/" + id);
			};

			$scope.editBroodje = function(id) {
				$location.path("/broodjes/edit/" + id);
			};

			$scope.removeBroodje = function(broodje) {
				Broodjes.remove(broodje);
				var index = $scope.broodjes.indexOf(broodje);
				$scope.broodjes.splice(index, 1);
			};
		} ]);

broodjesControllers
		.controller(
				'BroodjesNewController',
				[
						'$scope',
						'$http',
						'$location',
						'Broodjes',
						'Broden',
						'Ingredienten',
						function($scope, $http, $location, Broodjes, Broden,
								Ingredienten) {
							$scope.title = "New Broodje: ";
							$scope.buttonTitle = "Add broodje";
							$scope.broodje = {
								naam : "",
								prijs : "",
								brood : {},
								basisBeleg : []
							};

							$scope.ingredienten = Ingredienten
									.query(function() {
										$scope.broodje.basisBeleg
												.push($scope.ingredienten[0]);
									});

							$scope.broden = Broden.query(function() {
								$scope.broodje.brood = $scope.broden[0];
							});

							$scope.addIngredient = function() {
								var loop = true;
								for ( var i = 0; i < $scope.ingredienten.length
										&& loop; i++) {
									var ingredientenLoop = true;
									for ( var j = 0; j < $scope.broodje.basisBeleg.length
											&& ingredientenLoop; j++) {
										if ($scope.ingredienten[i].naam == $scope.broodje.basisBeleg[j].naam) {
											ingredientenLoop = false;
										}
									}

									if (ingredientenLoop) {
										loop = false;
										$scope.broodje.basisBeleg
												.push($scope.ingredienten[i]);
									}
								}

							};

							$scope.formAction = function() {
								Broodjes.save($scope.broodje, function() {
									$location.path("/broodjes");
								});
							};

							$scope.removeBeleg = function(index) {
								$scope.broodje.basisBeleg.splice(index, 1);
							};

							$scope.goBack = function() {
								window.history.back();
							};

						} ]);

broodjesControllers
		.controller(
				'BroodjesEditController',
				[
						'$scope',
						'$http',
						'$location',
						'$routeParams',
						'Broodjes',
						'Broden',
						'Ingredienten',
						function($scope, $http, $location, $routeParams,
								Broodjes, Broden, Ingredienten) {
							$scope.title = "Edit Broodje: ";
							$scope.buttonTitle = "Edit broodje";
							$scope.broodje = Broodjes
									.get(
											{
												id : $routeParams.id
											},
											function() {
												$scope.broden = Broden
														.query(function() {
															for ( var i = 0; i < $scope.broden.length; i++) {
																if ($scope.broden[i].naam == $scope.broodje.brood.naam) {
																	$scope.broodje.brood = $scope.broden[i];
																}
															}
														});

												$scope.ingredienten = Ingredienten
														.query(function() {
															for ( var i = 0; i < $scope.ingredienten.length; i++) {
																for ( var j = 0; j < $scope.broodje.basisBeleg.length; j++) {
																	if ($scope.ingredienten[i].naam == $scope.broodje.basisBeleg[j].naam) {
																		$scope.broodje.basisBeleg[j] = $scope.ingredienten[i];
																	}
																}
															}
														});
											});

							$scope.addIngredient = function() {
								var loop = true;
								for ( var i = 0; i < $scope.ingredienten.length
										&& loop; i++) {
									var ingredientenLoop = true;
									for ( var j = 0; j < $scope.broodje.basisBeleg.length
											&& ingredientenLoop; j++) {
										if ($scope.ingredienten[i].naam == $scope.broodje.basisBeleg[j].naam) {
											ingredientenLoop = false;
										}
									}

									if (ingredientenLoop) {
										loop = false;
										$scope.broodje.basisBeleg
												.push($scope.ingredienten[i]);
									}
								}

								if (loop) {
									alert("U kan niets meer toevoegen");
								}

							};

							$scope.formAction = function() {
								Broodjes.update({
									id : $routeParams.id
								}, $scope.broodje, function() {
									$location.path("/broodjes/detail/"
											+ $routeParams.id);
								});
							};

							$scope.removeBeleg = function(index) {
								$scope.broodje.basisBeleg.splice(index, 1);
							};

							$scope.goBack = function() {
								$location.path("/broodjes/detail/"
										+ $routeParams.id);
							};
						} ]);

broodjesControllers.controller('BroodjesDetailController', [ '$scope', '$http',
		'$location', '$routeParams', 'Broodjes',
		function($scope, $http, $location, $routeParams, Broodjes) {
			$scope.broodje = Broodjes.get({
				id : $routeParams.id
			});

			$scope.goToEditMode = function() {
				$location.path("/broodjes/edit/" + $routeParams.id);
			};

			$scope.goBack = function() {
				$location.path("/broodjes/");
			};
		} ]);

broodjesControllers.controller('BroodjesComposeController', [ '$scope', '$http', "Broden", "Ingredienten",
    function ($scope, $http, Broden, Ingredienten) {
		$scope.showBin = false;
		$scope.broden = Broden.query();
		$scope.ingredienten = Ingredienten.query();
		$scope.basisBeleg = [];
		$scope.broodje = {
			naam : "",
			prijs : "",
			brood : {}			
		};
		
		$scope.showGarbageBin = function(show) {
			$scope.showBin = show;
			$scope.$apply();
		};
		
		$scope.belegBroodje = function(naam) {
			for (var i = 0; i < $scope.ingredienten.length; i++) {
				if ($scope.ingredienten[i].naam == naam) {
					$scope.basisBeleg.push($scope.ingredienten[i]);
					$scope.ingredienten.splice(i, 1);
				}
			}
			$scope.$apply();
		};
		
		$scope.removeBelegBroodje = function(naam) {
			for (var i = 0; i < $scope.basisBeleg.length; i++) {
				if ($scope.basisBeleg[i].naam == naam) {
					$scope.ingredienten.push($scope.basisBeleg[i]);
					$scope.basisBeleg.splice(i, 1);
				}
			}
			$scope.$apply();
		};
}]);
