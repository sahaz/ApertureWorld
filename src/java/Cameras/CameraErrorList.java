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
public class CameraErrorList {
    private boolean idMissing = false;
    private boolean idIllegal = false;
    private boolean nameMissing = false;
    private boolean categoryMissing = false;
    private boolean priceMissing = false;
    private boolean priceNotNumeric = false;
    private boolean descriptionMissing = false;
    private boolean emailMissing = false;
    private boolean emailIllegal = false;
    private boolean cameraAlreadyExists = false;

    public boolean isIdMissing() {
        return idMissing;
    }

    public void setIdMissing(boolean idMissing) {
        this.idMissing = idMissing;
    }

    public boolean isIdIllegal() {
        return idIllegal;
    }

    public void setIdIllegal(boolean idIllegal) {
        this.idIllegal = idIllegal;
    }

    public boolean isNameMissing() {
        return nameMissing;
    }

    public void setNameMissing(boolean nameMissing) {
        this.nameMissing = nameMissing;
    }

    public boolean isCategoryMissing() {
        return categoryMissing;
    }

    public void setCategoryMissing(boolean categoryMissing) {
        this.categoryMissing = categoryMissing;
    }

    public boolean isPriceMissing() {
        return priceMissing;
    }

    public void setPriceMissing(boolean priceMissing) {
        this.priceMissing = priceMissing;
    }

    public boolean isPriceNotNumeric() {
        return priceNotNumeric;
    }

    public void setPriceNotNumeric(boolean priceNotNumeric) {
        this.priceNotNumeric = priceNotNumeric;
    }

    public boolean isDescriptionMissing() {
        return descriptionMissing;
    }

    public void setDescriptionMissing(boolean descriptionMissing) {
        this.descriptionMissing = descriptionMissing;
    }

    public boolean isEmailMissing() {
        return emailMissing;
    }

    public void setEmailMissing(boolean emailMissing) {
        this.emailMissing = emailMissing;
    }

    public boolean isEmailIllegal() {
        return emailIllegal;
    }

    public void setEmailIllegal(boolean emailIllegal) {
        this.emailIllegal = emailIllegal;
    }

    public boolean isCameraAlreadyExists() {
        return cameraAlreadyExists;
    }

    public void setCameraAlreadyExists(boolean cameraAlreadyExists) {
        this.cameraAlreadyExists = cameraAlreadyExists;
    }

}
