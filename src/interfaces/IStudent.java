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
public interface IStudent {
 
    public void setGPA(float p_gpa);
    public void setDateOfGraduation(java.time.LocalDate p_dateOfGraduation);
    public void setStudentID(int p_studentID);
    public void setStudentID(String p_studentID);
    
    public float getGPA();
    public java.time.LocalDate getDateOfGraduation();
    public int getStudentID();
    public ArrayList<Course> getListOfCourses();
}
