/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import datamodels.Classroom;

/**
 *
 * @author Jorge
 */
public interface ICourse {
    
    public void setCourseID(String p_courseID);
    public void setCourseName(String p_courseName);
    public void setClassroom(Classroom p_classroom);
    
    public String getCourseID();
    public String getCourseName();
    public Classroom getClassroom();
    
}
