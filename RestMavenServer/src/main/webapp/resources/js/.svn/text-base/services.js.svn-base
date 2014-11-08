var broodjesServices = angular.module('broodjesServices', [ 'ngResource' ]);

broodjesServices
		.factory(
				'Broodjes',
				[
						'$resource',
						function($resource) {
							return $resource(
									'http://restmaventomcatserver.flurkdeschurk.cloudbees.net/broodjes/:id',
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
							return $resource('http://restmaventomcatserver.flurkdeschurk.cloudbees.net/broden/:id');
						} ]);

broodjesServices
		.factory(
				'Ingredienten',
				[
						'$resource',
						function($resource) {
							return $resource('http://restmaventomcatserver.flurkdeschurk.cloudbees.net/ingredienten/:id');
						} ]);
