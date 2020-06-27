package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.OrganizationDAORemote;
import dto.OrganizationDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class OrganizationsBean {

	@EJB
	private OrganizationDAORemote organizationDAORemote;
	
	public OrganizationsBean() {
			
	}
		
	public List<OrganizationDTO> getOrganizations(){
		return organizationDAORemote.findAll();
	}
}
