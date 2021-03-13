package gobblets;


import gobblets.ihm.texte.SaisieConsole;

public class Gobblets {
	
	public Gobblets() {
		
	}
	/**
	 * Permet de gérer l'introduction du jeu (la méthode début).
	 * @param cas
	 * @return 0
	 */
	public static int principal(int cas) {
		
		
		SaisieConsole s = new SaisieConsole();
		

	    if (cas < 1) {  //  Permet d'afficher l'intro du jeu qu'une seule fois
	        s.debut();
	        s.deuxMenu();
	    } else {
	        s.deuxMenu();   //  Relance directement sur le menu principal
	    }
		
	    s.finalize();
		return 0;
	}
	
	
	public static void main(String[] args) {
//		System.out.println("Coucou" + Couleur.ROUGE.getCode());
		principal(0);
	}
}

