package dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {

	private int id;
	private String name;
	private String description;
	private List<RightDTO> dtoRights;
	
	public RoleDTO() {
		super();
		dtoRights = new ArrayList<RightDTO>();
	}
	
	public RoleDTO(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		dtoRights = new ArrayList<RightDTO>();
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
	
	public List<RightDTO> getDtoRights() {
		return dtoRights;
	}

	public void setDtoRights(List<RightDTO> dtoRights) {
		this.dtoRights = dtoRights;
	}

	@Override
	public String toString() {
		return "RoleDTO [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
