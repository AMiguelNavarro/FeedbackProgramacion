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
	 *hacer un select con los datos de la ciudad que ha introducido el usuario, en el main se comprueba si existe por el return de este m�todo
	 */
	public Ciudades getCiudad(String nombreCiudad) {
		
		final String SELECT_POR_NCIUDAD = "SELECT * FROM PARQUES P INNER JOIN CIUDADES C ON P.ID_CIUDAD = C.ID_CIUDAD WHERE C.NOMBRE_CIUDAD = ?";
		Ciudades ciudad = new Ciudades();
		this.conectar();		
		try {
			
			PreparedStatement ps = conexion.prepareStatement(SELECT_POR_NCIUDAD);
			ps.setString(1, nombreCiudad);
			ResultSet result = ps.executeQuery();
			
			
			
			while (result.next()) {
				ciudad.setNombreCiudad(nombreCiudad);

			}
			
			ps.close();
			result.close();
			
			
		} catch (Exception e) {
			System.out.println("No existe la ciudad, no se puede hacer");
		}finally {
			this.desconectar();
		}
		return ciudad;
	}
	
	// Parte de las interfaces

	public int a�adir(Ciudades c) {
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
