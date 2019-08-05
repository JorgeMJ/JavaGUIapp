/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datamodels.Course;
import java.util.ArrayList;
/**
 *
 * @author Jorge
 */
public interface IFaculty {
    
    public void setDateOfHire(java.time.LocalDate p_dateOfHire);
    public void setSalary(double p_salary);
    public void setStatus(String p_status);

    public java.time.LocalDate getDateOfHire();
    public double getSalary();
    public String getStatus();
    public ArrayList<Course> getListOfCourses();
      
}
