package dao;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import dto.UserDTO;

@Stateless
@LocalBean
public class UserDAO implements UserDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	public UserDAO() {

	}
	
	@Override
	public UserDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO create(UserDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDTO update(UserDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
