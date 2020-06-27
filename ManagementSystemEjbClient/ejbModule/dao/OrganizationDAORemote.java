package dao;

import javax.ejb.Remote;
import dto.OrganizationDTO;

@Remote
public interface OrganizationDAORemote extends GenericDAO<OrganizationDTO> {
	
	OrganizationDTO findByName(String name);

	OrganizationDTO findByCui(String name);
}
