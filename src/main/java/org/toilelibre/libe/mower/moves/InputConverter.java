package org.toilelibre.libe.mower.moves;

import org.toilelibre.libe.mower.MowerException;

public interface InputConverter<T> {

    MowerMoves convert (T scenarioInput) throws MowerException;

}
