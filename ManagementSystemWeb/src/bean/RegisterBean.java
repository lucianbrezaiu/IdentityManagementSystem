package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.IdentityDAORemote;
import dto.IdentityDTO;
import dto.RegisterDTO;
import links.Links;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class RegisterBean {

	IdentityDTO identityDTO;
	RegisterDTO registerDTO;
	String LOGIN_LINK; 
	@EJB
	IdentityDAORemote identityDAORemote;

	public RegisterBean() {
		registerDTO = new RegisterDTO();
		LOGIN_LINK = Links.LOGIN_LINK;
	}
	
	public IdentityDTO getIdentityDTO() {
		return identityDTO;
	}

	public void setIdentityDTO(IdentityDTO identityDTO) {
		this.identityDTO = identityDTO;
	}

	public RegisterDTO getRegisterDTO() {
		return registerDTO;
	}

	public void setRegisterDTO(RegisterDTO registerDTO) {
		this.registerDTO = registerDTO;
	}
	
	public String getLOGIN_LINK() {
		return LOGIN_LINK;
	}

	public void setLOGIN_LINK(String lOGIN_LINK) {
		LOGIN_LINK = lOGIN_LINK;
	}

	public String registerIdentity() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			List<IdentityDTO> identities = identityDAORemote.findAll();
			for (IdentityDTO identityDTO : identities) {
				if(identityDTO.getEmail().equals(registerDTO.getEmail())) {
					throw new Exception("Email already exist!");
				}
			}
			
			identityDAORemote.registerIdentity(registerDTO);
			facesContext.getExternalContext().getSessionMap().put("identityDTO", registerDTO);
			return Links.USER_HOME_LINK;

		} catch (Exception e) {
			// help: facesContext.addMessage afiseaza mesage de eroare in elementul html: <h:messages></h:messages>
			facesContext.addMessage("registerForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
			return null;
		}
	}
}
