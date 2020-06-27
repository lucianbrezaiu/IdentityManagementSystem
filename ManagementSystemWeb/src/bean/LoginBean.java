package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import dao.IdentityDAORemote;
import dto.IdentityDTO;
import dto.LoginDTO;
import exception.LoginException;
import links.Links;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginBean {

	IdentityDTO identityDTO;
	LoginDTO loginDTO;
	String REGISTER_LINK;
	@EJB
	IdentityDAORemote identityDAORemote;
	
	public LoginBean() {
		loginDTO = new LoginDTO();
		REGISTER_LINK = Links.REGISTER_LINK; 
	}
	
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public IdentityDTO getIdentityDTO() {
		return identityDTO;
	}

	public void setIdentityDTO(IdentityDTO identityDTO) {
		this.identityDTO = identityDTO;
	}
	
	public String getREGISTER_LINK() {
		return REGISTER_LINK;
	}

	public void setREGISTER_LINK(String rEGISTER_LINK) {
		REGISTER_LINK = rEGISTER_LINK;
	}

	public String loginIdentity() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			identityDTO = identityDAORemote.loginIdentity(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("identityDTO", identityDTO);
			
			return Links.ADMIN_HOME_LINK;
			//"/adminFilter/admin.xhtml?faces-redirect=true";
		} catch (LoginException e) {
			// help: facesContext.addMessage afiseaza mesage de eroare in elementul html: <h:messages></h:messages>
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
	}
}
