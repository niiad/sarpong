package com.eduful9877;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a Program of Study, a list of courses taken and planned, for an
 * individual student
 * @author Kelvin Eduful
 * ID: 10889877
 */
public class ProgramOfStudy implements Iterable<Course>, Serializable {
    private List<Course> list;
    /**
     * Constructs an initially empty Program of Study.
     */
    public ProgramOfStudy() {
        list = new LinkedList<>();
    }
    /**
     * Adds the specified course to the end of the course list.
     *
     * @param course the course to add
     */
    public void addCourse(Course course) {
        if (course != null)
            list.add(course);
    }
    /**
     * Finds and returns the course matching the specified prefix and number.
     *
     * @param prefix the prefix of the target course
     * @param number the number of the target course
     * @return the course, or null if not found
     */
    public Course find(String prefix, int number) {
        for (Course course: list)
            if (prefix.equals(course.getPrefix()) &&
            number == course.getNumber())
                return course;
        return null;
    }
    /**
     * Adds the specified course after the target course. Does nothing if
     * either course is null or if the target is not found.
     * @param target the course after which the new course will be added
     * @param newCourse the course to add
     */
    public void addCourseAfter(Course target, Course newCourse) {
        if (target == null || newCourse == null)
            return;
        int targetIndex = list.indexOf(target);
        if (targetIndex != -1)
            list.add(targetIndex + 1, newCourse);
    }
    /**
     * Replaces the specified target course with the new course. Does nothing if
     * either course is null or if the target is not found.
     *
     * @param target the course to be replaced
     * @param newCourse the new course to add
     */
    public void replace(Course target, Course newCourse) {
        if (target == null || newCourse == null)
            return;
        int targetIndex = list.indexOf(target);
        if (targetIndex != -1)
            list.set(targetIndex, newCourse);
    }
    /**
     * Creates and returns a string representation of this Program of Study.
     *
     * @return a string representation of the Program of Study
     */
    public String toString() {
        String result = "";
        for (Course course : list)
            result += course + "\n";
        return result;
    }

    /**
     * Returns an iterator for this Program of Study.
     *
     * @return an iterator for the Program of Study
     */
    public Iterator<Course> iterator() {
        return list.iterator();
    }
    /**
     * Saves a serialized version of this Program of Study to the specified
     * file name.
     *
     * @param fileName the file name under which the POS will be stored
     * @throws IOException
     */
    public void save(String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    /**
     * Loads a serialized Program of Study from the specified file.
     *
     * @param fileName the file from which the POS is read
     * @return the loaded Program of Study
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ProgramOfStudy load(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
        ois.close();
        return pos;
    }

}
