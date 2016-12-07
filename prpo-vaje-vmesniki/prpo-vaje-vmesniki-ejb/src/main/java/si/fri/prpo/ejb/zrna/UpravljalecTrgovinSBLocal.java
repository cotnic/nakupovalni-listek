package si.fri.prpo.ejb.zrna;

import java.util.List;

import javax.ejb.Local;

import si.fri.prpo.jpa.entitete.Trgovina;

@Local
public interface UpravljalecTrgovinSBLocal {

	List<Trgovina> vrniVseTrgovine();
	List<Trgovina> vrniVseTrgovine(int offset, int limit);
	void shraniTrgovino(Trgovina trgovina);
	Trgovina vrniTrgovino(int id);
	void posodobiTrgovino(Trgovina trgovina);
	void zbrisiTrgovino(int id);
}
