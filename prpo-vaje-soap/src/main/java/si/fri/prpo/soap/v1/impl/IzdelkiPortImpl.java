package si.fri.prpo.soap.v1.impl;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import si.fri.prpo.ejb.zrna.UpravljalecIzdelkovSBLocal;
import si.fri.prpo.jpa.entitete.Izdelek;
import si.fri.prpo.sheme.izdelki.sporocila.v1.*;
import si.fri.prpo.sheme.izdelki.v1.IzdelekType;
import si.fri.prpo.sheme.izdelki.v1.IzdelkiListType;
import si.fri.prpo.soap.v1.IzdelkiPort;

@WebService(serviceName = "Izdelki", endpointInterface = "si.fri.prpo.soap.v1.IzdelkiPort", targetNamespace = "http://prpo.fri.si/storitve/izdelki/v1")
public class IzdelkiPortImpl implements IzdelkiPort {
	
	@EJB
	private UpravljalecIzdelkovSBLocal upravljalecIzdelkov;
	
	public VrniIzdelkeResponse vrniIzdelke(VrniIzdelkeRequest parameters) {
		List<Izdelek> izdelki = upravljalecIzdelkov.vrniVseIzdelke();
		List<IzdelkiListType.IzdelekType> izdelekList = new ArrayList<IzdelkiListType.IzdelekType>();
		for(Izdelek izdelek : izdelki) {
			IzdelkiListType.IzdelekType iz = new IzdelkiListType.IzdelekType();
			iz.setIdIzdelek(izdelek.getIdIzdelek());
			iz.setNaziv(izdelek.getNaziv());
			iz.setKategorija(izdelek.getKategorija());
			iz.setCena(izdelek.getCena());
			izdelekList.add(iz);
		}
		VrniIzdelkeOdgovorSporocilo odgovorSporocilo = new VrniIzdelkeOdgovorSporocilo();
		odgovorSporocilo.setIzdelek(izdelekList);
		
		VrniIzdelkeResponse response = new VrniIzdelkeResponse();
		response.setOutput(odgovorSporocilo);
		
		return response;
	}

	public VrniIzdelekResponse vrniIzdelek(VrniIzdelekRequest parameters) {
		Izdelek izdelek = upravljalecIzdelkov.vrniIzdelek(parameters.getInput().getIdIzdelek());
		IzdelekType iz = new IzdelekType();
		iz.setIdIzdelek(izdelek.getIdIzdelek());
		iz.setNaziv(izdelek.getNaziv());
		iz.setKategorija(izdelek.getKategorija());
		iz.setCena(izdelek.getCena());
		
		VrniIzdelekOdgovorSporocilo odgovorSporocilo = new VrniIzdelekOdgovorSporocilo();
		odgovorSporocilo.setIzdelek(iz);
		
		VrniIzdelekResponse response = new VrniIzdelekResponse();
		response.setOutput(odgovorSporocilo);
		return response;
	}
}