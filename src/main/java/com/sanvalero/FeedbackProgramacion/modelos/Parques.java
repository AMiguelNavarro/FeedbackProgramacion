package com.sanvalero.FeedbackProgramacion.modelos;

public class Parques { // Bean
	
	private int idParque;
	private String nombreParque;
	private String extension;
	private int idCiudad;
	
	public Parques(int idParque, String nombreParque, String extension, int idCiudad) {
		this.idParque = idParque;
		this.nombreParque = nombreParque;
		this.extension = extension;
		this.idCiudad = idCiudad;
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
	
	

}
