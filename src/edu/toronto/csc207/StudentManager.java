package edu.toronto.csc207;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the entire system of Students and their Courses
 */
public class StudentManager {

    private List<Student> students;
    private List<Course> courses;

    /**
     * Creates a StudentManager with lists of Student and Course that are empty
     */
    public StudentManager() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    /**
     * Adds an instance of Student to the overall list of Students
     * @param info Student name, number, date of birth, and course
     */
    public void add(List<String> info) {
        Student s = new Student(info);
        students.add(s);
    }

    /**
     * Takes in a course and enrolls all current students in the course
     * @param c instance of Course
     */
    public void enrolAllInCourse(Course c) {
        for (Student s : students) {
            s.enrol(c);
            c.add(s);
            courses.add(c);
        }
    }

    /**
     * Represents a StudentManager as a String containing all Student names, numbers, and Courses in the system.
     * @return a list of student names, numbers, and their courses, separated by commas.
     */
    @Override
    public String toString() {
        String res = "";
        for (Student s : students) {
            res += s.toString();
            res += ", ";
        }
        for (Course c : courses) {
            res += c.getCourseCode();
            res += ", ";
        }
        return res; //includes a trailing ", "
    }

}
