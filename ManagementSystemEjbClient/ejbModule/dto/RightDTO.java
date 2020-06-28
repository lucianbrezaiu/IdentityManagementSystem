package dto;

public class RightDTO {

	private int id;
	private String Name;
	private String Description;
	
	public RightDTO() {
		
	}
	
	public RightDTO(String name, String description) {
		super();
		Name = name;
		Description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "RightDTO [Name=" + Name + ", Description=" + Description + "]";
	}
	
}
