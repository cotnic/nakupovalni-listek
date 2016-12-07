package si.fri.prpo.jpa.entitete;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


import java.util.List;


/**
 * The persistent class for the listek database table.
 * 
 */
@Entity
@XmlRootElement
@NamedQueries({
	@NamedQuery(name="Listek.findAll", query="SELECT l FROM Listek l"),
	@NamedQuery(name="Listek.findId", query="SELECT l FROM Listek l WHERE l.idListek = :id"),
	@NamedQuery(name="Listek.deleteAll", query="DELETE FROM Listek"),
	@NamedQuery(name="Listek.deleteId", query="DELETE FROM Listek l WHERE l.idListek = :id")
})
public class Listek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_listek")
	private Integer idListek;

	//bi-directional many-to-one association to Uporabnik
	@ManyToOne
	@JoinColumn(name="id_uporabnik")
	private Uporabnik uporabnik;

	//bi-directional many-to-many association to Izdelek
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="listek_izdelek"
		, joinColumns={
			@JoinColumn(name="id_listek")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_izdelek")
			}
		)
	private List<Izdelek> izdeleks;

	public Listek() {
	}

	public Integer getIdListek() {
		return this.idListek;
	}

	public void setIdListek(Integer idListek) {
		this.idListek = idListek;
	}
	
	public Uporabnik getUporabnik() {
		return this.uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	@XmlTransient
	public List<Izdelek> getIzdeleks() {
		return this.izdeleks;
	}

	public void setIzdeleks(List<Izdelek> izdeleks) {
		this.izdeleks = izdeleks;
	}

}