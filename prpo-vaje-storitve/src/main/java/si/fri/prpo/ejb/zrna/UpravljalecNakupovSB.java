package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import si.fri.prpo.jpa.entitete.Uporabnik;
import si.fri.prpo.jpa.entitete.Izdelek;
import si.fri.prpo.jpa.entitete.Trgovina;

/**
 * Session Bean implementation class UpravljalecNakupovSB
 */
@Stateless
@RunAs("Uporabniki")
@DeclareRoles({"Uporabniki", "Administrator", "Gost"})
public class UpravljalecNakupovSB implements UpravljalecNakupovSBRemote, UpravljalecNakupovSBLocal, NakupovListekFacade {

	@PersistenceContext(unitName="prpo-vaje-jpa")
	private EntityManager em; 
	
	@EJB
	private UpravljalecUporabnikovSBLocal uporabnikiZrno;
	
	@EJB
	private UpravljalecIzdelkovSBLocal izdelkiZrno;
	
	@EJB
	private UpravljalecTrgovinSBLocal trgovinaZrno;
	
	@EJB
	private UpravljalecStetjaSBLocal stetjeZrno;
    /**
     * Default constructor. 
     */
    public UpravljalecNakupovSB() {
        // TODO Auto-generated constructor stub
    	
    }

	@Override
	@PermitAll
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void shraniIzdelek(Izdelek izdelek) {
		stetjeZrno.stetljeDostopov();
		try {
			izdelkiZrno.shraniIzdelek(izdelek);
		} catch (NeustrezenIzdelekException e) {
			e.printTraceIzdelekErr();
		}
	}

	@Override
	@PermitAll
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Uporabnik> vrniVseUporabnike() {
		stetjeZrno.stetljeDostopov();
		List<Uporabnik> uporabniki = uporabnikiZrno.vrniVseUporabnike();
		return uporabniki;
	}

	@Override
	@PermitAll
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Trgovina vrniTrgovino(int id) {
		stetjeZrno.stetljeDostopov();
		Trgovina trgovina = trgovinaZrno.vrniTrgovino(id);
		return trgovina;
	}

}
