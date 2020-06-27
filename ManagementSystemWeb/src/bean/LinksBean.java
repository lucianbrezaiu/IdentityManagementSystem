package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LinksBean {

	private String LOGIN_LINK = "/login.xhtml";
	
	private String REGISTER_LINK = "/register.xhtml";
		
	private String NOT_AUTHORIZED_LINK = "/notAuthorized.xhtml";
	
	private String ADMIN_HOME_LINK = "/adminFilter/home.xhtml?faces-redirect=true";
	
	private String ADMIN_ORGANISATIONS_LINK = "/adminFilter/organisations.xhtml?faces-redirect=true";
	
	private String ADMIN_RESOURCES_LINK = "/adminFilter/resources.xhtml?faces-redirect=true";
	
	private String ADMIN_ROLES_LINK = "/adminFilter/roles.xhtml?faces-redirect=true";
	
	private String USER_HOME_LINK = "/userFilter/home.xhtml";

	public LinksBean() {
		
	}

	public String getLOGIN_LINK() {
		return LOGIN_LINK;
	}

	public void setLOGIN_LINK(String lOGIN_LINK) {
		LOGIN_LINK = lOGIN_LINK;
	}

	public String getREGISTER_LINK() {
		return REGISTER_LINK;
	}

	public void setREGISTER_LINK(String rEGISTER_LINK) {
		REGISTER_LINK = rEGISTER_LINK;
	}

	public String getNOT_AUTHORIZED_LINK() {
		return NOT_AUTHORIZED_LINK;
	}

	public void setNOT_AUTHORIZED_LINK(String nOT_AUTHORIZED_LINK) {
		NOT_AUTHORIZED_LINK = nOT_AUTHORIZED_LINK;
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

	public String getUSER_HOME_LINK() {
		return USER_HOME_LINK;
	}

	public void setUSER_HOME_LINK(String uSER_HOME_LINK) {
		USER_HOME_LINK = uSER_HOME_LINK;
	}
	
	
}
