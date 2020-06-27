package dao;

import java.util.List;
import java.util.Random;
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
import dto.RegisterDTO;
import dto.RoleDTO;
import model.Identity;
import model.Identityroleresource;
import model.Resource;
import model.Role;
import dto.IdentityDTO;
import exception.LoginException;
import exception.RegisterException;


@Stateless
@LocalBean
public class IdentityDAO implements IdentityDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO;
	private DTOToEntity DTOToEntity;
	
	public IdentityDAO() {
		entityToDTO = new EntityToDTO();
		DTOToEntity = new DTOToEntity();
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
				"Trying to login %s with password %s.",
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
	
	@Override
	public void registerIdentity(RegisterDTO registerDTO) throws RegisterException{
		LOGGER.log(Level.INFO, String.format(
				"Trying to register %s with password %s.",
				registerDTO.getEmail(),
				registerDTO.getPassword()
				));		
		try {
			String username = generateUsernameForEmail(registerDTO.getEmail());
			IdentityDTO identityDTO = new IdentityDTO(username,registerDTO.getPassword());
			identityDTO.setEmail(registerDTO.getEmail());
			identityDTO.setFirstname(registerDTO.getFirstname());
			identityDTO.setLastname(registerDTO.getLastname());
			create(identityDTO);
			addMemberRoleInIdentitySystem(username);
			
		} catch (Exception e) {
			throw new RegisterException();
		}
	}
	
	private String generateUsernameForEmail(String email) {
		int min = 100;
		int max = 999;
		Integer random = new Random().nextInt((max - min) + 1) + min;
		String username = email.split("@")[0];
		username += String.format("#%s",random.toString());
		return username;
	}
	
	public boolean hasAdminRoleInIdentitySystem(String username) {
		try {
			Identity identity = entityManager.createNamedQuery("findIdentityByUsername", Identity.class)
					.setParameter("username", username).getSingleResult();
			List<Identityroleresource> claims = identity.getIdentityroleresources();
			for (Identityroleresource claim : claims) {
				
				String roleName = claim.getRole().getRoleName().trim();
				String resourceName = claim.getResource().getResourceName().trim();
				if(roleName.equals("idp_admin") && resourceName.equals("Identity Management System")) {
					return true;
				}
			}
			return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void addMemberRoleInIdentitySystem(String username) {
		Identity identity = entityManager.createNamedQuery("findIdentityByUsername", Identity.class)
				.setParameter("username", username).getSingleResult();
		
		Role role = entityManager.createNamedQuery("findRoleByName", Role.class)
				.setParameter("name", "idp_member").getSingleResult();
	
		Resource resource = entityManager.createNamedQuery("findResourceByName", Resource.class)
				.setParameter("name", "Identity Management System").getSingleResult();
		
		Identityroleresource claim = new Identityroleresource(identity,role,resource);
		
		entityManager.persist(claim);
		entityManager.flush();
		LOGGER.log(Level.INFO, String.format(
				"The user %s was successfully registered and received the role %s in %s.",
				username,
				role.getRoleName(),
				resource.getResourceName()
				));	
	}
}
