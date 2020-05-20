 package com.sanvalero.FeedbackProgramacion.dao;

import java.util.List;

import com.sanvalero.FeedbackProgramacion.interfaces.IDAO;
import com.sanvalero.FeedbackProgramacion.modelos.Ciudades;


public class CiudadesDao extends BaseDAO implements IDAO <Ciudades, String>{
	
	
	// Parte de las interfaces

	public int añadir(Ciudades bean) {
		// TODO Auto-generated method stub
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

	public int actualizar(Ciudades bean) {
		// TODO Auto-generated method stub
		return 0;
	}
}
