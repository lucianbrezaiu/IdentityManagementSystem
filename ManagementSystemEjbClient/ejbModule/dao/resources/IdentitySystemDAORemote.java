package dao.resources;

import javax.ejb.Remote;

import util.RoleEnum;

@Remote
public interface IdentitySystemDAORemote {

	boolean hasRoleInIdentitySystem(int identityId, RoleEnum role);
	
	void addMemberRoleInIdentitySystem(String username);
	
}
