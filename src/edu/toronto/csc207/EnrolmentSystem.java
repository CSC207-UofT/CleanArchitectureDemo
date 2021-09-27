package edu.toronto.csc207;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controls the system responsible for storing Students, Courses, and Enrollment.
 */
public class EnrolmentSystem {

    public interface InOut {
        String getInput() throws IOException;

        void sendOutput(Object s);
    }

    private StudentManager studentManager = new StudentManager();

    /**
     * Interacts with the user to prompt input of a student and course information.
     */
    public void run(InOut inOut) {

        StudentPropertiesIterator prompts = new StudentPropertiesIterator();
        List<String> temp = new ArrayList<>();

        inOut.sendOutput("Type 'exit' to quit or 'ok' to continue.");
        try {
            String input = inOut.getInput();
            while (!input.equals("exit") && prompts.hasNext()) { // != compares memory addresses.

                inOut.sendOutput(prompts.next());
                input = inOut.getInput();
                if (!input.equals("exit")) {
                    temp.add(input);
                }
            }
            inOut.sendOutput(temp);
        } catch (IOException e) {
            inOut.sendOutput("Something went wrong");
        }

        try {
            if (temp.get(0) != null) {
                studentManager.add(temp);
                Course c = new Course(temp.get(temp.size() - 1));
                studentManager.enrolAllInCourse(c);
                inOut.sendOutput(studentManager);
            }
        } catch (IndexOutOfBoundsException e) {
            inOut.sendOutput("Empty enrolment");
        }

    }
}
