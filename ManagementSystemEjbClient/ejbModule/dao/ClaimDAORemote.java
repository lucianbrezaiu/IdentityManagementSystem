package dao;

import java.util.List;

import javax.ejb.Remote;
import dto.ClaimDTO;

@Remote
public interface ClaimDAORemote extends GenericDAO<ClaimDTO>{

	List<ClaimDTO> findAllForIdentity(int identityId);
	
}
