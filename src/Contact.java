public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String email;

    public Contact(String i, String f, String l, String p, String a, String e) {
        this.id = i;
        this.firstName = f;
        this.lastName = l;
        this.phoneNumber = p;
        this.address = a;
        this.email = e;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Contact && ((Contact) o).id.equals(this.id);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ". Phone number : " + phoneNumber + ". "
        + "Address: " + address + ". Email: " + email + ".";
    }

}
