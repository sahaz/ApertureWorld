/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CameraServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Cameras.*;

import java.sql.*;
/**
 *
 * @author bushmaster
 */
public class ValidateCameraServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
        String nextPage = "/ViewCamera.jsp";
        
        // Read in all form parameters
        String camera_id = request.getParameter("camera_id");
        String camera_category = request.getParameter("camera_category");
        String camera_name = request.getParameter("camera_name");
        String camera_price = request.getParameter("camera_price");
        String camera_description = request.getParameter("camera_description");
        String camera_email = request.getParameter("camera_email");
        String camera_image = "default.jpg";
        
        // Create a new object for all of the error messages we might need
        // to send back to the JSP
        CameraErrorList errors = new CameraErrorList();
        
        // Call each of the validaton methods, keepin track of what they return
        // so we know if anything  went wrong. Pass the CameeraErrorList to each
        // so it can be modified if an error is found by that method.
        
        boolean isIdValid = CameraValidation.validateId(camera_id, errors);
        boolean isCategoryValid = CameraValidation.validateCategory(camera_category, errors);
        boolean isNameValid = CameraValidation.validateName(camera_name, errors);
        boolean isPriceValid = CameraValidation.validatePrice(camera_price, errors);
        boolean isDescriptionValid = CameraValidation.validateDescription(camera_description, errors);
        boolean isEmailValid = CameraValidation.validateEmail(camera_email, errors);
        boolean isCameraUnique = CameraValidation.validateCameraUnique(camera_id, errors);
        
        // If no errors wer found, create the camera.
        // Otherwise, redirect back to the input page.
        if (isIdValid && isCategoryValid && isNameValid && isPriceValid && isDescriptionValid && isEmailValid && isCameraUnique) {
 
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet results = null;
        try {
            // Load the appropriate database driver
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            
            // Connect to the database through that driver, using the 
            // database url and the username and password
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ApertureWorld", "app", "app");
            //connection = DriverManager.getConnection(urlString, "root", "xyzzy1234");
        }
        catch (SQLException ex) {
            System.out.println("Connection failed!");
        }
        catch (Exception ex) {
            System.out.println("No driver!");
        }
        
        try {
      
            String template = "insert into Cameras "
                    + "(id, category, name, description, price, email)"
                    + "values (?, ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(template);
            statement.setString(1, camera_id);
            statement.setString(2, camera_category);
            statement.setString(3, camera_name);
            statement.setString(4, camera_description);
            statement.setInt(5, Integer.parseInt(camera_price));
            statement.setString(6, camera_email);
            int changed = statement.executeUpdate();
            System.out.println(changed+" records added");
        }      
        catch (SQLException ex) {
            System.out.println("Query failed!");
        }
        request.setAttribute("add_success", camera_name);
        
        CameraList cameras = new CameraList();
        cameras.loadCameras();
        session.setAttribute("cameraarray", cameras);

         getServletContext().getRequestDispatcher(nextPage).forward(request, response);
         
        }
        else {            
            nextPage = "/AddCamera.jsp";
            
            // Add the validation object to the session for use by the JSP
            request.setAttribute("errors", errors);
        }
        getServletContext().getRequestDispatcher(nextPage).forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
