/*
 *  This Class contains a list which will hold course objects created in the UI
 */
package datacontainers;

import datamodels.Course;

import java.util.ArrayList;

public class CourseDC {
    
    private ArrayList<Course> listOfCourses = new ArrayList<>();
    
    public CourseDC() {
    }
    
     public ArrayList<Course> getListOfCourses() {
        return listOfCourses;
    }

    public void setListOfCourses(ArrayList<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
    }
   
}
