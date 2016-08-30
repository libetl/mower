package org.toilelibre.libe.mower.moves;

public class RangeUtils {

    private static final int LOW = 0;

    public static int getValueInRange (final int value, final int high) {
        return Math.max (RangeUtils.LOW, Math.min (value, high));
    }
}
