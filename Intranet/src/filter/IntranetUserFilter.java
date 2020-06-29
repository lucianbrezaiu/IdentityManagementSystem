package filter;

import java.io.IOException;
import java.util.List;

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

import bean.IntranetLoginBean;
import dao.resources.IdentitySystemDAORemote;
import dao.resources.IntranetDAORemote;
import dto.ClaimDTO;
import util.RoleEnum;

@WebFilter("/userFilter/*")
public class IntranetUserFilter implements Filter {

	@EJB
	private IdentitySystemDAORemote identitySystemDAORemote;

	@EJB
	private IntranetDAORemote intranetDAORemote;
	
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

		IntranetLoginBean loginBean = (IntranetLoginBean) httpServletRequest.getSession().getAttribute("intranetLoginBean");
		if (loginBean != null && loginBean.getIdentityDTO() != null) {
			List<ClaimDTO> claims = intranetDAORemote.getRolesForAuthenticatedUser(loginBean.getIdentityDTO().getId());
			boolean res = false;
			for (ClaimDTO claimDTO : claims) {
				if(claimDTO.getRoleName().equals(RoleEnum.member.name())) {
					res = true;
					filterChain.doFilter(servletRequest, servletResponse);
				}
			}
			if(!res) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/notAuthorized.xhtml?faces-redirect=true");
			}
		} else {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml?faces-redirect=true");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
