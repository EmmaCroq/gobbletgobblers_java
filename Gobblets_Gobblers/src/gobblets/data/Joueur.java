package gobblets.data;

import java.util.ArrayList;
import gobblets.interaction.Action;
import gobblets.logic.PiecePasDisponibleException;

public abstract class Joueur {

	private final String nom;
	private final Couleur couleur;
	private ArrayList<Piece> MaisonJoueur;
	
	public Joueur(String nomJoueur, Couleur couleurJoueur){
		this.nom = nomJoueur;
		this.couleur = couleurJoueur;
		MaisonJoueur = new ArrayList<Piece>();
		ajoutePiece(new Piece(Taille.PETITE, this.couleur));
		ajoutePiece(new Piece(Taille.PETITE, this.couleur));
		ajoutePiece(new Piece(Taille.MOYENNE, this.couleur));
		ajoutePiece(new Piece(Taille.MOYENNE, this.couleur));
		ajoutePiece(new Piece(Taille.GRANDE, this.couleur));
		ajoutePiece(new Piece(Taille.GRANDE, this.couleur));
	}
	
	public ArrayList<Piece> getPieces() { // méthode qui retourne les pièces que l'utilisateur n'a pas encore placées
		return MaisonJoueur;
	}
	
	public void setPieces(ArrayList<Piece> piece) {
		this.MaisonJoueur = piece;
	}
	
	public void ajoutePiece(Piece piecee) { // méthode qui ajoute une pièce à la maison du joueur, en affectant la couleur du joueur au champ couleur de la pièce
		MaisonJoueur.add(piecee);
	}
	
	public boolean aPiece(Piece piecee) { // teste si la pièce passée en paramètre appartient au joueur
		for(int i=0;i<MaisonJoueur.size();i++) {
			if(piecee == MaisonJoueur.get(i)) return true;
		}
		return false;
	}
	
	public String getNom() {
		return nom;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public abstract Action choisirAction(Plateau plateau);
	
	public Piece enlevePiece(Taille taille) throws PiecePasDisponibleException { // enlève une pièce d'une taille donnée de la maison du joueur
		for(int i=0;i<MaisonJoueur.size();i++) {
			if(MaisonJoueur.get(i).getTaille() == taille) { 
				return MaisonJoueur.remove(i);
			}
		}
		throw new PiecePasDisponibleException();
	}
	
	public boolean aPieceDeTaille(Taille taille) { // teste si la joueur a au moins une pièce d'une certain taille dans sa maison
		for(int i=0;i<MaisonJoueur.size();i++) {
			if(MaisonJoueur.get(i).getTaille() == taille) return true;	
		}
		return false;
	}
}
