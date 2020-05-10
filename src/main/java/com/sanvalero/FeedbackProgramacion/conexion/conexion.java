package com.sanvalero.FeedbackProgramacion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion { // Esta clase nos permitira hacer conexiones
	
	Connection conexion = null;
	String cadenaConexion = "jdbc:oracle:thin:@localhost:1521:XE\",\"HR\",\"HR";
	
	public Connection conectar() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(cadenaConexion);
			
		} catch (ClassNotFoundException e) {
			
			System.out.println(e);
			
		} catch (SQLException ex) {
			
			System.out.println(ex);
			
		}
		
		return conexion;
		
	}

}
