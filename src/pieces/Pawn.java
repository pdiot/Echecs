package pieces;

import game.Plate;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Pawn extends Piece {

	@Override
	public ArrayList<Piece> accessibleCells(Plate plate) {

		ArrayList<Piece> accessibles = new ArrayList<Piece>();
		// Cas d'une piece morte
		if(!this.isOnScreen(plate)){
			return null;
		}
		else{
			int x = this.getRow();
			int y = this.getColumn();

			//Cas d'une piece blanche
			if(this.getColor() == "w") {			
				// premier deplacement = 2 cases
				if(x == 6 && plate.getPiece(x-1, y).getColor()=="e" && plate.getPiece(x-2, y).getColor()=="e")
					accessibles.add(plate.getPiece(x-2, y));
				// deplacement normal
				if (x > 0 && plate.getPiece(x-1, y).getColor()=="e")
					accessibles.add(plate.getPiece(x-1, y));
				//diagonale gauche
				if (y > 0 && x>0 && plate.getPiece(x-1, y-1).getColor() == "b")
					accessibles.add(plate.getPiece(x-1, y-1));					
				//diagonale droite
				if (y < plate.getBoardSize()-1 && x>0 && plate.getPiece(x-1,y+1).getColor() == "b")
					accessibles.add(plate.getPiece(x-1, y+1));
			}

			//Cas d'une piece noire
			if(this.getColor() == "b") {
				// premier deplacement
				if( x == 1 && plate.getPiece(x+1, y).getColor()=="e" && plate.getPiece(x+2, y).getColor()=="e")					
					accessibles.add(plate.getPiece(x+2, y));
				// deplacement normal
				if(x < 7 && plate.getPiece(x+1,y).getColor()=="e")
					accessibles.add(plate.getPiece(x+1, y));
				//diagonale gauche
				if(x < 7 && y>0 && plate.getPiece(x+1, y-1).getColor() == "w")
					accessibles.add(plate.getPiece(x+1, y-1));
				//diagonale droite
				if (x < 7 && y<plate.getBoardSize()-1 && plate.getPiece(x+1, y+1).getColor() == "w")
					accessibles.add(plate.getPiece(x+1, y+1));
			}			
			return accessibles;
		}

	}

	@Override
	boolean canMove(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean move(Piece piece) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void show(){
		System.out.println("Je suis un pion ! et ma position est : "+getRow() + " " + getColumn());
	}

	@Override
	public Icon getIcon() {
		
		if (this.getColor()=="w")
		{
			Icon img = new ImageIcon("./img/wpawn.png");
			return img;
		}
		else {
			Icon img = new ImageIcon("./img/bpawn.png");
			return img;
		}

		
	}

}
