package filter;

import static java.util.Objects.isNull;

import java.io.IOException;

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

@WebFilter("/system/*")
public class AuthenticationFilter extends HttpFilter implements Filter {

	public AuthenticationFilter() {
		super();
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

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

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
