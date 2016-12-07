package si.fri.prpo.jdbc;

public class Izdelek extends Entiteta {
	private String naziv;
	private String kategorija;
	private double cena;
	
	public Izdelek(int id, String naziv, String kategorija, double cena) {
		super(id);
		this.naziv = naziv;
		this.kategorija = kategorija;
		this.cena = cena;
	}
	
	public String getNaziv(){
		return this.naziv;
	}
	
	public void setNaziv(String naziv){
		this.naziv = naziv;
	}
	
	public String getKategorija(){
		return this.kategorija;
	}
	
	public void setKategorija(String kategorija){
		this.kategorija = kategorija;
	}
	
	public double getCena(){
		return this.cena;
	}
	
	public void setCena(double cena){
		this.cena = cena;
	}
}
