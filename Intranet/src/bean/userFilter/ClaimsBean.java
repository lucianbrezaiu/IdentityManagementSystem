package bean.userFilter;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.ClaimDAORemote;
import dto.ClaimDTO;
import dto.IdentityDTO;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class ClaimsBean {

	@EJB
	private ClaimDAORemote claimDAORemote;
	private UserBean userBean;
	
	public ClaimsBean() {
		userBean = new UserBean();
	}
	
	public List<ClaimDTO> getClaims(){
		IdentityDTO identity = userBean.getAuthenticatedIdentity();
		return claimDAORemote.findAllForIdentity(identity.getId());
	}
}
