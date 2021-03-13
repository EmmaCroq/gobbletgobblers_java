package gobblets.logic;

import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;
import gobblets.data.*;
import gobblets.ihm.texte.SaisieConsole;
import gobblets.interaction.Action;

public class Jeu { // Cette classe modélise un jeu Gobblets
	
	SaisieConsole s;
	private Etat etat;
	int i= 0;
	private Plateau plateau;
	private Joueur Jactif; //le joueur J1 est le premier joueur à jouer
	
	
	public Jeu(Plateau p){ //Constructeur qui exploite des méthodes de saisie afin d'initialiser le jeu
		this.plateau = p;
		this.s = new SaisieConsole();
	}
	

	public Etat getEtat() {
		return this.etat;
	}
	
	public void setEtat(Etat etat) { //interprète l'état actuel du plateau afin de dériver l'état du jeu
		this.etat = etat; 
	}

	private Etat unTour(int i) { // i le nb de tour
		Action a;

		setEtat(Etat.JEUENCOURS);
		if (this.Jactif == null) {
			this.Jactif = this.getJ1();
		}
		
		
		System.out.println("\n=== "+IHM.avertissement(Avertissement.JOUEUR) +this.Jactif.getNom()+" ===\n\n" ); 
		s.display(this.getPlateau(), this.Jactif);
		System.out.println( "\n\n"+this.Jactif.getNom()+", " + IHM.avertissement(Avertissement.TONTOUR));
		a = this.Jactif.choisirAction(this.getPlateau());
		try {
			if(a.verifier(this.Jactif) == true) {
				a.appliquer(this.Jactif);
			}
		}catch(PiecePasDisponibleException | CaseBloqueeException e) {
			System.err.println(e.getMessage());
			return this.unTour(i);
		}
		if(this.etat == Etat.JEUENCOURS && i>20) {
			this.setEtat(Etat.MATCHNUL);
		}
		if(this.etat == Etat.JEUENCOURS) {
			this.setEtat(this.getPlateau().verifierPartie(this.getJ1(),this.getJ2()));
		}
		this.changeJoueur(getJoueurActif());
		return this.etat;
	}
	
	public Joueur changeJoueur(Joueur Jactif) { //met à jour le joueur actif
		if (this.Jactif==this.getJ1()) {
			this.Jactif=this.getJ2();
		}else {
			this.Jactif=this.getJ1();
		}
		return this.Jactif;
	}
	/**
	 * Permet d'incrémenter des tours.
	 * @return
	 * 
	 */
	public Etat play() { // joue une partie
		
		this.unTour(i);
		i++;

		return this.etat;
	}
	
	public Plateau getPlateau() {
		return this.plateau;
	}
	
	public Joueur getJ1() {
		return this.plateau.J1;
	}
	
	public Joueur getJ2() {
		return this.plateau.J2;
	}
	
	public Joueur getJoueurActif() {
		return this.Jactif;
	}
}
