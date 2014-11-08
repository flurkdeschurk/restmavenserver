var broodjesServices = angular.module('broodjesServices', [ 'ngResource' ]);

broodjesServices
		.factory(
				'Broodjes',
				[
						'$resource',
						function($resource) {
							return $resource(
									'http://localhost:8080/RestMavenServer/broodjes/:id',
									null, {
										'update' : {
											method : 'PUT'
										}
									});
						} ]);

broodjesServices
		.factory(
				'Broden',
				[
						'$resource',
						function($resource) {
							return $resource('http://localhost:8080/RestMavenServer/broden/:id');
						} ]);

broodjesServices
		.factory(
				'Ingredienten',
				[
						'$resource',
						function($resource) {
							return $resource('http://localhost:8080/RestMavenServer/ingredienten/:id');
						} ]);
