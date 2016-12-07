package si.fri.prpo.ejb.zrna;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class UpravljalecStetjaSB
 */
@Singleton
public class UpravljalecStetjaSB implements UpravljalecStetjaSBRemote, UpravljalecStetjaSBLocal {

	int stevec;
    /**
     * Default constructor. 
     */
    public UpravljalecStetjaSB() {
        // TODO Auto-generated constructor stub
    }
    
    @PostConstruct
    public void inicializacijaVirov() {
    	stevec = 0;
    }

	@Override
	public void stetljeDostopov() {
		// TODO Auto-generated method stub
		stevec++;
		System.out.println("Stanje stevca zahtev: " + stevec);
	}

}
