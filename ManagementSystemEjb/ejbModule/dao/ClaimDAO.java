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
import model.Identity;
import model.Identityroleresource;
import util.DTOToEntity;
import util.EntityToDTO;

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
		Query query = entityManager.createQuery("SELECT claim FROM Identityroleresource claim");
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
}
