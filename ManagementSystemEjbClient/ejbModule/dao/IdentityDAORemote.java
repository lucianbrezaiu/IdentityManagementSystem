package dao;

import dto.*;
import javax.ejb.Remote;
import exception.LoginException;
import exception.RegisterException;


@Remote
public interface IdentityDAORemote extends GenericDAO<IdentityDTO>{

	IdentityDTO loginIdentity(LoginDTO loginDTO) throws LoginException;
	
	void registerIdentity(RegisterDTO registerDTO) throws RegisterException;
	
	boolean hasAdminRoleInIdentitySystem(String username);
	
	void addMemberRoleInIdentitySystem(String username);
	
}
