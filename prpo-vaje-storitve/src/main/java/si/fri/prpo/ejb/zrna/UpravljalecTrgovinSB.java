package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.jpa.entitete.Trgovina;
import si.fri.prpo.jpa.entitete.Uporabnik;

/**
 * Session Bean implementation class UpravlajlecTrgovinSB
 */
@Stateless
@DeclareRoles({"Uporabniki", "Administrator", "Gost"})
public class UpravljalecTrgovinSB implements UpravljalecTrgovinSBRemote, UpravljalecTrgovinSBLocal {
	@PersistenceContext(unitName="prpo-vaje-jpa")
	private EntityManager em; 
    /**
     * Default constructor. 
     */
    public UpravljalecTrgovinSB() {
        // TODO Auto-generated constructor stub
    }

	@Override
	@RolesAllowed({"Uporabniki", "Administrator", "Gost"})
	public List<Trgovina> vrniVseTrgovine() {
		return em.createNamedQuery("Trgovina.findAll").getResultList();
	}
	
	@Override
	@RolesAllowed({"Uporabniki", "Administrator"})
	public List<Trgovina> vrniVseTrgovine(int offset, int limit) {
		return em.createNamedQuery("Trgovina.findAll").setFirstResult(offset).setMaxResults(limit).getResultList();
	}

	@Override
	@RolesAllowed({"Administrator"})
	public void shraniTrgovino(Trgovina trgovina) {
		em.persist(trgovina);
	}

	@Override
	@RolesAllowed({"Uporabniki", "Administrator"})
	public Trgovina vrniTrgovino(int id) {
		return (Trgovina)em.createNamedQuery("Trgovina.findId").setParameter("id", id).getSingleResult();
	}

	@Override
	@RolesAllowed({"Administrator"})
	public void posodobiTrgovino(Trgovina trgovina) {
		em.merge(trgovina);
	}

	@Override
	@RolesAllowed({"Administrator"})
	public void zbrisiTrgovino(int id) {
		em.createNamedQuery("Trgovina.deleteId").setParameter("id", id).getSingleResult();
	}

	

}
