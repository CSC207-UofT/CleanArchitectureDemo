package edu.toronto.csc207;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a course with Students enrolled in it.
 */
public class Course {

    private String courseCode;
    private List<Student> classList;

    /**
     * Creates an instance of Course that already has an official code
     * @param code official course code
     */
    public Course(String code) {
        courseCode = code;
        classList = new ArrayList<>();
    }

    /**
     * Getter for the course code as a String
     * @return course code as a String
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Stores the student in this Course's class list.
     * @param s Student to be enrolled
     */
    public void add(Student s) {
        classList.add(s);
    }
}
