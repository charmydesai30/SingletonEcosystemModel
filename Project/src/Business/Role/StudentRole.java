/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.StudentOrganization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.StudentRole.StudentAccomodationWorkAreaJPanel;

/**
 *
 * @author Charmy
 */
public class StudentRole extends Role{
    
    
    

    
     
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
         if(enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Accomodation)
         {
             
            return new StudentAccomodationWorkAreaJPanel(userProcessContainer, account, organization, enterprise);
       
         }
         return null;
    }
    
}

