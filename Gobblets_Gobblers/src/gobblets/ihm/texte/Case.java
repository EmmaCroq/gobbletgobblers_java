package gobblets.ihm.texte;

import gobblets.data.Piece;

public class Case {
	
	private gobblets.data.Case contenu;
	
	public Case(gobblets.data.Case contenu) {
		this.contenu=contenu;
	}
	
	public String getRepresentationTextuelle() {
		Piece pieceAAfficher = this.contenu.plusGrandePiece();
		gobblets.ihm.texte.Piece pp = new gobblets.ihm.texte.Piece(pieceAAfficher);
		return pp.getRepresentationTextuelle();
	}
}
