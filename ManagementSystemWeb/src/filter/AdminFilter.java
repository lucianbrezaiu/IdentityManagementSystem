package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LoginBean;

@WebFilter("/adminFilter/*")
public class AdminFilter implements Filter {

	public static final String AUTHENTICATED_USER_MAIN_PAGE = "/userFilter/user.xhtml";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		System.out.println("filter called");
		LoginBean loginBean = (LoginBean) httpServletRequest.getSession().getAttribute("loginBean");
		if (loginBean != null && loginBean.getIdentityDTO() != null && loginBean.getIdentityDTO().getUsername().equals("admin")) {
			// todo: check if authenticated user has the admin role in this organization
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + AUTHENTICATED_USER_MAIN_PAGE);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
