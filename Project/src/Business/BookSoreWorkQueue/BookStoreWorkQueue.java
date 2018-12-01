/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BookSoreWorkQueue;

import Business.AccomodationWorkQueue.*;
import java.util.ArrayList;

/**
 *
 * @author Ami Gandhi
 */
public class BookStoreWorkQueue {
    
    private ArrayList<WorkRequest> workRequestList;

    public BookStoreWorkQueue() {
        workRequestList = new ArrayList();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}