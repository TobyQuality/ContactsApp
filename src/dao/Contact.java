package dao;

import util.Validator;
import java.lang.IllegalArgumentException;

/**
 * Contact class is the object based data model
 * that dictates the form of the personal data,
 * which is entered in the "database" (contacts.csv file).
 * 
 * Only address and email are optional information,
 * all the other attributes need to have a value.
 * Validator class is instrumental in making sure
 * that information is added in the correct form.
 * The IllegalArgumentExceptions thrown by the class
 * are handled by the GUI classes in the directory "app".
 * 
 * @author Topias Laatu
 */
public class Contact {
    private String id = null;
    private String firstName = null;
    private String lastName = null;
    private String phoneNumber = null;
    private String address = null;
    private String email = null;
    private Validator validator = new Validator();

    /**
     * Constructor without arguments is used,
     * when a new contact is being made and
     * validation checks for the personal information
     * have to be made.
     */
    public Contact() {
    }

    /**
     * This is used, when saving into file all the contacts,
     * and all the validations have been done to new or updated contact.
     * 
     * @param i
     * @param f
     * @param l
     * @param p
     * @param a
     * @param e
     */
    public Contact(String i, String f, String l, String p, String a, String e) {
        this.setId(i);
        this.setFirstName(f);
        this.setLastName(l);
        this.setPhoneNumber(p);
        this.setAddress(a);
        this.setEmail(e);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {

        if (this.validator.validateId(id)) {
            this.id = id;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (this.validator.validateFirstName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (this.validator.validateLastName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (this.validator.validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getAddress() {
        return this.address;
    }
    
    //in the last remaining setter methods
    //it is possible to give empty or null values
    public void setAddress(String address) {
        if (address.equals(null) || address.equals("") ||
            address.equals("null")) {
            this.address = "null";
        } else if (this.validator.validateAddress(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (email.equals(null) || email.equals("") ||
            email.equals("null")) {
            this.email = "null";
        } else if (this.validator.validateEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // ID is the main identifier of a contact, which is why it is
    // sufficient in itself to be used in equal-method. No other
    // attribute checks are required. Equals-method
    // inherited from Object class must take Object-class object
    // as parameter. Since Contact class is a subclass of the
    // Object class, it can be given as a parameter.
    @Override
    public boolean equals(Object o) {
        return o instanceof Contact && ((Contact) o).id.equals(this.id);
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + 
        ". Id: " + id + ". Phone number: " + phoneNumber + ". "
        + "Address: " + address + ". Email: " + email + ".";
    }


}