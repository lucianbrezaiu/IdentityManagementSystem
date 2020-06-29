package dto;

public class NewClaimDTO {

	private int identityId;
	private int resourceId;
	private int roleId;
	
	public NewClaimDTO() {
		
	}

	public NewClaimDTO(int identityId, int resourceId, int roleId) {
		super();
		this.identityId = identityId;
		this.resourceId = resourceId;
		this.roleId = roleId;
	}

	public int getIdentityId() {
		return identityId;
	}

	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "NewClaimDTO [identityId=" + identityId + ", resourceId=" + resourceId + ", roleId=" + roleId + "]";
	}
	
	
	
}
