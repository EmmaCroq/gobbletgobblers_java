package gobblets.ihm;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;

public interface Dictionnaire {
	
	public String couleur(Couleur c);
	public String taille(Taille t);
	public String etat(Etat e);
	public String action(ActionType a);
	public String erreur(Erreur e);
	public String avertissement(Avertissement a);
	public String menu(Menu m);
}
