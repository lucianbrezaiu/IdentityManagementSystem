package dto;

public class OrganizationDTO {

	private int id;
	private String name;
	private String cui;
	
	public OrganizationDTO() {
		super();
	}
	
	public OrganizationDTO(String name, String cui) {
		super();
		this.name = name;
		this.cui = cui;
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
	public String getCui() {
		return cui;
	}
	public void setCui(String cui) {
		this.cui = cui;
	}

	@Override
	public String toString() {
		return "OrganizationDTO [id=" + id + ", name=" + name + ", cui=" + cui + "]";
	}

}
