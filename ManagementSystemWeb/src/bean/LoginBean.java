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

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginBean {

	private IdentityDTO identityDTO;
	private LoginDTO loginDTO;
	private LinksBean linksBean;
	
	@EJB
	private IdentityDAORemote identityDAORemote;
	
	public LoginBean() {
		loginDTO = new LoginDTO();
		linksBean = new LinksBean();
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
	
	public String login() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			identityDTO = identityDAORemote.loginIdentity(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("identityDTO", identityDTO);
			
			return linksBean.getADMIN_HOME_LINK();
		} catch (LoginException e) {
			// help: facesContext.addMessage afiseaza mesage de eroare in elementul html: <h:messages></h:messages>
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
	}
	
	public String logout() {
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().invalidateSession();
		System.out.println("Trying to logout ...");
		return linksBean.getLOGIN_LINK();
	}
}
