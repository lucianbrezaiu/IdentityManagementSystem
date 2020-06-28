package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import dao.IdentityDAORemote;
import dao.OrganizationDAORemote;
import dto.IdentityDTO;
import dto.LoginDTO;
import dto.OrganizationDTO;
import dto.RegisterDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class RegisterBean {

	private IdentityDTO identityDTO;
	private RegisterDTO registerDTO;
	private LinksBean linksBean;
	
	@EJB
	IdentityDAORemote identityDAORemote;

	@EJB
	OrganizationDAORemote organizationDAORemote;
	
	public RegisterBean() {
		registerDTO = new RegisterDTO();
		linksBean = new LinksBean();
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
	
	public List<OrganizationDTO> getOrganizations() {
		return organizationDAORemote.findAll();
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
			registerDTO = new RegisterDTO();
			return linksBean.getLOGIN_LINK();
		} catch (Exception e) {
			// help: facesContext.addMessage afiseaza mesage de eroare in elementul html: <h:messages></h:messages>
			facesContext.addMessage("registerForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
			return null;
		}
	}
}
