package gobblets.data;

public enum Couleur { 
	//on enum�re les diff�rentes couleurs
	ROUGE(255, 0, 0, "\033[0;31m"),
	VERT(0, 255, 0, "\033[0;32m"),
	BLEU(0, 0, 255, "\033[0;34m"),
	JAUNE(255, 255, 0, "\033[0;33m"),
	WHITE(255, 255, 255, "\033[0;37m");
	
	private final int r,g,b;
	private String code;
	
	private Couleur(int r, int g, int b, String code) { 
		//le constructeur va permettre d'initialiser les attributs lors de la cr�ation d'un objet
		this.r = r;
		this.g = g;
		this.b = b;
		this.code = code;
	}
	
	public int getR() {
		return r;
	}
	
	public int getG() {
		return g;
	}
	
	public int getB() {
		return b;
	}
	
	public String getCode() {
		return code;
	}
	
	public String toString() {
		return "La valeur de R, G et B sont : "+r+" "+g+" "+b+
				"\nLe code est : "+code;
	}
}
