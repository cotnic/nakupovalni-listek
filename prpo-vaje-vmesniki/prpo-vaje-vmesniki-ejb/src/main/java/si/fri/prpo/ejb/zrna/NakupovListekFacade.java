package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.ejb.Local;

import si.fri.prpo.jpa.entitete.Izdelek;
import si.fri.prpo.jpa.entitete.Trgovina;
import si.fri.prpo.jpa.entitete.Uporabnik;

@Local
public interface NakupovListekFacade {

	void shraniIzdelek(Izdelek izdelek);
	List<Uporabnik> vrniVseUporabnike();
	Trgovina vrniTrgovino(int id);
}
