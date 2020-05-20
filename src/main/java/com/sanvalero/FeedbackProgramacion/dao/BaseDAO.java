package com.sanvalero.FeedbackProgramacion.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sanvalero.FeedbackProgramacion.modelos.MotorOracle;

public class BaseDAO extends MotorOracle{ // Esta clase nos permitira hacer conexiones
	
	// 1.- CONEXION CON LA BD
		/*Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","HR");
		*/
	
	protected Connection conexion = null;
	String cadenaConexion = "jdbc:oracle:thin:@localhost:1521:XE";	

	public void conectar() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(cadenaConexion, "HR", "HR");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println(e);
			
		} catch (SQLException ex) {
			
			System.out.println(ex);
			
		}
		
	}

	@Override
	public int ejecutar(String sql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultSet ejecutarQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desconectar() {
		try {
			conexion.close();
		} catch (Exception e2) {
			System.out.println(e2);
		}		
	}
	

}
