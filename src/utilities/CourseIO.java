/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import datamodels.Course;
import datacontainers.CourseDC;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
/**
 *
 * @author Jorge
 */
public class CourseIO {
    
    private CourseIO() {
    }
    
    public static void writeTextFile(String fileLocation, CourseDC datacontainer) {

        PrintWriter textFile = null;

        try {
            // Create output file
            // We are putting it in a location specified when the program is run
            // This is done via a command line argument
            textFile = new PrintWriter(fileLocation + "course.txt");

            // Loop through the array list of classrooms and print delimited text to a file
            for (Course course : datacontainer.getListOfCourses()) {
                textFile.println(course.getCourseID() + ":" + course.getCourseName() + ":" +
                        course.getClassroom());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Flush the output stream and close the file
            textFile.flush();
            textFile.close();
        }
    }
    
       public static void writeSerializedFile(String fileLocation, CourseDC datacontainer) {
        try {
            // Create output file
            ObjectOutputStream serializedFile = new ObjectOutputStream(
                    new FileOutputStream(fileLocation + "course.ser"));
            // Write out the data
            serializedFile.writeObject(datacontainer.getListOfCourses());
        } catch (Exception exp) {
            // TO-DO
        }
    }
        
    public static void writeJSONFile(String fileLocation, CourseDC datacontainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "course.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert classroom list to JSON format
            gson.toJson(datacontainer.getListOfCourses(), jsonFile);

        } catch (Exception exp) {
            // TO-DO
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }
    
    public static ArrayList<Course> readJSONFile(String fileLocation) {

        ArrayList<Course> listOfCourses = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "course.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Course[] courseArray = gson.fromJson(jsonFile, Course[].class);

            // Convert to arraylist for the data model
            for (int i = 0; i < courseArray.length; i++) {
                listOfCourses.add(courseArray[i]);
            }
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfCourses;
        }
    }
    
    public static ArrayList<Course> readSerializedFile(String fileLocation) {

        ArrayList<Course> listOfCourses = new ArrayList<>();

        try {
            ObjectInputStream serializedFile = new ObjectInputStream(
                    new FileInputStream(fileLocation + "course.ser"));
            // Read the serialized object and cast to its original type
            listOfCourses = (ArrayList<Course>) serializedFile.readObject();
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfCourses;
        }
    }

}
