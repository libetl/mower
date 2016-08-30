package org.toilelibre.libe.mower.producer;

import org.toilelibre.libe.mower.calculator.MowerPositions;

public class StringOutputProducer implements OutputProducer<String> {

    @Override
    public String output (final MowerPositions positions) {
        final StringBuffer buffer = new StringBuffer ();

        positions.getFinalSituations ()
                .forEach (situation -> buffer.append (String.format ("%d %d %c\n", situation.getX (), situation.getY (), situation.getO ().name ().charAt (0))));

        return buffer.toString ();
    }

}
