package bean.adminFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.IdentityDAORemote;
import dto.IdentityDTO;


@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class AdminBean {

	@EJB
	private IdentityDAORemote identityDAORemote;
	
	public AdminBean() {
		
	}

	public List<IdentityDTO> getIdentities() {
		return identityDAORemote.findAll();
	}
	
}