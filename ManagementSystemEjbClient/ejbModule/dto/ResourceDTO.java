package dto;

public class ResourceDTO {

	private int id;
	private String name;

	public ResourceDTO() {
		super();
	}
	
	public ResourceDTO(String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "ResourceDTO [name=" + name + "]";
	}

	
	
	
}
