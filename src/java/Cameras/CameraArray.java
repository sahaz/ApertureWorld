/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cameras;

/**
 *
 * @author bushmaster
 */
public class CameraArray {
    
    // Array of current Course objects
    Camera[] cameras;
    
    
    public Camera[] getCameras(){
        return cameras;
    }
    
     // Search the array of current cameras for one with the given
    // camera_id, and return the corresponding object in the array
    public Camera getCamera(String camera_id) {
        for (int i = 0; i < cameras.length; i++) {
            Camera c = cameras[i];
            if (camera_id.equals(c.getCamera_id())) {
                return c;
            }
        }
        return null;
    }
    
   
}
