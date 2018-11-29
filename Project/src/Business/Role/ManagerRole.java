/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.ManagerRole.AccomodationManagerWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.ManagerRole.BookstoreManagerWorkAreaJPanel;

/**
 *
 * @author Ami Gandhi
 */
public class ManagerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        if(enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Accomodation)
         {
        return new AccomodationManagerWorkAreaJPanel(userProcessContainer, account, (ManagerOrganization)organization, enterprise);
         }
        if(enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Bookstore)
         {
        return new BookstoreManagerWorkAreaJPanel(userProcessContainer, account, (ManagerOrganization)organization, enterprise);
         }
        return null;
    }
    
    
}
