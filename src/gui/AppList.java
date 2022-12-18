package gui;

import dao.*;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import java.util.List;

/**
 * AppList class creates the JList component that shows
 * the personal information within contacts.csv in the AppMainFrame.
 * 
 * @author Topias Laatu
 * 
 */
public class AppList {

    JList<Contact> contactsShown = new JList<>();
    DefaultListModel<Contact> model = new DefaultListModel<>();
    CrudContactDao dao = new CrudContactDao();
    List<Contact> list;

    /**
     * The constructor sets the model for the JList,
     * which makes the manipulation of data possible.
     * The model is then given Contact objects with the help of
     * dao object, which returns a List object containing Contact
     * objects.
     */
    public AppList() {
        contactsShown.setModel(model);
        contactsShown.setLayoutOrientation(JList.VERTICAL);
        list = dao.getAllContacts();

        if (!(list.isEmpty())) {
            for (Contact c : list) {
                model.addElement(c);
            }
        }
    }

    /**
     * 
     * @return contacts - JList component for the GUI
     */
    public JList<Contact> showContacts() {
        return this.contactsShown;
    }

    /**
     * @return the number of the contacts within the list
     */
    public int listSize() {
        return this.list.size();
    }

    /**
     * 
     * @param index
     * @return a contact contained within list variable
     * according to its index number.
     */
    public Contact getContact(int index) {
        return this.list.get(index);
    }
    
}