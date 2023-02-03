package servlet;

import static java.util.Objects.nonNull;
import static java.util.Objects.isNull;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginModel;

@WebServlet(urlPatterns = {"/system/LoginServilet","/LoginServilet"})
public class LoginServilet extends HttpServlet {

	public LoginServilet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		var username = request.getParameter("username");
		var password = request.getParameter("password");
		var url = request.getParameter("url");

		if (nonNull(username) && !username.isEmpty() && nonNull(password) && !password.isEmpty()) {

			LoginModel loginModel = new LoginModel();
			
			loginModel.setUsername(username);
			loginModel.setPassword(password);
			
			if (loginModel.getUsername().equals("admin") && loginModel.getPassword().equals("admin")) {
				
				request.getSession().setAttribute("username", loginModel.getUsername());
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/system/home.jsp");
				request.setAttribute("msg", "Usuario Logado");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Informe o login e a senha corretamente");
				dispatcher.forward(request, response);
			}
			
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "Informe o login e a senha");
			dispatcher.forward(request, response);
		}

		LoginModel loginModel = new LoginModel();

		loginModel.setUsername(username);
		loginModel.setPassword(password);

		System.out.println(String.format("Usuário: %s | Senha: %s", username, password));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
