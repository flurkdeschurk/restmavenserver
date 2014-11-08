<div class="panel panel-primary">
	<div class="panel panel-heading">
		<h2>Broodjes</h2>
	</div>
	<table class="table">
	    <thead>
	    <tr>
	        <th>
	            Naam
	        </th>
	        <th>
	            Prijs
	        </th>
	        <th>
	        	Brood
	        </th>
	        <th>
	        	Aantal stukken beleg
	        </th>
	    </tr>
	    </thead>
	    <tbody>
	    <tr ng-repeat="broodje in broodjes">
	        <td>
	            <p class="btn btn-link" ng-click="detailBroodje(broodje.id)">{{broodje.naam}}</p>
	        </td>
	        <td>
	            {{broodje.prijs}}
	        </td>
	        <td>
	        	{{broodje.brood.naam}}
	        </td>
	        <td>
	        	{{broodje.basisBeleg.length}}
	        </td>
	        <td>
	        	<p class="btn btn-default pull-right" ng-click="editBroodje(broodje.id)">Edit</p>
	        	<p class="btn btn-default pull-right" ng-click="removeBroodje(broodje)">Remove</p>
	        </td>
	    </tr>
	    </tbody>
	</table>
</div>