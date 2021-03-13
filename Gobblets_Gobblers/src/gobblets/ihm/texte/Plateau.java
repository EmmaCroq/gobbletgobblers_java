package gobblets.ihm.texte;

import gobblets.data.Case;

public class Plateau {
	
	gobblets.data.Plateau p;

	public Plateau(gobblets.data.Plateau p){
		this.p = p;
	};
	
	/**
	 * Constructeur vide
	 */
	public Plateau(){
	};
	
	public void getRepresentationTextuelle() {
		for(int i=0; i<=2;i++){ // 3 boucles
	        if (i == 0) { //    Permet d'afficher qu'une fois le haut du plateau_ boucle 1
	        	System.out.println("╔═════════╦═════════╦═════════╗       ");
	        } else {
	        	System.out.println("╠═════════╬═════════╬═════════╣       "); //   Permet de l'afficher deux fois_ boucle 2 et 3
	        }
	        System.out.println("║         ║         ║         ║");
	        for(int j=0; j<=2;j++){ 
	        	Case c = p.getPlateau()[i][j];
	        	
	        	gobblets.ihm.texte.Case casee = new gobblets.ihm.texte.Case(c);
	        	System.out.print("║    "+casee.getRepresentationTextuelle()+"    ");
	        	
	        }
	        System.out.println("║");
	        System.out.println("║         ║         ║         ║");
	    }
	    System.out.println("╚═════════╩═════════╩═════════╝");
		
	}
}
