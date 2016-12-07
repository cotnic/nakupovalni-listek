package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.ejb.Local;

import si.fri.prpo.jpa.entitete.Izdelek;

@Local
public interface UpravljalecIzdelkovSBLocal {

	List<Izdelek> vrniVseIzdelke();
	void shraniIzdelek(Izdelek izdelek) throws NeustrezenIzdelekException;
	Izdelek vrniIzdelek(int id);
	List<Izdelek> vrniVseIzdelke(int offset, int limit);
	void izbrisiIzdelek(int id);
	void posodobiIzdelek(Izdelek izdelek);
}
