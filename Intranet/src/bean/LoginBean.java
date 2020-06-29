package bean;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.IdentityDAORemote;
import dto.IdentityDTO;
import dto.LoginDTO;
import exception.LoginException;
@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginBean {

	private IdentityDTO identityDTO;
	private LoginDTO loginDTO;
	
	@EJB
	private IdentityDAORemote identityDAORemote;
	
	public LoginBean() {
		loginDTO = new LoginDTO();
	}

	public IdentityDTO getIdentityDTO() {
		return identityDTO;
	}

	public void setIdentityDTO(IdentityDTO identityDTO) {
		this.identityDTO = identityDTO;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}
	
	public String login() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			//identityDTO is the current identity and it is called is UserBean, that's why it is initialized here
			identityDTO = identityDAORemote.loginIdentity(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("identityDTO", identityDTO);
			loginDTO = new LoginDTO();
			return "/home.xhtml?faces-redirect=true";
		} catch (LoginException e) {
			// help: facesContext.addMessage afiseaza mesage de eroare in elementul html: <h:messages></h:messages>
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
	}
	
}
