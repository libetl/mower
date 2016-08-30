package org.toilelibre.libe.mower.ioc;

import org.toilelibre.libe.mower.MowerProgram;
import org.toilelibre.libe.mower.TextualMowerProgram;
import org.toilelibre.libe.mower.calculator.PositionCalculator;
import org.toilelibre.libe.mower.calculator.SimplePositionCalculator;
import org.toilelibre.libe.mower.moves.InputConverter;
import org.toilelibre.libe.mower.moves.StringInputConverter;
import org.toilelibre.libe.mower.producer.OutputProducer;
import org.toilelibre.libe.mower.producer.StringOutputProducer;

public class NaiveIOC {

    private static PositionCalculator injectCalculator () {
        return new SimplePositionCalculator ();
    }

    private static InputConverter<String> injectConverter () {
        return new StringInputConverter ();
    }

    private static OutputProducer<String> injectProducer () {
        return new StringOutputProducer ();
    }

    public static MowerProgram<String> injectProgram () {
        return new TextualMowerProgram (NaiveIOC.injectConverter (), NaiveIOC.injectCalculator (), NaiveIOC.injectProducer ());
    }

}
