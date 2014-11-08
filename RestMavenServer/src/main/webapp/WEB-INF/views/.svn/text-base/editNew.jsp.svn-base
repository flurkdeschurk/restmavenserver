<form ng-submit="formAction()">
	<div ng-model="broodje" id="displayDiv" class="panel panel-primary">
		<div class="panel panel-heading">
			<h2>{{title}}{{broodje.naam}}</h2>
		</div>
		<div class="panel panel-body">
			    <div class="form-group">
				    <label for="broodjeNaam">Naam:</label>
				    <input id="broodjeNaam"  class="form-control" type="text" ng-model="broodje.naam" required><br/><br/>
				    <label for="broodjePrijs">Prijs:</label>
				    <input id="broodjePrijs" class="form-control" type="text" ng-model="broodje.prijs" required><br/><br/>
				    <label for="broodjeBrood">Brood:</label>
				    <select id="broodjeBrood" class="form-control" ng-model="broodje.brood" ng-options="brood.naam for brood in broden" required></select><br/><br/>
			    </div>
			   	<table class="table">
			   		<thead>
			   			<tr>
			   				<th colspan="2">
							    <p class="btn btn-primary" ng-click="addIngredient()">Add beleg</p>
			   				</th>
			   			</tr>
			   		</thead>
			   		<tbody>
			   			<tr ng-repeat="beleg in broodje.basisBeleg">
			   				<td>
			   					<select class="form-control" ng-model="broodje.basisBeleg[$index]" ng-options="ingr.naam for ingr in ingredienten"></select>
			   				</td>
			   				<td>
			   					<p class="btn btn-default pull-right" ng-click="removeBeleg($index)">Remove</p>
			   				</td>
			   			</tr>
			   		</tbody>
			   	</table>
			<br/>
		    <input type="submit" class="btn btn-primary pull-right" value="{{buttonTitle}}">
		    <p class="btn btn-primary pull-right" ng-click="goBack()">Back</p>
		</div>
	</div>
</form>