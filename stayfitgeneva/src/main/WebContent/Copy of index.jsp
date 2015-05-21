<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="/stayfitgeneva/css/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://js.arcgis.com/3.13/esri/css/esri.css">
<script src="http://js.arcgis.com/3.13/"></script>
<style>
  html, body, #mapDiv {
    padding: 0;
    margin: 0;
    height: 100%;
    width: 100%;
  }
</style>
</head>
<body>
	<br>
	<div id="container">
		<h1>
		Bienvenue sur la WebApp StayFitGeneva!<br> <br>
		</h1>
		<h3>
		<jsp:include page="template-menu.jsp" />
		</h3>
		<!-- Colonne 1 -->
	    <div class="leftside">
		</div>
		<!-- Colonne 2-->
	    <div class="rightside">
	    </div>
	    <!-- Colonne Centrale <div id="container" style="text-align:center"> -->
		<div class="content">
		<script>
		  require(["esri/map", "dojo/domReady!"], function(Map) {
		    // code to create the map and add a basemap will go here
			  map = new Map("mapDiv", {
				    center: [6.14229661, 46.1983922],
				    zoom: 10,
				    basemap: "streets"
				  });
		  });
		</script>
			<div id="corps">
			<div id="demo">
			<script>
			var text = '{"employees":[' +
			'{"firstName":"John","lastName":"Doe" },' +
			'{"firstName":"Anna","lastName":"Smith" },' +
			'{"firstName":"Peter","lastName":"Jones" }]}';
			
			obj = JSON.parse(text);
			document.getElementById("demo").innerHTML =
			obj.employees[1].firstName + " " + obj.employees[1].lastName;
			</script>
			</div>
			
				
				<div id="javascript">
				<p>Test javascript</p>
				
				 </div>
				 <div id="mapDiv"></div>
				 <div id="map-canvas">
				 </div>
			</div>
		</div>
	</div>
	<div id="foot">
	</div>
	<script>
				var map;
				function initialize() {
				  var mapOptions = {
				    zoom: 13,
				    center: new google.maps.LatLng(46.1983922, 6.14229661)
				  };
				  map = new google.maps.Map(document.getElementById('map-canvas'),
				      mapOptions);
				}
				function loadScript() {
					  var script = document.createElement('script');
					  script.type = 'text/javascript';
					  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp' +
					      '&signed_in=false&callback=initialize';
					  document.body.appendChild(script);
					}
				
				window.onload = loadScript;
				</script>
</body>
</html>