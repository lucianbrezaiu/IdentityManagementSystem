package util;

import dto.*;
import model.*;

public class EntityToDTO {

	public IdentityDTO convertIdentity(Identity identity) {
		IdentityDTO identityDTO = new IdentityDTO(identity.getUsername(), identity.getPassword());

		identityDTO.setId(identity.getIdentityId());
		identityDTO.setEmail(identity.getEmail());
		identityDTO.setFirstname(identity.getFirstname());
		identityDTO.setLastname(identity.getLastname());
		identityDTO.setOrganizationId(identity.getOrganization().getOrganizationId());
		return identityDTO;
	}

	public OrganizationDTO convertOrganization(Organization organization) {
		OrganizationDTO organizationDTO = new OrganizationDTO(organization.getOrganizationName(),
				organization.getCui());
		organizationDTO.setId(organization.getOrganizationId());
		return organizationDTO;
	}

	public ResourceDTO convertResource(Resource resource) {
		ResourceDTO resourceDTO = new ResourceDTO(resource.getResourceName());
		return resourceDTO;
	}

	public RoleDTO convertRole(Role role) {
		RoleDTO roleDTO = new RoleDTO(role.getRoleName(), role.getRoleDescription());
		roleDTO.setId(role.getRoleId());
		return roleDTO;
	}

	public RightDTO convertRight(Right right) {
		RightDTO rightDTO = new RightDTO(right.getRightName(), right.getRightDescription());
		rightDTO.setId(right.getRightId());
		return rightDTO;
	}

	public ClaimDTO convertClaim(Identityroleresource claim) {

		Role role = claim.getRole();
		Resource resource = claim.getResource();

		ClaimDTO claimDTO = new ClaimDTO(role.getRoleName(), role.getRoleDescription(), resource.getResourceName());
		claimDTO.setId(claim.getId());
		return claimDTO;
	}
}
