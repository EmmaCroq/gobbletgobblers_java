package gobblets.data;

import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.interaction.Termination;

public class JoueurHumain extends Joueur {
	
	
	public JoueurHumain(String nom, Couleur couleur){
		super(nom, couleur);
	}
	
	public Action choisirAction(Plateau plateau) { 
		//Implémentation de la méthode abstraite de la classe Joueur, utilise les méthodes de une instance de la classe IHM
		SaisieConsole s = new SaisieConsole();
		Action action;
		ActionType a = s.saisirAction(this);
		switch(a) {
			case PLACER :
				Taille t = s.saisirTaille();
				int[] coord = s.saisirCoordonnees(a);
				action = new Placement(t, plateau.getPlateau()[coord[0]][coord[1]]);
				return action;
			case DEPLACER :
				int[] coord1 = s.saisirCoordonnees(a);
				action = new Deplacement(plateau.getPlateau()[coord1[0]][coord1[1]], plateau.getPlateau()[coord1[2]][coord1[3]]);
				return action;
			case QUITTER :
				action =  new Termination();
				return action;
		}
		return null;
	}
}
