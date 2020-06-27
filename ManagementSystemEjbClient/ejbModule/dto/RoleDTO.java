package dto;

public class RoleDTO {

	private int id;
	private String name;
	private String description;
	
	public RoleDTO() {
		super();
	}
	
	public RoleDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
