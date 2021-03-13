package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.data.*;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

public class Francais implements Dictionnaire{
	private HashMap<Couleur, String> couleurs;
	private HashMap<Taille, String> tailles;
	private HashMap<Etat, String> etats;
	private HashMap<ActionType, String> actions;
	private HashMap<Erreur, String> erreurs;
	private HashMap<Avertissement, String> avertissements;
	private HashMap<Menu, String> menus;
	
	public Francais() {
		couleurs = new HashMap<Couleur, String>();
		couleurs.put(Couleur.BLEU, "bleu");
		couleurs.put(Couleur.JAUNE, "jaune");
		couleurs.put(Couleur.ROUGE, "rouge");
		couleurs.put(Couleur.VERT, "vert");
		couleurs.put(Couleur.WHITE, "blanc");
		
		tailles = new HashMap<Taille, String>();
		tailles.put(null, "aucune");
		tailles.put(Taille.GRANDE, "grande");
		tailles.put(Taille.MOYENNE, "moyenne");
		tailles.put(Taille.PETITE, "petite");
		
		etats = new HashMap<Etat, String>();
		etats.put(Etat.JEUENCOURS, "jeu en cours");
		etats.put(Etat.JEUQUITTE, "jeu quitte");
		etats.put(Etat.JOUEUR1GAGNE, "joueur 1 a gagne");
		etats.put(Etat.JOUEUR2GAGNE, "joueur 2 a gagne");
		etats.put(Etat.MATCHNUL, "match nul");

		actions = new HashMap<ActionType, String>();
		actions.put(ActionType.DEPLACER, "- 2 pour DEPLACER une piece");
		actions.put(ActionType.PLACER, "- 1 pour PLACER une piece");
		actions.put(ActionType.QUITTER, "- 3 pour QUITTER le jeu");
		
		erreurs = new HashMap<Erreur, String>();
		erreurs.put(Erreur.ARGUMENTINCORRECT, "Argument incorrect");
		erreurs.put(Erreur.CASEBLOQUEE, "Case bloquee");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "Diagonale incorrecte");
		erreurs.put(Erreur.ORIGINEVIDE, "L'origine est vide");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE,"Pas de piece disponible");
		erreurs.put(Erreur.PASDEPIECEICI, "Pas de piece ici");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "Taille indisponible");
		erreurs.put(Erreur.PASTAPIECE, "Pas ta piece");
		
		avertissements = new HashMap<Avertissement, String>();
		avertissements.put(Avertissement.CHOIXACTION, "choisis ton action :");
		avertissements.put(Avertissement.CHOIXDESTINATION, "choisis ta destination (ligne puis colonne)");
		avertissements.put(Avertissement.CHOIXMODE, "Veuillez selectionner un mode !");
		avertissements.put(Avertissement.CHOIXLANGUE, "Choisissez votre langue :");
		avertissements.put(Avertissement.CHOIXORIGIN, "Choisis ton origine (ligne puis colonne) :");
		avertissements.put(Avertissement.CHOIXTAILLE, "Choisis ta taille (1='o' 2='x' 3='X') :");
		avertissements.put(Avertissement.COULEURJOUEUR, "Saisis ta couleur :");
		avertissements.put(Avertissement.NOMJOUEUR, "Saisis ton nom");
		avertissements.put(Avertissement.TONTOUR, "a toi de jouer !");
		avertissements.put(Avertissement.CHOIXNBJOUEUR, "Saisissez le nombre de joueur (1 ou 2)");
		avertissements.put(Avertissement.SAISIRCOULEUR,  "Si vous saisissez autre chose, votre couleur sera le ROUGE");
		avertissements.put(Avertissement.JOUEUR, "Joueur ");
		avertissements.put(Avertissement.CREER, "Crédit : ");
		avertissements.put(Avertissement.REGLES, "       ===Description du projet===     \n\n" +
				"Ce projet vise à implémenter un jeu à deux joueurs, proche du jeu Tic-Tac-Toe. Les règles des jeux sont décrites ci-dessous. \n" +
				"Le jeu est joué par deux joueurs sur un plateau de trois par trois carrés, bien que des variantes puissent être jouées sur des plateaux plus grands. \n" +
				"Chaque joueur a le contrôle d'un ensemble de six pièces dont le propriétaire est facilement identifiable, par exemple par la forme ou la couleur de la pièce. \n"+
				"Les pièces sont de trois tailles différentes (grande, moyenne, petite), chaque joueur en ayant deux de chaque taille.\n"+
				"Au cours du jeu, les joueurs effectuent alternativement un mouvement qui consiste à: \n"+
				"	-	ajouter une pièce de leur collection au tableau.\n"+
				"	-	déplacer une de ses pièces visibles déjà sur le plateau vers une autre case.\n"+
				"Une pièce peut être placée soit sur une case vide, soit sur une case contenant uniquement des pièces plus petites, quel que soit le propriétaire de la pièce.\n"+
				"Dans ce dernier cas, la pièce recouvre et cache les plus petites pièces. Lorsqu'une pièce placée sur d'autres pièces est déplacée d une case, la plus grande pièce couverte est révélée et peut être jouée dans un tour ultérieur.\n"+
				"Le jeu est gagné par le premier joueur qui parvient à faire une ligne visible de ses pièces à travers le plateau (sur une ligne, une colonne ou une diagonale, comme pour Tic-Tac-Toe.)\n\n" );
		avertissements.put(Avertissement.CHOIXCOULEUR, "Vous ne pouvez pas choisir la même couleur ! ");
		avertissements.put(Avertissement.GAGNER, ", vous avez gagné\n\n\n");
		avertissements.put(Avertissement.REJOUER, "Voulez-vous rejouer?\n");
		avertissements.put(Avertissement.OUI, "OUI [0] ");
		avertissements.put(Avertissement.NON, "NON [1] ");
		avertissements.put(Avertissement.QUITTER, "Etes-vous sur de vouloir quitter? : ");
		
		menus = new HashMap<Menu, String>();
		menus.put(Menu.MENU_NOUVEAU, "Nouveau menu");
		menus.put(Menu.MENU_AIDE, "Menu aide");
		menus.put(Menu.MENU_APROPOS, "Menu a propos");
		menus.put(Menu.MENU_ENREGISTRER, "Menu enregistrer");
		menus.put(Menu.MENU_FICHIER, "Menu fichier");
		menus.put(Menu.MENU_LANGUE,"Menu langue");
		menus.put(Menu.MENU_OUVRIR, "Menu ouvrir");
		menus.put(Menu.MENU_QUITTER, "Quitter");
		menus.put(Menu.MENU_JVSJ, "Joueur VS Joueur");
		menus.put(Menu.MENU_JVSIA, "Joueur VS IA");
		menus.put(Menu.MENU_RETOUR, "Retour");
		menus.put(Menu.MENU_CONTINUER, "Continuer");
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
