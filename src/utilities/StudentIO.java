/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import datamodels.Student;
import datacontainers.StudentDC;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedReader;
import java.util.ArrayList;
/**
 *
 * @author Jorge
 */
public class StudentIO {
    
    private StudentIO() {
    }
    
    
    public static void writeTextFile(String fileLocation, StudentDC datacontainer) {

        PrintWriter textFile = null;

        try {
            // Create output file
            // We are putting it in a location specified when the program is run
            // This is done via a command line argument
            textFile = new PrintWriter(fileLocation + "student.txt");

            // Loop through the array list of classrooms and print delimited text to a file
            for (Student student : datacontainer.getListOfStudents()) {
                textFile.println(student.toString());//student.getStudentID() + ":" + student.getGPA() + ":" 
                        //+ student.getDateOfGraduation() + student.getListOfCourses());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // Flush the output stream and close the file
            textFile.flush();
            textFile.close();
        }
    }

    /**
     * Creates a serialized object output file containing all classrooms in the
     * classroom data model
     */
    public static void writeSerializedFile(String fileLocation, StudentDC datacontainer) {
        try {
            // Create output file
            ObjectOutputStream serializedFile = new ObjectOutputStream(
                    new FileOutputStream(fileLocation + "student.ser"));
            // Write out the data
            serializedFile.writeObject(datacontainer.getListOfStudents());
        } catch (Exception exp) {
            // TO-DO
        }
    }
    
    public static void writeJSONFile(String fileLocation, StudentDC datacontainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "student.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert classroom list to JSON format
            gson.toJson(datacontainer.getListOfStudents(), jsonFile);

        } catch (Exception exp) {
            // TO-DO
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }
    
        public static ArrayList<Student> readJSONFile(String fileLocation) {

        ArrayList<Student> listOfStudents = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "student.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Student[] studentArray = gson.fromJson(jsonFile, Student[].class);

            // Convert to arraylist for the data model
            for (int i = 0; i < studentArray.length; i++) {
                listOfStudents.add(studentArray[i]);
            }
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfStudents;
        }
    }
        
      public static ArrayList<Student> readSerializedFile(String fileLocation) {

        ArrayList<Student> listOfStudents = new ArrayList<>();

        try {
            ObjectInputStream serializedFile = new ObjectInputStream(
                    new FileInputStream(fileLocation + "student.ser"));
            // Read the serialized object and cast to its original type
            listOfStudents = (ArrayList<Student>) serializedFile.readObject();
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfStudents;
        }
    }
}
