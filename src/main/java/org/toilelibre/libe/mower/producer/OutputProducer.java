package org.toilelibre.libe.mower.producer;

import org.toilelibre.libe.mower.calculator.MowerPositions;

public interface OutputProducer<T> {

    T output (MowerPositions positions);

}
