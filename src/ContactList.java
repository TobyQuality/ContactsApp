import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.util.List;

public class ContactList {

    JList<Contact> contacts = new JList<>();
    DefaultListModel<Contact> model = new DefaultListModel<>();
    CrudContactDao dao = new CrudContactDao();
    List<Contact> list;

    public ContactList() {
        contacts.setModel(model);
        list = dao.getAllContacts();

        if (!(list.isEmpty())) {
            for (Contact c : list) {
                model.addElement(c);
            }
        }

    }

    
    public JList<Contact> getContacts() {
        return this.contacts;
    }

    public Contact getContact(Contact c) {
        return c;
    }
    

}