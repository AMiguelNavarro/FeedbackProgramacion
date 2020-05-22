package com.sanvalero.FeedbackProgramacion.dao;

import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sanvalero.FeedbackProgramacion.interfaces.IDAO;
import com.sanvalero.FeedbackProgramacion.modelos.Parques;

import oracle.net.aso.p;

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
	 *@param Pregunta 4
	 *Listar los parque por el nombre de parque que haya puesto el usuario
	 */
	public List<Parques> findAll(Parques p) throws SQLException{
	
		String query = "SELECT * FROM PARQUES WHERE NOMBRE_PARQUE = ?";
		
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setString(1, p.getNombreParque());
		
		ResultSet rs = ps.executeQuery();
		
		List<Parques> listaParques = new ArrayList();
		
		while (rs.next()) {
			Parques parque = new Parques();
			parque.setNombreParque(rs.getString("NOMBRE_PARQUE"));
			parque.setExtension(rs.getString("EXTENSION"));
			parque.setIdCiudad(rs.getInt("ID_CIUDAD"));
		}
		
		return listaParques;
	}

	
	/**
	 *@author alber
	 *@param Pregunta 4
	 *Actualizar el parque
	 */
	public void actualizar(Parques p) throws SQLException {
		
		String query = "UPDATE PARQUES SET NOMBRE_PARQUE = ?, EXTENSION = ?, ID_CIUDAD = ? WHERE NOMBRE_PARQUE = ?";
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
