package si.fri.prpo.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class IzdelekDaoImpl implements BaseDao {
    
	public Connection getConnection(){
		Connection connection = null;
        try {
        	Context initCtx = new InitialContext();
			DataSource ds = (DataSource) initCtx.lookup("java:/PostgresDS");

			connection = ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return connection;
	}

	public Entiteta vrni(int id){
		Connection connection = getConnection();
		PreparedStatement ps = null;
		Entiteta izd = null;
		try{
			String sql = "select * from  public.izdelek where id_izdelek = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				String naziv = rs.getString("naziv");
				String kategorija = rs.getString("kategorija");
				double cena = rs.getDouble("cena");
				izd = new Izdelek(id, naziv, kategorija, cena);
				
			}else {
				System.out.println("Ne najdem uporabnika.");
			}
		}catch (SQLException e){
			System.out.print(e);
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return izd;
	}

	public void vstavi(Entiteta ent){
		Connection connection = getConnection();
		PreparedStatement ps = null;
		try{
			connection.setAutoCommit(false);
			String sql = "insert into public.izdelek(id_izdelek, naziv, kategorija, cena) "
					+ "values (?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ent.getId());
			ps.setString(2, ((Izdelek) ent).getNaziv());
			ps.setString(3, ((Izdelek) ent).getKategorija());
			ps.setDouble(4, ((Izdelek) ent).getCena());
			int rs = ps.executeUpdate();
			if(rs > 0)
				System.out.println("Izdelek je ustvarjen v tabeli!");
			else
				System.out.println("Prišlo je do napake pri vnosu!");
			connection.commit();
		}catch (SQLException e){
			System.out.print(e);
		}catch(Exception e) {
			try{
				connection.rollback();
			}catch(SQLException esql) {
				esql.printStackTrace();
			}
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void vstaviDva(Entiteta ent1, Entiteta ent2){
		Connection connection = getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		try{
			connection.setAutoCommit(false);
			String sql = "insert into public.izdelek(id_izdelek, naziv, kategorija, cena) "
					+ "values (?,?,?,?)";
			//Entiteta1
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ent1.getId());
			ps.setString(2, ((Izdelek) ent1).getNaziv());
			ps.setString(3, ((Izdelek) ent1).getKategorija());
			ps.setDouble(4, ((Izdelek) ent1).getCena());
			int rs = ps.executeUpdate();
			//Entiteta2
			ps2 = connection.prepareStatement(sql);
			ps2.setInt(1, ent2.getId());
			ps2.setString(2, ((Izdelek) ent2).getNaziv());
			ps2.setString(3, ((Izdelek) ent2).getKategorija());
			ps2.setDouble(4, ((Izdelek) ent2).getCena());
			int rs1 = ps.executeUpdate();
			if(rs > 0 || rs1 > 0)
				System.out.println("Izdelek je ustvarjen v tabeli!");
			else
				System.out.println("Prišlo je do napake pri vnosu!");
			connection.commit();
		}catch(Exception e) {
			try{
				System.out.println("Izvaja se rollback!");
				connection.rollback();
			}catch(SQLException esql) {
				esql.printStackTrace();
			}
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void odstrani(int id){
		Connection connection = getConnection();
		PreparedStatement ps = null;
		try{
			String sql = "delete from public.izdelek "
					+ "where id_izdelek = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			if(rs > 0)
				System.out.println("Izdelek je bil izbrisan!");
			else
				System.out.println("Prišlo je do napake pri brisanju!");
		}catch (SQLException e){
			System.out.print(e);
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void posodobi(Entiteta ent){
		Connection connection = getConnection();
		PreparedStatement ps = null;
		try{
			String sql = "update public.izdelek set naziv = ?, kategorija = ?, cena = ? "
					+ "where id_izdelek = ?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, ((Izdelek) ent).getNaziv());
			ps.setString(2, ((Izdelek) ent).getKategorija());
			ps.setDouble(3, ((Izdelek) ent).getCena());
			ps.setInt(4, ent.getId());
			int rs = ps.executeUpdate();
			if(rs > 0)
				System.out.println("Izdelek je bil posodobljen!");
			else
				System.out.println("Prišlo je do napake pri posodobitvi!");
		}catch (SQLException e){
			System.out.print(e);
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public List<Entiteta> vrniVse(){
		Connection connection = getConnection();
		List<Entiteta> list = new ArrayList<Entiteta>();
		PreparedStatement ps = null;
		try{
			String sql = "SELECT * FROM public.izdelek";
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id_izdelek");
				String naziv = rs.getString("naziv");
				String kategorija = rs.getString("kategorija");
				double cena = rs.getDouble("cena");
				list.add(new Izdelek(id, naziv, kategorija, cena));
			}
		}catch (SQLException e){
			System.out.print(e);
		}finally{
			if(ps != null){
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
	
}
