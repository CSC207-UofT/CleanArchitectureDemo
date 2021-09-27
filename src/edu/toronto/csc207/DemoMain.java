package edu.toronto.csc207;

import edu.toronto.csc207.ui.SystemInOut;

public class DemoMain {

    public static void main(String[] args) {

        EnrolmentSystem em = new EnrolmentSystem();
        SystemInOut inOut = new SystemInOut();
        em.run(inOut);

    }
}
