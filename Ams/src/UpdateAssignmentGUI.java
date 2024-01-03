import javax.swing.*;
import java.awt.event.*;

public class UpdateAssignmentGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton selectFileButton;
    private JButton uploadButton;

    public UpdateAssignmentGUI() {
        frame = new JFrame("Update Assignment");
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        selectFileButton = new JButton("Select Updated File");
        selectFileButton.setBounds(50, 50, 150, 30);
        panel.add(selectFileButton);

        uploadButton = new JButton("Update Assignment");
        uploadButton.setBounds(210, 150, 150, 30);
        uploadButton.setEnabled(false); // Initially, disable the button
        panel.add(uploadButton);

        selectFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // File selected, handle the selected file
                    String fileName = fileChooser.getSelectedFile().getName();
                    JOptionPane.showMessageDialog(frame, "Updated File selected: " + fileName);

                    // Enable the Update Assignment button when a file is selected
                    uploadButton.setEnabled(true);
                }
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for updating the assignment (Not implemented in this example)
                JOptionPane.showMessageDialog(frame, "Assignment updated successfully!");
            }
        });
    }

   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UpdateAssignmentGUI();
            }
        });
    }*/
}
