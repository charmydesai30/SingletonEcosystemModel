package Business;

import Business.Person.Person;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author Ami Gandhi
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Person person = system.getPersonDirectory().createPerson("RRH");
        
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("admin", "admin", person, new SystemAdminRole());
        
        return system;
    }
    
}
