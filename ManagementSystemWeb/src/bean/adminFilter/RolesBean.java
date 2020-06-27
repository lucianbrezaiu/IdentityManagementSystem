package bean.adminFilter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.RoleDAORemote;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class RolesBean {

	@EJB
	private RoleDAORemote roleDAORemote;

	public RolesBean() {
		
	}

	public RoleDAORemote getRoleDAORemote() {
		return roleDAORemote;
	}

	public void setRoleDAORemote(RoleDAORemote roleDAORemote) {
		this.roleDAORemote = roleDAORemote;
	}
	
	
	
}
