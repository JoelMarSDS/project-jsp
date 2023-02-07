package filter;

import static java.util.Objects.isNull;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import utils.connection.SingleConnection;

@WebFilter("/system/*")
public class AuthenticationFilter extends HttpFilter implements Filter {

	private static Connection connection;

	public AuthenticationFilter() {
		super();
	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession httpSession = httpServletRequest.getSession();
			String url = httpServletRequest.getServletPath();
			String username = (String) httpSession.getAttribute("username");

			if (isNull(username) && !url.equals("/system/LoginServilet") && !url.equals("/LoginServilet")) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
				request.setAttribute("msg", "Realize o login corretemente");
				dispatcher.forward(request, response);
				return;
			} else {
				chain.doFilter(request, response);
			}

			connection.commit();
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			request.setAttribute("msg", "Estamos resolvendo o ocorrido, tente novamente mais tarde");
			dispatcher.forward(request, response);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnection.getConnection();
	}
}
