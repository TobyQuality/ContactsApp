import java.util.Scanner;
import java.util.List;

public class ContactsApp {
    /* s
    private static CrudContactDao dao = new CrudContactDao();
    private final static String INTRO = "Commands:\n"
    + "show - show all of your contacts\n"
    + "add - you will fill a form to create a new contact\n"
    + "remove - remove a contact from your list\n"
    + "update - update your contact's information\n"
    + "help - show all the commands\n"
    + "quit - quit the application\n";

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(INTRO);

        boolean running = true;

        while (running) {
            System.out.print(">");
            String command = input.next();

            switch(command) {
                case "show":
                    showAll();
                    break;
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "update":
                    update();
                    break;
                case "help":
                    help();
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
            System.out.println();
        }

        System.out.println("Bye!");
        input.close();
    }

    private static void showAll() {
        List<Contact> contacts = dao.getAllContacts();
        if (contacts.isEmpty()) {
            System.out.println("No contacts");
        }else {
            System.out.println("Contacts:");
            int i = 1;
            for (Contact c : contacts) {
                System.out.println(i + ": " + c.toString());
                i++;
            }
        }
    }

    private static void add() {
        Scanner input = new Scanner(System.in);
        //variable name s abbreviated from String (array)
        String[] s = new String[6];
        String[] attributes = {"personal id", "first name", "last name", "phone number",
            "address", "email"};
        
        for (int i=0; i < s.length; i++) {
            System.out.println("Give " + attributes[i]);
            s[i] = input.nextLine();
            }

        Contact c = new Contact(s[0], s[1], s[2], s[3], s[4], s[5]);

        boolean successfulAdd = dao.addContact(c);

        if (successfulAdd) {
            System.out.println(c.getFirstName() + " " + c.getLastName()
            + " was succesfully added.");
        }else {
            System.out.println("Adding contact failed.");
        }
    }

    private static void remove() {
        Scanner input = new Scanner(System.in);
        List<Contact> contacts = dao.getAllContacts();
        Contact removeContact = null;

        System.out.println("Which contact do you want to remove?");

        String contactId = input.nextLine().trim();

        boolean foundId = false;

        for (int i=0; i < contacts.size(); i++) {
            String id = contacts.get(i).getId();

            if (contactId.equals(id)) {
                foundId = true;
                removeContact = contacts.get(i);
                break;
            }
        }

        if (foundId) {
            boolean removeSuccesful = dao.removeContact(removeContact);

            if (removeSuccesful) {
                System.out.print("Contact was successfully removed");
            }else {
                System.out.print("Removing contact failed.");
            }
        } else {
            System.out.println("No such contact was found.");
        }
    }

    private static void update() {
        Scanner input = new Scanner(System.in);
        List<Contact> contacts = dao.getAllContacts();
        Contact updateContact = null;

        System.out.print("Which contact do you want to update? Type the personal id");
        String contactId = input.nextLine().trim();

        boolean foundId = false;

        for (int i=0; i < contacts.size(); i++) {
            String id = contacts.get(i).getId();

            if (contactId.equals(id)) {
                foundId = true;
                updateContact = contacts.get(i);
                break;
            }
        }


        if (foundId) {

            String answer = null;
            String change = null;
            String[] attributes = {"first name", "last name", "phone number",
            "address", "email"};

            System.out.println("Type y to change info, otherwise press any other button");

            for (int i = 0; i < attributes.length; i++) {
                System.out.println("Do you want to change " + attributes[i] + "?");
                answer = input.nextLine();

                if (answer.equals("y")) {
                    if (i == 0) {
                        System.out.println("Change " + attributes[i]);
                        change = input.nextLine();
                        updateContact.setFirstName(change);
                    }
                    if (i == 1) {
                        System.out.println("Change " + attributes[i]);
                        change = input.nextLine();
                        updateContact.setLastName(change);;
                    }
                    if (i == 2) {
                        System.out.println("Change " + attributes[i]);
                        change = input.nextLine();
                        updateContact.setPhoneNumber(change);;
                    }
                    if (i == 3) {
                        System.out.println("Change " + attributes[i]);
                        change = input.nextLine();
                        updateContact.setAddress(change);
                    }
                    if (i == 4) {
                        System.out.println("Change " + attributes[i]);
                        change = input.nextLine();
                        updateContact.setEmail(answer);;
                    }
                }
            }

            boolean updateSuccessful = dao.updateContact(updateContact);

            if (updateSuccessful) {
                System.out.print("Contact was successfully updated");
            } else {
                System.out.print("Updating contact failed.");
            }

        } else {
            System.out.println("No such contact was found.");
        }
    }

    public static void help() {
        System.out.println(INTRO);
    }

    */

}