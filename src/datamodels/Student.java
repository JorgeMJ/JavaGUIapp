package datamodels;

import java.util.ArrayList;
import java.io.Serializable;
import interfaces.IStudent;

public class Student extends Person implements IStudent, Serializable {
    private float gpa;
    private java.time.LocalDate dateOfGraduation;
    private int studentID;
    private ArrayList<Course> listOfCourses = new ArrayList<Course>();
    
    public void setGPA(float p_gpa){
        gpa = p_gpa;
    }
    
    public void setDateOfGraduation(java.time.LocalDate p_dateOfGraduation){
        dateOfGraduation = p_dateOfGraduation;
    }
    
    public void setStudentID(int p_studentID){
        studentID = p_studentID;
    }
    
    public void setStudentID(String p_studentID){
        studentID = Integer.parseInt(p_studentID);
    }
    
    public float getGPA(){
        return gpa;
    }
    
    public java.time.LocalDate getDateOfGraduation(){
        return dateOfGraduation;
    }
    
    public int getStudentID(){
        return studentID;
    }
    
    public ArrayList<Course> getListOfCourses(){
        return listOfCourses;
    }
    
    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", dateOfGraduation=" + dateOfGraduation + ", gpa=" + gpa + ",listOfCourses=" + listOfCourses + '}';
    }
}
