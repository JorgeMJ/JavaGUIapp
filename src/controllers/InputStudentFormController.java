/*
 * Listens for events on the input form. 
 * Implements the ActionListener interface which contains a single method, 
 * "actionPerformed" - this method contains all the logic to process the data
 * on the form, as well as several other events
 */
package controllers;

import datamodels.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import datacontainers.*;
import java.time.LocalDate;
import view.inputforms.StudentInputForm;
import exceptionhandlers.ErrorPopup;
import exceptionhandlers.InvalidDataException;

public class InputStudentFormController implements ActionListener {

    // The data datacontainers are passed in
    StudentDC studentDC;
    CourseDC courseDC;

    // Input form is created here
    StudentInputForm form;

    // Create a new Student object used in the event methods
    Student newStudent;

    public InputStudentFormController(StudentDC studentDC,
            CourseDC courseDC) {

        // store local pointers to the data datacontainers passed in
        this.studentDC = studentDC;
        this.courseDC = courseDC;

        // create the form, pass it this controller
        form = new StudentInputForm(this);

    }

    public void actionPerformed(ActionEvent event) {
        // TO-DO
        // Determine what the event is and call the appropriate method
        
          if (event.getActionCommand().equals("Save")) {
            this.saveData();
        } else if (event.getActionCommand().equals("Clear")) {
            this.clearForm();
        } else if (event.getActionCommand().equals("Close")) {
            this.closeForm();
        }
    }

    /**
     * Private method to save all the data on the form and create a new student
     * object
     */
    public void saveData() {

        // Create a new Student object used in the event methods
        newStudent = new Student();
        
        String studentName = form.getNameField().getText();
        String studentIdString;
        int studentIdInt;
        
        // Retrieve data from all text fields and store directly into object

        studentIdString = form.getStudentIdField().getText();
        
        try {

            if (isEmpty(studentName)) {
                throw new InvalidDataException("Missing Name!");
            }
            
            if (isEmpty(studentIdString)) {
                throw new InvalidDataException("Missing ID!");
            }
            
            if (!isValid(studentIdString)) {
                throw new InvalidDataException("Invalid ID!");
            }
            
            // If the name and the ID are valid, store ethem into object.
      
            studentIdInt = parseStudentId(studentIdString);
            newStudent.setName(studentName);
            newStudent.setStudentID(studentIdInt);
            newStudent.setAddress(form.getAddressField().getText());
                   
        

        // Retrieve GPA and convert to a double before storing in object
        // If there is a problem converting to a double, it will throw a built in
        // runtime exception. 
        String gpastring = form.getGpaField().getText();
        float gpadouble = Float.parseFloat(gpastring);
        newStudent.setGPA(gpadouble);

        // We retrieve the date data and convert to a LocalDate object 
        LocalDate lcDate = this.getDate(form.getDateOfBirthFormattedTextField1().getText());

        // Store 
        newStudent.setDateOfBirth(lcDate);

        lcDate = this.getDate(form.getDateOfGraduationFormattedTextField().getText());
        newStudent.setDateOfGraduation(lcDate);

        // Store
        this.studentDC.getListOfStudents().add(newStudent);
        
    }catch(InvalidDataException exception){

        ErrorPopup error = new ErrorPopup(form, exception);
    }

    }
    
     private static int parseStudentId(String studentId) {
        String newId = "";
        for (int i=0; i<studentId.length(); i++) {
            char nextChar = studentId.charAt(i);
            if (nextChar == '0') {
                // still zero, do nothing
            } else {
                // next char not zero, save it
                newId = studentId.substring(i, studentId.length());
                return Integer.parseInt(newId);
            }
        }
        return Integer.parseInt(newId);
    }

    /**
     * Private method to clear the data
     */
    private void clearForm() {
        // The text fields are set to blank
        form.getNameField().setText("");
        form.getStudentIdField().setText("");
        form.getAddressField().setText("");
        form.getGpaField().setText("");
        form.getDateOfBirthFormattedTextField1().setText("");
        form.getDateOfGraduationFormattedTextField().setText("");
    }

    /**
     * Private method to close the form
     */
    private void closeForm() {
        form.dispose();
    }

    //  The following methods are used by the form, you don't need to know how 
    //  these work but if you want to see how form data is transformed into 
    //  actual data types from strings, it's worth a read
    
    private LocalDate getDate(String formStringDate) {

        String[] dateElements = formStringDate.split("-");
        Integer dobMonth = this.getIntegerMonthFromString(dateElements[0]);
        Integer dobDay = Integer.parseInt(dateElements[1]);
        Integer dobYear = Integer.parseInt(dateElements[2]);
        LocalDate newdate = LocalDate.of(dobYear, dobMonth, dobDay);
        return newdate;
    }

    private int getIntegerMonthFromString(String stringmonth) {
        if (stringmonth.equals("Jan")) {
            return 0;
        } else if (stringmonth.equals("Feb")) {
            return 1;
        } else if (stringmonth.equals("Mar")) {
            return 2;
        } else if (stringmonth.equals("Apr")) {
            return 3;
        } else if (stringmonth.equals("May")) {
            return 4;
        } else if (stringmonth.equals("June")) {
            return 5;
        } else if (stringmonth.equals("Jul")) {
            return 6;
        } else if (stringmonth.equals("Aug")) {
            return 7;
        } else if (stringmonth.equals("Sep")) {
            return 8;
        } else if (stringmonth.equals("Oct")) {
            return 9;
        } else if (stringmonth.equals("Nov")) {
            return 10;
        } else {
            return 11;
        }
    }
    
    private boolean isEmpty(String data) {
        if (data.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isValid(String data) {

        if (data.matches("^[0-9]{7}")) {
            return true;
        } else {
            return false;
        }
    }

}
