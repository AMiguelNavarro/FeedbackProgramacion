package com.sanvalero.FeedbackProgramacion.modelos;

import java.sql.ResultSet;

import com.sanvalero.FeedbackProgramacion.interfaces.IMotorOracle;

public abstract class MotorOracle implements IMotorOracle{ // Se pone abstracto todo para implementarlo en BaseDAO

	public abstract void conectar(); // Conexión con base de datos de Oracle
	public abstract int ejecutar(String sql); // Inserts, deletes, y updates
	public abstract ResultSet ejecutarQuery(String sql);//Querys normales
	public abstract void desconectar(); // Desconectar

}
