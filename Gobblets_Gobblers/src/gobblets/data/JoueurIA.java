package gobblets.data;


import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;

public class JoueurIA extends Joueur {
	public JoueurIA(String nom, Couleur couleur){
		super(nom, couleur);
	}
	
	public Action choisirAction(Plateau plateau) {
// Pour les actions
		int rep = 1+(int)(Math.random()*((2-1)+1));
		Action action;
		ActionType a = null; 
			switch(rep) {
				case 1 :
					a = ActionType.PLACER;
					break;
				case 2 : 
					a = ActionType.DEPLACER;
					break;
			}
			switch(a) {
				case PLACER :
					
					// pour la taille
					int rep1;
					Taille retour1 = null;
					rep1 = 1+(int)(Math.random()*((3-1)+1));
					if(rep1 == 1) {
						retour1 = Taille.PETITE;
					}
					else if(rep1 == 2) {
						retour1 = Taille.MOYENNE;
					}
					else if(rep1 == 3) {
						retour1 = Taille.GRANDE;
					}
					
					// pour les coordonnées
//					int[] coord = s.saisirCoordonnees(a);
					
					int[] coord = new int[2];
					coord[0] = 0+(int)(Math.random()*((2-0)+1));
					coord[1] = 0+(int)(Math.random()*((2-0)+1));

					
					action = new Placement(retour1, plateau.getPlateau()[coord[0]][coord[1]]);
					return action;

					
					
				case DEPLACER :
					
					int[] coord1 = new int[4];
					coord1[0] = 0+(int)(Math.random()*((2-0)+1));
					coord1[1] = 0+(int)(Math.random()*((2-0)+1));
					coord1[2] = 0+(int)(Math.random()*((2-0)+1));
					coord1[3] = 0+(int)(Math.random()*((2-0)+1));
					
					action = new Deplacement(plateau.getPlateau()[coord1[0]][coord1[1]], plateau.getPlateau()[coord1[2]][coord1[3]]);
					return action;
			default:
				break;
			}
		return null;
	}
}
