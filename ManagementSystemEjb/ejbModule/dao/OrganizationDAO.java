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
import dto.OrganizationDTO;
import dto.RoleDTO;
import model.Identity;
import model.Organization;
import model.Role;
import util.DTOToEntity;
import util.EntityToDTO;

@Stateless
@LocalBean
public class OrganizationDAO implements OrganizationDAORemote {

	static final Logger LOGGER = Logger.getLogger(IdentityDAO.class.getName());
	
	@PersistenceContext
	private EntityManager entityManager;
	private EntityToDTO entityToDTO;
	private DTOToEntity DTOToEntity;
	
	public OrganizationDAO() {
		entityToDTO = new EntityToDTO();
		DTOToEntity = new DTOToEntity();
	}
	
	@Override
	public OrganizationDTO findById(int id) {
		Organization organization = entityManager.find(Organization.class, id);
		OrganizationDTO organizationDTO = entityToDTO.convertOrganization(organization);
		return organizationDTO;
	}

	@Override
	public List<OrganizationDTO> findAll() {
		Query query = entityManager.createQuery("SELECT organization FROM Organization organization");
		@SuppressWarnings("unchecked")
		List<Organization> organizations = query.getResultList();
		List<OrganizationDTO> organizationsDTO = new ArrayList<>();
		for (Organization identity : organizations) {
			organizationsDTO.add(entityToDTO.convertOrganization(identity));
		}
		return organizationsDTO;
	}

	@Override
	public OrganizationDTO create(OrganizationDTO organizationDTO) {
		Organization organization = DTOToEntity.convertOrganization(organizationDTO);
		entityManager.persist(organization);
		entityManager.flush();
		organizationDTO.setId(organization.getOrganizationId());
		return organizationDTO;
	}

	@Override
	public OrganizationDTO update(OrganizationDTO organizationDTO) {
		Organization organization = DTOToEntity.convertOrganization(organizationDTO);
		organization.setOrganizationId(organizationDTO.getId());
		organization = entityManager.merge(organization);
		return organizationDTO;
	}

	@Override
	public void delete(int id) {
		Organization organisation = entityManager.find(Organization.class, id);
		entityManager.remove(organisation);
	}
	
	@Override
	public OrganizationDTO findByName(String name) {
		try {
			Organization organization = entityManager.createNamedQuery("findOrganizationByName", Organization.class)
					.setParameter("name", name).getSingleResult();
			OrganizationDTO organizationDTO = entityToDTO.convertOrganization(organization);
			return organizationDTO;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public OrganizationDTO findByCui(String cui) {
		try {
			Organization organization = entityManager.createNamedQuery("findOrganizationByCUI", Organization.class)
					.setParameter("cui", cui).getSingleResult();
			OrganizationDTO organizationDTO = entityToDTO.convertOrganization(organization);
			return organizationDTO;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@Override
	public OrganizationDTO findByIdentity(int identityId) {
		try {
			Identity identity = entityManager.find(Identity.class, identityId);
			Organization organization = identity.getOrganization();
			return entityToDTO.convertOrganization(organization);
		}
		catch(Exception e) {
			return null;
		}
	}
}
