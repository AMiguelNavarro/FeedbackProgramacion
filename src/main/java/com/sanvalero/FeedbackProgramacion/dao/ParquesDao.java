package com.sanvalero.FeedbackProgramacion.dao;

import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sanvalero.FeedbackProgramacion.interfaces.IDAO;
import com.sanvalero.FeedbackProgramacion.modelos.Parques;

import oracle.net.aso.p;

/**
 * @author alber
 *
 */
public class ParquesDao extends BaseDAO implements IDAO<Parques, String>{
	
	
	private final String SELECT_POR_CIUDAD = "SELECT NOMBRE_PARQUE FROM PARQUES WHERE ID_CIUDAD = 1";
	private final String SELECT_POR_CCAA = "SELECT P.NOMBRE_PARQUE FROM PARQUES P INNER JOIN CIUDADES C ON P.ID_CIUDAD=C.ID_CIUDAD WHERE CCAA = ?";
	private final String ANIADIR_PARQUE = "INSERT INTO PARQUES (ID_PARQUE, NOMBRE_PARQUE, EXTENSION, ID_CIUDAD) VALUES (?, ?, ?, ?)";
	
	/**
	 *@author alber
	 *@param Pregunta 1
	 *listar paques por ciudad
	 */
	public void listarParquesPorIdCiudad() { // Pregunta 1
		
		this.conectar();
		try {
			
			Statement st = conexion.createStatement(); 
			ResultSet resul = st.executeQuery(SELECT_POR_CIUDAD);
			
			while (resul.next()) {
				System.out.println(resul.getString(1));
			}
			
			st.close();
			resul.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.desconectar();				
		}
		
	}
	
	/**
	 *@author alber
	 *@param Pregunta 2
	 *listar parques por comunidad autónoma
	 */
	public void listarParquesPorCCAA() { // Pregunta 2
		this.conectar();
		try {
			
			PreparedStatement ps = conexion.prepareStatement(SELECT_POR_CCAA);
			ps.setString(1, "COMUNIDAD DE MADRID" );
			ResultSet resul = ps.executeQuery();
			
			while (resul.next()) {
				System.out.println(resul.getString(1));			
		}	
			
			ps.close();
			resul.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
	}
	
	
	/**
	 *@author alber
	 *@param Pregunta 4
	 *Imprimir por pantalla los datos del parque una vez haya comprobado que existen
	 */
	public void listarParquePorNombreParque(String nombreParque) throws SQLException {
		this.conectar();
		final String SELECT_POR_NPARQUE = "SELECT NOMBRE_PARQUE, NOMBRE_CIUDAD, EXTENSION FROM PARQUES P INNER JOIN CIUDADES C ON C.ID_CIUDAD = P.ID_CIUDAD WHERE NOMBRE_PARQUE = ?";
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_NPARQUE);
		ps.setString(1, nombreParque);
		ResultSet result = ps.executeQuery();
		
		while (result.next()) {
			System.out.println("NOMBRE_PARQUE: "+result.getString(1));
			System.out.println("NOMBRE_CIUDAD: "+result.getString(2));
			System.out.println("EXTENSION: "+result.getString(3));
		}
		
		ps.close();
		result.close();
		this.desconectar();
		
	}
	
	
	
	/**
	 *@author alber
	 *@param Pregunta 3
	 *Añadir el parque 
	 */
	public int añadir(Parques p) throws SQLException {
		String query = "INSERT INTO PARQUES (ID_PARQUE, NOMBRE_PARQUE, EXTENSION, ID_CIUDAD) VALUES (?, ?, ?, ?)";
		this.conectar();

		PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, p.getIdParque());
			ps.setString(2, p.getNombreParque());
			ps.setString(3, p.getExtension());
			ps.setInt(4, p.getIdCiudad());
			
		int n = ps.executeUpdate();
		
		ps.close();
		
		this.desconectar();
		
		return n;
	}

	public int borrar(String integer) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	/**
	 *@author alber
	 *@param Pregunta 5
	 *Listar por cadena de texto
	 */	
	public void listarParquePorCadena(String cadena) throws SQLException{
		
		this.conectar();
		
		final String SELECT_POR_CADENA = "SELECT * FROM PARQUES WHERE NOMBRE_PARQUE LIKE '%"+cadena+"%'";
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_CADENA);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("ID_PARQUE: " + rs.getInt(1));
			System.out.println("NOMBRE_PARQUE: " + rs.getString(2));
			System.out.println("EXTENSION: " + rs.getString(3));
			System.out.println("ID_CIUDAD: " + rs.getInt(4));
		}
		
		ps.close();
		rs.close();		
		this.desconectar();
		
	}
	
	
	
	/**
	 *@author alber
	 *@param Pregunta 4
	 *Comprobar si el parque existe
	 */	
	public boolean getParque (String nombreParque) throws SQLException{
		
		boolean resultado;
		final String SELECT_POR_NPARQUE = "SELECT * FROM PARQUES WHERE NOMBRE_PARQUE = ?";
		
		this.conectar();
		
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_NPARQUE);
		ps.setString(1, nombreParque);
		
		ResultSet result = ps.executeQuery();
		
		if (result.next()) {
			resultado = true;
		} else {
			resultado = false;
		}
		
		ps.close();
		result.close();
		this.desconectar();
		
		return resultado;
		
	}

	public List<Parques> findAll(Parques p) throws SQLException{

		
		return findAll(p);
	}

	
	/**
	 *@author alber
	 *@param Pregunta 4
	 *Actualizar el parque
	 */
	public void actualizar(Parques p) throws SQLException {
		
		String query = "UPDATE PARQUES SET NOMBRE_PARQUE = ?, EXTENSION = ?, NOMBRE_CIUDAD = ? WHERE NOMBRE_PARQUE = ?";
		this.conectar();
		
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setString(1, p.getNombreParque());
		ps.setString(2, p.getExtension());
		ps.setInt(3, p.getIdCiudad());
		ps.setString(4, p.getNombreParque());
		
		ps.executeUpdate();
		
		this.desconectar();
	}

}
