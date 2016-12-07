package si.fri.prpo.jdbc;

import java.io.Serializable;

public class Entiteta implements Serializable{
	private int id;
	
	public Entiteta(int id) {
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
}