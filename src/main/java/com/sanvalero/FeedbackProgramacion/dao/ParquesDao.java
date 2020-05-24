package com.sanvalero.FeedbackProgramacion.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.sanvalero.FeedbackProgramacion.interfaces.IDAO;
import com.sanvalero.FeedbackProgramacion.modelos.Parques;


/**
 * @author alber
 *
 */
public class ParquesDao extends BaseDAO implements IDAO<Parques, String>{
	
	/**
	 *  PREGUNTA 1 .- Lista los parques de la ciudad que elija el usuario por teclado
	 *@author alber
	 *@param nombre de la ciudad
	 *
	 */
	public void listarParquesPorNombreCiudad(String nomCiudad) throws SQLException { // Pregunta 1
		
		final String SELECT_POR_NCIUDAD = "SELECT NOMBRE_PARQUE FROM PARQUES P INNER JOIN CIUDADES C ON C.ID_CIUDAD = P.ID_CIUDAD WHERE NOMBRE_CIUDAD = ?";
		
		this.conectar();
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_NCIUDAD);
		ps.setString(1, nomCiudad.toUpperCase()); // Lo convierto a mayusculas ya que en la bbdd está todo en mayúsculas
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Nombre parque ----> " + rs.getString(1));
		}
		
		ps.close();
		rs.close();
		this.desconectar();
		
	}
	
	/**
	 *  PREGUNTA 2 .- Lista los parques de una comunidad autónoma que elija el usuario por teclado
	 *@author alber
	 *@param comunidad autonoma 
	 *
	 */
	public void listarParquesPorCCAA(String comunidadAutonoma) throws SQLException{ // Pregunta 2
		
		final String SELECT_POR_CCAA = "SELECT P.NOMBRE_PARQUE FROM PARQUES P INNER JOIN CIUDADES C ON P.ID_CIUDAD=C.ID_CIUDAD WHERE CCAA = ?";
		this.conectar();
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_CCAA);
		ps.setString(1, comunidadAutonoma.toUpperCase());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("Nombre parque ----> "+rs.getString(1));
		}
		
		ps.close();
		rs.close();
		this.desconectar();
		
		
	}
	
	
	/**
	 * PREGUNTA 3 .- Añadir un parque
	 *@author alber
	 *@param objeto parque
	 *
	 */
	public int añadir(Parques p) throws SQLException {
		String query = "INSERT INTO PARQUES (ID_PARQUE, NOMBRE_PARQUE, EXTENSION, ID_CIUDAD) VALUES (?, ?, ?, ?)";
		this.conectar();

		PreparedStatement ps = conexion.prepareStatement(query);
			ps.setInt(1, p.getIdParque());
			ps.setString(2, p.getNombreParque());
			ps.setString(3, p.getExtension());
			ps.setInt(4, p.getIdCiudad());
			
		int n = ps.executeUpdate();
		
		ps.close();
		
		this.desconectar();
		
		return n;
	}
	
	
	/**
	 * PREGUNTA 4.- Comprueba si el parque existe, duevuelve true en caso de existir y false si no existe
	 *@author alber
	 *@param nombre parque
	 *
	 */	
	public boolean getParque (String nombreParque) throws SQLException{
		
		boolean resultado;
		final String SELECT_POR_NPARQUE = "SELECT * FROM PARQUES WHERE NOMBRE_PARQUE = ?";
		
		this.conectar();
		
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_NPARQUE);
		ps.setString(1, nombreParque);
		
		ResultSet result = ps.executeQuery();
		
		if (result.next()) {
			resultado = true;
		} else {
			resultado = false;
		}
		
		ps.close();
		result.close();
		this.desconectar();
		
		return resultado;
		
	}
	
	
	
	/**
	 * PREGUNTA 4.- Imprime por pantalla los datos del paque
	 *@author alber
	 *@param nombre parque
	 *
	 */
	public void listarParquePorNombreParque(String nombreParque) throws SQLException {
		this.conectar();
		final String SELECT_POR_NPARQUE = "SELECT NOMBRE_PARQUE, NOMBRE_CIUDAD, EXTENSION FROM PARQUES P INNER JOIN CIUDADES C ON C.ID_CIUDAD = P.ID_CIUDAD WHERE NOMBRE_PARQUE = ?";
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_NPARQUE);
		ps.setString(1, nombreParque);
		ResultSet result = ps.executeQuery();
		
		while (result.next()) {
			System.out.println("NOMBRE_PARQUE: "+result.getString(1));
			System.out.println("NOMBRE_CIUDAD: "+result.getString(2));
			System.out.println("EXTENSION: "+result.getString(3));
		}
		
		ps.close();
		result.close();
		this.desconectar();
		
	}
	
	
	
	/**
	 * PREGUNTA 4.- Actualiza el parque con los datos del usuario que hay en el objeto parque creado
	 *@author alber
	 *@param objeto parque 
	 *
	 */
	public void actualizar(Parques p) throws SQLException {
		
		String query = "UPDATE PARQUES SET NOMBRE_PARQUE = ?, EXTENSION = ?, NOMBRE_CIUDAD = ? WHERE NOMBRE_PARQUE = ?";
		this.conectar();
		
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setString(1, p.getNombreParque());
		ps.setString(2, p.getExtension());
		ps.setInt(3, p.getIdCiudad());
		ps.setString(4, p.getNombreParque());
		
		ps.executeUpdate();
		
		this.desconectar();
	}
	

	
	
	
	/**
	 * PREGUNTA 5.- Lista los parques que contienen una cadena de texo
	 *@author alber
	 *@param cadena de texto
	 
	 */	
	public void listarParquePorCadena(String cadena) throws SQLException{
		
		this.conectar();
		
		final String SELECT_POR_CADENA = "SELECT * FROM PARQUES WHERE NOMBRE_PARQUE LIKE '%"+cadena.toUpperCase()+"%'";
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_CADENA);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("ID_PARQUE: " + rs.getInt(1));
			System.out.println("NOMBRE_PARQUE: " + rs.getString(2));
			System.out.println("EXTENSION: " + rs.getString(3));
			System.out.println("ID_CIUDAD: " + rs.getInt(4));
		}
		
		ps.close();
		rs.close();		
		this.desconectar();
		
	}
	
	
	
	/**
	 * PREGUNTA 6.- Lista los parques de una ciudad que tengan una extensión mayor que la elegida por el usuario
	 *@author alber
	 *@param extensión
	 *
	 */	
	public void listarNumeroParquesConMayorExtension(String extension) throws SQLException{
		
		final String NUMERO_PARQUES = "SELECT COUNT(*) AS NUMERO_DE_PARQUES FROM PARQUES P INNER JOIN CIUDADES C ON C.ID_CIUDAD = P.ID_CIUDAD WHERE C.ID_CIUDAD = 1 AND P.EXTENSION > ?";
		// En esta sentencia el ID_CIUDAD no se pide al usuario, solo la extensión
		
		this.conectar();
		
		PreparedStatement ps = conexion.prepareStatement(NUMERO_PARQUES);
		ps.setString(1, extension); // Parametro que le pasamos al llamar al método, será el dato que introduzca el usuario por teclado
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			System.out.println("Número de parque con extensión mayor a "+extension+ " ---> " + rs.getInt(1));
		}
		
		ps.close();
		rs.close();
		this.desconectar();
	}
	
	
	
	/**
	 * PREGUNTA 7.- Comprueba que la ciudad exista
	 *@author alber
	 *@param nombre ciudad
	 *
	 */
	public boolean comprobarParquesPorNombreCiudad(String nombreCiudad) throws SQLException {
		
		boolean resultado;
		final String SELECT_POR_IDCIUDAD = "SELECT * FROM PARQUES P INNER JOIN CIUDADES C ON P.ID_CIUDAD = C.ID_CIUDAD WHERE NOMBRE_CIUDAD = ?";
		
		this.conectar();
		PreparedStatement ps = conexion.prepareStatement(SELECT_POR_IDCIUDAD);
		ps.setString(1, nombreCiudad);;
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			resultado = true;
		} else {
			resultado = false;
		}
		
		return resultado;
	}

	public List<Parques> findAll(Parques p) throws SQLException{

		
		return findAll(p);
	}
	
	
	
	/**
	 * PREGUNTA 7.- Borra los parques de la ciudad que elija el usuario
	 *@author alber
	 *@param nombre ciudad
	 *
	 */	
	public void borrarParquesPorCiudad(String nombreCiudad) throws SQLException{
		
		this.conectar();
		final String BORRAR_PARQUES = "DELETE * FROM PARQUES P WHERE P.ID_CIUDAD = (SELECT C.ID_CIUDAD FROM CIUDADES C WHERE C.NOMBRE_CIUDAD = ?)";
		PreparedStatement ps = conexion.prepareStatement(BORRAR_PARQUES);
		ps.setString(1, nombreCiudad);
		ps.executeUpdate();
		
		ps.close();
		this.desconectar();
		
	}
	
	
	


	public int borrar(String integer) {
		// TODO Auto-generated method stub
		return 0;
	}
	



}
