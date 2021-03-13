package gobblets.ihm;

import gobblets.data.*;
import gobblets.ihm.langues.*;

public abstract class IHM {

private static Dictionnaire langage;

	
	public IHM(){
		langage = new Anglais();
	}
	
	public static IHM getIHM() {
		return null;
	}
	
	public static void setIHM(IHM i) {
		
	}
	
	public static void setLangage(String s) {
		if(s == "fr") {
			langage = new Francais();
		}
		else if (s == "en") {
			langage = new Anglais();
		}
		else if(s == "de") {
			langage = new Allemand();
		} 
	}
	
	public static String couleur(Couleur c) {
		return langage.couleur(c);
	}
	
	public static String taille(Taille t) {
		return langage.taille(t);
	}
	
	public static String etat(Etat e) {
		return langage.etat(e);
	}
	
	public static String erreur(Erreur e) {
		return langage.erreur(e);
	}
	
	public static String action(ActionType a) {
		return langage.action(a);
	}
	
	public static String avertissement(Avertissement a) {
		return langage.avertissement(a);
	}
	
	public static String menu(Menu m) {
		return langage.menu(m);
	}
	
	public abstract Joueur saisirJoueur(int i);
	
	public abstract ActionType saisirAction(Joueur j);
	
	public abstract Taille saisirTaille();
	
	public abstract int[] saisirCoordonnees(ActionType a);
	
	public abstract void display(Plateau p, Joueur j);
}
