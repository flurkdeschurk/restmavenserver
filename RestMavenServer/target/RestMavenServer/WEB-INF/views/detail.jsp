<div class="panel panel-primary">
	<div class="panel panel-heading">
		<h2>Detail Broodje: {{broodje.naam}}</h2>
	</div>
	<div class="panel panel-body">
	    <label for="broodjeNaam">Naam</label>
	    <p id="broodjeNaam">{{broodje.naam}}</p>
	    <label for="broodjePrijs">Prijs</label>
	    <p id="broodjePrijs">{{broodje.prijs}}</p>
	    <label for="broodjeBrood">Brood</label>
	    <p id="broodjeBrood">{{broodje.brood.naam}}</p>
	    <label for="basisBeleg">Beleg</label>
	    <ul id="basisBeleg">
		    <li ng-repeat="beleg in broodje.basisBeleg">
				<img class="beleg-component" alt="{{beleg.naam}}" src="{{beleg.imageUrl}}">
			</li>
		</ul>
	    <button type="button" class="btn btn-primary" ng-click="goToEditMode()">Edit</button>
	    <button type="button" class="btn btn-primary" ng-click="goBack()">Back</button>
	</div>
</div>