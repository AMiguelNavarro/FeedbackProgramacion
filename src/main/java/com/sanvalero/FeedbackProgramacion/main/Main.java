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
			
		
			
		// PARA EVITAR INYECCIONES SQL HAY QUE HACER LOS INSERT, UPDATE Y DELETE DE LA SIGUIENTE FORMA
			// String sql = "INSERT INTO PARQUES VALUES (?, ?, ?)";
			
		// AHORA CREAMOS EL PREPARE STATEMENT PERO EN LUGAR DE CREATE PONEMOS PREPARE
			// PreparedStatement sentencia = conexion.preparedStatement(sql);
			
		// SE SUSTITUYEN LOS INTERROGANTES CON LOS SETTERS
			//sentencia.setInt(1, Integer.parseInt(ID_PARQUE));
			//sentencia.setString(2, NOMBRE_PARQUE);
			//sentencia.setString(3, EXTENSION );
		
			// Estas variables se declaran arriba
			
		// SE EJECUTA LA SENTENCIA CON EL NÚMERO DE FILAS INSERTADAS
			/*
			 * int filas;
			 * try{
			 * 	filas = sentencia.executeUpdate();
			 * 	System.out.println("Filas insertadas: " +filas);
			 * }
			 * catch (SQLException e) {
			 * 	System.out.println("No se ha podido insertar nada" +e.getMessage);
			 * }
			 * finally { // Siempre meter el cierre de conexiones en el finally, ya que siempre se va a ejecutar
			 * 	sentencia.close();
			 * 	conexion.close(),
			 * }
			 * 
			 * */
			
			// Para inserts, deletes y update se usa executeUpdate no executeQuery
			
		} catch (Exception e) {
			System.out.println("NO CONECTA!!");
		}
		
		
		
		
	}

}
