package com.vikrambpgc.ShipDestroyer;
import java.util.List;
import java.util.ArrayList;

public class ShipDestroyerPlayer implements Player {
	private int id;
	private Ship[][] shipPositionBoard;
	public List<Ship> playerShips;

	public ShipDestroyerPlayer(int id, GameBoard gameBoard) {
		this.id = id;
		this.playerShips = new ArrayList<Ship>();
		this.shipPositionBoard = new Ship[gameBoard.length][gameBoard.breadth];
		
		for(int i=0; i<gameBoard.length;i++) {
			for(int j=0;j<gameBoard.breadth;j++) {
				shipPositionBoard[i][j] = null;
			}
		}

	}

	public int getPlayerId() {
		return id;
	}

	public void play() {
		
	}
	
	public void addShip(Ship ship) {
		playerShips.add(ship);
		updateShipPositionBoard();
	}
	
	public void updateShipPositionBoard() {
		
	}
	
	//public void hit(Coordinate coordinate);
}
