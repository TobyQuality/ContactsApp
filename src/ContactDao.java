import java.util.ArrayList;
import java.util.List;

/**
 * ContactDaoModel is an interface that dictates 
 * the operations that Contact class has to implement
 * @author Topias Laatu
 */

 public interface ContactDao {
    public List<Contact> getAllContacts();

    public Contact getContact(String id);

    public boolean addContact(Contact contact);

    public boolean removeContact(Contact contact);

    public boolean updateContact (Contact contact);
 }