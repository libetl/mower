package org.toilelibre.libe.mower.moves;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.toilelibre.libe.mower.MowerException;

public enum Orientation {

    NORTH, EAST, SOUTH, WEST;

    public static Orientation fromInitial (final char c) throws MowerException {
        try {
            return Arrays.asList (Orientation.values ()).stream ().filter (orientation -> orientation.name ().charAt (0) == c).findFirst ().get ();
        } catch (final NoSuchElementException nsee) {
            throw new MowerException ("Could not find a valid orientation from initial " + c, nsee);
        }
    }
}
