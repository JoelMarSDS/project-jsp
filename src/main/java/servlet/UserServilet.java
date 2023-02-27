package servlet;

import static java.util.Objects.isNull;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginModel;

@WebServlet("/UserServilet")
public class UserServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserServilet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = isNull(request.getParameter("idInput")) ? 0L:Long.parseLong(request.getParameter("idInput"));
		String name = request.getParameter("nameInput");
		String email = request.getParameter("emailInput");
		String username = request.getParameter("usernameInput");
		String password = request.getParameter("passwordPassword");
		
		LoginModel loginModel = new LoginModel();
		
		loginModel.setId(id);
		loginModel.setName(name);
		loginModel.setEmail(email);
		loginModel.setUsername(username);
		loginModel.setPassword(password);
		
		System.out.println(loginModel);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
