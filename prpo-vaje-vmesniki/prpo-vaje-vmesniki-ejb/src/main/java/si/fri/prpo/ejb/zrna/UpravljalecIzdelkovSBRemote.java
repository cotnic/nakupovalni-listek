package si.fri.prpo.ejb.zrna;

import javax.ejb.Remote;

import si.fri.prpo.jpa.entitete.Izdelek;

@Remote
public interface UpravljalecIzdelkovSBRemote {

	Izdelek vrniIzdelek(int id);
}
