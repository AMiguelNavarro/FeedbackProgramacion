package com.sanvalero.FeedbackProgramacion.main;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		
		/* CONEXION CON LA BBDD */
		
		try {
			
		// 1.- CONEXION CON LA BD
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","HR","HR");
			
			
		// 2.- PREPARAR LA CONSULTA 			
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM PARQUES";
			ResultSet resul = sentencia.executeQuery(sql); //Para ejecutar una consulta
			
		// 3.- RECORRER RESULTADO */
			
			while (resul.next()) { // Con esto se posiciona en el primer registro que ha devuelto la consulta 
				System.out.println(resul.getString(2) + " " + resul.getString("EXTENSION"));
			}
			
		// 4.- CERRAR CANALES DE COMUNICACION
			// Muy importante cerrar todos los canales, si se queda abierta al realizar otra conexión dará error
			resul.close(); 
			sentencia.close();
			conexion.close();
			
		} catch (Exception e) {
			System.out.println("NO CONECTA!!");
		}
		
		
		
		
	}

}
