/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cameras;
import java.sql.*;
/**
 *
 * @author bushmaster
 */
public class CameraValidation {
  
    
    // Has the user enterd the course id? 
    // We compare the trimmed value with the empty string.
    public static boolean validateId(String camera_id, 
                                       CameraErrorList errors) {
        if ("".equals(camera_id.trim())) {
            errors.setIdMissing(true);
            return false;
        }
        // We compare the string to a regular expression which 
        // specifies the id must be starting with AW and followed by 3 numbers.
        String numRegEx = "AW\\d\\d\\d";
        camera_id = camera_id.trim();
        if (!camera_id.matches(numRegEx)) {
            errors.setIdIllegal(true);
            return false;
            }
        else {
            return true;
        }
    }
    
       // Has the user enterd the camera name? 
    // We compare the trimmed value with the empty string.
    public static boolean validateName(String camera_name, 
                                       CameraErrorList errors) {
        if ("".equals(camera_name.trim())) {
            errors.setNameMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
    
    // Has the user selected the category from the list?
    // If the category has no value, or is still "choose", then they haven't
    public static boolean validateCategory(String camera_category, 
                                         CameraErrorList errors) {
        if (camera_category == null || camera_category.equals("Default")) {
            errors.setCategoryMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
    
     // Has the user enterd the camera price? 
    // We compare the trimmed value with the empty string.
    public static boolean validatePrice(String camera_price, 
                                       CameraErrorList errors) {
        if ("".equals(camera_price.trim())) {
            errors.setPriceMissing(true);
            return false;
        }
        else {
            // If a NumberFormatException error occurs, the user has put non-integer
            // values into one of the fields, so create an priceNotNumeric error.
            try{
             int price = Integer.parseInt(camera_price.trim());
             if (price < 0) {
                    errors.setPriceNotNumeric(true);
                    return false;
                }
            }
            catch (NumberFormatException ex) {
                errors.setPriceNotNumeric(true);
                return false;
            }
            return true;
        }
    }
     // Has the user enterd the camera description? 
    // We compare the trimmed value with the empty string.
    public static boolean validateDescription(String camera_description, 
                                       CameraErrorList errors) {
        if ("".equals(camera_description.trim())) {
            errors.setDescriptionMissing(true);
            return false;
        }
        else {
            return true;
        }
    }
     // Has the user enterd the admin email? 
    // We compare the trimmed value with the empty string.
    public static boolean validateEmail(String camera_email, 
                                       CameraErrorList errors) {
        if ("".equals(camera_email.trim())) {
            errors.setEmailMissing(true);
            return false;
        }

        // We compare the string to a regular expression which 
        // specifies the email must be in correct format
        String numRegEx = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        camera_email = camera_email.trim();
        if (!camera_email.matches(numRegEx)) {
            errors.setEmailIllegal(true);
            return false;
            }
        else {
            return true;
        }
    }
    
    public static boolean validateCameraUnique(String camera_id, CameraErrorList errors) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        boolean alreadyExists = false;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ApertureWorld", "app", "app");
            
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        try {
            // Ceate parameterized query for existing course
            String template = "select * from Cameras "
                    + "where id = ?";
            statement = connection.prepareStatement(template);
            
            // Insert prefix and number of proposed course into query and perform
            statement.setString(1, camera_id);           
            results = statement.executeQuery();
            
            // If next returns true, some existing record has same prefix and number
            alreadyExists = results.next();
        }     
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        if (alreadyExists) {
            // If so, the related error is set to true, and false that all input is valid
            errors.setCameraAlreadyExists(true);  
            return false;            
        }
        else {
           return true;
        }
    } 
}
