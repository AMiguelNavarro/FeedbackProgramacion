 package com.sanvalero.FeedbackProgramacion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sanvalero.FeedbackProgramacion.interfaces.IDAO;
import com.sanvalero.FeedbackProgramacion.modelos.Ciudades;


public class CiudadesDao extends BaseDAO implements IDAO <Ciudades, String>{
	
	/**
	 * PREGUNTA 8.- Lista el nombre de las ciudades con una suma de extensión mayor que la solicitada por el usuario
	 *@author alber
	 *@param extension
	 *
	 */
	public void listarCiudadesPorExtension (int extension) throws SQLException {
		
		final String SELECT_POR_EXTENSION = "SELECT C.NOMBRE_CIUDAD, SUM(P.EXTENSION) FROM CIUDADES C INNER JOIN PARQUES P ON P.ID_CIUDAD = C.ID_CIUDAD GROUP BY NOMBRE_CIUDAD HAVING SUM (P.EXTENSION) > ?";
		
		this.conectar();
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_EXTENSION);
		ps.setInt(1, extension);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("Nombre ciudad ----> " +rs.getString(1));
			System.out.println("Suma total extension de sus parques ---->" + rs.getString(2));
		}
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
