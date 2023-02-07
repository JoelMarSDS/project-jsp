<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row justify-content-center align-items-center vh-100">
			<div class="col-5">
				<h1 class="text-center">Projeto Jsp</h1>
				<form action="LoginServilet" method="post" class="needs-validation" novalidate>
					<div class="row">
						<div class="col">
							<label for="inputUsername" class="form-label">Usuário</label>
							<input type="text" class="form-control" name="username" id="inputUsername" required="required">
							<div class="invalid-feedback">
								Campo Obrigatorio!
							</div>
							<div class="valid-feedback">
								Ok!
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<label for="inputPassword" class="form-label">Senha</label>
							<input type="password" class="form-control" name="password" id="inputPassword" required="required">
							<div class="invalid-feedback">
								Campo Obrigatorio!
							</div>
							<div class="valid-feedback">
								Ok!
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-auto mt-2">
							<button type="submit" class="btn btn-primary">Entrar</button>
						</div>
					</div>
				</form>
				<h4 class="text-center">${ msg }</h4>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
		crossorigin="anonymous"></script>
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
</body>
</html>