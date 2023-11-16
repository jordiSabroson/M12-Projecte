package iticjobs.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPRESA")
public class Empresa {
	@Id //jakarta.persistence.Id
	private long id;

	@Column(nullable = false, unique = true)
	private String nom;

	@Column(nullable = false)
	private String cif;
	
	@JsonManagedReference
	@OneToMany(mappedBy="empresa")
	private Set<Oferta> ofertes;

	public Set<Oferta> getOfertes() {
		return ofertes;
	}

	public void setOfertes(Set<Oferta> ofertes) {
		this.ofertes = ofertes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Empresa(long id, String nom, String cif, Set<Oferta> ofertes) {
		super();
		this.id = id;
		this.nom = nom;
		this.cif = cif;
		this.ofertes = ofertes;
	}

	public Empresa() {
		super();
		// TODO Auto-generated constructor stub
	}

}
