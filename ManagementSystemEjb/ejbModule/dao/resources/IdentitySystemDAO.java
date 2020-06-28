package dao.resources;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.IdentityDAO;
import dao.resources.IdentitySystemDAORemote;
import model.Identity;
import model.Identityroleresource;
import model.Resource;
import model.Role;
import util.DTOToEntity;
import util.EntityToDTO;
import util.ResourceEnum;
import util.RoleEnum;

@Stateless
@LocalBean
public class IdentitySystemDAO implements IdentitySystemDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
		
	@PersistenceContext
	private EntityManager entityManager;
	
	public IdentitySystemDAO() {
	}
	
	public boolean hasRoleInIdentitySystem(int identityId, RoleEnum role) {
		try {
			List<Identityroleresource> claims = entityManager
					.createNamedQuery("getClaimsForIdentity", Identityroleresource.class)
					.setParameter("id", identityId)
					.getResultList();
			
			for (Identityroleresource claim : claims) {
				String dbRole = claim.getRole().getRoleName().trim();
				String resourceName = claim.getResource().getResourceName().trim();
				if(dbRole.equals(role.name()) && resourceName.equals(ResourceEnum.IdentityManagementSystem.name())) {
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
				.setParameter("name", RoleEnum.member.name()).getSingleResult();
	
		Resource resource = entityManager.createNamedQuery("findResourceByName", Resource.class)
				.setParameter("name", ResourceEnum.IdentityManagementSystem.name()).getSingleResult();
		
		Identityroleresource claim = new Identityroleresource(identity,role,resource);
		
		entityManager.persist(claim);
		entityManager.flush();
		LOGGER.log(Level.INFO, String.format(
				"The user %s has been successfully registered and received the role %s in %s.",
				username,
				role.getRoleName(),
				resource.getResourceName()
				));	
	}

}
