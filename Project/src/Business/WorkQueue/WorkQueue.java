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
    private ArrayList<HouseholdWorkRequest> householdWorkRequest;

    public WorkQueue() {
        workRequestList = new ArrayList();
        householdWorkRequest=new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    
    public ArrayList<HouseholdWorkRequest> getHouseholdWorkRequests() {
        return householdWorkRequest;
    }
    
}