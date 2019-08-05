package datamodels;

import interfaces.ICourse;
import java.io.Serializable;

public class Course implements ICourse, Serializable {
    
    private String courseID;
    private String courseName;
    private Classroom classroom;
    
    public void setCourseID(String p_courseID){
        courseID = p_courseID;
    }
          
    public void setCourseName(String p_courseName){
        courseName = p_courseName;
    }
    
    public void setClassroom(Classroom p_classroom){
        classroom = p_classroom;
    }
    
    public String getCourseID(){
        return courseID;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public Classroom getClassroom(){
        return classroom;
    }
    
    @Override
    public String toString() {
        return "Course{" + "courseID=" + courseID + ", courseName=" + courseName + ", classroom=" + classroom + '}';
    }
}
