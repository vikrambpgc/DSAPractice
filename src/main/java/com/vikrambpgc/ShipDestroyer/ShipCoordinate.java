package com.vikrambpgc.ShipDestroyer;

public class ShipCoordinate extends Coordinate {
    public boolean isCoordinateDestroyed;
    public int canTakeHits;

    public ShipCoordinate(int x, int y, int canTakeHits) {
        super(x, y);
        this.isCoordinateDestroyed = false;
        this.canTakeHits = canTakeHits;
    }

    public ShipCoordinate(int x, int y) {
        this(x, y, 1);
    }
}
