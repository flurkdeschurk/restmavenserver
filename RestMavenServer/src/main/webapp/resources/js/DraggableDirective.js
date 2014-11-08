var Draggable = function () {
 
    return {
        restrict: "A",
        link: function(scope, element, attributes, ctlr) {
            element.attr("draggable", true);
 
            element.bind("dragstart", function(eventObject) {
                eventObject.dataTransfer.setData("broodjesNaam", attributes.naam);
                
                if (element.hasClass("sandwichBeleg")) {
                	scope.showGarbageBin(true);
                }
            });
        }
    };
}