package dao.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.IdentityDAO;
import dto.ClaimDTO;
import model.Identity;
import model.Identityroleresource;
import util.DTOToEntity;
import util.EntityToDTO;
import util.ResourceEnum;
import util.RoleEnum;

@Stateless
@LocalBean
public class IntranetDAO implements IntranetDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO;
	
	public IntranetDAO() {
		entityToDTO = new EntityToDTO();
	}
	
	@Override
	public List<ClaimDTO> getRolesForAuthenticatedUser(int identityId){
		
		Query query =  entityManager.createNamedQuery("Identityroleresource.findAll", Identityroleresource.class);
		@SuppressWarnings("unchecked")
		List<Identityroleresource> claims = query.getResultList();
		List<ClaimDTO> claimsDTO = new ArrayList<>();
		for (Identityroleresource claim : claims) {
			int dbIdentityId = claim.getIdentity().getIdentityId();
			String resourceName = claim.getResource().getResourceName();
			if(dbIdentityId==identityId && resourceName.equals(ResourceEnum.Intranet.name())) {
				claimsDTO.add(entityToDTO.convertClaim(claim));
			}
		}
		return claimsDTO;
	}
}
