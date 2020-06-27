package bean.adminFilter;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.IdentityDAORemote;
import links.Links;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class AdminBean {

	@EJB
	IdentityDAORemote identityDAORemote;
	
	String ADMIN_HOME_LINK = Links.ADMIN_HOME_LINK; 
	String ADMIN_ORGANISATIONS_LINK = Links.ADMIN_ORGANISATIONS_LINK;
	String ADMIN_RESOURCES_LINK = Links.ADMIN_RESOURCES_LINK;
	String ADMIN_ROLES_LINK = Links.ADMIN_ROLES_LINK;
	
	public AdminBean() {
		
	}

	public IdentityDAORemote getIdentityDAORemote() {
		return identityDAORemote;
	}

	public void setIdentityDAORemote(IdentityDAORemote identityDAORemote) {
		this.identityDAORemote = identityDAORemote;
	}

	public String getADMIN_HOME_LINK() {
		return ADMIN_HOME_LINK;
	}

	public void setADMIN_HOME_LINK(String aDMIN_HOME_LINK) {
		ADMIN_HOME_LINK = aDMIN_HOME_LINK;
	}

	public String getADMIN_ORGANISATIONS_LINK() {
		return ADMIN_ORGANISATIONS_LINK;
	}

	public void setADMIN_ORGANISATIONS_LINK(String aDMIN_ORGANISATIONS_LINK) {
		ADMIN_ORGANISATIONS_LINK = aDMIN_ORGANISATIONS_LINK;
	}

	public String getADMIN_RESOURCES_LINK() {
		return ADMIN_RESOURCES_LINK;
	}

	public void setADMIN_RESOURCES_LINK(String aDMIN_RESOURCES_LINK) {
		ADMIN_RESOURCES_LINK = aDMIN_RESOURCES_LINK;
	}

	public String getADMIN_ROLES_LINK() {
		return ADMIN_ROLES_LINK;
	}

	public void setADMIN_ROLES_LINK(String aDMIN_ROLES_LINK) {
		ADMIN_ROLES_LINK = aDMIN_ROLES_LINK;
	}
	
	public String logout() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().invalidateSession();
		System.out.println("Trying to logout ...");
		return Links.LOGIN_LINK;
	}
}
