package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.RoleDAORemote;
import dto.RoleDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class RolesBean {

	@EJB
	private RoleDAORemote roleDAORemote;

	public RolesBean() {
		
	}

	public List<RoleDTO> getRoles(){
		return roleDAORemote.findAll();
	}
	
}
