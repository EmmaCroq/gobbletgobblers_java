package gobblets.ihm.texte;

import gobblets.data.Couleur;
import gobblets.data.Taille;

public class Piece { // pour les maisons
	
	private gobblets.data.Piece contenu;
	
	public Piece(gobblets.data.Piece pieceAAfficher) {
		this.contenu=pieceAAfficher;
	}
	
	public String getRepresentationTextuelle() {
		String symbole = " ";
		if (contenu.getTaille()==Taille.PETITE) {
			symbole = "o";
		} else if (contenu.getTaille()==Taille.MOYENNE) {
			symbole = "x";
		} else if (contenu.getTaille()==Taille.GRANDE) {
			symbole = "X";
		}
		
		if (contenu.getCouleur() != null)
			symbole = contenu.getCouleur().getCode() + symbole + Couleur.WHITE.getCode();
		
		return symbole;
	}
}
