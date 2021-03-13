package gobblets.interaction;

import gobblets.data.Case;
import gobblets.data.Couleur;
import gobblets.data.Joueur;
import gobblets.data.Piece;
import gobblets.data.Taille;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Placement extends Action{

	private Taille taille;
	private Case avant;
	public Couleur couleurPiece;
	
	public Placement(Taille taille, Case avant) {
		this.taille = taille;
		this.avant = avant;	
	}
	
	public Taille getTaille() {
		return this.taille;
	}
	
	public Case getDestination() {
		return avant;
	}
	
	public boolean verifier(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		// vérifie si l'action peut être appliquée par le joueur qui tente de la faire
		if(avant.acceptePiece(this.getTaille()) == true) {
			if(joueur.aPieceDeTaille(this.getTaille()) == true) {
				return true;
			}
			else {
				throw new PiecePasDisponibleException("La piece n'est pas disponible");
			}
		}
		else {
			throw new CaseBloqueeException("Tu ne peux pas placer la piece dans cette case");
		}
	}
	
	public void appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException{
		//applique l'action et change l'état du jeu
		Piece p = new Piece(taille,couleurPiece);
//		lPlateau.grid[i][j].placePiece(new gobblets.data.Piece(Taille.MOYENNE,  Couleur.ROUGE))
		p.setCouleur(joueur.getCouleur());
		joueur.enlevePiece(this.taille);
		avant.placePiece(p);
	}
	
	public String toString() {
		return "Le joueur souhaite placer une piece de taille : " + taille + ", dans la case numéro : " + avant;
	}

}
