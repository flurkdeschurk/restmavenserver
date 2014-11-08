var DropTarget= function () {
 
    return {
        restrict: "A",
        link: function (scope, element, attributes, ctlr) {
 
            element.bind("dragover", function(eventObject){
                eventObject.preventDefault();
            });
 
            element.bind("drop", function(eventObject) {
                
            	scope.showBin = false;
            	
            	if (element.hasClass("sandwich")) {
            		scope.belegBroodje(eventObject.dataTransfer.getData("broodjesNaam"));
            	} else if (element.hasClass("garbage")) {
            		scope.removeBelegBroodje(eventObject.dataTransfer.getData("broodjesNaam"));
            	}
 
                // cancel actual UI element from dropping, since the angular will recreate a the UI element
                eventObject.preventDefault();
            });
        }
    };
}