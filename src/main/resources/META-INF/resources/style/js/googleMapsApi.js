// This example requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
// script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&amp;libraries=places"
function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 50.431782, lng: 30.516382},
        zoom: 13
    });
    //Define direction
    googleMapRouteRenderer = new google.maps.DirectionsRenderer();
    googleMapRouteRenderer.setMap(map);
    //
    inputFrom = document.getElementById('centerForm:input-from');
    inputTo = document.getElementById('centerForm:input-to');
    var autocompleteFrom = new google.maps.places.Autocomplete(inputFrom);
    var autocompleteTo = new google.maps.places.Autocomplete(inputTo);

    // Bind the map's bounds (viewport) property to the autocomplete object,
    // so that the autocomplete requests use the current map bounds for the
    // bounds option in the request.
    autocompleteFrom.bindTo('bounds', map);
    autocompleteTo.bindTo('boundsTo', map);
    // Set the data fields to return when the user selects a place.
    autocompleteFrom.setFields(
        ['address_components', 'geometry', 'icon', 'name']);
    autocompleteTo.setFields(
        ['address_components', 'geometry', 'icon', 'name']);
    marker = new google.maps.Marker({
        map: map,
        anchorPoint: new google.maps.Point(0, -29)
    });
    autocompleteFrom.addListener('place_changed', function () {
        marker.setVisible(false);
        var place = autocompleteFrom.getPlace();
        if (!place.geometry) {
            // User entered the name of a Place that was not suggested and
            // pressed the Enter key, or the Place Details request failed.
            window.alert("No details available for input: '" + place.name + "'");
            return;
        }
        // If the place has a geometry, then present it on a map.
        if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
        } else {
            map.setCenter(place.geometry.location);
            map.setZoom(17);  // Why 17? Because it looks good.
        }
        marker.setPosition(place.geometry.location);
        marker.setVisible(true);
    });
    autocompleteTo.addListener('place_changed', function () {
        marker.setVisible(false);
        var place = autocompleteTo.getPlace();
        if (!place.geometry) {
            // User entered the name of a Place that was not suggested and
            // pressed the Enter key, or the Place Details request failed.
            window.alert("No details available for input: '" + place.name + "'");
            return;
        }
        if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
        } else {
            map.setCenter(place.geometry.location);
            map.setZoom(17);  // Why 17? Because it looks good.
        }
        marker.setPosition(place.geometry.location);
        marker.setVisible(true);
    });
}
function calcRoute() {
    marker.setVisible(false);
    var request = {
        //origin: PF('addressFrom').jq.val(),
        origin: inputFrom.value,
        //destination: PF('addressTo').jq.val(),
        destination: inputTo.value,
        travelMode: google.maps.TravelMode.DRIVING
    };
    new google.maps.DirectionsService().route(request, function (response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            googleMapRouteRenderer.setDirections(response);
            var distance = response.routes[0].legs[0].distance;
            sendDistanceToServer(distance.text, distance.value);
        } else {
            alert("Не удается найти маршрут " + start.toUrlValue(6) + " к "
                + end.toUrlValue(6) + " status: " + status);
        }
    });
}

function sendDistanceToServer(distanceText, distanceValue) {
    PF('distanceText').jq.val(distanceText);
    PF('distanceValue').jq.val(distanceValue);
    var rbChecked = getCheckedRbValue();
    PF('resultCarType').jq.val(rbChecked);
    PF('sendResults').jq.click();
}

//
function getCheckedRbValue() {
    var radioGroupLength = document.forms['centerForm']['centerForm:car'].length;
    var checkedRbValue;
    for (i = 0; i < radioGroupLength; i++) {
        if (document.forms['centerForm']['centerForm:car'][i].checked === true) {
            checkedRbValue = document.forms['centerForm']['centerForm:car'][i].value;
        }
    }
    return checkedRbValue;
}