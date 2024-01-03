import javax.swing.*;
import java.awt.event.*;

public class AssignmentUploadGUI {
    private JFrame frame;
    private JPanel panel;
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JTextField dueDateField;
    private JButton uploadButton;

    public AssignmentUploadGUI() {
        frame = new JFrame("Upload Assignment");
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(100, 20, 350, 25);
        panel.add(titleField);

        JLabel descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(10, 60, 80, 25);
        panel.add(descriptionLabel);

        descriptionArea = new JTextArea();
        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);
        descriptionScrollPane.setBounds(100, 60, 350, 100);
        panel.add(descriptionScrollPane);

        JLabel dueDateLabel = new JLabel("Due Date:");
        dueDateLabel.setBounds(10, 180, 80, 25);
        panel.add(dueDateLabel);

        dueDateField = new JTextField();
        dueDateField.setBounds(100, 180, 150, 25);
        panel.add(dueDateField);

        uploadButton = new JButton("Upload Assignment");
        uploadButton.setBounds(180, 230, 150, 30);
        panel.add(uploadButton);

        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionArea.getText();
                String dueDate = dueDateField.getText();

                // Perform assignment upload logic here (Not implemented in this example)
                // This would involve storing assignment details in the system
                // For demonstration purposes, display a message indicating the upload
                JOptionPane.showMessageDialog(frame, "Assignment Uploaded:\nTitle: " + title +
                        "\nDescription: " + description + "\nDue Date: " + dueDate);
            }
        });
    }

  /*  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AssignmentUploadGUI();
            }
        });
    }*/
}
