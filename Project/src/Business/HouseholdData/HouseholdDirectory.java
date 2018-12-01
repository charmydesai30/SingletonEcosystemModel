/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.HouseholdData;

import Business.AccomodationData.*;
import java.util.ArrayList;

/**
 *
 * @author Charmy
 */
public class HouseholdDirectory {
     private ArrayList<Household> householdDataList;
      
    public HouseholdDirectory() {
        householdDataList= new  ArrayList<>();
        
    }

    public ArrayList<Household> getHouseholdDataList() {
        return householdDataList;
    }

    public void setHouseholdDataList(ArrayList<Household> householdDataList) {
        this.householdDataList = householdDataList;
    }
    public void sellHouseholdInformation( String furnitureType,
            double  cost ,int quantity,String fName,String lName, String status)
    {
        Household householdObject= new Household();
        householdObject.setfName(fName);
        householdObject.setlName(lName);        
        householdObject.setStatus(status);
        householdObject.setFurnitureType(furnitureType);
        householdObject.setCost(cost);
        householdObject.setQuantity(quantity);
        
        householdDataList.add(householdObject);
        
    }
}
