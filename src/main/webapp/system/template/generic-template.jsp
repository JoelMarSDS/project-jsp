<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<jsp:include page="./componente/head-pag.jsp"></jsp:include>
<body>
	<div class="container-fluid position-relative d-flex p-0">
		<jsp:include page="./componente/loading-pag.jsp"></jsp:include>
		
		<!-- Sidebar Start -->
		<jsp:include page="./componente/sidebar-pag.jsp"></jsp:include>
		<!-- Sidebar End -->
		
        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
			<jsp:include page="./componente/navbar-content-pag.jsp"></jsp:include>
			<!-- Navbar End -->
			
			<!-- Widgets End -->
			<jsp:include page="${ page }"></jsp:include>
			<!-- Widgets End -->
			
			<!-- Footer Start -->
            <jsp:include page="./componente/footer-pag.jsp"></jsp:include>
            <!-- Footer End -->
        </div>
        <!-- Content End -->
        
        <!-- Back to Top -->
		<jsp:include page="./componente/back-top-pag.jsp"></jsp:include>
	</div>	
	<jsp:include page="./componente/script-pag.jsp"></jsp:include>
</body>
</html>