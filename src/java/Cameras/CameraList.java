/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cameras;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author bushmaster
 */
public class CameraList {
     // Internally, a CameraList is an array list of Camera objects
    private ArrayList<Camera> cameras;
    
    public CameraList() {
        cameras = new ArrayList();
        }
    // Return the list of cameras for iteration in a view
    public ArrayList getCameras() {
        return cameras;
    }
    
    
    public void loadCameras() {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
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
            // Create and execute query statement for all in Cameras table,
            // storing links to matching records in ResultSet object results.
            statement = connection.createStatement();
            results = statement.executeQuery("select * from Cameras order by SERIAL desc");
            
            // Loop to next record in results, while there is a next record.
            while (results.next()) {
                
                // Get each field of current record (as appropriate type)
                String camera_id = results.getString("id");
                String camera_category = results.getString("category");
                String camera_name = results.getString("name");
               
                String camera_description = results.getString("description");
                 String camera_price =  results.getString("price");
                String camera_email = results.getString("email"); 
                String camera_image = results.getString("image");
                // Construct a new course object from that data, and add to list
                Camera c = new Camera(camera_id, camera_category, camera_name, camera_price, camera_description, camera_image, camera_email); 
                cameras.add(c);
            }
        }        
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
    }
    
    // Construct a new Camera object directly from parameters read in from the form.
    public void add(String camera_id, String camera_category, String camera_name, String camera_description, String camera_price, String camera_image, String camera_email) {
        Camera c = new Camera(camera_id, camera_category, camera_name, camera_description, camera_price, camera_image, camera_email);
        cameras.add(c);
    }
    
    // Take an already existing Course as a parameter (possibly already in the
    // array of all courses) and add it to the list.
    public void add(Camera c) {
        cameras.add(c);
    }
    
     public int getSize() {
        return cameras.size();
    }
    
     public int getTotal(String camera_id){
           for (int i = 0; i < cameras.size(); i++) {
            Camera c = cameras.get(i);
            if (camera_id.equals(c.getCamera_id())) {
                return Integer.parseInt(c.getCamera_price());
            }
        }         
         return 0;
     }
     
     
    // Search the list for the camera withthe given id
    // and return  that Camera object.
    public Camera getCamera(String camera_id) {
        for (int i = 0; i < cameras.size(); i++) {
            Camera c = cameras.get(i);
            if (camera_id.equals(c.getCamera_id())) {
                return c;
            }
        }
        return null;
    }
    
    // Remove camera with given id from list,
    // using search method to find it first
    public void drop(String camera_id) {
        Camera c = getCamera(camera_id);
        cameras.remove(c);
    }
}
