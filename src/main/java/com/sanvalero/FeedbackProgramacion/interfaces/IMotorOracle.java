package com.sanvalero.FeedbackProgramacion.interfaces;

import java.sql.ResultSet;

public interface IMotorOracle {
	
	public void conectar(); // Conexión con base de datos de Oracle
	public int ejecutar(String sql); // Inserts, deletes, y updates
	public ResultSet ejecutarQuery(String sql);//Querys normales
	public void desconectar(); // Desconectar

}
