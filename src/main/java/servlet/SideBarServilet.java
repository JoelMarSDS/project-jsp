package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.properties.PropertiesUtils;

@WebServlet("/SideBarServilet")
public class SideBarServilet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SideBarServilet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var page = request.getParameter("item");

		RequestDispatcher dispatcher = request.getRequestDispatcher("/system/template/generic-template.jsp");
		request.setAttribute("page", PropertiesUtils.getPathPage(page));
		request.setAttribute("msg", "Informe o login e a senha corretamente");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
