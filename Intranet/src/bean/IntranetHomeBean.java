package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.OrganizationDAORemote;
import dao.resources.IntranetDAORemote;
import dto.ClaimDTO;
import dto.IdentityDTO;
import dto.OrganizationDTO;
import dto.RightDTO;
import dto.RoleDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class IntranetHomeBean {

	private IdentityDTO authenticatedIdentity;
	
	@EJB
	private IntranetDAORemote intranetDAORemote;
	
	@EJB
	private OrganizationDAORemote organizationDAORemote;
	
	public IntranetHomeBean() {
		FacesContext facesContext = FacesContext.getCurrentInstance();

		IntranetLoginBean loginBean = (IntranetLoginBean) facesContext.getExternalContext().getSessionMap().get("intranetLoginBean");
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
		if(authenticatedIdentity!=null) {
			return String.format("%s %s", authenticatedIdentity.getFirstname(), authenticatedIdentity.getLastname());
		}
		return "";
	}
	
	public String getCurrentOrganization() {
		int organizationId = authenticatedIdentity.getOrganizationId();
		OrganizationDTO organization = organizationDAORemote.findById(organizationId);
		return organization.getName();
	}
	
	public List<ClaimDTO> getCurrentClaims() {
		if(authenticatedIdentity!=null) {
			List<ClaimDTO> claims = intranetDAORemote.getRolesForAuthenticatedUser(authenticatedIdentity.getId());
			return claims;
		}
		return null;
	}
	
	public String rightsToString(List<RightDTO> rightsDTO) {
		if(rightsDTO.size()==0) {
			return "";
		}
		
		String str = "";
		for (RightDTO rightDTO : rightsDTO) {
			str += String.format("%s,", rightDTO.getName());
		}
		return str.substring(0, str.length() - 1);
	}

}
