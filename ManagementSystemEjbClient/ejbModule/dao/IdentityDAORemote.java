package dao;

import dto.*;
import javax.ejb.Remote;
import exception.LoginException;

@Remote
public interface IdentityDAORemote extends GenericDAO<IdentityDTO>{

	IdentityDTO loginIdentity(LoginDTO loginDTO) throws LoginException;
	
}
