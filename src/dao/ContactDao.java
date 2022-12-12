package dao;

import java.util.List;

/**
 * ContactDao is an interface that dictates 
 * the operations that Contact class has to implement.
 * 
 * ContactDao is based on Data Access Object model
 * that is used in JDBC and CRUD operations.
 * "In software, a data access object (DAO) is a pattern 
 * that provides an abstract interface to some type of database
 * or other persistence mechanism."
 * (https://en.wikipedia.org/wiki/Data_access_object)
 * 
 * @author Topias Laatu
 */

public interface ContactDao {
    public List<Contact> getAllContacts();

    public Contact getContact(String id);

    public boolean addContact(Contact contact);

    public boolean removeContact(Contact contact);

    public boolean updateContact (Contact contact);
}