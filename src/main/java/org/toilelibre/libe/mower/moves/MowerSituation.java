package org.toilelibre.libe.mower.moves;

public class MowerSituation {

    private final int         x;
    private final int         y;
    private final Orientation o;

    public MowerSituation (final int x, final int y, final Orientation o) {
        super ();
        this.x = x;
        this.y = y;
        this.o = o;
    }

    public Orientation getO () {
        return this.o;
    }

    public int getX () {
        return this.x;
    }

    public int getY () {
        return this.y;
    }

}
