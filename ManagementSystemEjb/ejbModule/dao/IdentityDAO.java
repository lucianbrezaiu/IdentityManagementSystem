package dao;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import util.*;
import dto.LoginDTO;
import model.Identity;
import dto.IdentityDTO;
import exception.LoginException;


@Stateless
@LocalBean
public class IdentityDAO implements IdentityDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO = new EntityToDTO();;
	private DTOToEntity DTOToEntity = new DTOToEntity();
	
	public IdentityDAO() {
		
	}
	
	@Override
	public IdentityDTO findById(int id) {
		Identity identity = entityManager.find(Identity.class, id);
		IdentityDTO userDTO = entityToDTO.convertIdentity(identity);
		return userDTO;
	}

	@Override
	public List<IdentityDTO> findAll() {
		Query query = entityManager.createQuery("SELECT identity FROM Identity identity");
		@SuppressWarnings("unchecked")
		List<Identity> identities = query.getResultList();
		List<IdentityDTO> dtoUsers = new ArrayList<>();
		for (Identity identity : identities) {
			dtoUsers.add(entityToDTO.convertIdentity(identity));
		}
		return dtoUsers;
	}

	@Override
	public IdentityDTO create(IdentityDTO identityDTO) {
		Identity identity = DTOToEntity.convertIdentity(identityDTO);
		entityManager.persist(identity);
		entityManager.flush();
		identityDTO.setId(identity.getIdentityId());
		return identityDTO;
	}

	@Override
	public IdentityDTO update(IdentityDTO identityDTO) {
		Identity identity = DTOToEntity.convertIdentity(identityDTO);
		identity.setIdentityId(identityDTO.getId());
		identity = entityManager.merge(identity);
		return identityDTO;
	}

	@Override
	public void delete(int id) {
		Identity identity = entityManager.find(Identity.class, id);
		entityManager.remove(identity);
	}

	@Override
	public IdentityDTO loginIdentity(LoginDTO loginDTO) throws LoginException {
		LOGGER.log(Level.INFO, String.format(
				"Trying to login for %s with password %s.",
				loginDTO.getUsername(),
				loginDTO.getPassword()
				));
		
		Identity identity = null;
		try {
			identity = entityManager.createNamedQuery("findIdentityByUsername", Identity.class)
					.setParameter("username", loginDTO.getUsername()).getSingleResult();
		} catch (NoResultException e) {
			throw new LoginException();
		}
		if (!loginDTO.getPassword().equals(identity.getPassword())) {
			throw new LoginException();
		}

		IdentityDTO userDTO = entityToDTO.convertIdentity(identity);
		return userDTO;
	}

}
