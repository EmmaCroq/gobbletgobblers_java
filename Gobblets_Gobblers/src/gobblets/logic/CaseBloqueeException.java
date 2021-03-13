package gobblets.logic;

import gobblets.ihm.Erreur;

public class CaseBloqueeException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CaseBloqueeException() {
		
	}
	
	public CaseBloqueeException(String s) {
			
	}
	
	public CaseBloqueeException(Throwable t) {
		
	}
	
	public CaseBloqueeException(String s, Throwable t) {
		
	}
	
	public CaseBloqueeException(String s, Throwable t, boolean a, boolean b) {
		
	}
	
	public CaseBloqueeException(Erreur e) {
		
	}
	
	public long getSerialversionuid() {
		return CaseBloqueeException.serialVersionUID;
	}
	
	public Erreur getErreur() {
		return Erreur.CASEBLOQUEE;
	}
}