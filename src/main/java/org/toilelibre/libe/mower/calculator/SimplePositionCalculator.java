package org.toilelibre.libe.mower.calculator;

import java.util.LinkedList;
import java.util.List;

import org.toilelibre.libe.mower.moves.Move;
import org.toilelibre.libe.mower.moves.Moves;
import org.toilelibre.libe.mower.moves.MowerMoves;
import org.toilelibre.libe.mower.moves.MowerSituation;
import org.toilelibre.libe.mower.moves.Point;

public class SimplePositionCalculator implements PositionCalculator {

    @Override
    public MowerPositions calculate (final MowerMoves moves) {
        final List<MowerSituation> situations = new LinkedList<> ();

        for (int mowerIndex = 0 ; mowerIndex < moves.getInitialSituation ().size () ; mowerIndex++) {
            situations.add (this.calculateForOneMower (moves.getInitialSituation ().get (mowerIndex), moves.getMovesByMower ().get (mowerIndex), moves.getCorner ()));
        }

        return new MowerPositions (situations);
    }

    private MowerSituation calculateForOneMower (final MowerSituation mowerSituation, final Moves moves, final Point point) {
        MowerSituation actualSituation = mowerSituation;

        for (final Move move : moves.getListOfMoves ()) {
            actualSituation = this.makeOneMove (actualSituation, move, point);
        }

        return actualSituation;
    }

    private MowerSituation makeOneMove (final MowerSituation mowerSituation, final Move move, final Point corner) {
        return move.getAction ().doAction (mowerSituation, corner);
    }

}
