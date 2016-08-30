package org.toilelibre.libe.mower.moves;

import java.util.Collections;
import java.util.List;

public class MowerMoves {

    private final Point                corner;

    private final List<MowerSituation> initialSituation;

    private final List<Moves>          movesByMower;

    public MowerMoves (final Point corner1, final List<MowerSituation> initialSituation, final List<Moves> movesByMower) {
        super ();
        this.corner = corner1;
        this.initialSituation = initialSituation;
        this.movesByMower = Collections.unmodifiableList (movesByMower);
    }

    public Point getCorner () {
        return this.corner;
    }

    public List<MowerSituation> getInitialSituation () {
        return this.initialSituation;
    }

    public List<Moves> getMovesByMower () {
        return this.movesByMower;
    }

}
