package gui;

import dao.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * AppDelete class contains the window for deleting contacts.
 * 
 * Editing or changing contact information is blocked.
 * Option window pops up to make sure the user really wants to delete
 * a contact.
 * 
 * @author Topias Laatu
 */
public class AppDelete extends JFrame implements ActionListener {

    private CrudContactDao dao = new CrudContactDao();
    private String[] attributes = new String[6];
    private Contact c;

    /**
     * The method creates a new frame for deletion operation.
     * 
     * @param con The Contact object is selected from the JList
     */
    public AppDelete(Contact con) {
        c= con;

        JTextField textField1 = new JTextField(10);
        textField1.setText(c.getId());
        textField1.setEditable(false);
        JTextField textField2 = new JTextField(10);
        textField2.setText(c.getFirstName());
        textField2.setEditable(false);
        JTextField textField3 = new JTextField(10);
        textField3.setText(c.getLastName());
        textField3.setEditable(false);
        JTextField textField4 = new JTextField(10);
        textField4.setText(c.getPhoneNumber());
        textField4.setEditable(false);
        JTextField textField5 = new JTextField(10);
        textField5.setText(c.getAddress());
        textField5.setEditable(false);
        if (c.getAddress().equals("null")) {
            textField5.setText("");
        }
        JTextField textField6 = new JTextField(10);
        textField6.setText(c.getEmail());
        textField6.setEditable(false);
        if (c.getEmail().equals("null")) {
            textField6.setText("");
        }

        JLabel jLabel1 = new JLabel("Id:");
        JLabel jLabel2 = new JLabel("First name:");
        JLabel jLabel3 = new JLabel("Last name:");
        JLabel jLabel4 = new JLabel("Phone number:");
        JLabel jLabel5 = new JLabel("Address:");
        JLabel jLabel6 = new JLabel("Email:");

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> {
            attributes[0] = textField1.getText();
            attributes[1] = textField2.getText();
            attributes[2] = textField3.getText();
            attributes[3] = textField4.getText();
            attributes[4] = textField5.getText();
            attributes[5] = textField6.getText();

            c.setId(attributes[0]);
            c.setFirstName(attributes[1]);
            c.setLastName(attributes[2]);
            c.setPhoneNumber(attributes[3]);
            c.setAddress(attributes[4]);
            c.setEmail(attributes[5]);
            
            //number 3 is random, as JOptionPane.YES_NO_CANCEL_OPTION
            //returns -1,0,1 or 2.
            int answer = 3;
            answer = JOptionPane.showConfirmDialog(null, 
            "Do you really want to delete the contact?",
            "Confirm deletion", 
            JOptionPane.YES_NO_CANCEL_OPTION);

            if (answer == 0) {
                boolean successfulDelete = dao.removeContact(c);

                answer = 3;
                c = new Contact();

                for (int i=0; i < attributes.length; i++) {
                    attributes[i] = null;
                }

                if (successfulDelete) {
                    JOptionPane.showMessageDialog(null, 
                    "Contact was deleted successfully",
                    "Success", 
                    JOptionPane.PLAIN_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, 
                    "Deleting contact failed, please try again",
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JPanel jPanel5 = new JPanel();
        JPanel jPanel6 = new JPanel();
        JPanel jPanel7 = new JPanel();

        jPanel1.add(jLabel1);
        jPanel2.add(jLabel2);
        jPanel3.add(jLabel3);
        jPanel4.add(jLabel4);
        jPanel5.add(jLabel5);
        jPanel6.add(jLabel6);
        jPanel1.add(textField1);
        jPanel2.add(textField2);
        jPanel3.add(textField3);
        jPanel4.add(textField4);
        jPanel5.add(textField5);
        jPanel6.add(textField6);
        jPanel7.add(deleteButton);

        this.setTitle("Delete a contact");
        this.setSize(400, 400);
        this.setVisible(true);
        this.setLayout(new GridLayout(7, 1));

        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
        this.add(jPanel4);
        this.add(jPanel5);
        this.add(jPanel6);
        this.add(jPanel7);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //left empty intentionally to implement the interface
    }

}
