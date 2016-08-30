package org.toilelibre.libe.mower.moves;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.toilelibre.libe.mower.MowerException;

public class StringInputConverter implements InputConverter<String> {

    @Override
    public MowerMoves convert (final String scenarioInput) throws MowerException {

        this.ensureInputIsNotBlank (scenarioInput);
        final String [] inputLines = scenarioInput.split ("\n");
        this.ensureNumberOfLinesIsCorrect (inputLines);

        final Point corner = this.readFirstLine (inputLines);
        final List<MowerSituation> situations = this.readSituations (inputLines, corner);
        final List<Moves> movesByMowers = this.readMovesByMowers (inputLines);

        return new MowerMoves (corner, situations, movesByMowers);
    }

    private void ensureInputIsNotBlank (final String scenarioInput) throws MowerException {
        if ( (scenarioInput == null) || scenarioInput.trim ().isEmpty ()) {
            throw new MowerException ("input is empty or null");
        }
    }

    private void ensureInputRespectsTheExpectedFormat (final int inputLine, final String text, final String regex) throws MowerException {
        if (!text.matches (regex)) {
            throw new MowerException (String.format ("input line is incorrect at line %d (%s), expected format : %s", inputLine, text, regex));
        }
    }

    private MowerSituation ensureInsideLawn (final MowerSituation mowerSituation, final Point corner) throws MowerException {
        if ( (RangeUtils.getValueInRange (mowerSituation.getX (), corner.getX ()) != mowerSituation.getX ())
                || (RangeUtils.getValueInRange (mowerSituation.getY (), corner.getY ()) != mowerSituation.getY ())) {
            throw new MowerException (
                    String.format ("One mower is already outside the lawn. (%d %d %s)", mowerSituation.getX (), mowerSituation.getY (), mowerSituation.getO ().name ().charAt (0)));
        }
        return mowerSituation;
    }

    private void ensureNumberOfLinesIsCorrect (final String [] inputLines) throws MowerException {
        if ( (inputLines.length % 2) == 0) {
            throw new MowerException ("The number of lines of the input should be odd");
        }

    }

    private Point readFirstLine (final String [] inputLines) {
        final Scanner scanner = new Scanner (inputLines [0]);
        final Point corner = new Point (scanner.nextInt (), scanner.nextInt ());
        scanner.close ();
        return corner;
    }

    private List<Moves> readMovesByMowers (final String [] inputLines) throws MowerException {
        final List<Moves> result = new LinkedList<Moves> ();

        for (int i = 2 ; i < inputLines.length ; i += 2) {
            this.ensureInputRespectsTheExpectedFormat (i, inputLines [i], "\\s*[A-Z]*\\s*");

            final Moves moves = this.readMovesOfOneMower (inputLines [i].trim ());
            result.add (moves);
        }
        return result;
    }

    private Moves readMovesOfOneMower (final String moves) throws MowerException {

        final List<Move> movesOfMower = new LinkedList<Move> ();
        for (final int oneChar : moves.chars ().toArray ()) {
            movesOfMower.add (Move.fromInitial ((char) oneChar));
        }
        return new Moves (movesOfMower);
    }

    private List<MowerSituation> readSituations (final String [] inputLines, final Point corner) throws MowerException {
        final List<MowerSituation> result = new LinkedList<MowerSituation> ();

        for (int i = 1 ; i < inputLines.length ; i += 2) {

            this.ensureInputRespectsTheExpectedFormat (i, inputLines [i], "\\s*[0-9]+\\s+[0-9]+\\s+[A-Z]\\s*");

            final Scanner scanner = new Scanner (inputLines [i]);
            result.add (this.ensureInsideLawn (new MowerSituation (scanner.nextInt (), scanner.nextInt (), Orientation.fromInitial (scanner.next ().charAt (0))), corner));
            scanner.close ();
        }
        return result;
    }
}
