import java.lang.IllegalArgumentException;
//import Validator

public class Contact {
    private String id = null;
    private String firstName = null;
    private String lastName = null;
    private String phoneNumber = null;
    private String address = null;
    private String email = null;
    private Validator validator = new Validator();

    public Contact(){
    }

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
        }else {
            throw new IllegalArgumentException();
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        if (this.validator.validateFirstName(firstName)) {
            this.firstName = firstName;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (this.validator.validateLastName(lastName)) {
            this.lastName = lastName;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (this.validator.validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        if (this.validator.validateAddress(address)) {
            this.address = address;
        }else {
            throw new IllegalArgumentException();
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (this.validator.validateEmail(email)) {
            this.email = email;
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Contact && ((Contact) o).id.equals(this.id);
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ". Id: " + id 
        + ". Phone number: " + phoneNumber + ". "
        + "Address: " + address + ". Email: " + email + ".";
    }

}
