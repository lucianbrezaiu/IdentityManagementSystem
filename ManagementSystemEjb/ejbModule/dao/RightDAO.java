package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.IdentityDTO;
import dto.RightDTO;
import dto.RoleDTO;
import model.Identity;
import model.Right;
import model.Role;
import util.DTOToEntity;
import util.EntityToDTO;

@Stateless
@LocalBean
public class RightDAO implements RightDAORemote {


	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO;
	private DTOToEntity DTOToEntity;
	
	public RightDAO() {
		entityToDTO = new EntityToDTO();
		DTOToEntity = new DTOToEntity();
	}
	
	@Override
	public RightDTO findById(int id) {
		Right Right = entityManager.createNamedQuery("findRightById", Right.class)
				.setParameter("id", id).getSingleResult();
		RightDTO rightDTO = entityToDTO.convertRight(Right);
		return rightDTO;
	}

	@Override
	public List<RightDTO> findAll() {
		Query query = entityManager.createNamedQuery("Right.findAll", Right.class);
		@SuppressWarnings("unchecked")
		List<Right> rights = query.getResultList();
		List<RightDTO> rightsDTO = new ArrayList<>();
		for (Right right : rights) {
			rightsDTO.add(entityToDTO.convertRight(right));
		}
		return rightsDTO;
	}

	@Override
	public RightDTO create(RightDTO rightDTO) {
		Right right = DTOToEntity.convertRight(rightDTO);
		entityManager.persist(right);
		entityManager.flush();
		rightDTO.setId(right.getRightId());
		return rightDTO;
	}

	@Override
	public RightDTO update(RightDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RightDTO findByName(String name) {
		try {
			Right right = entityManager.createNamedQuery("findRightByName", Right.class)
					.setParameter("name", name).getSingleResult();
			RightDTO rightDTO = entityToDTO.convertRight(right);
			return rightDTO;
		}
		catch(Exception e) {
			return null;
		}
	}

}
