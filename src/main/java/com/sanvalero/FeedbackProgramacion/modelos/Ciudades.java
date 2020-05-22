package com.sanvalero.FeedbackProgramacion.modelos;

public class Ciudades { // Beans o Pojos
	
	private int idCiudad;
	private String nombreCiudad;
	private String ccaa;
	
	
	public Ciudades() {
	}

	public Ciudades(int idCiudad, String nombreCiudad, String ccaa) {
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
		this.ccaa = ccaa;
	}
	
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
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
		return "Ciudades (" + "idCiudad = " +idCiudad+ ", nombreCiudad = " + nombreCiudad+ ", comunidadAutonoma = " +ccaa+ ")";
	}
	

}
