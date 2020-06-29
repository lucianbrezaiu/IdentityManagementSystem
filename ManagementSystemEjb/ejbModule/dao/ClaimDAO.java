package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dto.ClaimDTO;
import dto.NewClaimDTO;
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
public class ClaimDAO implements ClaimDAORemote {

static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO;
	private DTOToEntity DTOToEntity;
	
	public ClaimDAO() {
		entityToDTO = new EntityToDTO();
		DTOToEntity = new DTOToEntity();
	}
	
	@Override
	public ClaimDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClaimDTO> findAll() {
		Query query =  entityManager.createNamedQuery("Identityroleresource.findAll", Identityroleresource.class);
		@SuppressWarnings("unchecked")
		List<Identityroleresource> claims = query.getResultList();
		List<ClaimDTO> claimsDTO = new ArrayList<>();
		for (Identityroleresource claim : claims) {
			claimsDTO.add(entityToDTO.convertClaim(claim));
		}
		return claimsDTO;
	}

	@Override
	public List<ClaimDTO> findAllForIdentity(int identityId) {
		List<Identityroleresource> claims = entityManager
				.createNamedQuery("getClaimsForIdentity", Identityroleresource.class)
				.setParameter("id", identityId)
				.getResultList();
		
		List<ClaimDTO> claimsDTO = new ArrayList<>();
		for (Identityroleresource claim : claims) {
			claimsDTO.add(entityToDTO.convertClaim(claim));
		}
		return claimsDTO;
	}
	
	@Override
	public ClaimDTO create(ClaimDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClaimDTO update(ClaimDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		Identityroleresource claim = entityManager.find(Identityroleresource.class, id);
		entityManager.remove(claim);
	}
	
	@Override
	public void createFromNewClaimDTO(NewClaimDTO newClaimDTO) {
		Identity identity = entityManager.createNamedQuery("findIdentityById", Identity.class)
				.setParameter("id", newClaimDTO.getIdentityId()).getSingleResult();

		Resource resource = entityManager.createNamedQuery("findResourceById", Resource.class)
				.setParameter("id", newClaimDTO.getResourceId()).getSingleResult();
		
		Role role = entityManager.createNamedQuery("findRoleById", Role.class)
				.setParameter("id", newClaimDTO.getRoleId()).getSingleResult();
		
		Identityroleresource claim = new Identityroleresource(identity,role,resource);
		entityManager.persist(claim);
		entityManager.flush();
	}
	
	@Override
	public boolean exist(int identityId, int resourceId, int roleId) {
		Query query =  entityManager.createNamedQuery("Identityroleresource.findAll", Identityroleresource.class);
		@SuppressWarnings("unchecked")
		List<Identityroleresource> claims = query.getResultList();
		
		for (Identityroleresource claim : claims) {
			int dbIdentityId = claim.getIdentity().getIdentityId();
			int dbResourceId = claim.getResource().getResourceId();
			int dbRoleId = claim.getRole().getRoleId();
			if(dbIdentityId==identityId && dbResourceId==resourceId && dbRoleId==roleId) {
				return true;
			}
		}
		return false;
	}
}
