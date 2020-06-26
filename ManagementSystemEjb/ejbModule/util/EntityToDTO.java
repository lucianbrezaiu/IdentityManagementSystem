package util;

import dto.IdentityDTO;
import model.Identity;

public class EntityToDTO {

	public IdentityDTO convertIdentity(Identity identity) {
		IdentityDTO identityDTO = new IdentityDTO(identity.getUsername(), identity.getPassword());

		identityDTO.setId(identity.getIdentityId());
		identityDTO.setEmail(identity.getEmail());
		identityDTO.setFirstname(identity.getFirstname());
		identityDTO.setLastname(identity.getLastname());
		return identityDTO;

	}
	
}
