package gui;

import dao.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * This class creates the main frame for the app's GUI).
 * 
 * The frame has a header, a search bar for contacts,
 * a list of all the contacts contained within contacts.csv file
 * and buttons for adding, deleting and updating contacts,
 * as well as a refresh button to render the app, after
 * changes have been made to the list.
 * 
 * @author Topias Laatu
 */
 public class AppMainFrame extends JFrame implements ActionListener {

    private Contact c = null;
    private AppList appList = null;
    private JList jList = null;

    /**
     * The constructor creates the main frame of the GUI.
     * 
     * Additional windows are opened by pressing the buttons
     * with titles "Add", "Edit" and "Delete". A contact has to
     * be selected with a mouse click from the list in the middle
     * in order for the edit and delete windows to open.
     */
    public AppMainFrame() {
        appList = new AppList();
        jList = appList.showContacts();
        //the list listener is used for selecting a contact
        //from the list that is given as a parameter to either
        //AppEdit() or AppDelete constructors.
        jList.getSelectionModel().addListSelectionListener(e -> {
            Contact con = (Contact) jList.getSelectedValue();
            setContact(con);
        });

        // panels: Components that are containers for other components
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        // this element goes into panel1
        JLabel appLabel = new JLabel();
        appLabel.setText("Contacts Application");
        appLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        // these elements go into panel2
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(jList);
        jList.setLayoutOrientation(JList.VERTICAL);

        JPanel searchPanel = new JPanel();

        JLabel searchLabel = new JLabel();
        searchLabel.setText("Search by ID:");

        JTextField searchField = new JTextField(10);

        JButton searchButton = new JButton("Search");
        //the lambda function that is added to the button
        //is used to look for contacts based on their ID.
        searchButton.addActionListener(e -> {
            String searchString = searchField.getText();
            Contact c = null;
            boolean found = false;
            if (0 < appList.listSize()) {
                for (int i=0; i < appList.listSize(); i++) {
                    c = appList.getContact(i);
                    if (searchString.equals(c.getId())) {
                        JOptionPane.showMessageDialog(null, 
                        "Contact information: " + "\n"
                        + "Id: " + c.getId() + "\n"
                        + "Name: "+ c.getFirstName() +" "+ c.getLastName() +"\n"
                        + "Phone number: " + c.getPhoneNumber() + "\n"
                        + "Address: " + c.getAddress() + "\n"
                        + "Email: " + c.getEmail(),
                        "Search successful", 
                        JOptionPane.PLAIN_MESSAGE);
                        c = null;
                        found = true;
                        break;
                    }
                }
            } 
            
            if (found == false) {
                JOptionPane.showMessageDialog(null, 
                "No such contact exists",
                "Search unsuccessful",
                JOptionPane.PLAIN_MESSAGE);
                c = null;
            }
        });

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // these button elements go into panel3
        JButton addButton = new JButton();
        addButton.setText("Add");
        addButton.addActionListener(e -> new AppAdd() );
        JButton editButton = new JButton();
        editButton.setText("Edit");
        //a contact from the JList (within scrollPane variable)
        //needs to be selected in order for the Edit Window to open
        editButton.addActionListener(e -> {
            if (c != null) {
                new AppEdit(c);
            }
        });

        JButton deleteButton = new JButton();
        deleteButton.setText("Delete");
        //a contact from the JList (within scrollPane variable)
        //needs to be selected in order for the Delete Window to open
        deleteButton.addActionListener(e -> {
            if (c != null) {
                new AppDelete(c);
            }
        });
        
        JButton refreshButton = new JButton();
        refreshButton.setText("Refresh");
        //the refresh button's function is needed
        //to refresh the view of the app after a change
        //to the contact list is made. This is done
        //by making a new scrollPane with new
        //AppList object. The setVisible with
        //false then true parameters is needed
        //for "rendering".
        refreshButton.addActionListener(e -> {
            panel2.remove(scrollPane);
            appList = new AppList();
            jList = appList.showContacts();
            scrollPane.setViewportView(jList);
            jList.setLayoutOrientation(JList.VERTICAL);
            panel2.add(scrollPane);
            jList.getSelectionModel().addListSelectionListener(event -> {
                Contact con = (Contact) jList.getSelectedValue();
                setContact(con);
            });
            this.setVisible(false);
            this.setVisible(true);
        });

        //Panels: components that are containers for other components
        panel1.add(appLabel);
        panel2.add(searchPanel);
        panel2.add(scrollPane);
        panel3.add(addButton);
        panel3.add(editButton);
        panel3.add(deleteButton);
        panel3.add(refreshButton);

        //the "logo" for the application
        ImageIcon image = new ImageIcon("oak.jpg");

        //Frame for the application and its configurations
        this.setTitle("Contacts Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 500);
        this.setVisible(true);
        this.setLayout(new BorderLayout(10,10));
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(240,255,255));
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //left empty intentionally to implement the interface
    }

    // the two methods below had to be made
    // in order to make the lambda expression
    // to function properly, because local variables
    // can't be manipulated directly in a lambda,
    // but it can be done through a method call

    /**
     * Sets a contact within lambda.
     * @param con
     */
    public void setContact(Contact con) {
        this.c = con;
    }

    /**
     * creates a new AppList for the variable
     * appList and creates a new JList object for the
     * variable contacts. 
     */
    public void setContactList() {
        this.appList = new AppList();
        this.jList = appList.showContacts();
    }

 }