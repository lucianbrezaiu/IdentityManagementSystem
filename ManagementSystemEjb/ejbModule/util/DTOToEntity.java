package util;

import dto.IdentityDTO;
import dto.OrganizationDTO;
import dto.ResourceDTO;
import dto.RoleDTO;
import model.Identity;
import model.Organization;
import model.Resource;
import model.Role;

public class DTOToEntity {

	public Identity convertIdentity(IdentityDTO identityDTO) {
		Identity identity = new Identity(identityDTO.getUsername(), identityDTO.getPassword());
		identity.setIdentityId(identityDTO.getId());
		identity.setEmail(identityDTO.getEmail());
		identity.setFirstname(identityDTO.getFirstname());
		identity.setLastname(identityDTO.getLastname());
		return identity;
	}
	
	public Organization convertOrganization(OrganizationDTO organizationDTO) {
		Organization organization = new Organization(organizationDTO.getName(), organizationDTO.getCui());
		
		return organization;
	}
	
	public Resource convertResource(ResourceDTO resourceDTO) {
		Resource resource = new Resource(resourceDTO.getName());
		return resource;
	}
	
	
	public Role convertRole(RoleDTO roleDTO) {
		Role role = new Role(roleDTO.getName(),roleDTO.getDescription());
		return role;
	}
}
