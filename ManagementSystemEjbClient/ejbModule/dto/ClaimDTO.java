package dto;

public class ClaimDTO {

	private int id;
	private String identityEmail;
	private String roleName;
	private String roleDescription;
	private String resourceName;
	
	public ClaimDTO() {
		
	}

	public ClaimDTO(String identityEmail, String roleName, String roleDescription, String resourceName) {
		super();
		this.identityEmail = identityEmail;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.resourceName = resourceName;
	}

	public String getIdentityEmail() {
		return identityEmail;
	}

	public void setIdentityEmail(String identityEmail) {
		this.identityEmail = identityEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	@Override
	public String toString() {
		return "ClaimDTO [id=" + id + ", roleName=" + roleName + ", roleDescription=" + roleDescription
				+ ", resourceName=" + resourceName + "]";
	}

}
