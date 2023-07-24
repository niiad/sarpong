package com.eduful9877;

import java.io.Serializable;

/**
 * Represents a course that might be taken by a student.
 * @author Kelvin Eduful
 * ID: 10889877
 */
public class Course implements Serializable {
    private String prefix;
    private int number;
    private String title;
    private String grade;

    /**
     * Constructs the course with the specified information.
     *
     * @param prefix the prefix of the course designation
     * @param number the number of the course designation
     * @param title the title of the course
     * @param grade the grade received for the course
     */
    public Course(String prefix, int number, String title, String grade) {
        this.prefix = prefix;
        this.number = number;
        this.title = title;
        if (grade == null)
            this.grade = "";
        else
            this.grade = grade;
    }

    /**
     * Constructs the course with the specified information, with no grade
     * established.
     *
     * @param prefix the prefix of the course designation
     * @param number the number of the course designation
     * @param title the title of the course
     */
    public Course(String prefix, int number, String title) {
        this(prefix, number, title, "");
    }
    /**
     * Returns the prefix of the course designation.
     *
     * @return the prefix of the course designation
     */
    public String getPrefix() {
        return prefix;
    }
    /**
     * Returns the number of the course designation.
     *
     * @return the number of the course designation
     */
    public int getNumber() {
        return number;
    }
    /**
     * Returns the title of this course.
     *
     * @return the prefix of the course
     */
    public String getTitle() {
        return title;
    }
    /**
     * Returns the grade for this course.
     *
     * @return the grade for this course
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the grade for this course to the one specified.
     *
     * @param grade the new grade for the course
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }
    /**
     * Returns true if this course has been taken (if a grade has been received).
     *
     * @return true if this course has been taken and false otherwise
     */
    public boolean taken() {
        return !grade.equals("");
    }
    /**
     * Determines if this course is equal to the one specified, based on the
     * course designation (prefix and number).
     *
     * @return true if this course is equal to the parameter
     */
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Course) {
            Course otherCourse = (Course) other;
            if (prefix.equals(otherCourse.getPrefix()) &&
            number == otherCourse.getNumber())
                result = true;
        }
        return result;
    }

    /**
     * Creates and returns a string representation of this course.
     *
     * @return a string representation of the course
     */
    public String toString() {
        String result = prefix + " " + number + ": " + title;
        if (!grade.equals(""))
            result += "  [" + grade + "]";
        return result;
    }
}
