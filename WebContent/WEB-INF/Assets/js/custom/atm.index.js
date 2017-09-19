$(function () {
	(function () {
		var pocetna = {lat: 43.969052, lng: 17.970227};
		var map = new google.maps.Map(document.getElementById("atm-map"), {
			zoom: 7,
			center: pocetna
	    });
		
		var infoWindow = new google.maps.InfoWindow({
			//maxWidth: 350
		});
		atmLocations.forEach(function (atm) {
			var latLng = new google.maps.LatLng(atm.atmLatitude, atm.atmLongitude);
			var marker = new google.maps.Marker({
				position: latLng,
				map: map,
				title: atm.atmName,
				//icon: {
				//	url: markerIconUrl,
				//	scaledSize: new google.maps.Size(20, 20)
				//}
			});
			
			(function(marker, atm) {
				var infoContent = "<div style='overflow:auto; padding: 4px 0 2px 0'> <div style='float:left; margin-right:12px'><img src='" + markerIconUrl + "' height='45' width='45' /></div> <div style='float:right'>" + atm.bankName + "<br />" + atm.atmName + "<br />" + atm.atmAddress + "<div> </div>"
				google.maps.event.addListener(marker, "click", function(e) {
					infoWindow.setContent(infoContent);
				    infoWindow.open(map, marker);
				});
			})(marker, atm);
		});
	})();
});
