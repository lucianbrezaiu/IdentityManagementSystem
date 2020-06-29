package dao;

import java.util.List;

import javax.ejb.Remote;
import dto.ClaimDTO;
import dto.NewClaimDTO;

@Remote
public interface ClaimDAORemote extends GenericDAO<ClaimDTO>{

	List<ClaimDTO> findAllForIdentity(int identityId);
	
	boolean exist(int identityId, int resourceId,int roleId);
	
	void createFromNewClaimDTO(NewClaimDTO claim);
	
}
