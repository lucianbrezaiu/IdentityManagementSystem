package util;

import dto.IdentityDTO;
import dto.OrganizationDTO;
import model.Identity;
import model.Organization;

public class EntityToDTO {

	public IdentityDTO convertIdentity(Identity identity) {
		IdentityDTO identityDTO = new IdentityDTO(identity.getUsername(), identity.getPassword());

		identityDTO.setId(identity.getIdentityId());
		identityDTO.setEmail(identity.getEmail());
		identityDTO.setFirstname(identity.getFirstname());
		identityDTO.setLastname(identity.getLastname());
		return identityDTO;
	}
	
	public OrganizationDTO convertIdentity(Organization organization) {
		OrganizationDTO organizationDTO = new OrganizationDTO(organization.getOrganizationName(), organization.getCui());

		return organizationDTO;

	}
	
}
