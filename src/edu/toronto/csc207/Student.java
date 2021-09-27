package edu.toronto.csc207;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Student in the system
 */
public class Student {

    private List<String> studentInfo;
    private List<String> courses;

    /**
     * Constructs an instance of Student based on Strings of information
     * @param info all information in the Student's record
     */
    public Student(List<String> info) {
        studentInfo = info;
        courses = new ArrayList<>();
    }

    /**
     * Adds the course code of the parameter to this Student's list of Courses
     * @param c course to add to this Student's list
     */
    public void enrol(Course c) {
        courses.add(c.getCourseCode());
    }

    /**
     * Represents the current Student by their name and student number
     * @return the name and student number separated by a comma
     */
    public String toString() {
        return studentInfo.get(0) + ", " + studentInfo.get(1);
    }
}
