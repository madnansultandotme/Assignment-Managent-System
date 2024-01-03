import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> userTypeComboBox;

    public SignUpUI() {

        frame = new JFrame("Signup");
        frame.setSize(350, 250); // Decreased frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10)); // Adjusted layout
        frame.setUndecorated(true);// Remove controls from the Frame
        usernameField = new JTextField(15); // Decreased field width
        passwordField = new JPasswordField(15); // Decreased field width

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        String[] userTypes = { "Teacher", "Student" };
        userTypeComboBox = new JComboBox<>(userTypes);

        JButton signupButton = new JButton("Signup");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel("User Type:"));
        panel.add(userTypeComboBox);
        panel.add(new JLabel()); // Placeholder
        panel.add(signupButton);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String userType = (String) userTypeComboBox.getSelectedItem();

                // Here, you can perform your validation or any other action based on the input data
                if (isValidCredentials(username, password)) {
                   // JOptionPane.showMessageDialog(null, "Credentials Valid!"); // Display a success message
                    // Perform additional actions if credentials are valid
                    openDetailsInputScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again."); // Display an error message
                }
            }
        });
        // Added padding from the right side
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.add(panel);
        frame.setVisible(true);
    }
    private void clearFields() {
        usernameField.setText("");
        passwordField.setText("");
        userTypeComboBox.setSelectedIndex(0);
    }
    private void openDetailsInputScreen() {
        JFrame detailsFrame = new JFrame("Additional Details");
        detailsFrame.setSize(400, 300);
        detailsFrame.setLocationRelativeTo(null);
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(5, 2, 10, 10)); // Updated layout
        detailsFrame.setUndecorated(true);
        // Decreased field width and added padding
        JTextField universityIdField = new JTextField(15);
        universityIdField.setMargin(new Insets(5, 5, 5, 5)); // Adding padding/margin

        JTextField firstNameField = new JTextField(15);
        firstNameField.setMargin(new Insets(5, 5, 5, 5)); // Adding padding/margin

        JTextField lastNameField = new JTextField(15);
        lastNameField.setMargin(new Insets(5, 5, 5, 5)); // Adding padding/margin

        JTextField addressField = new JTextField(15);
        addressField.setMargin(new Insets(5, 5, 5, 5)); // Adding padding/margin

        JLabel universityIdLabel = new JLabel("University ID:");
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel addressLabel = new JLabel("Address:");

        JButton saveButton = new JButton("Complete SignUp");

        detailsPanel.add(universityIdLabel);
        detailsPanel.add(universityIdField);
        detailsPanel.add(firstNameLabel);
        detailsPanel.add(firstNameField);
        detailsPanel.add(lastNameLabel);
        detailsPanel.add(lastNameField);
        detailsPanel.add(addressLabel);
        detailsPanel.add(addressField);
        detailsPanel.add(new JLabel()); // Placeholder
        detailsPanel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Details saved successfully!");
                detailsFrame.dispose();
                clearFields();
                frame.setVisible(false);
                SwingUtilities.invokeLater(LoginGUI::new);
            }
        });

        // Adding padding/margin to the panel
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        detailsFrame.add(detailsPanel);
        detailsFrame.setVisible(true);
    }

    private boolean isValidCredentials(String username, String password) {
        return !username.isEmpty() && password.length() >= 8;
    }

   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SignUpUI();
            }
        });
    }*/
}

