package si.fri.prpo.jpa.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import java.util.List;


/**
 * The persistent class for the lokacija database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Lokacija.findAll", query="SELECT l FROM Lokacija l"),
	@NamedQuery(name="Lokacija.findId", query="SELECT l FROM Lokacija l WHERE l.postnaStevilka = :posta"),
	@NamedQuery(name="Lokacija.deleteAll", query="DELETE FROM Lokacija"),
	@NamedQuery(name="Lokacija.deleteId", query="DELETE FROM Lokacija l WHERE l.postnaStevilka = :posta")
})
public class Lokacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="postna_stevilka")
	private Integer postnaStevilka;

	@Column(length=40, nullable=false)
	private String naziv;

	//bi-directional many-to-one association to Trgovina
	@OneToMany(mappedBy="lokacija")
	private List<Trgovina> trgovinas;

	//bi-directional many-to-one association to Uporabnik
	@OneToMany(mappedBy="lokacija")
	private List<Uporabnik> uporabniks;

	public Lokacija() {
	}

	public Integer getPostnaStevilka() {
		return this.postnaStevilka;
	}

	public void setPostnaStevilka(Integer postnaStevilka) {
		this.postnaStevilka = postnaStevilka;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@XmlTransient
	public List<Trgovina> getTrgovinas() {
		return this.trgovinas;
	}

	public void setTrgovinas(List<Trgovina> trgovinas) {
		this.trgovinas = trgovinas;
	}

	public Trgovina addTrgovina(Trgovina trgovina) {
		getTrgovinas().add(trgovina);
		trgovina.setLokacija(this);

		return trgovina;
	}

	public Trgovina removeTrgovina(Trgovina trgovina) {
		getTrgovinas().remove(trgovina);
		trgovina.setLokacija(null);

		return trgovina;
	}

	@XmlTransient
	public List<Uporabnik> getUporabniks() {
		return this.uporabniks;
	}

	public void setUporabniks(List<Uporabnik> uporabniks) {
		this.uporabniks = uporabniks;
	}

	public Uporabnik addUporabnik(Uporabnik uporabnik) {
		getUporabniks().add(uporabnik);
		uporabnik.setLokacija(this);

		return uporabnik;
	}

	public Uporabnik removeUporabnik(Uporabnik uporabnik) {
		getUporabniks().remove(uporabnik);
		uporabnik.setLokacija(null);

		return uporabnik;
	}

}