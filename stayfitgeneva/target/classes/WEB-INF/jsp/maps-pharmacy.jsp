<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<title>Activité</title>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/stayfitgeneva/css/style.css" rel="stylesheet" type="text/css">
		<!-- <link href="/stayfitgeneva/css/style.css" rel="stylesheet" type="text/css"> -->
	</head>
<body>
	<br>
	<div id="container">
		<h1>
		Pharmacies de Genève <br>
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
			<div id='map-canvas'>	
			</div>
		</div>
	</div>
	<script>
	//<![CDATA[
	var map;
	function initialize() {
	  var mapOptions = {
	    zoom: 13,
	    center: new google.maps.LatLng(46.1983922, 6.14229661)
	  };
	  map = new google.maps.Map(document.getElementById('map-canvas'),
	      mapOptions);
	  
	  render();
	}
	
	function render() {
		//var arrayTitles = ${titles};
		var arrayLats = ${lats};
		var arrayLngs = ${lngs};
		var arrayLength = arrayLats.length, i = 0;
		
		for (; i < arrayLength; i++) {
			
			//var title = "title => " + arrayTitles[i];
	    	var myLatlng = new google.maps.LatLng(arrayLats[i],arrayLngs[i]);
	    	var marker = new google.maps.Marker({
	  	      position: myLatlng,
	  	      map: map,
	  	      //title: arrayTitles[i]
	    	});
	    }
	}
	
	function loadScript() {
		  var script = document.createElement('script');
		  script.type = 'text/javascript';
		  script.src = 'https://maps.googleapis.com/maps/api/js?v=3.exp' +
		      '&signed_in=false&callback=initialize';
		  document.body.appendChild(script);
		}
	
	window.onload = loadScript;
	//]]>
			</script>
	</div>
	<jsp:include page="/template-footer.jsp" />
</body>
</html>