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
    private ArrayList<BookstoreWorkRequest> bookstoreWorkRequestList;

    public WorkQueue() {
        workRequestList = new ArrayList();
        bookstoreWorkRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }

    public ArrayList<BookstoreWorkRequest> getBookstoreWorkRequestList() {
        return bookstoreWorkRequestList;
    }

    
    }