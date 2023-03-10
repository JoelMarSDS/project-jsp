<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/lib/chart/chart.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/lib/easing/easing.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/lib/waypoints/waypoints.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/lib/tempusdominus/js/moment.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/lib/tempusdominus/js/moment-timezone.min.js"></script>
	<script src="<%= request.getContextPath() %>/assets/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

	<!-- Template Javascript -->
	<script src="<%= request.getContextPath() %>/assets/js/main.js"></script>

	<script type="text/javascript">
		(() => {
			  'use strict'
	
			  const forms = document.querySelectorAll('.needs-validation')
	
			  Array.from(forms).forEach(form => {
			    form.addEventListener('submit', event => {
			      if (!form.checkValidity()) {
			        event.preventDefault()
			        event.stopPropagation()
			      }
	
			      form.classList.add('was-validated')
			    }, false)
			  })
		})()
	</script>