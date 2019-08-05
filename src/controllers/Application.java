/*
 * This is the main entry into the application. It creates a menu controller object
 * and the controller object creates the forms and the data models as needed
 */
package controllers;

public class Application {

    public static void main(String[] args) {

        // The location of input and output files is specified on the command
        // and read in as an argument via the args array
        String fileLocation = args[0];
        
        // Create main menu controller, the controller creates the menu form
        MainMenuController controller = new MainMenuController(fileLocation);

        // Retrieve the main menu form from the controller and make it visible
        controller.getMainMenu().setVisible(true);
    }
}
