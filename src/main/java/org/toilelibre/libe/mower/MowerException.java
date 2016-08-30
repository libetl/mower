package org.toilelibre.libe.mower;

public class MowerException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 275884221769804904L;

    public MowerException (final String message) {
        super (message);
    }

    public MowerException (final String message, final Exception cause) {
        super (message, cause);
    }
}
