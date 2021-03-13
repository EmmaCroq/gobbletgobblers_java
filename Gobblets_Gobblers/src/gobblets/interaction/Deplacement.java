package gobblets.interaction;

import gobblets.data.*;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Deplacement extends Action{
	private Case avant;
	private Case apres;

	public Deplacement(Case avant, Case apres) {
		this.avant = avant;
		this.apres = apres;
	}
	
	public Case getOrigin() {
		return this.avant;
	}
	
	public Case getDestination() {
		return this.apres;
	}
	
	public boolean verifier(Joueur joueur) throws  PiecePasDisponibleException, CaseBloqueeException{
		//vérifie si l'action peut être appliquée par le joueur qui tente de la faire
		if(this.avant.plusGrandePiece().getCouleur() == joueur.getCouleur()) {
			if(this.apres.acceptePiece(this.avant.plusGrandePiece().getTaille()) == true) {
				return true;
			}
			else {
				throw new CaseBloqueeException("Tu ne peux pas deplacer la piece dans cette case");
			}
		}
		else {
			throw new PiecePasDisponibleException("La piece n'est pas disponible");
		}
	}
		

	
	public void appliquer(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException { 
		//applique l'action et change l'état du jeu
		Piece p = avant.enlevePiece();
		apres.placePiece(p);
	}
	
	public String toString() {
		return "Deplacement piece de la case : " + avant + " à la case : " + apres;
	}
	
}