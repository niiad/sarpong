import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Demonstrates the use of a list to manage a set of objects.
 *

 */
public class POSTester
{

    public static void main(String[] args) throws IOException
    {
        ProgramOfStudy pos = new ProgramOfStudy();
        pos.addCourse(new Course("CS", 101, "Introduction to Programming", "A-"));
        pos.addCourse(new Course("ARCH", 305, "Building Analysis", "A"));
        pos.addCourse(new Course("GER", 210, "Intermediate German"));
        pos.addCourse(new Course("CS", 320, "Computer Architecture"));
        pos.addCourse(new Course("THE", 201, "The Theatre Experience"));
        Course arch = pos.find("CS", 320);
        pos.addCourseAfter(arch, new Course("CS", 321, "Operating Systems"));
        Course theatre = pos.find("THE", 201);
        theatre.setGrade("A-");
        Course german = pos.find("GER", 210);
        pos.replace(german, new Course("FRE", 110, "Beginning French", "B+"));
        System.out.println(pos);
        pos.save("ProgramOfStudy");
    }
}




public class ProgramOfStudy implements Iterable<Course>, Serializable
{
    private List<Course> list;
    /**
     * Constructs an initially empty Program of Study.
     */
    public ProgramOfStudy()
    {
        list = new LinkedList<Course>();
    }
    /**
     * Adds the specified course to the end of the course list.
     *
     * @param course the course to add
     */
    public void addCourse(Course course)
    {
        if (course != null)
            list.add(course);
    }
    /**
     * Finds and returns the course matching the specified prefix and number.
     *

     */
    public Course find(String prefix, int number)
    {
        for (Course course : list)
            if (prefix.equals(course.getPrefix()) &&
                    number == course.getNumber())
                return course;
        return null;
    }
    public void addCourseAfter(Course target, Course newCourse)
    {
        if (target == null || newCourse == null)
            return;
        int targetIndex = list.indexOf(target);
        if (targetIndex != -1)
            list.add(targetIndex + 1, newCourse);
    }
    /**
     * Replaces the specified target course with the new course. Does nothing if
     * either course is null or if the target is not found.

     */
    public void replace(Course target, Course newCourse)
    {
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
    public String toString()
    {
        String result = "";
        for (Course course : list)
            result += course + "\n";
        return result;
    }
    public Iterator<Course> iterator()
    {
        return list.iterator();
    }
    /**
     * Saves a serialized version of this Program of Study to the specified
     * file name.
     *
     * @param fileName the file name under which the POS will be stored
     * @throws IOException
     */
    public void save(String fileName) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }
    /**
     * Loads a serialized Program of Study from the specified file.
     *

     */
    public static ProgramOfStudy load(String fileName) throws IOException,
            ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ProgramOfStudy pos = (ProgramOfStudy) ois.readObject();
        ois.close();
        return pos;
    }
}