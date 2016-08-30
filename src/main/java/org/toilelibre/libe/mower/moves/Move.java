package org.toilelibre.libe.mower.moves;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.toilelibre.libe.mower.MowerException;
import org.toilelibre.libe.mower.moves.actions.Action;
import org.toilelibre.libe.mower.moves.actions.GoForward;
import org.toilelibre.libe.mower.moves.actions.TurnLeft;
import org.toilelibre.libe.mower.moves.actions.TurnRight;

public enum Move {

    LEFT (new TurnLeft ()), RIGHT (new TurnRight ()), FORWARD (new GoForward ());

    public static Move fromInitial (final char c) throws MowerException {
        try {
            return Arrays.asList (Move.values ()).stream ().filter (move -> move.name ().charAt (0) == c).findFirst ().get ();
        } catch (final NoSuchElementException nsee) {
            throw new MowerException ("Could not find a valid move from initial " + c, nsee);
        }
    }

    private final Action action;

    Move (final Action action1) {
        this.action = action1;
    }

    public Action getAction () {
        return this.action;
    }
}
