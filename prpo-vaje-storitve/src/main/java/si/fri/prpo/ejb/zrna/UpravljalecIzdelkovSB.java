package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.jpa.entitete.Izdelek;

/**
 * Session Bean implementation class UpravljalecIzdelkovSB
 */
@Stateless
@DeclareRoles({"Uporabniki", "Administrator", "Gost"})
public class UpravljalecIzdelkovSB implements UpravljalecIzdelkovSBRemote, UpravljalecIzdelkovSBLocal {
	@PersistenceContext(unitName="prpo-vaje-jpa")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public UpravljalecIzdelkovSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	@PermitAll
	//@RolesAllowed({"Uporabniki", "Administrator", "Gost"})
	public List<Izdelek> vrniVseIzdelke() {
		return em.createNamedQuery("Izdelek.findAll").getResultList();
	}
	
	@Override
	@PermitAll
	//@RolesAllowed({"Uporabniki", "Administrator"})
	public List<Izdelek> vrniVseIzdelke(int offset, int limit) {
		return em.createNamedQuery("Izdelek.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

	@Override
	@PermitAll
	//@RolesAllowed({"Administrator"})
	public void shraniIzdelek(Izdelek izdelek) throws NeustrezenIzdelekException {
		em.persist(izdelek);
	}

	@Override
	@PermitAll
	//@RolesAllowed({"Uporabniki", "Administrator"})
	public Izdelek vrniIzdelek(int id) {
		Izdelek izdelek = (Izdelek)em.createNamedQuery("Izdelek.findId").setParameter("id", id).getSingleResult();
		
		return izdelek;
	}
	
	@Override
	@RolesAllowed({"Administrator"})
	public void posodobiIzdelek(Izdelek izdelek) {
		em.merge(izdelek);
	}

	@Override
	@RolesAllowed({"Administrator"})
	public void izbrisiIzdelek(int id) {
		em.createNamedQuery("Izdelek.deleteId").setParameter("id", id).executeUpdate();
	}
}
