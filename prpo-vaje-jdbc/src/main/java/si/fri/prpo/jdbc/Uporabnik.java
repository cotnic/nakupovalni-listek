package si.fri.prpo.jdbc;

public class Uporabnik extends Entiteta{
	private String ime;
	private String priimek;
	private String uporabnisko_ime;
	private String email;
	//private String lokacija;
	
	public Uporabnik(int id, String ime, String priimek, String uporabnisko_ime, String email) {
		super(id);
		this.ime = ime;
		this.priimek = priimek;
		this.uporabnisko_ime = uporabnisko_ime;
		this.email = email;
	}
}
