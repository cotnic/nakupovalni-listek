package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.jpa.entitete.Uporabnik;

/**
 * Session Bean implementation class UpravljalecUporabnikovSB
 */
@Stateless
@DeclareRoles({"Uporabniki", "Administrator", "Gost"})
public class UpravljalecUporabnikovSB implements UpravljalecUporabnikovSBRemote, UpravljalecUporabnikovSBLocal {

	@PersistenceContext(unitName="prpo-vaje-jpa")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public UpravljalecUporabnikovSB() {
    }

	@Override
	@RolesAllowed({"Uporabniki", "Administrator", "Gost"})
	public List<Uporabnik> vrniVseUporabnike() {
		return em.createNamedQuery("Uporabnik.findAll").getResultList();
	}
	
	@Override
	@RolesAllowed({"Uporabniki", "Administrator"})
	public List<Uporabnik> vrniVseUporabnike(int offset, int limit) {
		return em.createNamedQuery("Uporabnik.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

	@Override
	@RolesAllowed({"Uporabniki", "Administrator"})
	public void shraniUporabnika(Uporabnik uporabnik) {
		em.persist(uporabnik);
	}
	
	@Override
	@RolesAllowed({"Uporabniki", "Administrator"})
	public void posodobiUporabnika(Uporabnik uporabnik) {
		em.merge(uporabnik);
	}
	
	@Override
	@RolesAllowed({"Uporabniki", "Administrator"})
	public void zbrisiUporabnika(int id) {
		em.createNamedQuery("Uporabnik.deleteId").setParameter("id", id).getSingleResult();
	}

	@Override
	@RolesAllowed({"Uporabniki", "Administrator"})
	public Uporabnik vrniUporabnika(int id) {
		return (Uporabnik)em.createNamedQuery("Uporabnik.findId").setParameter("id", id).getSingleResult();
	}

}
