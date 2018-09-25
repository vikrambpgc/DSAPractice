package com.vikrambpgc.ShipDestroyer;

public interface GameController<Player> {
	public Player determineNextTurn();
	public boolean didAnyPlayerWin();
	public Player playerWon(); //returns null if no one won.
}
