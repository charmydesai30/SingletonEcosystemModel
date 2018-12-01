/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.AssistantManagerRole.AssistantAccomodationManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Ami Gandhi
 */
public class AssistantManagerRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        if(enterprise.getEnterpriseType()==Enterprise.EnterpriseType.Accomodation)
        {
        return new AssistantAccomodationManagerWorkAreaJPanel(userProcessContainer, account, organization, business);
        }
        return null;
    }
    
}
