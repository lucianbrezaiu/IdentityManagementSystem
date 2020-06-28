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
	
	public UserBean() {
		
	}
	
	public boolean isAdmin(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		LoginBean loginBean = (LoginBean) facesContext.getExternalContext().getSessionMap().get("loginBean");
		if(loginBean!=null && loginBean.getIdentityDTO()!= null) {
			IdentityDTO identity = loginBean.getIdentityDTO();
			return identityDAORemote.hasRoleInIdentitySystem(identity.getUsername(), IdpRole.idp_admin);
		}
		
		RegisterBean registerBean = (RegisterBean) facesContext.getExternalContext().getSessionMap().get("registerBean");
		if(registerBean!=null && registerBean.getIdentityDTO()!= null) {
			IdentityDTO identity = registerBean.getIdentityDTO();
			System.out.println(identity);
			return identityDAORemote.hasRoleInIdentitySystem(identity.getUsername(), IdpRole.idp_admin);
		}
		
		return false;
	}
	
	public String getUsername() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		
		LoginBean loginBean = (LoginBean) facesContext.getExternalContext().getSessionMap().get("loginBean");
		if(loginBean!=null && loginBean.getIdentityDTO()!= null) {
			IdentityDTO identity = loginBean.getIdentityDTO();
			return String.format("%s %s", identity.getFirstname(),identity.getLastname());
		}
		
		RegisterBean register = (RegisterBean) facesContext.getExternalContext().getSessionMap().get("registerBean");
		if(register!=null && register.getIdentityDTO()!= null) {
			IdentityDTO identity = register.getIdentityDTO();
			return String.format("%s %s", identity.getFirstname(),identity.getLastname());
		}
		
		return "";
	}
	
}
