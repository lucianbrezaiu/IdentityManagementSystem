package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.LinksBean;
import dao.ResourceDAORemote;
import dto.OrganizationDTO;
import dto.ResourceDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class ResourcesBean {
	
	@EJB
	private ResourceDAORemote resourceDAORemote;
	private ResourceDTO resourceDTO;
	private LinksBean linksBean;
	
	public ResourcesBean() {
		resourceDTO = new ResourceDTO();
		linksBean = new LinksBean();
	}

	public List<ResourceDTO> getResources(){
		return resourceDAORemote.findAll();
	}

	public ResourceDTO getResourceDTO() {
		return resourceDTO;
	}

	public void setResourceDTO(ResourceDTO resourceDTO) {
		this.resourceDTO = resourceDTO;
	}

	public LinksBean getLinksBean() {
		return linksBean;
	}

	public void setLinksBean(LinksBean linksBean) {
		this.linksBean = linksBean;
	}
	
	public String addResource() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			ResourceDTO resource= resourceDAORemote.findByName(resourceDTO.getName().trim());
			if(resource != null) {
				facesContext.addMessage("addResourceForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Resource already exist!", null));
				return null;
			}
			
			resourceDAORemote.create(resourceDTO);
			resourceDTO = new ResourceDTO();
			return linksBean.getADMIN_RESOURCES_LINK();
		}catch(Exception e) {
			facesContext.addMessage("addResourceForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error! Please try again!", null));
			return null;
		}
	}
	
}
