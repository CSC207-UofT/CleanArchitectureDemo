package edu.toronto.csc207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Controls the system responsible for storing Students, Courses, and Enrollment.
 */
public class EnrolmentSystem {

    private StudentManager sm1 = new StudentManager();

    /**
     * Interacts with the user to prompt input of a student and course information.
     */
    public void run() {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StudentPropertiesIterator prompts = new StudentPropertiesIterator();
        ArrayList<String> temp = new ArrayList<>();

        System.out.println("Type 'exit' to quit or 'ok' to continue.");
        try {
            String input = br.readLine();
            while (!input.equals("exit") && prompts.hasNext()) { // != compares memory addresses.

                System.out.println(prompts.next());
                input = br.readLine();
                if (!input.equals("exit")) {
                    temp.add(input);
                }
            }
            System.out.println(temp);
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }

        try {
            if(temp.get(0) != null) {
                sm1.add(temp);
                Course c = new Course(temp.get(temp.size()-1));
                sm1.enrolAllInCourse(c);
                System.out.println(sm1);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Empty enrolment");
        }

    }
}
