package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Elemento;
import entity.Persona;
import entity.Reserva;

public class DataReserva {

	public ArrayList<Reserva> getAll(){
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from reserva r "
		 			+ "inner join elemento e on r.id_elemento=e.id_elemento");
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setElemento(new Elemento());
					r.setId_reserva(rs.getInt("id_reserva"));
					r.setFecha_hora(rs.getDate("fecha_hora"));
					r.setDescripcion(rs.getString("descripcion"));
					r.getElemento().setId_elemento(rs.getInt("id_elemento"));
		 			r.getElemento().setNombre(rs.getString("e.nombre"));
		 			reservas.add(r);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return reservas;	
	}
	
	public void add(Reserva r){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into reserva(fecha_hora, descripcion, id_elemento) values (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setDate(1,r.getFecha_hora());
 			stmt.setString(2, r.getDescripcion());
 			stmt.setInt(3, r.getElemento().getId_elemento());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId_reserva(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Reserva r){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"DELETE FROM reserva where id_reserva=?",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, r.getId_reserva());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId_reserva(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void update(Reserva r){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE  reserva SET fecha_hora=?, descripcion=?, id_elemento =? where id_reserva=? ",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setDate(1, r.getFecha_hora());
			stmt.setString(2, r.getDescripcion());
			stmt.setInt(3, r.getElemento().getId_elemento());
			stmt.setInt(4, r.getId_reserva());			
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId_reserva(keyResultSet.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
