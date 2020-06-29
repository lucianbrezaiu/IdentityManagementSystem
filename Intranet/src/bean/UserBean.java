package bean;

import javax.faces.context.FacesContext;

import dto.IdentityDTO;

public class UserBean {

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

	public String getCurrentFullname() {
		return String.format("%s %s", authenticatedIdentity.getFirstname(), authenticatedIdentity.getLastname());
	}
	
	
}
