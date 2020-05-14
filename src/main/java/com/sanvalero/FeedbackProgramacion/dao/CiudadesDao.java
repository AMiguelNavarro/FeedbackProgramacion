 package com.sanvalero.FeedbackProgramacion.dao;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sanvalero.FeedbackProgramacion.clases.Ciudades;
import com.sanvalero.FeedbackProgramacion.conexion.Conexion;

public class CiudadesDao extends Conexion{
	
	private final String SELECT_POR_CIUDAD = "SELECT NOMBRE_PARQUE FROM PARQUES WHERE ID_CIUDAD = 1";
	
	
	public void listarParquesPorIdCiudad(Ciudades c) { // Pregunta 1
		
		this.conectar();
		try {
			
			Statement st = conexion.createStatement;
			ResultSet resul = st.conexion.executeQuery(SELECT_POR_CIUDAD);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexion.close();
			st.close();
			resul.close;
			
		}
		
	}
}
