import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CrudContactDao implements ContactDao interface
 * @author Topias Laatu
 */

public class CrudContactDao implements ContactDao {

  final String fileName = "contacts.csv";

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
      if(id == contact.getId()) {
        return contact;
      }
    }
    return null;
  }

  public boolean addContact(Contact c) {
      List<Contact> l = this.getAllContacts();

      try(FileWriter fw = new FileWriter(fileName, true)) {

            if (l.size() != 0) {
              fw.append("\n");
            }

            fw.append(c.getId() + "," + c.getFirstName() + "," + c.getLastName() + "," +
            c.getPhoneNumber() + "," + c.getAddress() + "," + c.getEmail());

            return true;
      } catch(Exception e) {
          System.out.println("Error: " + e.getMessage());
          return false;
      }
  }

  public boolean removeContact(Contact con) {

    List<Contact> l = this.getAllContacts();

    for (int i = 0; i < l.size(); i++) {
      if (l.get(i).equals(con)) {
        boolean test = l.get(i).equals(con);
        l.remove(i);
        break;
      }
    }

    try(FileWriter fw = new FileWriter("contacts.csv")) {
      
      for (int i = 0; i < l.size(); i++) {
        Contact c = l.get(i);
        fw.append(c.getId() + "," + c.getFirstName() + "," + c.getLastName() + "," +
                  c.getPhoneNumber() + "," + c.getAddress() + "," + c.getEmail());

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

  public boolean updateContact (Contact con)  {

    List<Contact> l = this.getAllContacts();

    for (int i = 0; i < l.size(); i++) {

      if (con.equals(l.get(i))) {

        l.set(i, new Contact(con.getId(), con.getFirstName(), con.getLastName(),
        con.getPhoneNumber(), con.getAddress(), con.getEmail()));

        break;
      }
    }

    try(FileWriter fw = new FileWriter(fileName)) {
      
      for (int i = 0; i < l.size(); i++) {

        Contact c = l.get(i);

        fw.append(c.getId() +","+ c.getFirstName() +","+ c.getLastName() +","+
                  c.getPhoneNumber() + "," + c.getAddress() + "," + c.getEmail());

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
