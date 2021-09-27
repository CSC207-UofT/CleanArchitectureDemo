package edu.toronto.csc207.ui;

import edu.toronto.csc207.EnrolmentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInOut implements EnrolmentSystem.InOut {
    /**
     * Where input comes from.
     */
    BufferedReader reader;

    /**
     * Creates a new InOut implementation hooked up to java.lang.System.
     */
    public SystemInOut() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String getInput() throws IOException {
        return reader.readLine();
    }

    @Override
    public void sendOutput(Object s) {
        System.out.println(s);
    }
}
