 package com.sanvalero.FeedbackProgramacion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sanvalero.FeedbackProgramacion.interfaces.IDAO;
import com.sanvalero.FeedbackProgramacion.modelos.Ciudades;


public class CiudadesDao extends BaseDAO implements IDAO <Ciudades, String>{
	
	/**
	 *@author alber
	 *@param Pregunta 3
	 *hacer un select con los datos de la ciudad que ha introducido el usuario, en el main se comprueba si existe por el return de este método
	 */
	public boolean getCiudad(String nombreCiudad) throws SQLException {
		
		boolean resultado;
		final String SELECT_POR_NCIUDAD = "SELECT * FROM PARQUES P INNER JOIN CIUDADES C ON P.ID_CIUDAD = C.ID_CIUDAD WHERE C.NOMBRE_CIUDAD = ?";
		this.conectar();		
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_NCIUDAD);
		ps.setString(1, nombreCiudad);
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
	
	// Parte de las interfaces

	public int añadir(Ciudades c) {
		return 0;
	}

	public int borrar(String integer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Ciudades> findAll(Ciudades bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public void actualizar(Ciudades bean) {
		// TODO Auto-generated method stub
	}
}
