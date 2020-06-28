package bean.userFilter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LoginBean;
import dao.OrganizationDAORemote;
import dao.resources.IdentitySystemDAORemote;
import dto.IdentityDTO;
import dto.OrganizationDTO;
import util.RoleEnum;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class UserBean {

	@EJB
	private IdentitySystemDAORemote identitySystemDAORemote;
	@EJB
	private OrganizationDAORemote organizationDAORemote;
	private IdentityDTO authenticatedIdentity;

	public UserBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		LoginBean loginBean = (LoginBean) facesContext.getExternalContext().getSessionMap().get("loginBean");
		if (loginBean != null && loginBean.getIdentityDTO() != null) {
			authenticatedIdentity = loginBean.getIdentityDTO();
		} 
	}

	public IdentityDTO getAuthenticatedIdentity() {
		return authenticatedIdentity;
	}

	public void setAuthenticatedIdentity(IdentityDTO authenticatedIdentity) {
		this.authenticatedIdentity = authenticatedIdentity;
	}

	public boolean isAdmin() {
		return identitySystemDAORemote.hasRoleInIdentitySystem(authenticatedIdentity.getId(), RoleEnum.administrator);
	}

	public String getCurrentFullname() {
		return String.format("%s %s", authenticatedIdentity.getFirstname(), authenticatedIdentity.getLastname());
	}

	public String getCurrentOrganization() {
		int organizationId = authenticatedIdentity.getOrganizationId();
		OrganizationDTO organization = organizationDAORemote.findById(organizationId);
		return organization.getName();
	}
}
