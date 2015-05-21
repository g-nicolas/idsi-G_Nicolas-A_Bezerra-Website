<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link href="/stayfitgeneva/css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Météo</title>
</head>
<body>
	<br>
	<div id="container">
		<h1>
		Bienvenue sur la page Météo!<br>
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
				<div id="weather">
					<p>
						${displayWeather}
					</p>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/template-footer.jsp" />
</body>
</html>