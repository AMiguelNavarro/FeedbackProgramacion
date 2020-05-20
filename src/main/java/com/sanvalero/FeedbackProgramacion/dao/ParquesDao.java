package com.sanvalero.FeedbackProgramacion.dao;

import java.security.interfaces.RSAKey;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.sanvalero.FeedbackProgramacion.interfaces.IDAO;
import com.sanvalero.FeedbackProgramacion.modelos.Parques;

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
	 *Añadir un parque a una ciudad y si no existe informa de ellos 
	 */
	public void añadirParque(int idCiudadAInsertar) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			if (idCiudadAInsertar < 1 || idCiudadAInsertar > 5) {
				System.out.println("El id no existe");
			} else {			
				
				PreparedStatement ps = conexion.prepareStatement(ANIADIR_PARQUE);
				ps.setInt(1, 50);
				ps.setString(2, "Parque Grande (PG)");
				ps.setString(3, "15000");
				ps.setInt(4, idCiudadAInsertar);
				
				ps.close();
			}	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.desconectar();
		}
	}
	


	public int añadir(Parques bean) {
		
		return 0;
	}

	public int borrar(String integer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Parques> findAll(Parques bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public int actualizar(Parques bean) {
		// TODO Auto-generated method stub
		return 0;
	}

}
