import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.util.List;

public class AppList {

    JList<Contact> contacts = new JList<>();
    DefaultListModel<Contact> model = new DefaultListModel<>();
    CrudContactDao dao = new CrudContactDao();
    List<Contact> list;

    public AppList() {
        contacts.setModel(model);
        contacts.setLayoutOrientation(JList.VERTICAL);
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

    public int listSize() {
        return this.list.size();
    }

    public Contact getContact(int index) {
        return this.list.get(index);
    }
    
}