import javax.swing.*;
import java.awt.event.*;

public class EditAssignmentGUI {
    private JFrame frame;
    private JPanel panel;
    private JComboBox<String> assignmentList;
    private JTextArea editedContentArea;
    private JButton saveButton;

    public EditAssignmentGUI() {
        frame = new JFrame("Edit Assignment");
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel assignmentLabel = new JLabel("Select Assignment:");
        assignmentLabel.setBounds(10, 20, 120, 25);
        panel.add(assignmentLabel);

        // Sample assignment list (Replace this with your actual list)
        String[] assignments = {"Assignment 1", "Assignment 2", "Assignment 3"};
        assignmentList = new JComboBox<>(assignments);
        assignmentList.setBounds(140, 20, 200, 25);
        panel.add(assignmentList);

        editedContentArea = new JTextArea();
        editedContentArea.setBounds(10, 60, 460, 200);
        panel.add(editedContentArea);

        saveButton = new JButton("Save Changes");
        saveButton.setBounds(180, 280, 150, 30);
        panel.add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String editedContent = editedContentArea.getText();

                // Logic for saving edited content (Not implemented in this example)
                // For demonstration purposes, display a success message
                JOptionPane.showMessageDialog(frame, "Changes saved successfully!");
            }
        });
    }

  /*  public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EditAssignmentGUI();
            }
        });
    }*/
}

