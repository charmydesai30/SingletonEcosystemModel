/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Ami Gandhi
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;
    private ArrayList<AccomodationWorkRequest> accomodationWorkRequestList;
    private ArrayList<BookstoreWorkRequest> bookstoreWorkRequestList;
    private ArrayList<HouseholdWorkRequest> householdWorkRequest;

    public WorkQueue() {
        workRequestList = new ArrayList();
        accomodationWorkRequestList= new ArrayList();
        bookstoreWorkRequestList = new ArrayList();
        householdWorkRequest=new ArrayList<>();
    }

    public ArrayList<AccomodationWorkRequest> getAccomodationWorkRequestList() {
        return accomodationWorkRequestList;
    }

    public void setAccomodationWorkRequestList(ArrayList<AccomodationWorkRequest> accomodationWorkRequestList) {
        this.accomodationWorkRequestList = accomodationWorkRequestList;
    }
     

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public ArrayList<BookstoreWorkRequest> getBookstoreWorkRequestList() {
        return bookstoreWorkRequestList;
    }

    
    public ArrayList<HouseholdWorkRequest> getHouseholdWorkRequests() {
        return householdWorkRequest;
    }
    }