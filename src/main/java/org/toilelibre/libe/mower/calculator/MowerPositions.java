package org.toilelibre.libe.mower.calculator;

import java.util.Collections;
import java.util.List;

import org.toilelibre.libe.mower.moves.MowerSituation;

public class MowerPositions {

    private final List<MowerSituation> finalSituations;

    public MowerPositions (final List<MowerSituation> finalSituations) {
        super ();
        this.finalSituations = Collections.unmodifiableList (finalSituations);
    }

    public List<MowerSituation> getFinalSituations () {
        return this.finalSituations;
    }

}
