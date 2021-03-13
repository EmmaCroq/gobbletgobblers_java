package gobblets.ihm.texte;

import java.util.ArrayList;
import java.util.Scanner;

import gobblets.data.*;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;
import gobblets.ihm.Menu;
import gobblets.logic.Jeu;

public class SaisieConsole extends IHM{
	private Scanner sc;
	
	public SaisieConsole() {
		sc = new Scanner(System.in);
	}
	public void saisirLangage() {
		int i;
		System.out.println(avertissement(Avertissement.CHOIXLANGUE)+"\n");
		System.out.println(" 1 Francais");
		System.out.println(" 2 English");
		System.out.println(" 3 Deutch");
		i = sc.nextInt();
		sc.nextLine();
		switch(i) {
			case 1:
				setLangage("fr");
				break;
			case 2:
				setLangage("en");
				break;
			case 3:
				setLangage("de");
					break;
			default:
				setLangage("en");
		}
	}
	
	public Joueur saisirJoueur(int i) {
		String nom;
		int couleur;
		Couleur c;
		System.out.println(avertissement(Avertissement.JOUEUR) + i + ", " + avertissement(Avertissement.NOMJOUEUR));
		nom = sc.next();
		System.out.println(nom + ", " + avertissement(Avertissement.COULEURJOUEUR) + " : ");
		System.out.println("- 1 = " + couleur(Couleur.BLEU));
		System.out.println("- 2 = " + couleur(Couleur.JAUNE));
		System.out.println("- 3 = " + couleur(Couleur.ROUGE));
		System.out.println("- 4 = " + couleur(Couleur.VERT));
		System.out.println(avertissement(Avertissement.SAISIRCOULEUR));
		couleur = sc.nextInt();
		sc.nextLine();
		switch(couleur) {
		case 1 :
			c = Couleur.BLEU;
			break;
		case 2 : 
			c = Couleur.JAUNE;
			break;
		case 3 : 
			c = Couleur.ROUGE;
			break;
		case 4 : 
			c = Couleur.VERT;
			break;
		case 5 : 
			c = Couleur.WHITE;
			break;
		default :
			c = Couleur.ROUGE;
			break;
			
		}
		
		Joueur j = new JoueurHumain(nom, c);
		return j;
	}
	
	
	public ActionType saisirAction(Joueur j) {
		int rep;
		ActionType retour;
		System.out.println(j.getNom() + ", " + avertissement(Avertissement.CHOIXACTION));
		System.out.println(action(ActionType.PLACER));
		System.out.println(action(ActionType.DEPLACER));
		System.out.println(action(ActionType.QUITTER));
		rep = sc.nextInt(); // on demande de choisir et on retourne le choix
		sc.nextLine();
		switch(rep) {
			case 1 :
				retour = ActionType.PLACER;
				break;
			case 2 : 
				retour = ActionType.DEPLACER;
				break;
			case 3 : 
				retour = ActionType.QUITTER;
				break;
			default : 
				retour = ActionType.PLACER; // si on entre un mauvais nb, alors on place par defaut
				break;
		}
		return retour; // on retourne le choix
	}
	
	public Taille saisirTaille() {
		int rep;
		Taille retour;
		System.out.println(avertissement(Avertissement.CHOIXTAILLE));
		rep = sc.nextInt();
		sc.nextLine();
		if(rep == 1) {
			retour = Taille.PETITE;
		}
		else if(rep == 2) {
			retour = Taille.MOYENNE;
		}
		else if(rep == 3) {
			retour = Taille.GRANDE;
		}
		else {
			retour = null;
			this.saisirTaille();
		}
		return retour;
	}
	
	public int[] saisirCoordonnees(ActionType a) {
		if(a == ActionType.PLACER) {
			int[] coord = new int[2];
			System.out.println(avertissement(Avertissement.CHOIXDESTINATION));
			coord[0] = sc.nextInt()-1;
			sc.nextLine();
			coord[1] = sc.nextInt()-1;
			sc.nextLine();
			return coord;
		}
		else{
			int[] coord = new int[4];
			System.out.println(avertissement(Avertissement.CHOIXORIGIN));
			coord[0] = sc.nextInt()-1;
			sc.nextLine();
			coord[1] = sc.nextInt()-1;
			sc.nextLine();
			System.out.println(avertissement(Avertissement.CHOIXDESTINATION));
			coord[2] = sc.nextInt()-1;
			sc.nextLine();
			coord[3] = sc.nextInt()-1;
			sc.nextLine();
			return coord;
		}
	}
	
	public void display(gobblets.data.Plateau p, Joueur joueur) {
		
		gobblets.ihm.texte.Plateau p1 = new gobblets.ihm.texte.Plateau(p);
		
		p1.getRepresentationTextuelle();
	    
		ArrayList<gobblets.data.Piece> piecesJoueur1 = p.getMaisonJoueur1();
		System.out.print("J1 : "); 
		System.out.print("            ");
        for (int i = 0; i < piecesJoueur1.size(); i++) {
            gobblets.ihm.texte.Piece textePiece = new gobblets.ihm.texte.Piece(piecesJoueur1.get(i));
            System.out.print(textePiece.getRepresentationTextuelle()+" ");
        }
        System.out.println("\n");
        ArrayList<gobblets.data.Piece> piecesJoueur2 = p.getMaisonJoueur2();
        System.out.print("J2 : "); 
        System.out.print("            ");
        for (int i = 0; i < piecesJoueur2.size(); i++) {
            gobblets.ihm.texte.Piece textePiece = new gobblets.ihm.texte.Piece(piecesJoueur2.get(i));
            System.out.print(textePiece.getRepresentationTextuelle()+" ");
        }

	}
	
	public void finalize() { //ferme le scanner utilisé quand l'instance est détruite
		sc.close();
	}

	public int saisirNbJoueur() {
		int retour;
		do {
			System.out.println(avertissement(Avertissement.CHOIXNBJOUEUR));
			retour = sc.nextInt();
			sc.nextLine();
		}while(retour != 1 && retour != 2);
		return retour;
	}
	
	
	/**
	 * Le tout premier menu du jeu.
	 * @return choixMenu
	 */
	public int premierMenu() {
		
		    int choixMenu;

		    System.out.println("\n"+avertissement(Avertissement.CHOIXMODE)+"\n");
		    
		    System.out.println(" 1 "+menu(Menu.MENU_NOUVEAU));
		   
		    System.out.println(" 2 "+menu(Menu.MENU_AIDE));
		    
		    System.out.println(" 3 "+menu(Menu.MENU_APROPOS));
		    
		    System.out.println(" 4 "+menu(Menu.MENU_LANGUE));
		    
		    System.out.println(" 5 "+menu(Menu.MENU_QUITTER));
		   
		    choixMenu = sc.nextInt();
		  
		    return choixMenu;
	}
	/**
	 * Le deuxieme menu du jeu, qui gère les choix effectués dans le premier menu.
	 * @return 0
	 */
	public int deuxMenu() {
		
		int verif;
		int choix = premierMenu();
		
		if (choix== 1) {
			int choixMenu2;
		    
		    System.out.println("\n"+avertissement(Avertissement.CHOIXMODE)+"\n");
		    
		    System.out.println(" 1 "+menu(Menu.MENU_JVSJ));
		   
		    System.out.println(" 2 "+menu(Menu.MENU_JVSIA));
		    
		    System.out.println(" 3 "+menu(Menu.MENU_RETOUR));
		   
		    choixMenu2 = sc.nextInt();
		    
		    if (choixMenu2==1) {
		    	this.menuDeuxJoueur();
		    }else if(choixMenu2==2) {
		    	this.menuUnJoueur();
			}else 
				this.deuxMenu();
//				return 4; // eteindre la console
		}
		else if (choix== 2) {
			regles();
			this.deuxMenu();
		}
		else if (choix==3) {
			System.out.println(avertissement(Avertissement.CREER)+"	Emma CROQ \n	Baptiste LEMONNIER");
			this.deuxMenu();
		}
		else if (choix==4) {
			this.saisirLangage();
			this.deuxMenu();
		}
		else {
			System.out.println(avertissement(Avertissement.QUITTER)+avertissement(Avertissement.OUI)+avertissement(Avertissement.NON));
			verif = sc.nextInt();
			if (verif == 1) {
				return 4;
			}else
			this.deuxMenu();
		}
		return 0;
	}
	
	/**
	 * Les regles du jeu en differentes langues.
	 */
	public void regles() {
		System.out.print(avertissement(Avertissement.REGLES));
	}
	
	/**
	 * Menu issu du choix joueur VS joueur lors du deuxieme menu. Lance le gameplay.
	 */
	public void menuDeuxJoueur() {
		
		int rejoue=0;
		Joueur J1 = this.saisirJoueur(1);
		Joueur J2 = this.saisirJoueur(2);
		gobblets.data.Plateau p = gobblets.data.Plateau.initPlateau(J1, J2);
		
		while (J1.getCouleur()==J2.getCouleur()) {
			System.out.println(avertissement(Avertissement.CHOIXCOULEUR)); 
			J2 = this.saisirJoueur(2);
		}
		
		Jeu j = new Jeu(p);

	    Etat winner = Etat.JEUENCOURS;
	    
	    while(winner == Etat.JEUENCOURS){
	    	j.play();
	    	winner = j.getEtat();
	    }
	    while(rejoue != 1 || rejoue != 2) {
		    System.out.println("\n\n"+etat(j.getEtat())+"\n");
		    System.out.println(avertissement(Avertissement.REJOUER));
		    System.out.println("1 "+menu(Menu.MENU_CONTINUER)); 
		    System.out.println("2 "+menu(Menu.MENU_QUITTER)); 
		    rejoue = sc.nextInt();
		    if (rejoue==1)
		    {
		        this.menuDeuxJoueur();
		    }else if (rejoue==2) {
		    	this.deuxMenu();
		    }
	    }
	}
	/**
	 * Menu issu du choix joueur VS IA lors du deuxieme menu. Lance le gameplay.
	 */
	public void menuUnJoueur() {

		int rejoue=0;
		String nom = "Bob_The_Bot";
		Joueur J1 = this.saisirJoueur(1);
		Joueur ia = new JoueurIA(nom, Couleur.ROUGE);
		gobblets.data.Plateau p = gobblets.data.Plateau.initPlateau(J1, ia);
		
		while (J1.getCouleur()==ia.getCouleur()) {
			System.out.println(avertissement(Avertissement.CHOIXCOULEUR)); 
			J1 = this.saisirJoueur(1);
		}
//	    int choix=sousmenu();   //  Difficulté du jeu

		Jeu j = new Jeu(p);

	    Etat winner = Etat.JEUENCOURS;
	    
	    while(winner == Etat.JEUENCOURS){
	    	j.play();
	    	winner = j.getEtat();
	    }
	        
	    while(rejoue != 1 || rejoue != 2) {
		    System.out.println("\n\n"+etat(j.getEtat())+"\n");
		    System.out.println(avertissement(Avertissement.REJOUER));
		    System.out.println("1 "+menu(Menu.MENU_CONTINUER)); 
		    System.out.println("2 "+menu(Menu.MENU_QUITTER)); 
		    rejoue = sc.nextInt();
		    if (rejoue==1)
		    {
		        this.menuDeuxJoueur();
		    }else if (rejoue==2) {
		    	this.deuxMenu();
		    }
	    }
	}
	
	/**
	 * Introduction du jeu
	 */
	public void debut() {

//		Thread.sleep(3);
//	    Runtime.getRuntime().exec("cls");
	    System.out.flush();
	    System.out.println("	   	 ===Welcom to===\n\n");
//	    Thread.sleep(1);
	    System.out.println("╔═╗┌─┐┌┐ ┌┐ ┬  ┌─┐┌┬┐       ╔═╗┌─┐┌┐ ┌┐ ┬  ┌─┐┬─┐┌─┐");
//	    Thread.sleep(1);
	    System.out.println("║ ╦│ │├┴┐├┴┐│  ├┤  │        ║ ╦│ │├┴┐├┴┐│  ├┤ ├┬┘└─┐");
//	    Thread.sleep(1);
	    System.out.println("╚═╝└─┘└─┘└─┘┴─┘└─┘ ┴        ╚═╝└─┘└─┘└─┘┴─┘└─┘┴└─└─┘");
//	    Thread.sleep(2);
	    System.out.println("\n\n		    THE GAME\n");
//	    Thread.sleep(5);
	}
}

