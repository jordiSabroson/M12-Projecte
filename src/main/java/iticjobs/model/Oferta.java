package iticjobs.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id")
@Table(name = "oferta")
public class Oferta {

	private @Id @Column(name = "id") @GeneratedValue(strategy = GenerationType.IDENTITY) long id;

	@Column(nullable = false)
	private String titol;

	@Column(nullable = false)
	private String jornada;

	@Column(nullable = false)
	private String ciutat;

	@Column(nullable = false)
	private int salari;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "empresa_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Empresa empresa;

	public long getId() {
		return id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
		this.jornada = jornada;
	}

	public String getCiutat() {
		return ciutat;
	}

	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

	public int getSalari() {
		return salari;
	}

	public void setSalari(int salari) {
		this.salari = salari;
	}

	public Oferta(long id, String titol, String jornada, String ciutat, int salari, Empresa empresa) {
		super();
		this.id = id;
		this.titol = titol;
		this.jornada = jornada;
		this.ciutat = ciutat;
		this.salari = salari;
		this.empresa = empresa;
	}

	public Oferta() {
		super();
		// TODO Auto-generated constructor stub
	}

}
