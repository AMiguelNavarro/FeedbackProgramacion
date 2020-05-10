package com.sanvalero.FeedbackProgramacion.main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		
		/* CONEXION CON LA BBDD */
		
		//Class.forName("oracle.jdb.driver.OracleDriver");
		//Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","HR");
		// En la URL irá la que tenemos en SQL Developer
		
		
		/* PREPARAR LA CONSULTA */
		
		//Statement sentencia = conexion.createStatement();
		//String sql = "SELECT * FROM PARQUES";
		//ResultSet resul = sentencia.executeQuery(sql); //Para ejecutar una consulta
		
		/* RECORRER RESULTADO */
		
		//while (Resul.next()) {
			//System.out.println("%d, %s, %s, %n" ,resul.getInt(1), resul.getInt(2), resul.getInt(3));
		//}
		
		
		
	}

}
