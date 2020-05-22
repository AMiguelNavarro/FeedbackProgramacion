package com.sanvalero.FeedbackProgramacion.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IDAO <B, I>{ // B = beans, I = tipo de dato que es la clave primaria del bean que inserto
	
	public int añadir(B bean) throws SQLException;
	public int borrar(I integer);
	public List<B> findAll (B bean) throws SQLException;
	public void actualizar(B bean) throws SQLException;

}
