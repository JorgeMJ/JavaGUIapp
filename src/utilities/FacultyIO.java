/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import datamodels.Faculty;
import datacontainers.FacultyDC;
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
public class FacultyIO {
    
    private FacultyIO() {
    }
    
        public static void writeTextFile(String fileLocation, FacultyDC datacontainer) {

        PrintWriter textFile = null;

        try {
            // Create output file
            // We are putting it in a location specified when the program is run
            // This is done via a command line argument
            textFile = new PrintWriter(fileLocation + "faculty.txt");

            // Loop through the array list of classrooms and print delimited text to a file
            for (Faculty faculty : datacontainer.getListOfFaculty()) {
                textFile.println(faculty.toString());//faculty.getSalary() + ":" + faculty.getStatus() + ":" +
                        //faculty.getListOfCourses());
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
    public static void writeSerializedFile(String fileLocation, FacultyDC datacontainer) {
        try {
            // Create output file
            ObjectOutputStream serializedFile = new ObjectOutputStream(
                    new FileOutputStream(fileLocation + "faculty.ser"));
            // Write out the data
            serializedFile.writeObject(datacontainer.getListOfFaculty());
        } catch (Exception exp) {
            // TO-DO
        }
    }
    
    
    
    public static void writeJSONFile(String fileLocation, FacultyDC datacontainer) {

        PrintWriter jsonFile = null;

        try {
            // Create output file
            jsonFile = new PrintWriter(fileLocation + "faculty.json");

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // Convert classroom list to JSON format
            gson.toJson(datacontainer.getListOfFaculty(), jsonFile);

        } catch (Exception exp) {
            // TO-DO
        } finally {
            // Flush the output stream and close the file
            jsonFile.flush();
            jsonFile.close();
        }
    }
    
    public static ArrayList<Faculty> readJSONFile(String fileLocation) {

        ArrayList<Faculty> listOfFaculty = new ArrayList<>();

        try {
            // Create input file
            BufferedReader jsonFile = new BufferedReader(new FileReader(fileLocation + "faculty.json"));

            // Create JSON object
            Gson gson = new GsonBuilder().create();

            // fromJson returns an array
            Faculty[] courseArray = gson.fromJson(jsonFile, Faculty[].class);

            // Convert to arraylist for the data model
            for (int i = 0; i < courseArray.length; i++) {
                listOfFaculty.add(courseArray[i]);
            }
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfFaculty;
        }
    }
    
    public static ArrayList<Faculty> readSerializedFile(String fileLocation) {

        ArrayList<Faculty> listOfFaculty = new ArrayList<>();

        try {
            ObjectInputStream serializedFile = new ObjectInputStream(
                    new FileInputStream(fileLocation + "faculty.ser"));
            // Read the serialized object and cast to its original type
            listOfFaculty = (ArrayList<Faculty>) serializedFile.readObject();
        } catch (Exception exp) {
            // TO-DO
        } finally {
            return listOfFaculty;
        }
    }
}
