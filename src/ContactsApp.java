import java.util.Scanner;
import java.util.List;

public class ContactsApp {
    private static CrudContactDao dao = new CrudContactDao();
    private final static String INTRO = "Commands:\n"
    + "show - show all of your contacts\n"
    + "add - you will fill a form to create a new contact\n"
    + "remove - remove a contact from your list\n"
    + "update - update your contact's information\n"
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
        String[] s = new String[5];

        System.out.println("Give the contact's first name: ");
        s[0] = input.nextLine();

        System.out.println("Give the contact's last name: ");
        s[1] = input.nextLine();

        System.out.println("Give the contact's phone number");
        s[2] = input.nextLine();

        System.out.println("Give the contact's address");
        s[3] = input.nextLine();

        System.out.println("Give the contact's email");
        s[4] = input.nextLine();

        int randomizeId = (int) (Math.random() * 100000);
        String stringifyId = String.valueOf(randomizeId);

        Contact c = new Contact(stringifyId, s[0], s[1], s[2], s[3], s[4]);

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

        String contactName = input.nextLine().trim();

        boolean foundName = false;

        for (int i=0; i < contacts.size(); i++) {
            String name = contacts.get(i).getFirstName() + " " 
            + contacts.get(i).getLastName();

            if (contactName.equals(name)) {
                foundName = true;
                removeContact = contacts.get(i);
                break;
            }
        }

        if (foundName) {
            boolean removeSuccesful = dao.removeContact(removeContact);

            if (removeSuccesful) {
                System.out.print(contactName + " was successfully removed");
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

        System.out.print("Which contact do you want to update?");
        String contactName = input.nextLine().trim();

        boolean foundName = false;

        for (int i=0; i < contacts.size(); i++) {
            String name = contacts.get(i).getFirstName() + " " 
            + contacts.get(i).getLastName();

            if (contactName.equals(name)) {
                foundName = true;
                updateContact = contacts.get(i);
                break;
            }
        }


        if (foundName) {

            String answer = null;
            String change = null;
            String[] attributes = {"first name", "last name", "phone number",
            "address", "email"};

            for (int i = 0; i < attributes.length; i++) {
                System.out.println("Do you want to change " + attributes[i] + "?");
                answer = input.nextLine();

                if (answer.equals("yes")) {
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
                System.out.print(updateContact + " was successfully updated");
            } else {
                System.out.print("Updating contact failed.");
            }
        } else {
            System.out.println("No such contact was found.");
        }
    }

}