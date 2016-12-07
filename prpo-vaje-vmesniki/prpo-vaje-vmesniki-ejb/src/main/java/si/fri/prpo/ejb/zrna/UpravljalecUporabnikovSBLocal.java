package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.ejb.Local;

import si.fri.prpo.jpa.entitete.Uporabnik;

@Local
public interface UpravljalecUporabnikovSBLocal {

	List<Uporabnik> vrniVseUporabnike();
	void shraniUporabnika(Uporabnik uporabnik);
	Uporabnik vrniUporabnika(int id);
	void posodobiUporabnika(Uporabnik uporabnik);
	void zbrisiUporabnika(int id);
	List<Uporabnik> vrniVseUporabnike(int offset, int limit);
}
