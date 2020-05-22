package com.sanvalero.FeedbackProgramacion.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.sanvalero.FeedbackProgramacion.dao.CiudadesDao;
import com.sanvalero.FeedbackProgramacion.dao.ParquesDao;
import com.sanvalero.FeedbackProgramacion.modelos.Ciudades;
import com.sanvalero.FeedbackProgramacion.modelos.Parques;
import com.sanvalero.FeedbackProgramacion.dao.CiudadesDao;
public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		int num;
			
			System.out.println("\n\n�Qu� consulta SQL quieres realizar?");
			System.out.println("1.- Listar todos los parques de una determinada ciudad por nombre.");
			System.out.println("2.- Listar todos los parques de una cierta comunidad aut�ma por nombre.");
			System.out.println("3.- A�adir un parque a una determinada ciudad (por nombre de ciudad), si la ciudad no existe no se a�ade y se informa de ello.");
			System.out.println("4.- Actualizar la informaci�n de un parque (primero se pedir� al usuario el nombre del parque que quiere actualizar, se buscar� en la base de datos y se mostrar�n los datos del parque (nombre, nombre ciudad, extensi�n) y a continuaci�n se pedir�n los 3 nuevos datos (nombre, nombre ciudad y extensi�n) y se har� la actualizaci�n.");
			System.out.println("5.- Seleccionar todos los parques cuyo nombre contenga una determinada cadena.");
			System.out.println("6.- Devolver el n�mero de parques de una determinada ciudad que tengan una extensi�n individual mayor que la que desee el usuario.");
			System.out.println("7.- Borrar todos los parques de una determinada ciudad por nombre.");
			System.out.println("8.- Listar el nombre de todas las ciudades que contengan parques cuya suma total de su extensi�n, sea mayor que la que quiera el usuario.");
			System.out.print("N�mero: ");
			System.out.println("\n\n");
			
			num = sc.nextInt();
				
				switch (num) {
				
				case 1:	
					
					ParquesDao parque1 = new ParquesDao();
					parque1.listarParquesPorIdCiudad();
					
					break;
					
				case 2:
					
					ParquesDao parque2 = new ParquesDao();
					parque2.listarParquesPorCCAA();
					
					break;
					
				case 3:	
					System.out.println("Inserta el nombre de la ciudad, por favor:");
					String nombreCiudad = sc.next();
					
					CiudadesDao ciudad = new CiudadesDao();
					
					if (ciudad.getCiudad(nombreCiudad) == null) {
						System.out.println("No existe esa ciudad");
					} else {
						System.out.println("Inserta el nombre del parque, por favor");
						String nombreParque = sc.next();
						
						System.out.println("Inserta la extensi�n del parque, por favor");
						String extensionParque = sc.next();
						
						Parques parque = new Parques();
						parque.setExtension(extensionParque);
						parque.setNombreParque(nombreParque);
						ParquesDao parque3 = new ParquesDao();
						parque3.a�adir(parque);									
					}
					
					break;
				case 4:
					break;
				case 5:				
					break;
				case 6:
					break;
				case 7:				
					break;
				case 8:
					break;
				

				default:
					System.out.println("No has seleccionado un n�mero de la lista");
					break;
				}
		
		
	}

}
