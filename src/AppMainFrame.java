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
 * This class creates the main frame for the app's GUI
 * @author Topias Laatu
 */
 public class AppMainFrame extends JFrame implements ActionListener {

    private Contact c = null;
    private AppList appList = null;
    private JList contacts = null;

    public AppMainFrame() {
        appList = new AppList();
        contacts = appList.getContacts();
        contacts.getSelectionModel().addListSelectionListener(e -> {
            Contact con = (Contact) contacts.getSelectedValue();
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
        scrollPane.setViewportView(contacts);
        contacts.setLayoutOrientation(JList.VERTICAL);

        JPanel searchPanel = new JPanel();

        JLabel searchLabel = new JLabel();
        searchLabel.setText("Search");

        JTextField searchField = new JTextField(10);

        JButton searchButton = new JButton("search");
        searchButton.addActionListener(e -> {
            String searchString = searchField.getText();
            Contact c = null;
            if (0 < appList.listSize()) {
                for (int i=0; i < appList.listSize(); i++) {
                    c = appList.getContact(i);
                    if (searchString.equals(c.getId())) {
                        JOptionPane.showMessageDialog(null, 
                        "Contact information: " + "\n"
                        + "Id: " + c.getId() + "\n"
                        + "Name: "+c.getFirstName() +" "+c.getLastName()+"\n"
                        + "Phone number: " + c.getPhoneNumber() + "\n"
                        + "Address: " + c.getAddress() + "\n"
                        + "Email: " + c.getEmail(),
                        "Search successful", 
                        JOptionPane.PLAIN_MESSAGE);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, 
                        "No such contact exists",
                        "Search unsuccessful",
                        JOptionPane.PLAIN_MESSAGE);
                        break;
                    }
                }
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
        editButton.addActionListener(e -> {
            if (c != null) {
                new AppEdit(c);
            }
        });

        JButton deleteButton = new JButton();
        deleteButton.setText("Delete");
        deleteButton.addActionListener(e -> {
            if (c != null) {
                new AppDelete(c);
            }
        });
        
        JButton refreshButton = new JButton();
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(e -> {
            panel2.remove(scrollPane);
            appList = new AppList();
            contacts = appList.getContacts();
            scrollPane.setViewportView(contacts);
            contacts.setLayoutOrientation(JList.VERTICAL);
            panel2.add(scrollPane);
            contacts.getSelectionModel().addListSelectionListener(event -> {
                Contact con = (Contact) contacts.getSelectedValue();
                setContact(con);
            });
            this.setVisible(false);
            this.setVisible(true);
        });

        //Panels: components that are containers for other components

        panel1.add(appLabel);
        panel2.add(scrollPane);
        panel2.add(searchPanel);
        panel3.add(addButton);
        panel3.add(editButton);
        panel3.add(deleteButton);
        panel3.add(refreshButton);

        ImageIcon image = new ImageIcon("oak.jpg");

        //Frame for the application:
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

    public void setContact(Contact con) {
        this.c = con;
    }

    public void setContactList() {
        this.appList = new AppList();
        this.contacts = appList.getContacts();
    }


 }