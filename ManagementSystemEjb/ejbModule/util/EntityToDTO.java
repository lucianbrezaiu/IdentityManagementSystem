package util;

import dto.IdentityDTO;
import model.Identity;

public class EntityToDTO {

	public IdentityDTO convertIdentity(Identity identity) {
		IdentityDTO globalUserDTO = new IdentityDTO(identity.getUsername(), identity.getPassword());

		globalUserDTO.setId(identity.getIdentityId());
		return globalUserDTO;

	}
	
}
