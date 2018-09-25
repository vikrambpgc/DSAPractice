package com.vikrambpgc.ShipDestroyer;
import java.util.List;
import java.util.ArrayList;

public class ShipDestroyerController implements GameController<Player> {
	List<Player> player;

	public static void main(String[] args) {
		ShipDestroyerController controller =  new ShipDestroyerController();
		
		//Initialization
		GameBoard player1Board = new GameBoard(10, 10);
		GameBoard player2Board = new GameBoard(10, 10);
		
//		List<ShipCoordinate> ship1Coordinates = {new ShipCoordinate(1, 2)};
//		List<ShipCoordinate> ship2Coordinates = {new ShipCoordinate(3, 4)};
//		
//		Ship ship1 = new OrdinaryShip(1, ship1Coordinates);
		
		
		
		while (false == controller.didAnyPlayerWin()) {
			Player p = controller.determineNextTurn();
			p.play();
		}
		
		System.out.println("Won player: " + controller.playerWon());
	}
	
	public Player determineNextTurn() {
		Player p = null;
		//implementation pending
		return p;
	}
	
	public boolean didAnyPlayerWin() {
		boolean result = false;
		//implementation pending
		return result;
	}
	
	//returns null if no one won.
	public Player playerWon() {
		Player p = null;
		//implementation pending
		return p;
	}
}
