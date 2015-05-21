<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<title>Activité</title>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="css">
		<!-- <link href="/stayfitgeneva/css/style.css" rel="stylesheet" type="text/css"> -->
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
	</head>
<body>
	<br>
	<div id="container">
		<h1>
		Parcours des randonnées! <br>
		</h1>
		<h2><jsp:include page="/template-menu.jsp" /></h2>
		<div id="menu">
		</div>
		<!-- Colonne 1 -->
	    <div class="leftside">
	     
		</div>
		<!-- Colonne 2-->
	    <div class="rightside">
	     
	    </div>
	    <!-- Colonne Centrale <div id="container" style="text-align:center"> -->
		<div class="content">
			<div id="corps">
			<script>
				var map;
				function initialize() {
				  var mapOptions = {
				    zoom: 13,
				    center: new google.maps.LatLng(46.1983922, 6.14229661)
				  }
				  
				
				var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

				  var ctaLayer = new google.maps.KmlLayer({
				    url: 'http://ge.ch/ags1/rest/services/open_data/vector_layers/MapServer/149/query?text=&geometry=&geometryType=esriGeometryPoint&inSR=2056&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=0<1&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=4326&outFields=*&f=kmz'
				  });
				  ctaLayer.setMap(map);}
				
				google.maps.event.addDomListener(window, 'load', initialize);
			</script>
			<div id='map-canvas'></div>	
			</div>
		</div>
	</div>
	<jsp:include page="/template-footer.jsp" />
</body>
</html>