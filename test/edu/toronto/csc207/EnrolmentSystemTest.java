package edu.toronto.csc207;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class EnrolmentSystemTest {
    EnrolmentSystem system;

    @org.junit.Before
    public void setUp() throws Exception {
        system = new EnrolmentSystem();
    }

    @org.junit.Test
    public void runTest() {
        String[] expectedOutput = new String[]{
                "Type 'exit' to quit or 'ok' to continue.",
                "Name: ", "StudentNumber: ", "Date of Birth: ", "Course Code: ",
                "[Paul, 1234567890, last millenium, CSC207]",
                "Paul, 1234567890, CSC207, ", null, null, null};

        StringInOut inOut = new StringInOut(
                new String[]{"ok", "Paul", "1234567890", "last millenium", "CSC207"}
        );

        system.run(inOut);
        assertArrayEquals(expectedOutput, inOut.testOutput);
        assertEquals(7, inOut.nextOutput);
    }

    public static class StringInOut implements EnrolmentSystem.InOut {

        private String[] testInput;
        private int nextInput;
        private String[] testOutput;
        private int nextOutput;

        public int getNextOutput() {
            return nextOutput;
        }

        public String[] getTestOutput() {
            return testOutput;
        }

        public StringInOut(String[] testStrings) {
            this.testInput = testStrings;
            this.testOutput = new String[10]; // Expecting only a handful of outputs.
        }

        @Override
        public String getInput() throws IOException {
            return this.testInput[nextInput++];
        }

        @Override
        public void sendOutput(Object s) {
            testOutput[nextOutput++] = s.toString();
        }


    }
}