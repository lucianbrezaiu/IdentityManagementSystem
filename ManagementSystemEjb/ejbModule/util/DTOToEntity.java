package util;

import dto.IdentityDTO;
import model.Identity;

public class DTOToEntity {

	public Identity convertIdentity(IdentityDTO identityDTO) {
		Identity identity = new Identity(identityDTO.getUsername(), identityDTO.getPassword());
		identity.setIdentityId(identityDTO.getId());
		identity.setEmail(identityDTO.getEmail());
		identity.setFirstname(identityDTO.getFirstname());
		identity.setLastname(identityDTO.getLastname());
		return identity;
	}

}
