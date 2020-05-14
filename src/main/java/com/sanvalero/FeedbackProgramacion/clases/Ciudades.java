package com.sanvalero.FeedbackProgramacion.clases;

public class Ciudades { // Beans o Pojos
	
	private String idCiudad;
	private String nombreCiudad;
	private String ccaa;
	
	
	
	public Ciudades(String idCiudad, String nombreCiudad, String ccaa) {
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
		this.ccaa = ccaa;
	}
	
	public String getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public String getCcaa() {
		return ccaa;
	}
	public void setCcaa(String ccaa) {
		this.ccaa = ccaa;
	}
	
	
	@Override
	public String toString() {
		return "Ciudades (" + "idCiudad = " +idCiudad+ "nombreCiudad = " + nombreCiudad+ "comunidadAutonoma = " +ccaa;
	}
	

}
