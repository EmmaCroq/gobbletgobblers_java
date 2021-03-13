package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.data.*;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

public class Anglais implements Dictionnaire {
	private HashMap<Couleur, String> couleurs;
	private HashMap<Taille, String> tailles;
	private HashMap<Etat, String> etats;
	private HashMap<ActionType, String> actions;
	private HashMap<Erreur, String> erreurs;
	private HashMap<Avertissement, String> avertissements;
	private HashMap<Menu, String> menus;

	public Anglais() {
		couleurs = new HashMap<Couleur, String>();
		couleurs.put(Couleur.BLEU, "blue");
		couleurs.put(Couleur.JAUNE, "yellow");
		couleurs.put(Couleur.ROUGE, "red");
		couleurs.put(Couleur.VERT, "green");
		couleurs.put(Couleur.WHITE, "white");
		
		tailles = new HashMap<Taille, String>();
		tailles.put(null, "none");
		tailles.put(Taille.GRANDE, "large");
		tailles.put(Taille.MOYENNE, "medium");
		tailles.put(Taille.PETITE, "small");
		
		etats = new HashMap<Etat, String>();
		etats.put(Etat.JEUENCOURS, "Game in progress");
		etats.put(Etat.JEUQUITTE, "Game left");
		etats.put(Etat.JOUEUR1GAGNE, "Player 1 win");
		etats.put(Etat.JOUEUR2GAGNE, "Player 2 win");
		etats.put(Etat.MATCHNUL, "Draw");

		actions = new HashMap<ActionType, String>();
		actions.put(ActionType.DEPLACER, "- 2 to MOVE a piece");
		actions.put(ActionType.PLACER, "- 1 to PLACE a piece");
		actions.put(ActionType.QUITTER, "- 3 to QUIT the game");
		
		erreurs = new HashMap<Erreur, String>();
		erreurs.put(Erreur.ARGUMENTINCORRECT, "incorrect argument");
		erreurs.put(Erreur.CASEBLOQUEE, "case blocked");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "incorrect diagonal");
		erreurs.put(Erreur.ORIGINEVIDE, "empty origin");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"piece unavailable");
		erreurs.put(Erreur.PASDEPIECEICI, "no piece here");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "size unavailable");
		erreurs.put(Erreur.PASTAPIECE, "not your piece");
		
		avertissements = new HashMap<Avertissement, String>();
		avertissements.put(Avertissement.CHOIXACTION, "choose action");
		avertissements.put(Avertissement.CHOIXDESTINATION, "choose your destination  (row then column)");
		avertissements.put(Avertissement.CHOIXMODE, "Please select a mode!");
		avertissements.put(Avertissement.CHOIXLANGUE, "Choose your langage :");
		avertissements.put(Avertissement.CHOIXORIGIN, "Choose origin  (row then column)");
		avertissements.put(Avertissement.CHOIXTAILLE, "Choose size (1='o' 2='x' 3='X') :");
		avertissements.put(Avertissement.COULEURJOUEUR, "select your color");
		avertissements.put(Avertissement.NOMJOUEUR, "enter your name :");
		avertissements.put(Avertissement.TONTOUR, "it's your turn !");
		avertissements.put(Avertissement.CHOIXNBJOUEUR, "Enter the number of player (1 or 2)");
		avertissements.put(Avertissement.SAISIRCOULEUR,  "If you enter something else, your color will be RED");
		avertissements.put(Avertissement.JOUEUR, "Player ");
		avertissements.put(Avertissement.CREER, "Credit: ");
		avertissements.put(Avertissement.REGLES, "       === Description of the project === \n \n \n" + 
				"This project aims to implement a two-player game, similar to the Tic-Tac-Toe game. The rules of the games are described below.\n" + 
				"The game is played by two players on a three by three square board, although variations can be played on larger boards.\n" + 
				"Each player has control over a set of six pieces whose owner is easily identifiable, for example by the shape or color of the piece.\n" + 
				"The pieces are of three different sizes (large, medium, small), each player having two of each size.\n" + 
				"During the game, the players alternately perform a movement which consists of: \n" + 
				"  -  add a piece from their collection to the table.\n" + 
				"  -  move one of its visible pieces already on the board to another box.\n" + 
				"A piece can be placed either on an empty box, or on a box containing only smaller pieces, regardless of the owner of the piece.\n" + 
				"In the latter case, the piece covers and hides the smallest pieces. When a piece placed on other pieces is moved by one square, the largest covered piece is revealed and can be played in a later round.\n" + 
				"The game is won by the first player who manages to make a visible line of his pieces across the board (on a line, column or diagonal, as in Tic-Tac-Toe.)");
		avertissements.put(Avertissement.CHOIXCOULEUR, "You cannot choose the same color!");
		avertissements.put(Avertissement.GAGNER, ", you have won !\n\n\n");
		avertissements.put(Avertissement.REJOUER, "Do you want to play again?\n");
		avertissements.put(Avertissement.OUI, "YES [0] ");
		avertissements.put(Avertissement.NON, "NO [1] ");
		avertissements.put(Avertissement.QUITTER, "Are you sure you want to leave? :");
		
		menus = new HashMap<Menu, String>();
		menus.put(Menu.MENU_NOUVEAU, "New menu");
		menus.put(Menu.MENU_AIDE, "Help menu");
		menus.put(Menu.MENU_APROPOS, "About menu");
		menus.put(Menu.MENU_ENREGISTRER, "Save menu");
		menus.put(Menu.MENU_FICHIER, "File menu");
		menus.put(Menu.MENU_LANGUE,"Language menu");
		menus.put(Menu.MENU_OUVRIR, "Open menu");
		menus.put(Menu.MENU_QUITTER, "Quit");
		menus.put(Menu.MENU_JVSJ, "Player VS Player");
		menus.put(Menu.MENU_JVSIA, "Player vs AI");
		menus.put(Menu.MENU_RETOUR, "Return");
		menus.put(Menu.MENU_CONTINUER, "Continue");
	}
	
	@Override
	public String couleur(Couleur c) {
		return couleurs.get(c);
	}
	@Override
	public String taille(Taille t) {
		return tailles.get(t);
	}
	@Override
	public String etat(Etat e) {
		return etats.get(e);
	}
	@Override
	public String action(ActionType a) {
		return actions.get(a);
	}
	@Override
	public String erreur(Erreur e) {
		return erreurs.get(e);
	}
	@Override
	public String avertissement(Avertissement a) {
		return avertissements.get(a);
	}
	@Override
	public String menu(Menu m) {
		return menus.get(m);
	}
}