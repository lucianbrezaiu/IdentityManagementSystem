package filter;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.LinksBean;
import bean.LoginBean;
import dao.resources.IdentitySystemDAORemote;
import util.RoleEnum;

@WebFilter("/userFilter/*")
public class UserFilter implements Filter {

	@EJB
	private IdentitySystemDAORemote identitySystemDAORemote;

	public IdentitySystemDAORemote getIdentitySystemDAORemote() {
		return identitySystemDAORemote;
	}

	public void setIdentitySystemDAORemote(IdentitySystemDAORemote identitySystemDAORemote) {
		this.identitySystemDAORemote = identitySystemDAORemote;
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

		LinksBean linksBean = new LinksBean();
		LoginBean loginBean = (LoginBean) httpServletRequest.getSession().getAttribute("loginBean");
		if (loginBean != null && loginBean.getIdentityDTO() != null) {
			int identityId = loginBean.getIdentityDTO().getId();
			if (identitySystemDAORemote.hasRoleInIdentitySystem(identityId, RoleEnum.member)) {
				filterChain.doFilter(servletRequest, servletResponse);
			} else {
				httpServletResponse
						.sendRedirect(httpServletRequest.getContextPath() + linksBean.getNOT_AUTHORIZED_LINK());
			}
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + linksBean.getLOGIN_LINK());
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
