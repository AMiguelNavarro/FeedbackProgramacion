package com.sanvalero.FeedbackProgramacion.modelos;

public class Parques { // Bean
	
	private int idParque;
	private String nombreParque;
	private String extension;
	private int idCiudad;
	private String nombreCiudad;
	
	
	
	public Parques() {
	}

	public Parques(int idParque, String nombreParque, String extension, int idCiudad, String nombreCiudad) {
		this.idParque = idParque;
		this.nombreParque = nombreParque;
		this.extension = extension;
		this.idCiudad = idCiudad;
		this.nombreCiudad = nombreCiudad;
	}
	
	public int getIdParque() {
		return idParque;
	}
	public void setIdParque(int idParque) {
		this.idParque = idParque;
	}
	public String getNombreParque() {
		return nombreParque;
	}
	public void setNombreParque(String nombreParque) {
		this.nombreParque = nombreParque;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
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
	
	

}
