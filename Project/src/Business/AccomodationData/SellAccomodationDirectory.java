/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.AccomodationData;

import java.util.ArrayList;

/**
 *
 * @author Charmy
 */
public class SellAccomodationDirectory {
     private ArrayList<SellAccomodation> sellAccomodationDataList;
      
    public SellAccomodationDirectory() {
        sellAccomodationDataList= new  ArrayList<>();
        
    }



    public ArrayList<SellAccomodation> getSellAccomodationDataList() {
        return sellAccomodationDataList;
    }

    public void setSellAccomodationDataList(ArrayList<SellAccomodation> sellAccomodationDataList) {
        this.sellAccomodationDataList = sellAccomodationDataList;
    }
    public void sellAccomodationInformation( String apptSize,double  noOfBathrooms ,String mattress,double rent,int noOfTenants,String groceries,String fName,String lName)
    {
        SellAccomodation sellAcc= new SellAccomodation();
        sellAcc.setApptSize(apptSize);
        sellAcc.setNoOfBathrooms(noOfBathrooms);
        sellAcc.setNoOfTenants(noOfTenants);
        sellAcc.setMattress(mattress);
        sellAcc.setRent(rent);
        sellAcc.setGroceries(groceries);
        sellAcc.setfName(fName);
        sellAcc.setlName(lName);
        sellAccomodationDataList.add(sellAcc);
        
    }
}
