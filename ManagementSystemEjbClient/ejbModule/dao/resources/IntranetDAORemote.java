package dao.resources;

import java.util.List;

import javax.ejb.Remote;

import dto.ClaimDTO;
import util.RoleEnum;

@Remote
public interface IntranetDAORemote {

	List<ClaimDTO> getRolesForAuthenticatedUser(int identityId);
	
}
