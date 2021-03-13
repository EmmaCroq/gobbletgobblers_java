package gobblets.logic;

import gobblets.ihm.Erreur;

public class PiecePasDisponibleException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PiecePasDisponibleException() {
		
	}
	
	public PiecePasDisponibleException(String s) {
			super(s);
	}
	
	public PiecePasDisponibleException(Throwable t) {
		
	}
	
	public PiecePasDisponibleException(String s, Throwable t) {
		
	}
	
	public PiecePasDisponibleException(String s, Throwable t, boolean a, boolean b) {
		
	}
	
	public PiecePasDisponibleException(Erreur e) {
		
	}
	
	public long getSerialversionuid() {
		return PiecePasDisponibleException.serialVersionUID;
	}
	
	public Erreur getErreur() {
		return Erreur.PASDEPIECEDISPONIBLE;
	}
}
