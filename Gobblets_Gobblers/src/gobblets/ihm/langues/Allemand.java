package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.data.*;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

public class Allemand implements Dictionnaire{
	private HashMap<Couleur, String> couleurs;
	private HashMap<Taille, String> tailles;
	private HashMap<Etat, String> etats;
	private HashMap<ActionType, String> actions;
	private HashMap<Erreur, String> erreurs;
	private HashMap<Avertissement, String> avertissements;
	private HashMap<Menu, String> menus;
	
	public Allemand() {
		couleurs = new HashMap<Couleur, String>();
		couleurs.put(Couleur.BLEU, "blau");
		couleurs.put(Couleur.JAUNE, "gelb");
		couleurs.put(Couleur.ROUGE, "rot");
		couleurs.put(Couleur.VERT, "grun");
		couleurs.put(Couleur.WHITE, "weiss");
		
		tailles = new HashMap<Taille, String>();
		tailles.put(null, "keine"); 
		tailles.put(Taille.GRANDE, "gross");
		tailles.put(Taille.MOYENNE, "durchschnitt");
		tailles.put(Taille.PETITE, "klein");
		
		etats = new HashMap<Etat, String>();
		etats.put(Etat.JEUENCOURS, "Gerade stattfindendes Spiel");
		etats.put(Etat.JEUQUITTE, "Spiel ubrig");
		etats.put(Etat.JOUEUR1GAGNE, "Spieler 1 hat gewonnen");
		etats.put(Etat.JOUEUR2GAGNE, "Spieler 2 hat gewonnen");
		etats.put(Etat.MATCHNUL, "zeichnen");

		actions = new HashMap<ActionType, String>();
		actions.put(ActionType.DEPLACER, "bawegen");
		actions.put(ActionType.PLACER, "ort");
		actions.put(ActionType.QUITTER, "geh");
		
		erreurs = new HashMap<Erreur, String>();
		erreurs.put(Erreur.ARGUMENTINCORRECT, "falsches Argument");
		erreurs.put(Erreur.CASEBLOQUEE, "blockierte Box");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "falsche Diagonale");
		erreurs.put(Erreur.ORIGINEVIDE, "leerer Ursprung");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Kein Teil verfugbar");
		erreurs.put(Erreur.PASDEPIECEICI, "hier ist kein Platz");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "Keine Grosse verfugbar");
		erreurs.put(Erreur.PASTAPIECE, "nicht dein Zimmer");
		
		avertissements = new HashMap<Avertissement, String>();
		avertissements.put(Avertissement.CHOIXACTION, "Wahlen Sie Ihre Aktion:");
		avertissements.put(Avertissement.CHOIXDESTINATION, "Wahle dein Ziel (Zeile dann Spalte)");
		avertissements.put(Avertissement.CHOIXORIGIN, "Wahle deinen Ursprung (Zeile dann Spalte):");
		avertissements.put(Avertissement.CHOIXLANGUE, "Wahle deine Sprache :");
		avertissements.put(Avertissement.CHOIXMODE, "Bitte wählen Sie einen Modus!");
		avertissements.put(Avertissement.CHOIXTAILLE, "Wahle deine Größe (1='o' 2='x' 3='X') :");
		avertissements.put(Avertissement.COULEURJOUEUR, "Schnapp dir deine Farbe");
		avertissements.put(Avertissement.NOMJOUEUR, "gib deinen Namen ein");
		avertissements.put(Avertissement.TONTOUR, "Du bist dran");
		avertissements.put(Avertissement.CHOIXNBJOUEUR, "Geben Sie die Anzahl der Spieler ein (1 oder 2)");
		avertissements.put(Avertissement.SAISIRCOULEUR,  "Wenn Sie etwas anderes eingeben, ist Ihre Farbe ROT");
		avertissements.put(Avertissement.JOUEUR, "Spieler ");
		avertissements.put(Avertissement.CREER, "Anerkennung : ");
		avertissements.put(Avertissement.REGLES, "       === Projektbeschreibung === \n \n \n" +
				"Dieses Projekt zielt darauf ab, ein Zwei-Spieler-Spiel in der Nähe des Tic-Tac-Toe-Spiels zu implementieren. Die Spielregeln werden unten beschrieben. \n" +
				"Das Spiel wird von zwei Spielern auf einem Drei-mal-Drei-Quadrat-Brett gespielt, obwohl Variationen auf größeren Brettern gespielt werden können. \n" +
				"Jeder Spieler hat die Kontrolle über einen Satz von sechs Teilen, deren Besitzer leicht zu identifizieren ist, beispielsweise anhand der Form oder Farbe des Teils. \n" +
				"Die Stücke haben drei verschiedene Größen (groß, mittel, klein), wobei jeder Spieler zwei von jeder Größe hat. \n" +
				"Während des Spiels führen die Spieler abwechselnd eine Bewegung aus, die besteht aus: \n" +
				"	-	 füge ein Stück aus ihrer Sammlung zur Tabelle hinzu. \n" +
				"	- 	Verschiebe eines der sichtbaren Teile, die sich bereits auf dem Brett befinden, in eine andere Box. \n" +
				"Ein Stück kann entweder auf eine leere Schachtel oder auf eine Schachtel gelegt werden, die nur kleinere Stücke enthält, unabhängig vom Besitzer des Stücks. \n" +
				"Im letzteren Fall bedeckt und versteckt das Stück die kleinsten Stücke. Wenn ein Stück, das auf andere Stücke gelegt wird, um ein Quadrat bewegt wird, wird das größte bedeckte Stück aufgedeckt und kann in einer späteren Runde gespielt werden. \n"+
				"Das Spiel wird von dem ersten Spieler gewonnen, der es schafft, eine sichtbare Linie seiner Figuren auf der ganzen Linie zu zeichnen (auf einer Linie, Spalte oder Diagonale wie in Tic-Tac-Toe.)\n");
		avertissements.put(Avertissement.CHOIXCOULEUR, "Sie können nicht die gleiche Farbe wählen!");
		avertissements.put(Avertissement.GAGNER, ", du hast gewonnen\n\n\n");
		avertissements.put(Avertissement.REJOUER, "Möchten Sie wiederholen?\n");
		avertissements.put(Avertissement.OUI, "JA [0] ");
		avertissements.put(Avertissement.NON, "NEIN [1] ");
		avertissements.put(Avertissement.QUITTER, "Bist du sicher dass du gehen willst? : ");
		
		menus = new HashMap<Menu, String>();
		menus.put(Menu.MENU_NOUVEAU, "Neues Menu");
		menus.put(Menu.MENU_AIDE, "Hilfemenu");
		menus.put(Menu.MENU_APROPOS, "Uber Menu");
		menus.put(Menu.MENU_ENREGISTRER, "Menu speichern");
		menus.put(Menu.MENU_FICHIER, "Dateimenu");
		menus.put(Menu.MENU_LANGUE,"Sprachmenu");
		menus.put(Menu.MENU_OUVRIR, "Menu offnen");
		menus.put(Menu.MENU_QUITTER, "Menu verlassen");
		menus.put(Menu.MENU_JVSJ, "Spieler VS Spieler");
		menus.put(Menu.MENU_JVSIA, "Spieler VS KI");
		menus.put(Menu.MENU_RETOUR, "Ruckkehr");
		menus.put(Menu.MENU_CONTINUER, "Fortsetzen");
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
