package org.toilelibre.libe.mower.moves;

import java.util.Collections;
import java.util.List;

public class Moves {

    private final List<Move> listOfMoves;

    public Moves (final List<Move> listOfMoves) {
        super ();
        this.listOfMoves = Collections.unmodifiableList (listOfMoves);
    }

    public List<Move> getListOfMoves () {
        return this.listOfMoves;
    }

}
