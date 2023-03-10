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
		String acction = request.getParameter("acction");
		if(nonNull(acction) && 	!acction.isEmpty() && acction.equals("logout")) {
			request.getSession().invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			return;
		}

		try {
			var username = request.getParameter("username");
			var password = request.getParameter("password");
	
			if (nonNull(username) && !username.isEmpty() && nonNull(password) && !password.isEmpty()) {
	
				LoginModel loginModel = new LoginModel();
	
				loginModel.setUsername(username);
				loginModel.setPassword(password);
	
				if (loginDao.validateLogin(loginModel)) {
	
					request.getSession().setAttribute("username", loginModel.getUsername());
	
					RequestDispatcher dispatcher = request.getRequestDispatcher("/SideBarServilet?item=home");
					dispatcher.forward(request, response);
				} else {
					dispatcher(request, response, "/index.jsp", "Informe o login e a senha corretamente");
				}
	
			} else {
				dispatcher(request, response, "/index.jsp", "Informe o login e a senha");
			}
	
			LoginModel loginModel = new LoginModel();
	
			loginModel.setUsername(username);
			loginModel.setPassword(password);
	
			logger.info(String.format("Usu??rio: %s | Senha: %s", username, password));
		} catch (Exception e) {
			dispatcher(request, response, "/index.jsp", "Estamos resolvendo o ocorrido, tente novamente mais tarde");
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


	private void dispatcher(HttpServletRequest request, HttpServletResponse response, String path, String msg)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		request.setAttribute("msg", msg);
		dispatcher.forward(request, response);
	}

}
