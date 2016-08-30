package org.toilelibre.libe.mower.calculator;

import org.toilelibre.libe.mower.moves.MowerMoves;

public interface PositionCalculator {

    MowerPositions calculate (MowerMoves moves);

}
