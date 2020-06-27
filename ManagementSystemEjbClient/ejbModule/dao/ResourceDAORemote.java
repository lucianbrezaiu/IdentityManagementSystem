package dao;

import javax.ejb.Remote;

import dto.ResourceDTO;

@Remote
public interface ResourceDAORemote extends GenericDAO<ResourceDTO> {

	ResourceDTO findByName(String name);
	
}
