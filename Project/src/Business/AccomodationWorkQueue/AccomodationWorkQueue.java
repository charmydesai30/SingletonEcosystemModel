/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AccomodationWorkQueue;

import java.util.ArrayList;

/**
 *
 * @author Ami Gandhi
 */
public class AccomodationWorkQueue {
    
    private ArrayList<AccomodationWorkRequest> workRequestList;

    public AccomodationWorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<AccomodationWorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}