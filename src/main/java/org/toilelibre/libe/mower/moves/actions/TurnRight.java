package org.toilelibre.libe.mower.moves.actions;

import org.toilelibre.libe.mower.moves.MowerSituation;
import org.toilelibre.libe.mower.moves.Orientation;
import org.toilelibre.libe.mower.moves.Point;

public class TurnRight implements Action {

    @Override
    public MowerSituation doAction (final MowerSituation situation, final Point corner) {
        switch (situation.getO ()) {
        case EAST :
            return new MowerSituation (situation.getX (), situation.getY (), Orientation.SOUTH);
        case SOUTH :
            return new MowerSituation (situation.getX (), situation.getY (), Orientation.WEST);
        case WEST :
            return new MowerSituation (situation.getX (), situation.getY (), Orientation.NORTH);
        case NORTH :
            return new MowerSituation (situation.getX (), situation.getY (), Orientation.EAST);
        default :
            return null;
        }

    }

}
