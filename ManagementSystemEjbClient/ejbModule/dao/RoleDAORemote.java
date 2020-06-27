package dao;

import javax.ejb.Remote;
import dto.RoleDTO;

@Remote
public interface RoleDAORemote extends GenericDAO<RoleDTO>  {

	RoleDTO findByName(String name);
	
}
