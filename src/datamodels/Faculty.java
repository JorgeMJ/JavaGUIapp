package datamodels;

import java.util.ArrayList;
import java.io.Serializable;

import interfaces.IFaculty;

public class Faculty extends Person implements IFaculty, Serializable {
    
    private java.time.LocalDate dateOfHire;
    private double salary;
    private String status;
    private ArrayList<Course> listOfCourses = new ArrayList<Course>();
    
    public void setDateOfHire(java.time.LocalDate p_dateOfHire){
        dateOfHire = p_dateOfHire;
    }
    
    public void setSalary(double p_salary){
        salary = p_salary;
    }
    
    public void setStatus(String p_status){
        status = p_status;
    }
    
    public java.time.LocalDate getDateOfHire(){
        return dateOfHire;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public String getStatus(){
        return status;
    }
            
    public ArrayList<Course> getListOfCourses(){
        return listOfCourses;
    }
    
      @Override
    public String toString() {
        return "Faculty{" + "dateOfHire=" + dateOfHire + ", salary=" + salary + ", status=" + status + ",listOfCourses=" + listOfCourses + '}';
    }
}
