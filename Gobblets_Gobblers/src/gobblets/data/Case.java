package gobblets.data;

import java.util.ArrayList;

import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Case {
	
	private Piece[] pieceTaille;
	private ArrayList<Piece> piece = new ArrayList<Piece>();
	
	public Case(){ // initialise les références vers les trois pièces à null
		this.pieceTaille = new Piece[3];
		for(int i = 0; i<3 ; i++) {
		this.pieceTaille[i] = new Piece(null,Couleur.WHITE);
		this.pieceTaille[i].setCouleur(Couleur.WHITE);
	}}
	
	public boolean acceptePiece(Taille taille) { //teste si la case peut accepter une pièce d'une taille donnée
		if(piece.size() == 0) return true; //la piece est forcement accepte si la case est vide
		return taille.recouvre(piece.get(piece.size()-1)); // a revoir
	}
	
	public Piece enlevePiece() throws PiecePasDisponibleException{ // enleve la plus grande pièce de la case et retourne sa référence
		return piece.remove(piece.size()-1);
	}
	
	public void placePiece(Piece piecee) throws CaseBloqueeException { // place une pièce dans la case
		piece.add(piecee);
	}
	
	public Piece plusGrandePiece() { // retourne la référence vers la plus grande pièce, sans enlever la pièce
		if (piece.size()==0) {
			return new Piece(null, null);
		}
		return piece.get(piece.size()-1);
	}
	
	public String toString() {
		return "La plus grande piece de la case est : "+plusGrandePiece();
	}
}

//"== false" est remplac� par le "!"