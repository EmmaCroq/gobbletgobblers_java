package gobblets.data;

public class Piece {
	
	public Taille taillePiece;
	public Couleur couleurPiece;
	
	public Piece(Taille taillePiece, Couleur couleurPiece){
		this.taillePiece = taillePiece;
		this.couleurPiece = couleurPiece;
	}
	
	public Taille getTaille() {
		return this.taillePiece;
	}
	
	public Couleur getCouleur() {
		return this.couleurPiece;
	}
	
	public void setCouleur(Couleur couleurPiece) {
		this.couleurPiece = couleurPiece;
	}
	
	public boolean appartientA(Joueur joueur) { // teste si la pièce appartient au joueur passé en paramètre
		return joueur.aPiece(this);
	}
}
