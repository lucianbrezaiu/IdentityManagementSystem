package bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;

import dao.IdentityDAORemote;
import dto.IdentityDTO;
import dto.LoginDTO;
import exception.LoginException;


@ManagedBean
@SessionScoped
public class LoginBean {

	IdentityDTO identityDTO;
	LoginDTO loginDTO = new LoginDTO();
	
	@EJB
	IdentityDAORemote identityDAORemote;
	
	public LoginBean() {
		
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
	
	public String loginIdentity() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			identityDTO = identityDAORemote.loginIdentity(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("identityDTO", identityDTO);
			if(identityDTO.getUsername().equals("admin")) {
				return "/adminFilter/admin.xhtml?faces-redirect=true";
			}
			return "/test";

		} catch (LoginException e) {
			//facesContext.addMessage display error message in html element <h:messages></h:messages>
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
	}
}
