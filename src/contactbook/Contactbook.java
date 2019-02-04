/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package contactbook;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Contactbook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    // TODO code application logic here
    /*char choice;
        Menu m = new Menu();
        //while(true){
            do{
                m.showMenu();
                choice=(char)System.in.read();
            }
            while(!m.isValid(choice));
            /*if(choice==6)
            {
                System.out.println("Have a nice day");
                break;
            }
            m.selectedMenu(choice);
            */
            Contactstore cs = new Contactstore();
            cs.addContact("01750187821", "Biman", "Saha");
            cs.addContact("01755187821", "Nazmul", "Islam");
            cs.addContact("01750187821", "Sohel", "Rahman");
            cs.addContact("01756187821", "Uttam", "Saha");
            
            ArrayList<Contact> allContacts = cs.getAllContacts();
            for(Contact c : allContacts) {
                System.out.println(c.getId() + " " + c.getFullname() + " " + c.getPhoneNo());
            }
            
            ArrayList<Contact> filteredContacts = cs.searchContact("01750187821");
            for(Contact c : filteredContacts) {
                System.out.println(c.getId() + " " + c.getFullname() + " " + c.getPhoneNo());
            }
            
        //}
    }
}
