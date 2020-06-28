package dao.resources;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.IdentityDAO;
import model.Identityroleresource;
import util.ResourceEnum;
import util.RoleEnum;

@Stateless
@LocalBean
public class IntranetDAO implements IntranetDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public IntranetDAO() {
	}

	public boolean hasRoleInIntranet(int identityId, RoleEnum role) {
		try {
			List<Identityroleresource> claims = entityManager
					.createNamedQuery("getClaimsForIdentity", Identityroleresource.class)
					.setParameter("id", identityId)
					.getResultList();
			
			for (Identityroleresource claim : claims) {
				String dbRole = claim.getRole().getRoleName().trim();
				String resourceName = claim.getResource().getResourceName().trim();
				if(dbRole.equals(role.name()) && resourceName.equals(ResourceEnum.Intranet.name())) {
					return true;
				}
			}
			return false;
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
