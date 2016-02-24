package registrar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bjackson on 2/21/2016.
 */
public class Student {

    public String name;
    public Set<Course> courses;

    public Student(){
        courses = new HashSet<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Course> getCourses(){
        return courses;
    }

    public boolean enrollIn(Course c){
        if(c.hasSpace()) {
            courses.add(c);
            c.enroll(this);
            return true;
        }
        else{
            if(!c.getWaitlist().contains(this)){
                c.addToWaitlist(this);
            }
            return false;
        }
    }

    public void drop(Course c){
        if (courses.contains(c)) {
            courses.remove(c);
        }
        c.dropStudent(this);
    }
}
