package servlet;

import static java.util.Objects.nonNull;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import model.LoginModel;
import utils.connection.SingleConnection;

@WebServlet(urlPatterns = { "/system/LoginServilet", "/LoginServilet" })
public class LoginServilet extends HttpServlet {
	
	private Logger logger = Logger.getLogger(SingleConnection.class.getName());
	private LoginDao loginDao = new LoginDao();

	public LoginServilet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			var username = request.getParameter("username");
			var password = request.getParameter("password");
	
			if (nonNull(username) && !username.isEmpty() && nonNull(password) && !password.isEmpty()) {
	
				LoginModel loginModel = new LoginModel();
	
				loginModel.setUsername(username);
				loginModel.setPassword(password);
	
				if (loginDao.validateLogin(loginModel)) {
	
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
	
			logger.info(String.format("Usuário: %s | Senha: %s", username, password));
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "Estamos resolvendo o ocorrido, tente novamente mais tarde");
			dispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
