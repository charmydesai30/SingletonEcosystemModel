/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Ami Gandhi
 */
public abstract class WorkRequest {

    //data for Accomodation Enterprise
    String apptSize;
    double  noOfBathrooms ;
    String mattress;
    double rent;
    int noOfTenants;
    String groceries;
    String fName;
    String lName;
    
    //common data
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    
    
    // getter and setter for Accomodation
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
    
    //common getter and setter
    public WorkRequest(){
        requestDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }
}
