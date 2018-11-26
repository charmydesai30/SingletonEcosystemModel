/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AssistantManagerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Ami Gandhi
 */
public class AssisstantManagerOrganization extends Organization{

    public AssisstantManagerOrganization() {
        super(Organization.Type.AssisstantManager.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new AssistantManagerRole());
        return roles;
    }
     
   
    
    
}
