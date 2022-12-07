import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * This class creates the frame for the app's GUI
 * @author Topias Laatu
 */
 public class AppFrame extends JFrame implements ActionListener {

    private Contact c = null;
    private ContactList cList = null;
    private JList contacts = null;

    public AppFrame() {
        cList = new ContactList();
        contacts = cList.getContacts();
        contacts.getSelectionModel().addListSelectionListener(e -> {
            Contact con = (Contact) contacts.getSelectedValue();
            setContact(con);
        });

        ImageIcon image = new ImageIcon("oak.jpg");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

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
            panel2.remove(contacts);
            cList = new ContactList();
            contacts = cList.getContacts();
            panel2.add(contacts);
        });
        

        JLabel appLabel = new JLabel();
        appLabel.setText("Contacts Application");
        appLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

        //Panels: components that are containers for other components

        panel1.add(appLabel);
        panel2.add(contacts);
        panel3.add(addButton);
        panel3.add(editButton);
        panel3.add(deleteButton);
        panel3.add(refreshButton);

        //Frame for the application:
        this.setTitle("Contacts Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 650);
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
        this.cList = new ContactList();
        this.contacts = cList.getContacts();
    }


 }