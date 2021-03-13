package gobblets.data;

import java.util.ArrayList;

import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Plateau{

    private Case[][] grid;
    private static int GRID_SIZE = 3;
//    private ArrayList<Piece> maisonJoueur1 = new ArrayList<Piece>();
//    private ArrayList<Piece> maisonJoueur2 = new ArrayList<Piece>();
    public Joueur J1;
    public Joueur J2;
    private ArrayList<Piece> piece = new ArrayList<Piece>();
    
	public static Plateau initPlateau(Joueur J1, Joueur J2) { // crée une instance de Plateau et ajoute des pièces aux maisons des deux joueurs
		Plateau lPlateau = new Plateau(J1, J2);
	    	for(int i = 0; i < GRID_SIZE; i++){
	    		for(int j = 0; j < GRID_SIZE; j++){
	    			lPlateau.grid[i][j] = new Case();
//	    			lPlateau.grid[i][j].placePiece(new gobblets.data.Piece(Taille.MOYENNE,  Couleur.ROUGE)); // Test
	            }
	        }
	    	
	    return lPlateau;
	}
	
    public Plateau(Joueur J1, Joueur J2){
    	this.J1 = J1;
    	this.J2 = J2;
    	grid = new Case[3][3];
    }

    public Case[][] getPlateau(){
        return grid;
    }
    
    private Case[] getLigne(int ligne){
    	Case[] lLigne = new Case[GRID_SIZE];
        for(int i=0;i<grid.length;i++) {
        	lLigne[i] = grid[i][ligne];
        }
        return lLigne;
    }
    
    private Case[] getColonne(int colonne){
    	Case[] lColonne = new Case[GRID_SIZE];
        for(int i=0;i<grid.length;i++) {
        	lColonne[i] = grid[colonne][i];
        }
        return lColonne;
    }
    
    private Case[] getDiagonalePrincipale() {
    	Case[] diagonalePrincipale = new Case[GRID_SIZE];
    	for(int i=0; i<grid.length; i++) {
    		diagonalePrincipale[i] = grid[i][i];
    	}
    	return diagonalePrincipale;
    }
    
    private Case[] getDiagonaleSecondaire() {
    	Case[] diagonaleSecondaire = new Case[GRID_SIZE];
    	int j=GRID_SIZE-1;
    	for(int i=0; i<grid.length; i++) {
    		diagonaleSecondaire[i] = grid[i][j];
    		j--;
    	}
    	return diagonaleSecondaire;
    }
    
    public ArrayList<Piece> getMaisonJoueur1(){
//    	return maisonJoueur1;
    	return this.J1.getPieces();
    }
    
    public ArrayList<Piece> getMaisonJoueur2(){
//    	return maisonJoueur2;
    	return this.J2.getPieces();
    }
    
   public void placePiece(Piece nomPiece, int ligne, int colonne) throws CaseBloqueeException{ //met une pièce à une position précise dans le plateau
    	grid[colonne][ligne].placePiece(nomPiece);
    }
    
    public Piece enlevePiece(int ligne, int colonne) throws PiecePasDisponibleException{ //enlève la plus grande pièce d'une position précise
    	return grid[colonne][ligne].enlevePiece();
    }
    
    public Piece plusGrandePiece(int ligne, int colonne) { // récupère la référence vers la plus grande pièce stockée dà une position précise, sans l'enlever
		return piece.get(piece.size()-1);
	}
   
    public Couleur verifierLigne(int numeroLigne) { // verifie si toutes les cases d'une ligne sont contrôlées par des pièces de la même couleur
    	Couleur[] couleur = new Couleur[grid.length]; //initialisation d'un tableau de couleur de taille 3
    	for(int i=0;i<grid.length; i++) { //boucle permettant d'affecter une couleur à chaque case du tableau
    		couleur[i] = getLigne(numeroLigne)[i].plusGrandePiece().getCouleur(); // 
    	}
    	if(couleur[0] == couleur[1] && couleur[1] == couleur[2]) { //condition permettant de vérifier que les 3 cases possèdent la même couleur
    		return couleur[0]; //si oui, on return la couleur identique des 3 cases
    	}
    	return null;//si non, on return null
    }
    
    public Couleur verifierColonne(int numeroColonne) { // verifie si toutes les cases d'une colonne sont contrôlées par des pièces de la même couleur
    	Couleur[] couleur = new Couleur[grid.length]; //initialisation d'un tableau de couleur de taille 3
    	for(int i=0;i<grid.length; i++) { //boucle permettant d'affecter une couleur à chaque case du tableau
    		couleur[i] = getColonne(numeroColonne)[i].plusGrandePiece().getCouleur(); // 
    	}
    	if(couleur[0] == couleur[1] && couleur[1] == couleur[2]) { //condition permettant de vérifier que les 3 cases possèdent la même couleur
    		return couleur[0]; //si oui, on return la couleur identique des 3 cases
    	}
    	return null;//si non, on return null
    }
    
    public Couleur verifierDiagonale(char nomDiagonale) { // verifie si toutes les cases d'une diagonale sont contrôlées par des pièces de la même couleur
    	Couleur[] couleur = new Couleur[grid.length]; //initialisation d'un tableau de couleur de taille 3
    	if(nomDiagonale == 'P') {//condition permettant de séparer la diagonale Principale et Secondaire
    		for(int i=0;i<grid.length; i++) { //boucle permettant d'affecter une couleur à chaque case du tableau
        		couleur[i] = getDiagonalePrincipale()[i].plusGrandePiece().getCouleur(); // 
        	}
    	}
    	else if(nomDiagonale == 'S') {
    		for(int i=0;i<grid.length; i++) { //boucle permettant d'affecter une couleur à chaque case du tableau
        		couleur[i] = getDiagonaleSecondaire()[i].plusGrandePiece().getCouleur(); // 
        	}
    	}
    	if(couleur[0] == couleur[1] && couleur[1] == couleur[2]) { //condition permettant de vérifier que les 3 cases possèdent la même couleur
    		return couleur[0]; //si oui, on return la couleur identique des 3 cases
    	}
    	return null;//si non, on return null
    }
    /**
     * Permet de renvoyer l'etat du jeu, s'il y a un gagnant ou non.
     * @param j1
     * @param j2
     * @return Etat
     */
	public Etat verifierPartie(Joueur j1, Joueur j2) {
		int nj1 = 0, nj2 = 0;
		Couleur[] verif = new Couleur[8];
		verif[0] = verifierLigne(0);
		verif[1] = verifierLigne(1);
		verif[2] = verifierLigne(2);
		verif[3] = verifierColonne(0);
		verif[4] = verifierColonne(1);
		verif[5] = verifierColonne(2);
		verif[6] = verifierDiagonale('p');
		verif[7] = verifierDiagonale('s');
		for(int i=0 ; i<8 ; i++) {
			if(verif[i] == j1.getCouleur()) {
				nj1++;
			}
			else if(verif[i] == j2.getCouleur()) {
				nj2++;
			}
		}
		if(nj1>0 && nj2>0) {
			return Etat.MATCHNUL;
		}
		else if(nj1>0 && nj2==0) {
			return Etat.JOUEUR1GAGNE;
		}
		else if(nj2>0 && nj1==0) {
			return Etat.JOUEUR2GAGNE;
		}
		else {
			return Etat.JEUENCOURS;
		}
	}
	
}