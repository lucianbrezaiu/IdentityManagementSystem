package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.RoleDTO;
import model.Role;
import util.DTOToEntity;
import util.EntityToDTO;

@Stateless
@LocalBean
public class RoleDAO implements RoleDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO;
	private DTOToEntity DTOToEntity;
	
	public RoleDAO() {
		entityToDTO = new EntityToDTO();
		DTOToEntity = new DTOToEntity();
	}
	
	@Override
	public RoleDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoleDTO> findAll() {
		Query query = entityManager.createQuery("SELECT role FROM Role role");
		@SuppressWarnings("unchecked")
		List<Role> roles = query.getResultList();
		List<RoleDTO> rolesDTO = new ArrayList<>();
		for (Role resource : roles) {
			rolesDTO.add(entityToDTO.convertRole(resource));
		}
		return rolesDTO;
	}

	@Override
	public RoleDTO create(RoleDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleDTO update(RoleDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
