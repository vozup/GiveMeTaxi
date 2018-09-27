function initMap() {
    var mapOptions = {
        zoom: 10,
        center: {lat: 50.4294963, lng: 30.53469569999993}
    };
    googleMap = new google.maps.Map(document.getElementById('map'), mapOptions);
    googleMapRouteRenderer = new google.maps.DirectionsRenderer();
    googleMapRouteRenderer.setMap(googleMap);
}

function calcRoute() {

    var request = {
        origin: PF('fromAddress').jq.val(),
        destination: PF('toAddress').jq.val(),
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
    PF('sendResults').jq.click();
}