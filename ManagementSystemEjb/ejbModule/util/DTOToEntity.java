package util;

import dto.IdentityDTO;
import dto.OrganizationDTO;
import model.Identity;
import model.Organization;

public class DTOToEntity {

	public Identity convertIdentity(IdentityDTO identityDTO) {
		Identity identity = new Identity(identityDTO.getUsername(), identityDTO.getPassword());
		identity.setIdentityId(identityDTO.getId());
		identity.setEmail(identityDTO.getEmail());
		identity.setFirstname(identityDTO.getFirstname());
		identity.setLastname(identityDTO.getLastname());
		return identity;
	}
	
	public Organization convertIdentity(OrganizationDTO organizationDTO) {
		Organization organization = new Organization(organizationDTO.getName(), organizationDTO.getCui());
		
		return organization;
	}
	

}
