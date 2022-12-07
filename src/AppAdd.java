import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppAdd extends JFrame implements ActionListener {

    JFrame addWindow = new JFrame();
    CrudContactDao dao = new CrudContactDao();
    Contact c = new Contact();
    String[] attributes = new String[6];

    public AppAdd() {

        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JTextField textField3 = new JTextField(10);
        JTextField textField4 = new JTextField(10);
        JTextField textField5 = new JTextField(10);
        JTextField textField6 = new JTextField(10);


        JLabel jLabel1 = new JLabel("Id:");
        JLabel jLabel2 = new JLabel("First name:");
        JLabel jLabel3 = new JLabel("Last name:");
        JLabel jLabel4 = new JLabel("Phone number:");
        JLabel jLabel5 = new JLabel("Address:");
        JLabel jLabel6 = new JLabel("Email:");

        JButton button = new JButton("Submit");
        button.addActionListener(e -> {
            attributes[0] = textField1.getText();
            attributes[1] = textField2.getText();
            attributes[2] = textField3.getText();
            attributes[3] = textField4.getText();
            attributes[4] = textField5.getText();
            attributes[5] = textField6.getText();

            boolean validationSuccessful = true;

            try {
                c.setId(attributes[0]);
                c.setFirstName(attributes[1]);
                c.setLastName(attributes[2]);
                c.setPhoneNumber(attributes[3]);
                c.setAddress(attributes[4]);
                c.setEmail(attributes[5]);

            } catch (IllegalArgumentException err) {
                validationSuccessful = false;
                JOptionPane.showMessageDialog(null, "Validation failed, check the correct form",
                "Error", JOptionPane.ERROR_MESSAGE);
                c = new Contact();
                for (int i=0; i < attributes.length; i++) {
                    attributes[i] = null;
                }
            }


            if (validationSuccessful) {
                boolean successfullAdd = dao.addContact(c);
                c = new Contact();
                for (int i=0; i < attributes.length; i++) {
                    attributes[i] = null;
                }
                if (successfullAdd) {
                    JOptionPane.showMessageDialog(null, "Contact was added successfully",
                "Success", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Adding contact failed, please try again",
                "Error", JOptionPane.ERROR_MESSAGE);
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
        jPanel7.add(button);

        addWindow.setTitle("Add a new contact");
        addWindow.setSize(400, 400);
        addWindow.setVisible(true);
        addWindow.setLayout(new GridLayout(7, 1));

        addWindow.add(jPanel1);
        addWindow.add(jPanel2);
        addWindow.add(jPanel3);
        addWindow.add(jPanel4);
        addWindow.add(jPanel5);
        addWindow.add(jPanel6);
        addWindow.add(jPanel7);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //left empty intentionally to implement the interface
    }

}