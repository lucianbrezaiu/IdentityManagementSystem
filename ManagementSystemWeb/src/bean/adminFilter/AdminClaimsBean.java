package bean.adminFilter;

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
public class AdminClaimsBean {

	@EJB
	private ClaimDAORemote claimDAORemote;
	
	
	public AdminClaimsBean() {
		
	}
	
	public List<ClaimDTO> getClaims(){
		
		return claimDAORemote.findAll();
	}
	
	public void deleteClaim(int claimId) {
		claimDAORemote.delete(claimId);
	}
}
