package org.toilelibre.libe.mower;

import org.toilelibre.libe.mower.calculator.MowerPositions;
import org.toilelibre.libe.mower.calculator.PositionCalculator;
import org.toilelibre.libe.mower.moves.InputConverter;
import org.toilelibre.libe.mower.moves.MowerMoves;
import org.toilelibre.libe.mower.producer.OutputProducer;

public class TextualMowerProgram implements MowerProgram<String> {

    private final InputConverter<String> inputConverter;
    private final PositionCalculator     positionCalculator;
    private final OutputProducer<String> outputProducer;
                                         
    public TextualMowerProgram (final InputConverter<String> converter1, final PositionCalculator calculator1, final OutputProducer<String> producer1) {
        this.inputConverter = converter1;
        this.positionCalculator = calculator1;
        this.outputProducer = producer1;
    }

    @Override
    public String run (final String scenarioInput) throws MowerException {

        final MowerMoves moves = this.inputConverter.convert (scenarioInput);
        final MowerPositions positions = this.positionCalculator.calculate (moves);
        return this.outputProducer.output (positions);
    }

}
