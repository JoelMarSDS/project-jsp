<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<jsp:include page="system/template/componente/head-pag.jsp"></jsp:include>
<body>
	<div class="container-fluid position-relative d-flex p-0">
		
		<jsp:include page="system/template/componente/loading-pag.jsp"></jsp:include>
		
		<!-- Sign In Start -->
		<div class="container-fluid">
			<div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
				<div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
					<div class="bg-secondary rounded p-4 p-sm-5 my-4 mx-3">
						<div class="row d-flex align-items-center justify-content-between mb-3">
							<h3 class="text-primary text-center">Projeto Jsp</h3>
						</div>
						<form action="LoginServilet" method="post" class="needs-validation" novalidate>
							<div class="form-floating mb-3">
								<input type="text" class="form-control" id="floatingInput" name="username" placeholder="User" required>
								<label for="floatingInput">Usuário</label>
								<div class="invalid-feedback">
									Campo Obrigatorio!
								</div>
								<div class="valid-feedback">
									Ok!
								</div>
							</div>
							<div class="form-floating mb-4">
								<input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password" required>
								<label for="floatingPassword">Password</label>
								<div class="invalid-feedback">
									Campo Obrigatorio!
								</div>
								<div class="valid-feedback">
									Ok!
								</div>
							</div>
							<button type="submit" class="btn btn-primary py-3 w-100 mb-4">Entrar</button>
						</form>
						<h4 class="text-primary text-center">${ msg }</h4>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="system/template/componente/script-pag.jsp"></jsp:include>
</body>
</html>