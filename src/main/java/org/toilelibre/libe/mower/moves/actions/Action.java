package org.toilelibre.libe.mower.moves.actions;

import org.toilelibre.libe.mower.moves.MowerSituation;
import org.toilelibre.libe.mower.moves.Point;

public interface Action {

    MowerSituation doAction (MowerSituation situation, Point corner);
}
