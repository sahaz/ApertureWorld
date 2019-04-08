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

/**
 *
 * @author bushmaster
 */
public class AddCameraServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        
        
        //To get the CameraList "cart" of camera from the session
        HttpSession session = request.getSession();
        CameraList cameras = (CameraList)session.getAttribute("cameralist");
        
         // If the user has not yet added cameras, it will be null initially,
        // so construct a new CameraList cart in that case.
        if (cameras == null) {
            cameras = new CameraList();
        }
        
         // Get the camera id from the request
        String camera_id = request.getParameter("camera_id");
        if (session.getAttribute("cart_total") == null){
            session.setAttribute("cart_total", 0);
        }
        
         // Look them up in the array of all cameras stored in  the session        
        CameraList allcameras = (CameraList)session.getAttribute("cameraarray");
        Camera camera = allcameras.getCamera(camera_id);
        
        int cartTotal = (int)session.getAttribute("cart_total");
        if (cartTotal == 0 ){
            
        }
        cartTotal += allcameras.getTotal(camera_id);
        
        
        // Add the new camera to the cart, and store the modified cart back in the session.
        cameras.add(camera);
        session.setAttribute("cameralist", cameras);
        session.setAttribute("cart_total", cartTotal);
        
        
        getServletContext().
                getRequestDispatcher("/CamerasCart.jsp").
                        forward(request, response);
        
       
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
