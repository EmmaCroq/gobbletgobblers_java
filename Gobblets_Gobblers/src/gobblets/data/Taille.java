package gobblets.data;

public enum Taille {
	//on enum�re les diff�rentes tailles
	PETITE('1') {
		@Override
		public boolean recouvre(Taille taille) {
			return false;
		}
	},
	MOYENNE('2') {
		@Override
		public boolean recouvre(Taille taille) {
			return false;
		}
	},
	GRANDE('3') {
		@Override
		public boolean recouvre(Taille taille) {
			return false;
		}
	};
	
	private final char symbole;
	
	private Taille(char symbole){
		//le constructeur va permettre d'initialiser les attributs lors de la cr�ation d'un objet
		this.symbole = symbole;
	}

	public char getSymbole() {
		return symbole;
	}
	
	public boolean recouvre(Piece piece) {
		//on a chang� le type de la variable de char � int pour pouvoir les comparer
		return (Character.getNumericValue(piece.taillePiece.symbole) < Character.getNumericValue(symbole));
	}
	
	public abstract boolean recouvre(Taille taille);
}
