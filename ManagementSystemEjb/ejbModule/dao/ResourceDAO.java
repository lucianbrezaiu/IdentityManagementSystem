package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.ResourceDTO;
import model.Resource;
import util.DTOToEntity;
import util.EntityToDTO;

@Stateless
@LocalBean
public class ResourceDAO implements ResourceDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO;
	private DTOToEntity DTOToEntity;
	
	public ResourceDAO() {
		entityToDTO = new EntityToDTO();
		DTOToEntity = new DTOToEntity();
	}
	
	@Override
	public ResourceDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceDTO> findAll() {
		Query query = entityManager.createQuery("SELECT resource FROM Resource resource");
		@SuppressWarnings("unchecked")
		List<Resource> resources = query.getResultList();
		List<ResourceDTO> resourcesDTO = new ArrayList<>();
		for (Resource resource : resources) {
			resourcesDTO.add(entityToDTO.convertResource(resource));
		}
		return resourcesDTO;
	}

	@Override
	public ResourceDTO create(ResourceDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceDTO update(ResourceDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
