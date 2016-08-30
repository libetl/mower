package org.toilelibre.libe.mower;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.toilelibre.libe.mower.ioc.NaiveIOC;

public class MowerProgramTest {

    private static final String         SCENARIOS_PARENT_FOLDER = "scenarios/";
    private static final String         OUTPUT_SUFFIX           = ".output.txt";
    private static final String         INPUT_SUFFIX            = ".input.txt";
    private static final FilenameFilter INPUT_FILES_FILTER      = (dir, name) -> name.endsWith (MowerProgramTest.INPUT_SUFFIX);
    private MowerProgram<String>        program;

    private String getScenarioInput (final String scenarioFile) {
        return this.readAsString (MowerProgramTest.SCENARIOS_PARENT_FOLDER + scenarioFile + MowerProgramTest.INPUT_SUFFIX);
    }

    private String getScenarioOutput (final String scenarioFile) {
        return this.readAsString (MowerProgramTest.SCENARIOS_PARENT_FOLDER + scenarioFile + MowerProgramTest.OUTPUT_SUFFIX);
    }

    @Before
    public void naiveIOC () {
        this.program = NaiveIOC.injectProgram ();
    }

    private String readAsString (final String fileName) {
        return this.readInputStreamAsString (Thread.currentThread ().getContextClassLoader ().getResourceAsStream (fileName));
    }

    private String readInputStreamAsString (final InputStream inputStream) {
        final Scanner scanner = new java.util.Scanner (inputStream);
        final String result = scanner.useDelimiter ("\\A").next ().replaceAll ("[ ]+\n", "\n").trim ();
        scanner.close ();
        return result;
    }

    @Test
    public void runAllScenarios () throws MowerException {
        // given
        final File folder = new File (Thread.currentThread ().getContextClassLoader ().getResource (MowerProgramTest.SCENARIOS_PARENT_FOLDER).getFile ());

        for (final String inputFileName : folder.list (MowerProgramTest.INPUT_FILES_FILTER)) {
            final String scenario = inputFileName.replace (MowerProgramTest.INPUT_SUFFIX, "");
            final String scenarioInput = this.getScenarioInput (scenario);
            final String scenarioOutput = this.getScenarioOutput (scenario);

            // when
            try {
                final String foundOutput = this.program.run (scenarioInput).trim ();
                // then
                org.junit.Assert.assertEquals (scenarioOutput, foundOutput);
            } catch (final MowerException mowerException) {
                // then
                org.junit.Assert.assertEquals (scenarioOutput, mowerException.getMessage ());

            }
        }
    }

    @Test
    public void runWithExerciseScenarioShouldWork () throws MowerException {
        // given
        final String scenarioInput = this.getScenarioInput ("scenario1");
        final String scenarioOutput = this.getScenarioOutput ("scenario1").trim ();

        // when
        final String foundOutput = this.program.run (scenarioInput).trim ();

        // then
        org.junit.Assert.assertEquals (scenarioOutput, foundOutput);
    }
}
