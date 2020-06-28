package dao;

import dto.*;
import javax.ejb.Remote;
import exception.LoginException;
import exception.RegisterException;
import util.IdpRole;

@Remote
public interface IdentityDAORemote extends GenericDAO<IdentityDTO>{

	IdentityDTO findByUsername(String username);
	
	IdentityDTO loginIdentity(LoginDTO loginDTO) throws LoginException;
	
	IdentityDTO registerIdentity(RegisterDTO registerDTO) throws RegisterException;
	
	boolean hasRoleInIdentitySystem(int identityId, IdpRole role);
	
	void addMemberRoleInIdentitySystem(String username);
	
}
