package org.toilelibre.libe.mower;

public interface MowerProgram<T> {

    T run (T scenarioInput) throws MowerException;

}
