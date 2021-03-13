package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public abstract class Action {
	
	public Action() {}
	
	public abstract boolean verifier(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException;
	//vérifie si l'action peut être appliquée par le joueur qui tente de la faire
	
	public abstract void appliquer(Joueur joueur) throws CaseBloqueeException,PiecePasDisponibleException;
	//applique l'action et change l'état du jeu

}
