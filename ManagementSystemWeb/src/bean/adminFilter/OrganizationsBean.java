package bean.adminFilter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.OrganizationDAORemote;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class OrganizationsBean {

	@EJB
	private OrganizationDAORemote organizationDAORemote;
	
	public OrganizationsBean() {
			
	}
		
	public OrganizationDAORemote getOrganizationDAORemote() {
		return organizationDAORemote;
	}

	public void setOrganizationDAORemote(OrganizationDAORemote organizationDAORemote) {
		this.organizationDAORemote = organizationDAORemote;
	}
}
