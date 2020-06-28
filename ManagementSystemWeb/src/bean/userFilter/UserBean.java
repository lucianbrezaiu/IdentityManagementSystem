package bean.userFilter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LoginBean;
import bean.RegisterBean;
import dao.IdentityDAORemote;
import dto.IdentityDTO;
import util.IdpRole;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class UserBean {

	@EJB
	private IdentityDAORemote identityDAORemote;
	private IdentityDTO authenticatedIdentity;
	
	public UserBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		LoginBean loginBean = (LoginBean) facesContext.getExternalContext().getSessionMap().get("loginBean");
		if(loginBean!=null && loginBean.getIdentityDTO()!= null) {
			authenticatedIdentity = loginBean.getIdentityDTO();
		}
		else {
			RegisterBean register = (RegisterBean) facesContext.getExternalContext().getSessionMap().get("registerBean");
			if(register!=null && register.getIdentityDTO()!= null) {
				authenticatedIdentity = register.getIdentityDTO();
			}
		}
	}
	
	public IdentityDTO getAuthenticatedIdentity() {
		return authenticatedIdentity;
	}

	public void setAuthenticatedIdentity(IdentityDTO authenticatedIdentity) {
		this.authenticatedIdentity = authenticatedIdentity;
	}

	public boolean isAdmin(){
		return identityDAORemote.hasRoleInIdentitySystem(authenticatedIdentity.getUsername(), IdpRole.idp_admin);
	}
	
	public String getCurrentFullname() {
		return String.format("%s %s", authenticatedIdentity.getFirstname(),authenticatedIdentity.getLastname());
	}
}
