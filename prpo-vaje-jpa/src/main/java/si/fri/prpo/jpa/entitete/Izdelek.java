package si.fri.prpo.jpa.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the izdelek database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Izdelek.findAll", query="SELECT i FROM Izdelek i"),
	@NamedQuery(name="Izdelek.findId", query="SELECT i FROM Izdelek i WHERE i.idIzdelek = :id"),
	@NamedQuery(name="Izdelek.deleteAll", query="DELETE FROM Izdelek"),
	@NamedQuery(name="Izdelek.deleteId", query="DELETE FROM Izdelek i WHERE i.idIzdelek = :id")
})
public class Izdelek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_izdelek")
	private Integer idIzdelek;

	@Column(precision=10, scale=2)
	private double cena;

	@Column(length=30, nullable=false)
	private String kategorija;

	@Column(length=40, nullable=false)
	private String naziv;

	//bi-directional many-to-many association to Listek
	@ManyToMany(mappedBy="izdeleks")
	private List<Listek> listeks;

	//bi-directional many-to-many association to Trgovina
	@ManyToMany(mappedBy="izdeleks")
	private List<Trgovina> trgovinas;

	public Izdelek() {
	}
	
	public Izdelek(String naziv, String kategorija, double cena) {
		this.naziv = naziv;
		this.kategorija = kategorija;
		this.cena = cena;
	}

	public Integer getIdIzdelek() {
		return this.idIzdelek;
	}

	public void setIdIzdelek(Integer idIzdelek) {
		this.idIzdelek = idIzdelek;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getKategorija() {
		return this.kategorija;
	}

	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@XmlTransient
	public List<Listek> getListeks() {
		return this.listeks;
	}

	public void setListeks(List<Listek> listeks) {
		this.listeks = listeks;
	}

	@XmlTransient
	public List<Trgovina> getTrgovinas() {
		return this.trgovinas;
	}

	public void setTrgovinas(List<Trgovina> trgovinas) {
		this.trgovinas = trgovinas;
	}

}