package bean.adminFilter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import dao.ResourceDAORemote;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class ResourcesBean {
	
	@EJB
	private ResourceDAORemote resourceDAORemote;

	public ResourcesBean() {
		
	}

	public ResourceDAORemote getResourceDAORemote() {
		return resourceDAORemote;
	}

	public void setResourceDAORemote(ResourceDAORemote resourceDAORemote) {
		this.resourceDAORemote = resourceDAORemote;
	}

	
}
