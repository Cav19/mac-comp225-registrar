package registrar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bjackson on 2/21/2016.
 */
public class Course {

    private Set<Student> students;
    private List<Student> waitlist;
    private String catalogNumber;
    private String title;
    private int enrollmentLimit;

    public Course(){
        students = new HashSet<>();
        waitlist = new ArrayList<>();
        enrollmentLimit = 16;
    }

    public void setCatalogNumber(String number){
        this.catalogNumber = number;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getEnrollmentLimit(){
        return enrollmentLimit;
    }

    public boolean setEnrollmentLimit(int limit){
        //If students are enrolled you can't change the limit
        if (students.size() == 0){
            this.enrollmentLimit = limit;
            return true;
        }
        return false;
    }

    public Set<Student> getStudents(){
        return students;
    }

    public List<Student> getWaitList(){
        return waitlist;
    }

    public boolean hasSpace(){
        return students.size() >= enrollmentLimit;
    }

    public void enroll(Student s){
        students.add(s);
    }

    public void addToWaitlist(Student s){
        waitlist.add(s);
    }

    public void dropStudent(Student s){
        if (students.contains(s)) {
            students.remove(s);
            if (waitlist.size() > 0) {
                Student toEnroll = waitlist.remove(0);
                students.add(toEnroll);
                toEnroll.courses.add(this);
            }
        }
        else if (waitlist.contains(s)){
            waitlist.remove(s);
        }
    }

}
