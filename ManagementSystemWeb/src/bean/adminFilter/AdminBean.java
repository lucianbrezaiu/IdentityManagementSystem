package bean.adminFilter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.IdentityDAORemote;


@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class AdminBean {

	@EJB
	private IdentityDAORemote identityDAORemote;
	
	public AdminBean() {
		
	}

	public IdentityDAORemote getIdentityDAORemote() {
		return identityDAORemote;
	}

	public void setIdentityDAORemote(IdentityDAORemote identityDAORemote) {
		this.identityDAORemote = identityDAORemote;
	}
}
