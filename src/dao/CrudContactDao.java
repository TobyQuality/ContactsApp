package dao;

import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CrudContactDao implements ContactDao interface.
 * 
 * CrudContactDao is in charge of CRUD operations.
 * Instead of using JDBC or SQL database,
 * the information is read from and stored in
 * "contacts.csv" file in src directory.
 * 
 * @author Topias Laatu
 */
public class CrudContactDao implements ContactDao {

    final String fileName = "contacts.csv";

    /**
    * The method is used to read the contacts.csv file and
    * return a List object.
    * 
    * The method reads the csv file using Scanner row by row,
    * utilizing the split method to place temporarily
    * the different attributes separated by commas in the rows,
    * which are then placed in a new Contact object, which in turn
    * is placed inside a List containing Contact objects.
    * The List object is utilized in other CrudContactDao methods
    * and it is also given to AppList object, which displays
    * the information in GUI.
    * 
    * @return l = the List object containing Contact objects.
    */
    public List<Contact> getAllContacts() {
        //variable name "l" is for "list"
        List<Contact> l = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            while(scanner.hasNextLine()) {
                String row = scanner.nextLine();

                //variable name "p" is for "pieces"
                String[] p = row.split(",");

                l.add(new Contact(p[0], p[1], p[2], p[3], p[4], p[5]));
            }

            return l;
        } catch(Exception e) {
              System.out.println("Error: " + e.getMessage());
              return l;
          }
      }

    public Contact getContact(String id) {     
        List<Contact> l = this.getAllContacts();
        for (Contact contact : l) {
            if (id == contact.getId()) {
                return contact;
            }
        }
        return null;
    }

    /**
     * This method adds a new contact into contacts.csv
     * 
     * The method takes a Contact object as parameter.
     * Filewriter object is utilized to add a new contact.
     * 
     * @param c
     * @return boolean value, depending if the adding
     * is successful or not.
     */
    public boolean addContact(Contact c) {
        List<Contact> l = this.getAllContacts();

        // when new Filewriter object is given
        // true value as next parameter, it adds to
        // the existing file, not rewrite the whole file
        try(FileWriter fw = new FileWriter(fileName, true)) {

            if (l.size() != 0) {
                fw.append("\n");
            }

            fw.append(c.getId() + "," + c.getFirstName() 
            + "," + c.getLastName() + "," + c.getPhoneNumber() + ","
            + c.getAddress() + "," + c.getEmail());

            return true;
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    /**
     * This is used for removing contacts from the csv file.
     * 
     * It is assumed that the contact to be removed has been
     * selected in the GUI and the method then rewrites the
     * csv file with the selected contact removed.
     * 
     * @param con
     * @return boolean value to give information if the
     * deletion is succesful or not
     */
    public boolean removeContact(Contact con) {
        List<Contact> l = this.getAllContacts();

        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equals(con)) {
                l.remove(i);
                break;
            }
        }

        try(FileWriter fw = new FileWriter("contacts.csv")) {
          
            for (int i = 0; i < l.size(); i++) {
                Contact c = l.get(i);
                fw.append(c.getId() + "," + c.getFirstName() + "," 
                + c.getLastName() + "," +c.getPhoneNumber() + "," 
                + c.getAddress() + "," + c.getEmail());

                    if (i + 1 < l.size()) {
                        fw.write("\n");
                    }
            }

            return true;
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }

    }

    /**
     * This method is used for changing information
     * of a certain contact within the csv file
     * 
     * The contact, whose information has been changed in the GUI,
     * is given as the parameter. Only the ID is not to be changed.
     * The ID is used for identifying purposes, as the ID is used
     * for finding the contact from the list, then given the changed
     * information, and finally the csv file is rewritten with the changed
     * contact information.
     * 
     * @param con
     * @return A boolean value is returned to give information,
     * if the update was successful or not.
     */
    public boolean updateContact (Contact con)  {

        List<Contact> l = this.getAllContacts();

        for (int i = 0; i < l.size(); i++) {

            if (con.equals(l.get(i))) {

                l.set(i, new Contact(
                con.getId(), con.getFirstName(), con.getLastName(),
                con.getPhoneNumber(), con.getAddress(), con.getEmail()
                ));

                break;
            }
        }

        try(FileWriter fw = new FileWriter(fileName)) {
          
            for (int i = 0; i < l.size(); i++) {

                Contact c = l.get(i);

                fw.append(c.getId() + ","+ c.getFirstName() + ","
                + c.getLastName() + "," +c.getPhoneNumber() + ","
                + c.getAddress() + "," + c.getEmail());

                    if (i + 1 < l.size()) {
                        fw.write("\n");
                    }
            }

            return true;
            
            } catch(Exception e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
    }

}