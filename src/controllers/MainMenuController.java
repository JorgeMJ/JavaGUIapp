/*
 * Listens for events on the menu form. 
 * Implements the ActionListener interface which contains a single method, 
 * "actionPerformed"
 */
package controllers;

import java.awt.event.ActionListener;
import datacontainers.ClassroomDC;
import datacontainers.CourseDC;
import datacontainers.FacultyDC;
import datacontainers.StudentDC;
import utilities.ClassroomIO;
import utilities.CourseIO;
import utilities.FacultyIO;
import utilities.StudentIO;
import datamodels.Classroom;

import view.MainMenu;

public class MainMenuController implements ActionListener {

    // File location
    String fileLocation;
    
    /**
     * Constructor
     * @param fileLocation 
     */
    public MainMenuController(String fileLocation) {
        this.fileLocation = fileLocation;
    }
    
    // The data models are instantiated here and passed to the 
    // constructors for the controllers
    ClassroomDC datacontainer = new ClassroomDC();
    CourseDC courseDao = new CourseDC();
    StudentDC studentDao = new StudentDC();
    FacultyDC facultyDao = new FacultyDC();
    
    // The main menu form gets created here. Notice it takes this controller object
    // as an argument to the constructor
    private MainMenu mainMenu = new MainMenu(this);

    /**
     * The ActionListener interface contains a single method, actionPerformed
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {

        //  Figure out which button was clicked
        String menuItemClicked = event.getActionCommand();

        // create the controller which will open the correct form
        
        //Classroom
        if (menuItemClicked.equals("Add Classroom")) {
            InputClassroomFormController inputController = new InputClassroomFormController(datacontainer);
        } else if (menuItemClicked.equals("List Classrooms")) {
            ReportClassroomController reportController = new ReportClassroomController(datacontainer);
        } else if (menuItemClicked.equals("Exit")) {
            System.exit(0);      
        } else if (menuItemClicked.equals("Save Data")) {
            ClassroomIO.writeSerializedFile(fileLocation, datacontainer);
            ClassroomIO.writeTextFile(fileLocation, datacontainer);
            ClassroomIO.writeXMLFile(fileLocation, datacontainer);
            ClassroomIO.writeJSONFile(fileLocation, datacontainer);
        } else if (menuItemClicked.equals("Load Data")) {
            datacontainer.setListOfClassrooms(ClassroomIO.readSerializedFile(fileLocation));
            datacontainer.setListOfClassrooms(ClassroomIO.readTextFile(fileLocation));
            datacontainer.setListOfClassrooms(ClassroomIO.readXMLFile(fileLocation));
            datacontainer.setListOfClassrooms(ClassroomIO.readJSONFile(fileLocation));
        }
        
         //Course
        
        if (menuItemClicked.equals("Add Course")) {
            InputCourseController inputController = new InputCourseController(courseDao, datacontainer);
        } else if (menuItemClicked.equals("List Courses")) {
            ReportCourseController reportController = new ReportCourseController(courseDao);
        } else if (menuItemClicked.equals("Save Data")) {
            CourseIO.writeJSONFile(fileLocation, courseDao);
            CourseIO.writeSerializedFile(fileLocation, courseDao);
            CourseIO.writeTextFile(fileLocation, courseDao);
        } else if (menuItemClicked.equals("Load Data")) {
            courseDao.setListOfCourses(CourseIO.readJSONFile(fileLocation));
            courseDao.setListOfCourses(CourseIO.readSerializedFile(fileLocation));
        }
        
        //Faculty
        
         if (menuItemClicked.equals("Add Faculty")) {
            InputFacultyFormController inputController = new InputFacultyFormController(facultyDao, courseDao);
        } else if (menuItemClicked.equals("List Faculty")) {
            ReportFacultyController reportController = new ReportFacultyController(facultyDao);
        } else if (menuItemClicked.equals("Save Data")) {
            FacultyIO.writeJSONFile(fileLocation, facultyDao);
            FacultyIO.writeSerializedFile(fileLocation, facultyDao);
            FacultyIO.writeTextFile(fileLocation, facultyDao);
        } else if (menuItemClicked.equals("Load Data")) {
            facultyDao.setListOfFaculty(FacultyIO.readJSONFile(fileLocation));
            facultyDao.setListOfFaculty(FacultyIO.readSerializedFile(fileLocation));
        }
         
        //Student
        
          if (menuItemClicked.equals("Add Student")) {
            InputStudentFormController inputController = new InputStudentFormController(studentDao, courseDao);
        } else if (menuItemClicked.equals("List Students")) {
            ReportStudentController reportController = new ReportStudentController(studentDao);
        } else if (menuItemClicked.equals("Save Data")) {
            StudentIO.writeJSONFile(fileLocation, studentDao);
            StudentIO.writeSerializedFile(fileLocation, studentDao);
            StudentIO.writeTextFile(fileLocation, studentDao);
        } else if (menuItemClicked.equals("Load Data")) {
            studentDao.setListOfStudents(StudentIO.readJSONFile(fileLocation));
            studentDao.setListOfStudents(StudentIO.readSerializedFile(fileLocation));
        }
    }

    // Getter used in the Application.java class
    public MainMenu getMainMenu() {
        return mainMenu;
    }
}
