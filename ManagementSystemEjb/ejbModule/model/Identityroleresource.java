package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the identityroleresource database table.
 * 
 */
@Entity
@NamedQuery(name="Identityroleresource.findAll", query="SELECT i FROM Identityroleresource i")
@NamedQuery(name="getClaimsForIdentity", query="SELECT i FROM Identityroleresource i WHERE i.identity.identityId = :id")
public class Identityroleresource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Identity
	@ManyToOne
	@JoinColumn(name="identityId")
	private Identity identity;

	//bi-directional many-to-one association to Resource
	@ManyToOne
	@JoinColumn(name="resourceId")
	private Resource resource;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role;

	public Identityroleresource() {
	}
	
	public Identityroleresource(Identity identity,Role role, Resource resource) {
		this.identity = identity;
		this.role = role;
		this.resource = resource;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Identity getIdentity() {
		return this.identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public Resource getResource() {
		return this.resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}