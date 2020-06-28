package dao;

import javax.ejb.Remote;

import dto.RightDTO;

@Remote
public interface RightDAORemote extends GenericDAO<RightDTO>  {

	RightDTO findByName(String name);
	
}
