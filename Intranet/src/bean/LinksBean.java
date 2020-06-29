package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LinksBean {

	private String LOGIN_LINK = "/login.xhtml?faces-redirect=true";
	
	private String REGISTER_LINK = "/register.xhtml?faces-redirect=true";
		
	private String NOT_AUTHORIZED_LINK = "/notAuthorized.xhtml";
	
	private String ADMIN_HOME_LINK = "/adminFilter/home.xhtml?faces-redirect=true";
	
	private String ADMIN_ORGANIZATIONS_LINK = "/adminFilter/organizations.xhtml?faces-redirect=true";
	
	private String ADMIN_ADD_ORGANIZATION_LINK = "/adminFilter/addOrganization.xhtml?faces-redirect=true";
	
	private String ADMIN_RESOURCES_LINK = "/adminFilter/resources.xhtml?faces-redirect=true";
	
	private String ADMIN_ADD_RESOURCE_LINK = "/adminFilter/addResource.xhtml?faces-redirect=true";
	
	private String ADMIN_ROLES_LINK = "/adminFilter/roles.xhtml?faces-redirect=true";
	
	private String ADMIN_ADD_ROLE_LINK = "/adminFilter/addRole.xhtml?faces-redirect=true";
	
	private String ADMIN_RIGHTS_LINK = "/adminFilter/rights.xhtml?faces-redirect=true";
	
	private String ADMIN_ADD_RIGHT_LINK = "/adminFilter/addRight.xhtml?faces-redirect=true";
	
	private String ADMIN_CLAIMS_LINK = "/adminFilter/claims.xhtml?faces-redirect=true";
	
	private String ADMIN_ADD_CLAIM_LINK = "/adminFilter/addClaim.xhtml?faces-redirect=true";
	
	private String USER_HOME_LINK = "/userFilter/home.xhtml?faces-redirect=true";

	private String USER_CLAIMS_LINK = "/userFilter/claims.xhtml?faces-redirect=true";
	
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

	public String getADMIN_ORGANIZATIONS_LINK() {
		return ADMIN_ORGANIZATIONS_LINK;
	}

	public void setADMIN_ORGANIZATIONS_LINK(String aDMIN_ORGANIZATIONS_LINK) {
		ADMIN_ORGANIZATIONS_LINK = aDMIN_ORGANIZATIONS_LINK;
	}

	public String getADMIN_ADD_ORGANIZATION_LINK() {
		return ADMIN_ADD_ORGANIZATION_LINK;
	}

	public void setADMIN_ADD_ORGANIZATION_LINK(String aDMIN_ADD_ORGANIZATION_LINK) {
		ADMIN_ADD_ORGANIZATION_LINK = aDMIN_ADD_ORGANIZATION_LINK;
	}

	public String getADMIN_RESOURCES_LINK() {
		return ADMIN_RESOURCES_LINK;
	}

	public void setADMIN_RESOURCES_LINK(String aDMIN_RESOURCES_LINK) {
		ADMIN_RESOURCES_LINK = aDMIN_RESOURCES_LINK;
	}

	public String getADMIN_ADD_RESOURCE_LINK() {
		return ADMIN_ADD_RESOURCE_LINK;
	}

	public void setADMIN_ADD_RESOURCE_LINK(String aDMIN_ADD_RESOURCE_LINK) {
		ADMIN_ADD_RESOURCE_LINK = aDMIN_ADD_RESOURCE_LINK;
	}

	public String getADMIN_ROLES_LINK() {
		return ADMIN_ROLES_LINK;
	}

	public void setADMIN_ROLES_LINK(String aDMIN_ROLES_LINK) {
		ADMIN_ROLES_LINK = aDMIN_ROLES_LINK;
	}

	public String getADMIN_ADD_ROLE_LINK() {
		return ADMIN_ADD_ROLE_LINK;
	}

	public void setADMIN_ADD_ROLE_LINK(String aDMIN_ADD_ROLE_LINK) {
		ADMIN_ADD_ROLE_LINK = aDMIN_ADD_ROLE_LINK;
	}

	public String getADMIN_RIGHTS_LINK() {
		return ADMIN_RIGHTS_LINK;
	}

	public void setADMIN_RIGHTS_LINK(String aDMIN_RIGHTS_LINK) {
		ADMIN_RIGHTS_LINK = aDMIN_RIGHTS_LINK;
	}

	public String getADMIN_ADD_RIGHT_LINK() {
		return ADMIN_ADD_RIGHT_LINK;
	}

	public void setADMIN_ADD_RIGHT_LINK(String aDMIN_ADD_RIGHT_LINK) {
		ADMIN_ADD_RIGHT_LINK = aDMIN_ADD_RIGHT_LINK;
	}

	public String getADMIN_CLAIMS_LINK() {
		return ADMIN_CLAIMS_LINK;
	}

	public void setADMIN_CLAIMS_LINK(String aDMIN_CLAIMS_LINK) {
		ADMIN_CLAIMS_LINK = aDMIN_CLAIMS_LINK;
	}

	public String getADMIN_ADD_CLAIM_LINK() {
		return ADMIN_ADD_CLAIM_LINK;
	}

	public void setADMIN_ADD_CLAIM_LINK(String aDMIN_ADD_CLAIM_LINK) {
		ADMIN_ADD_CLAIM_LINK = aDMIN_ADD_CLAIM_LINK;
	}

	public String getUSER_HOME_LINK() {
		return USER_HOME_LINK;
	}
	
	public void setUSER_HOME_LINK(String uSER_HOME_LINK) {
		USER_HOME_LINK = uSER_HOME_LINK;
	}

	public String getUSER_CLAIMS_LINK() {
		return USER_CLAIMS_LINK;
	}

	public void setUSER_CLAIMS_LINK(String uSER_CLAIMS_LINK) {
		USER_CLAIMS_LINK = uSER_CLAIMS_LINK;
	}
	
	
}
