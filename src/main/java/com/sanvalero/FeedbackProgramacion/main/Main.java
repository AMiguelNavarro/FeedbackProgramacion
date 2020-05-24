package com.sanvalero.FeedbackProgramacion.main;

import java.sql.SQLException;
import java.util.Scanner;
import com.sanvalero.FeedbackProgramacion.dao.CiudadesDao;
import com.sanvalero.FeedbackProgramacion.dao.ParquesDao;
import com.sanvalero.FeedbackProgramacion.modelos.Parques;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		int num;
			
			System.out.println("�Qu� consulta SQL quieres realizar?");
			System.out.println("1.- Listar el nombre de los parques de una determinada ciudad");
			System.out.println("2.- Listar los parques de la comunidad aut�noma");
			System.out.println("3.- A�adir un parque a una determinada ciudad (por nombre de ciudad), si la ciudad no existe no se a�ade y se te informar� de ello");
			System.out.println("4.- Actualizar la informaci�n de un parque (primero se te pedir� el nombre del parque que quieres actualizar, se buscar� en la base de datos y se te mostrar�n los datos del parque (nombre, nombre ciudad, extensi�n) y a continuaci�n se te pedir�n los 3 nuevos datos (nombre, nombre ciudad y extensi�n) y se har� la actualizaci�n.");
			System.out.println("5.- Seleccionar todos los parques cuyo nombre contenga una determinada cadena.");
			System.out.println("6.- Devolver el n�mero de parques de una determinada ciudad que tengan una extensi�n individual mayor que la que desees");
			System.out.println("7.- Borrar todos los parques de una determinada ciudad por nombre.");
			System.out.println("8.- Listar el nombre de todas las ciudades que contengan parques cuya suma total de su extensi�n, sea mayor que la que digas");
			System.out.print("N�mero: ");
			num = sc.nextInt();
			
			
			System.out.println("\n");			
				
				switch (num) {
				
				case 1:	
					
					ParquesDao parque1 = new ParquesDao();
					System.out.println("Dime el nombre de la ciudad, por favor");
					String nombCiudad = sc.next();
					System.out.println("Los parques de " +nombCiudad+ " son: ");
					parque1.listarParquesPorNombreCiudad(nombCiudad);
					
					break;
					
				case 2:
					
					ParquesDao parque2 = new ParquesDao();
					System.out.println("Dime la comunidad aut�noma, por favor (Pon tildes donde se necesiten)");
					String comunidadAutonoma = sc.next();
					System.out.println("Los parques de " +comunidadAutonoma+ " son: ");
					parque2.listarParquesPorCCAA(comunidadAutonoma);
					
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
						
						System.out.println("Inserta la extensi�n del parque, por favor");
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
						parque3.a�adir(parque);		
						
						System.out.println("Parque a�adido con �xito");
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
						
						System.out.println("Introduce la nueva extensi�n del parque");
						String nuevaExtensionParque = sc.next();
						
						Parques nuevoParque = new Parques();
						nuevoParque.setNombreParque(nuevoNombreParque);
						nuevoParque.setNombreCiudad(nuevoNombreCiudad);
						nuevoParque.setExtension(nuevaExtensionParque);
						
						parque4.actualizar(nuevoParque); // Se hace el update
						System.out.println("informaci�n actualizada");
					}
					
					break;
					
				case 5:
					
					System.out.println("�Que cadena de texto debe contener el nombre del parque?");
					String cadena = sc.next();
					
					ParquesDao parque5 = new ParquesDao();
					parque5.listarParquePorCadena(cadena); // metodo que imprime por pantalla los datos del parque buscando por cadena
					
					break;
					
				case 6:
					
					System.out.println("Dime la extensi�n del parque, por favor ");
					String extension = sc.next();
					
					ParquesDao parque6 = new ParquesDao();
					parque6.listarNumeroParquesConMayorExtension(extension);
					
					break;
					
				case 7:
					
					System.out.println("�C�al es el nombre de la ciudad de la que quieres borrar los parques?");
					String nomCiudad = sc.next();
					
					ParquesDao parque7 = new ParquesDao();
					if (parque7.comprobarParquesPorNombreCiudad(nomCiudad) == false) {
						System.out.println("No existe esa ciudad, por lo que no hay parques que borrar");
					} else {
						parque7.borrarParquesPorCiudad(nomCiudad);
						System.out.println("Borrado realizado");
					}
										
					break;
				case 8:
					
					System.out.println("Dime la extensi�n por favor (Introduce un n�mero entero)");
					int ext = sc.nextInt();
					
					System.out.println("Estas son las ciudades con parques cuya suma total de extensi�n es mayor a " +ext);
					CiudadesDao ciudad8 = new CiudadesDao();
					ciudad8.listarCiudadesPorExtension(ext);
					break;
				

				default:
					System.out.println("No has seleccionado un n�mero de la lista");
					break;
				}
		sc.close(); // cierre del Scanner (Si no lo cierra me da un aviso de que nunca se cierra)
		
	}

}
