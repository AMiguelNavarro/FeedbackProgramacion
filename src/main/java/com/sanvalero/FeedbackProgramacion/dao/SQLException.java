package com.sanvalero.FeedbackProgramacion.dao;

public class SQLException extends Exception { // Clase para la excepciones

	public SQLException() {
		
	}
	
	public SQLException(String msjError) {
		super(msjError);
	}

}
