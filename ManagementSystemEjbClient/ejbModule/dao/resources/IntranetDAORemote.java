package dao.resources;

import javax.ejb.Remote;

import util.RoleEnum;

@Remote
public interface IntranetDAORemote {

	boolean hasRoleInIntranet(int identityId, RoleEnum role);
	
}
