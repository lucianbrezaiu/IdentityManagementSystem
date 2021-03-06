package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the organization database table.
 * 
 */
@Table(name = "\"organization\"")
@Entity
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
@NamedQuery(name = "findOrganizationByCUI", query = "SELECT o FROM Organization o WHERE o.cui = :cui")
@NamedQuery(name = "findOrganizationById", query = "SELECT o FROM Organization o WHERE o.organizationId = :id")
@NamedQuery(name = "findOrganizationByName", query = "SELECT o FROM Organization o WHERE o.organizationName = :name")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int organizationId;

	private String cui;

	private String organizationName;

	//bi-directional many-to-one association to Identity
	@OneToMany(mappedBy="organization")
	private List<Identity> identities;

	public Organization() {
	}
	
	public Organization(String organizationName, String cui) {
		this.organizationName = organizationName;
		this.cui = cui;
	}

	public int getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getCui() {
		return this.cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public List<Identity> getIdentities() {
		return this.identities;
	}

	public void setIdentities(List<Identity> identities) {
		this.identities = identities;
	}

	public Identity addIdentity(Identity identity) {
		getIdentities().add(identity);
		identity.setOrganization(this);

		return identity;
	}

	public Identity removeIdentity(Identity identity) {
		getIdentities().remove(identity);
		identity.setOrganization(null);

		return identity;
	}

}