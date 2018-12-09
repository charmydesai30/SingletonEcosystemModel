/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Charmy
 */
public abstract class AccomodationWorkRequest extends WorkRequest {
    String apptSize;
    double  noOfBathrooms ;
    String mattress;
    double rent;
    int noOfTenants;
    String groceries;
    String fName;
    String lName;
    String buyerName;
    String trackCartUser;
   

    public String getTrackCartUser() {
        return trackCartUser;
    }

    public void setTrackCartUser(String trackCartUser) {
        this.trackCartUser = trackCartUser;
    }

    

    

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
     public String getApptSize() {
        return apptSize;
    }

    public void setApptSize(String apptSize) {
        this.apptSize = apptSize;
    }

    public double getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public void setNoOfBathrooms(double noOfBathrooms) {
        this.noOfBathrooms = noOfBathrooms;
    }

    public String getMattress() {
        return mattress;
    }

    public void setMattress(String mattress) {
        this.mattress = mattress;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getNoOfTenants() {
        return noOfTenants;
    }

    public void setNoOfTenants(int noOfTenants) {
        this.noOfTenants = noOfTenants;
    }

    public String getGroceries() {
        return groceries;
    }

    public void setGroceries(String groceries) {
        this.groceries = groceries;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }
    
    public void setlName(String lName) {
        this.lName = lName;
    }
}
