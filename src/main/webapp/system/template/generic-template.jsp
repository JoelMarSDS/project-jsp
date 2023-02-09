<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<jsp:include page="head-pag.jsp"></jsp:include>
<body>

	<!-- jsp:body>${ pag }</jsp:body -->

	<jsp:include page="${ pag }"></jsp:include>
	
	<jsp:include page="script-pag.jsp"></jsp:include>
</body>
</html>