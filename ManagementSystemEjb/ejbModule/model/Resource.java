package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the resource database table.
 * 
 */
@Entity
@NamedQuery(name="Resource.findAll", query="SELECT r FROM Resource r")
@NamedQuery(name = "findResourceById", query = "SELECT r FROM Resource r WHERE r.resourceId = :id")
@NamedQuery(name = "findResourceByName", query = "SELECT r FROM Resource r WHERE r.resourceName = :name")
public class Resource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int resourceId;

	private String resourceName;

	//bi-directional many-to-one association to Identityroleresource
	@OneToMany(mappedBy="resource")
	private List<Identityroleresource> identityroleresources;

	public Resource() {
	}
	
	public Resource(String name) {
		this.resourceName = name;
	}

	public int getResourceId() {
		return this.resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public List<Identityroleresource> getIdentityroleresources() {
		return this.identityroleresources;
	}

	public void setIdentityroleresources(List<Identityroleresource> identityroleresources) {
		this.identityroleresources = identityroleresources;
	}

	public Identityroleresource addIdentityroleresource(Identityroleresource identityroleresource) {
		getIdentityroleresources().add(identityroleresource);
		identityroleresource.setResource(this);

		return identityroleresource;
	}

	public Identityroleresource removeIdentityroleresource(Identityroleresource identityroleresource) {
		getIdentityroleresources().remove(identityroleresource);
		identityroleresource.setResource(null);

		return identityroleresource;
	}

}