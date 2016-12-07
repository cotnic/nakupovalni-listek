package si.fri.prpo.rest.ponudniki.izjeme;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SporociloIzjeme {

	private String errSporocilo;
	private int errCode;
	private String documentacija;
	
	public SporociloIzjeme() {
		
	}
	
	public SporociloIzjeme(String errSporocilo, int errCode, String dokumentacija) {
		this.errSporocilo = errSporocilo;
		this.errCode = errCode;
		this.documentacija = dokumentacija;
	}

	public String getErrSporocilo() {
		return errSporocilo;
	}

	public void setErrSporocilo(String errSporocilo) {
		this.errSporocilo = errSporocilo;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getDocumentacija() {
		return documentacija;
	}

	public void setDocumentacija(String documentacija) {
		this.documentacija = documentacija;
	}
	
}
