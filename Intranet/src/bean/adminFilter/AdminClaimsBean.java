package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LinksBean;
import dao.ClaimDAORemote;
import dao.IdentityDAORemote;
import dao.ResourceDAORemote;
import dao.RoleDAORemote;
import dto.ClaimDTO;
import dto.IdentityDTO;
import dto.NewClaimDTO;
import dto.ResourceDTO;
import dto.RoleDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class AdminClaimsBean {

	@EJB
	private ClaimDAORemote claimDAORemote;
	
	@EJB
	private IdentityDAORemote identityDAORemote;
	
	@EJB
	private ResourceDAORemote resourceDAORemote;
	
	@EJB
	private RoleDAORemote roleDAORemote;
	
	
	private NewClaimDTO newClaimDTO;
	private LinksBean linksBean;
	
	public AdminClaimsBean() {
		newClaimDTO = new NewClaimDTO();
		linksBean = new LinksBean();
	}
	
	public NewClaimDTO getNewClaimDTO() {
		return newClaimDTO;
	}

	public void setNewClaimDTO(NewClaimDTO newClaimDTO) {
		this.newClaimDTO = newClaimDTO;
	}

	public List<ClaimDTO> getClaims(){
		
		return claimDAORemote.findAll();
	}
	
	public List<IdentityDTO> getIdentities() {
		return identityDAORemote.findAll();
	}
	
	public List<ResourceDTO> getResources() {
		return resourceDAORemote.findAll();
	}
	
	public List<RoleDTO> getRoles() {
		return roleDAORemote.findAll();
	}
	
	public String addClaim() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			boolean result = claimDAORemote.exist(newClaimDTO.getIdentityId(), newClaimDTO.getResourceId(), newClaimDTO.getRoleId());
			if(result) {
				facesContext.addMessage("addClaimForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Claim already exist!", null));
				return null;
			}
			claimDAORemote.createFromNewClaimDTO(newClaimDTO);
			newClaimDTO = new NewClaimDTO();
			return linksBean.getADMIN_CLAIMS_LINK();
		}catch(Exception e) {
			facesContext.addMessage("addClaimForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! Please try again!", null));
			return null;
		}
	}
	
	public void deleteClaim(int claimId) {
		claimDAORemote.delete(claimId);
	}
}
