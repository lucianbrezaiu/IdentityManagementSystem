package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.IdentityDAORemote;
import dao.resources.IntranetDAORemote;
import dto.ClaimDTO;
import dto.IdentityDTO;
import dto.LoginDTO;
import dto.RoleDTO;
import exception.LoginException;
import util.RoleEnum;
@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class IntranetLoginBean {

	private IdentityDTO identityDTO;
	private LoginDTO loginDTO;
	
	@EJB
	private IdentityDAORemote identityDAORemote;
	
	@EJB
	private IntranetDAORemote intranetDAORemote;
	
	public IntranetLoginBean() {
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
			
			List<ClaimDTO> claims = intranetDAORemote.getRolesForAuthenticatedUser(identityDTO.getId());
			for (ClaimDTO claimDTO : claims) {
				if(claimDTO.getRoleName().equals(RoleEnum.member.name())) {
					facesContext.getExternalContext().getSessionMap().put("identityDTO", identityDTO);
					loginDTO = new LoginDTO();
					return "/home.xhtml?faces-redirect=true";
				}
			}
			throw new LoginException();
		} catch (LoginException e) {
			// help: facesContext.addMessage afiseaza mesage de eroare in elementul html: <h:messages></h:messages>
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}
	}
	
}
