package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LinksBean;
import dao.OrganizationDAORemote;
import dto.OrganizationDTO;
import dto.RoleDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class OrganizationsBean {

	@EJB
	private OrganizationDAORemote organizationDAORemote;
	private OrganizationDTO organizationDTO;
	private LinksBean linksBean;
	
	public OrganizationsBean() {
		organizationDTO = new OrganizationDTO();
		linksBean = new LinksBean();
	}
		
	public List<OrganizationDTO> getOrganizations(){
		return organizationDAORemote.findAll();
	}

	public OrganizationDTO getOrganizationDTO() {
		return organizationDTO;
	}

	public void setOrganizationDTO(OrganizationDTO organizationDTO) {
		this.organizationDTO = organizationDTO;
	}

	public LinksBean getLinksBean() {
		return linksBean;
	}

	public void setLinksBean(LinksBean linksBean) {
		this.linksBean = linksBean;
	}
	
	public String addOrganization() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			OrganizationDTO organization= organizationDAORemote.findByName(organizationDTO.getName().trim());
			if(organization != null) {
				facesContext.addMessage("addOrganizationForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Organization already exist!", null));
				return null;
			}
			organization= organizationDAORemote.findByCui(organizationDTO.getCui().trim());
			if(organization != null) {
				facesContext.addMessage("addOrganizationForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cui already assigned to a organization!", null));
				return null;
			}
			
			organizationDAORemote.create(organizationDTO);
			organizationDTO = new OrganizationDTO();
			return linksBean.getADMIN_ORGANIZATIONS_LINK();
		}catch(Exception e) {
			facesContext.addMessage("addOrganizationForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! Please try again!", null));
			return null;
		}
	}
	
}
