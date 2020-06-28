package util;

import dto.*;
import model.*;

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
	
	public Right convertRight(RightDTO rightDTO) {
		Right right = new Right(rightDTO.getName(),rightDTO.getDescription());
		return right;
	}
}
