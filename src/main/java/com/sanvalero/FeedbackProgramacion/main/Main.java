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
			
			System.out.println("\n\n¿Qué consulta SQL quieres realizar?");
			System.out.println("1.- Listar todos los parques de una determinada ciudad por nombre.");
			System.out.println("2.- Listar todos los parques de una cierta comunidad autóma por nombre.");
			System.out.println("3.- Añadir un parque a una determinada ciudad (por nombre de ciudad), si la ciudad no existe no se añade y se informa de ello.");
			System.out.println("4.- Actualizar la información de un parque (primero se pedirá al usuario el nombre del parque que quiere actualizar, se buscará en la base de datos y se mostrarán los datos del parque (nombre, nombre ciudad, extensión) y a continuación se pedirán los 3 nuevos datos (nombre, nombre ciudad y extensión) y se hará la actualización.");
			System.out.println("5.- Seleccionar todos los parques cuyo nombre contenga una determinada cadena.");
			System.out.println("6.- Devolver el número de parques de una determinada ciudad que tengan una extensión individual mayor que la que desee el usuario.");
			System.out.println("7.- Borrar todos los parques de una determinada ciudad por nombre.");
			System.out.println("8.- Listar el nombre de todas las ciudades que contengan parques cuya suma total de su extensión, sea mayor que la que quiera el usuario.");
			System.out.print("Número: ");
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
					
					if (ciudad.getCiudad(nombreCiudad) == false) {
						System.out.println("No existe esa ciudad");
					} else {
						System.out.println("Inserta el nombre del parque, por favor");
						String nombreParque = sc.next();
						
						System.out.println("Inserta la extensión del parque, por favor");
						String extensionParque = sc.next();
						
						System.out.println("Inserta el id del parque, por favor");
						int idParque = sc.nextInt();
						
						System.out.println("Inserta el id de la ciudad, por favor");
						int idCiudad = sc.nextInt();
						
						Parques parque = new Parques();
						parque.setExtension(extensionParque);
						parque.setNombreParque(nombreParque);
						parque.setIdParque(idParque);
						parque.setIdCiudad(idCiudad);
						
						ParquesDao parque3 = new ParquesDao();
						parque3.añadir(parque);									
					}
					
					break;
				case 4:
					
					System.out.println("Por favor introduce el nombre del parque a actualizar");
					String nombreParque = sc.next();
					
					ParquesDao parque4 = new ParquesDao();
					if (parque4.getParque(nombreParque) == false) { // getParque() comprueba que el parque exista
						System.out.println("El parque no existe, no se puede actualizar nada");
					} else {
						parque4.listarParquePorNombreParque(nombreParque); // se muestran por consola los datos del parque seleccionado
						
						System.out.println("\nIntroduce el nuevo nombre del parque");
						String nuevoNombreParque = sc.next();
						
						System.out.println("Introduce el nuevo nombre de la ciudad");
						String nuevoNombreCiudad = sc.next();
						
						System.out.println("Introduce la nueva extensión del parque");
						String nuevaExtensionParque = sc.next();
						
						Parques nuevoParque = new Parques();
						nuevoParque.setNombreParque(nuevoNombreParque);
						nuevoParque.setNombreCiudad(nuevoNombreCiudad);
						nuevoParque.setExtension(nuevaExtensionParque);
						
						parque4.actualizar(nuevoParque); // Se hace el update
					}
					
					break;
				case 5:
					
					System.out.println("¿Que cadena de texto debe contener el nombre del parque?");
					String cadena = sc.next();
					
					ParquesDao parque5 = new ParquesDao();
					parque5.listarParquePorCadena(cadena); // metodo que imprime por pantalla los datos del parque buscando por cadena
					
					break;
				case 6:
					
					System.out.println("Dime la extensión del parque, por favor ");
					String extension = sc.next();
					
					break;
				case 7:				
					break;
				case 8:
					break;
				

				default:
					System.out.println("No has seleccionado un número de la lista");
					break;
				}
		
		
	}

}
