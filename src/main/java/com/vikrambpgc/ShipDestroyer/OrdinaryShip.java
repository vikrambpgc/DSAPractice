package com.vikrambpgc.ShipDestroyer;
import java.util.List;
import java.util.ArrayList;

public class OrdinaryShip implements Ship {

	public int id;
	private List<ShipCoordinate> shipCoordinates;
	private boolean isShipDestroyed;

	public OrdinaryShip(int id, List<ShipCoordinate> shipCoordinates) {
		this.id = id;
		this.shipCoordinates = shipCoordinates;
		this.isShipDestroyed = false;
	}
	
	public boolean isShipDestroyed() {
		return isShipDestroyed;
	}

	private boolean checkIfWholeShipDestroyed() {
		for(ShipCoordinate shipCoordinate: shipCoordinates) {
			if (false == shipCoordinate.isCoordinateDestroyed) return false;
		}

		return true;
	}
	
//	public void hit(Cooridnate coordinate) {
//		
//	}
}
