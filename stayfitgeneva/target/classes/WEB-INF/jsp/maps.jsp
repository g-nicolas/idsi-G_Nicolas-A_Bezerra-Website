<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>   
<html>
<head>
<link href="/stayfitgeneva/css/style.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Activité</title>
</head>
<body>
	<br>
	<div id="container">
		<h2><jsp:include page="/template-menu.jsp" /></h2>
		<!-- Colonne 1 -->
	    <div class="leftside">
		</div>
		<!-- Colonne 2-->
	    <div class="rightside">
	    </div>
	    <!-- Colonne Centrale <div id="container" style="text-align:center"> -->
		<div class="content">
			<div id="corps">
			<script type="text/javascript">
			</script>
				<div id="id01"></div>
			<c:forEach items="${pharmas}" var="pharmacie">
		    <tr>
		        <td>Pharma id<c:out value="${pharmacie.id}"/></td>
		        <td>Pharma name: <c:out value="${pharmacie.title}"/></td>  
		    </tr>
			</c:forEach>
			<script>
			//<![CDATA[
			    var arrayPharma ="${pharmas}";
			    var arrayLength = arrayPharma.length;
			    for (var i = 0; i < arrayLength; i++) {
			    	document.write(arrayPharma[i]);
			    	//document.write(arrayPharma[i].getTitle());
			    	//alert(arrayPharma[i]);
			        //Do something
			    }
			    var arrayPharma ="${findAll}";
			    var arrayLength = arrayPharma.length;
			    for (var i = 0; i < arrayLength; i++) {
			    	document.write(arrayPharma[i]);
			    	//document.write(arrayPharma[i].getTitle());
			    	//alert(arrayPharma[i]);
			        //Do something
			    }
			//]]>
			</script>
			</div>
		</div>
	</div>
	<jsp:include page="/template-footer.jsp" />
</body>
</html>