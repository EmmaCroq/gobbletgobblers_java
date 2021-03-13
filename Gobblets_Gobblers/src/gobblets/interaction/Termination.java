package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Termination extends Action{ // Cette classe modélise l'action de quitter le jeu
	SaisieConsole s;
	
	public Termination() {
		this.s = new SaisieConsole();
	}

	@Override
	public boolean verifier(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException {
		// vérifie si l'action peut être appliquée par le joueur qui tente de la faire
		return true; 
		
	}

	@Override
	public void appliquer(Joueur joueur) { //applique l'action et change l'état du jeu
		s.deuxMenu();
	}
}
