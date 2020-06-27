package dao;

import javax.ejb.Remote;
import dto.OrganizationDTO;
import dto.RoleDTO;

@Remote
public interface OrganizationDAORemote extends GenericDAO<OrganizationDTO> {
	
	OrganizationDTO findByName(String name);

	OrganizationDTO findByCui(String name);
}
