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
public class Camera {
    private String camera_id = "";
    private String camera_category = "";
    private String camera_name = "";
    private String camera_description = "";
    private String camera_price = "";
    private String camera_image = "";
    private String camera_email = "";

    public Camera(String camera_id, String camera_category, String camera_name, String camera_price, String camera_description, String camera_image, String camera_email) {
        this.camera_id = camera_id;
        this.camera_category = camera_category;
        this.camera_name = camera_name;
        this.camera_description = camera_description;
        this.camera_price = camera_price;
        this.camera_image = camera_image;
        this.camera_email = camera_email;
    }

    public String getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(String camera_id) {
        this.camera_id = camera_id;
    }

    public String getCamera_name() {
        return camera_name;
    }

    public void setCamera_name(String camera_name) {
        this.camera_name = camera_name;
    }

    public String getCamera_description() {
        return camera_description;
    }

    public void setCamera_description(String camera_description) {
        this.camera_description = camera_description;
    }

    public String getCamera_price() {
        return camera_price;
    }

    public void setCamera_price(String camera_price) {
        this.camera_price = camera_price;
    }

    public String getCamera_image() {
        return camera_image;
    }

    public void setCamera_image(String camera_image) {
        this.camera_image = camera_image;
    }

    public String getCamera_category() {
        return camera_category;
    }

    public void setCamera_category(String camera_category) {
        this.camera_category = camera_category;
    }

    public String getCamera_email() {
        return camera_email;
    }

    public void setCamera_email(String camera_email) {
        this.camera_email = camera_email;
    }

    
}
