package util;

import dto.IdentityDTO;
import model.Identity;

public class DTOToEntity {

	public Identity convertIdentity(IdentityDTO identityDTO) {
		Identity user = new Identity(identityDTO.getUsername(), identityDTO.getPassword());

		return user;
	}

}
