package org.toilelibre.libe.mower.moves.actions;

import org.toilelibre.libe.mower.moves.MowerSituation;
import org.toilelibre.libe.mower.moves.Point;
import org.toilelibre.libe.mower.moves.RangeUtils;

public class GoForward implements Action {

    @Override
    public MowerSituation doAction (final MowerSituation situation, final Point corner) {
        switch (situation.getO ()) {
        case EAST :
            return new MowerSituation (this.ensureRange (situation.getX () + 1, corner.getX ()), this.ensureRange (situation.getY (), corner.getY ()), situation.getO ());
        case SOUTH :
            return new MowerSituation (this.ensureRange (situation.getX (), corner.getX ()), this.ensureRange (situation.getY () - 1, corner.getY ()), situation.getO ());
        case WEST :
            return new MowerSituation (this.ensureRange (situation.getX () - 1, corner.getX ()), this.ensureRange (situation.getY (), corner.getY ()), situation.getO ());
        case NORTH :
            return new MowerSituation (this.ensureRange (situation.getX (), corner.getX ()), this.ensureRange (situation.getY () + 1, corner.getY ()), situation.getO ());
        default :
            return null;

        }
    }

    private int ensureRange (final int value, final int high) {
        return RangeUtils.getValueInRange (value, high);
    }

}
