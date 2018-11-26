/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;
import Business.Role.StudentRole;
import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author Charmy
 */
public class StudentOrganization extends Organization {
     public StudentOrganization() {
        super(Organization.Type.Student.getValue());
    }


    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new StudentRole());
        return roles;
    }
    
}
