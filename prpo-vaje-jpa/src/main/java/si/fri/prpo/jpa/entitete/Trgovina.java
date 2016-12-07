package si.fri.prpo.jpa.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import java.util.List;


/**
 * The persistent class for the trgovina database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Trgovina.findAll", query="SELECT t FROM Trgovina t"),
	@NamedQuery(name="Trgovina.findId", query="SELECT t FROM Trgovina t WHERE t.idTrgovina = :id"),
	@NamedQuery(name="Trgovina.deleteAll", query="DELETE FROM Trgovina"),
	@NamedQuery(name="Trgovina.deleteId", query="DELETE FROM Trgovina t WHERE t.idTrgovina = :id")
})
public class Trgovina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_trgovina")
	private Integer idTrgovina;

	@Column(length=50, nullable=false)
	private String naziv;

	//bi-directional many-to-many association to Izdelek
	@ManyToMany
	@JoinTable(
		name="seznam"
		, joinColumns={
			@JoinColumn(name="id_trgovina")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_izdelek")
			}
		)
	private List<Izdelek> izdeleks;

	//bi-directional many-to-one association to Lokacija
	@ManyToOne
	@JoinColumn(name="postna_stevilka")
	private Lokacija lokacija;

	public Trgovina() {
	}

	public Integer getIdTrgovina() {
		return this.idTrgovina;
	}

	public void setIdTrgovina(Integer idTrgovina) {
		this.idTrgovina = idTrgovina;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@XmlTransient
	public List<Izdelek> getIzdeleks() {
		return this.izdeleks;
	}

	public void setIzdeleks(List<Izdelek> izdeleks) {
		this.izdeleks = izdeleks;
	}

	@XmlTransient
	public Lokacija getLokacija() {
		return this.lokacija;
	}

	public void setLokacija(Lokacija lokacija) {
		this.lokacija = lokacija;
	}

}