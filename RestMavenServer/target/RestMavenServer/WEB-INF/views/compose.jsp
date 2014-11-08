<div class="panel panel-primary">
	<div class="panel panel-heading">
		<h2>Compose Broodje: {{broodje.naam}}</h2>
	</div>
	<div class="panel panel-body" dd-drop-target="true">
		<div class="form-group">
			<label for="broodjeNaam">Naam:</label>
			<input id="broodjeNaam"
				   class="form-control"
				   type="text" 
				   ng-model="broodje.naam" required><br/><br/>
			<div class="jumbotron sandwich" dd-drop-target="true" ng-class="{'narrowSandwich': showBin}">
				<p>Put on sandwich</p>
				<div ng-repeat="beleg in basisBeleg">
					<div dd-draggable="true" naam="{{beleg.naam}}" class="sandwichBeleg">
						<img class="beleg-component" alt="{{beleg.naam}}" src="{{beleg.imageUrl}}">
					</div>
				</div>
			</div>
			<div class="jumbotron garbage animate" dd-drop-target="true" ng-class="{'bigGarbage' : showBin}">
				<p>Remove from sandwich</p>
			</div>
			<div class="etalage">
				<div ng-repeat="ingredient in ingredienten">
					<div dd-draggable="true" naam="{{ingredient.naam}}">
						<img class="beleg-component" alt="{{ingredient.naam}}" src="{{ingredient.imageUrl}}">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>