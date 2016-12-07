package si.fri.prpo.jpa.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import java.util.List;


/**
 * The persistent class for the uporabnik database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Uporabnik.findAll", query="SELECT u FROM Uporabnik u"),
	@NamedQuery(name="Uporabnik.findId", query="SELECT u FROM Uporabnik u WHERE u.idUporabnik = :id"),
	@NamedQuery(name="Uporabnik.deleteAll", query="DELETE FROM Uporabnik"),
	@NamedQuery(name="Uporabnik.deleteId", query="DELETE FROM Uporabnik u WHERE u.idUporabnik = :id")
})
public class Uporabnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_uporabnik")
	private Integer idUporabnik;

	@Column(length=80, nullable=false)
	private String email;

	@Column(length=30, nullable=false)
	private String ime;

	@Column(length=50, nullable=false)
	private String priimek;

	@Column(name="uporabnisko_ime")
	private String uporabniskoIme;

	//bi-directional many-to-one association to Listek
	@OneToMany(fetch = FetchType.EAGER, mappedBy="uporabnik")
	private List<Listek> listeks;

	//bi-directional many-to-one association to Lokacija
	@ManyToOne
	@JoinColumn(name="postna_stevilka")
	private Lokacija lokacija;

	public Uporabnik() {
	}

	public Integer getIdUporabnik() {
		return this.idUporabnik;
	}

	public void setIdUporabnik(Integer idUporabnik) {
		this.idUporabnik = idUporabnik;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return this.priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public String getUporabniskoIme() {
		return this.uporabniskoIme;
	}

	public void setUporabniskoIme(String uporabniskoIme) {
		this.uporabniskoIme = uporabniskoIme;
	}

	@XmlTransient
	public List<Listek> getListeks() {
		return this.listeks;
	}

	public void setListeks(List<Listek> listeks) {
		this.listeks = listeks;
	}

	public Listek addListek(Listek listek) {
		getListeks().add(listek);
		listek.setUporabnik(this);

		return listek;
	}

	public Listek removeListek(Listek listek) {
		getListeks().remove(listek);
		listek.setUporabnik(null);

		return listek;
	}

	@XmlTransient
	public Lokacija getLokacija() {
		return this.lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

}