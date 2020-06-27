package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.ResourceDAORemote;
import dto.ResourceDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class ResourcesBean {
	
	@EJB
	private ResourceDAORemote resourceDAORemote;

	public ResourcesBean() {
		
	}

	public List<ResourceDTO> getResources(){
		return resourceDAORemote.findAll();
	}
}
