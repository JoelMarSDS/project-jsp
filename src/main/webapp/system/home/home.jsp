<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
            <!-- Blank Start -->
			<div class="container-fluid pt-4 px-4">
				<div class="row vh-100 bg-secondary rounded justify-content-center mx-0">
					<div class="col-md-6 text-center">
						<div class="bg-secondary rounded h-100 p-4">
							<div class="md-4">
								<h3>Cadastro de Usuário</h3>
							</div>
							<form action="<%= request.getContextPath() %>/UserServilet" method="post">
								<div class="form-floating mb-3">
									<input type="number" class="form-control" id="idInput"
		                                    placeholder="name@example.com" disabled="disabled" name="idInput">
									<label for="idInput">ID</label>
								</div>
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="nameInput"
		                                    placeholder="name@example.com" name="nameInput">
									<label for="nameInput">Nome</label>
								</div>
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="emailInput"
		                                    placeholder="name@example.com" name="emailInput">
									<label for="emailInput">Email</label>
								</div>
								<div class="form-floating mb-3">
									<input type="text" class="form-control" id="usernameInput"
		                                    placeholder="name@example.com" name="usernameInput">
									<label for="usernameInput">Username</label>
								</div>
								<div class="form-floating mb-3">
									<input type="password" class="form-control" id="passwordPassword"
                                    placeholder="Password" name="passwordPassword">
									<label for="passwordPassword">Password</label>
								</div>
								<button type="button" class="btn btn-outline-info m-2">Novo</button>
								<input type="submit" class="btn btn-success m-2" value="Salvar">
								<button type="button" class="btn btn-warning m-2">Atualizar</button>
								<button type="button" class="btn btn-primary m-2">Apagar</button>
							</form>
						</div>
					</div>
				</div>
			</div>
            <!-- Blank End -->