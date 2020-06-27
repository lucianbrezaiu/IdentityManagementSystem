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
import links.Links;

@WebFilter("/adminFilter/*")
public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

		LoginBean loginBean = (LoginBean) httpServletRequest.getSession().getAttribute("loginBean");
		if (loginBean != null && loginBean.getIdentityDTO() != null) {
			if(loginBean.getIdentityDTO().getUsername().equals("admin")) {
				// todo: check if authenticated user has the admin role in this organization
				filterChain.doFilter(servletRequest, servletResponse);
			}else {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Links.USER_HOME_LINK);
			}
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + Links.LOGIN_LINK);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}
}
