import javax.swing.*;
import java.awt.event.*;

public class SubmitAssignmentGUI {
    private JFrame frame;
    private JPanel panel;
    private JButton selectFileButton;
    private JButton uploadButton;

    public SubmitAssignmentGUI() {
        frame = new JFrame("Submit Assignment");
      //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        selectFileButton = new JButton("Select File");
        selectFileButton.setBounds(50, 50, 120, 30);
        panel.add(selectFileButton);

        uploadButton = new JButton("Upload Assignment");
        uploadButton.setBounds(180, 150, 150, 30);
        panel.add(uploadButton);

        selectFileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for selecting files from device (Not implemented in this example)
                // For demonstration purposes, display a file selection dialog
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    // File selected, handle the selected file
                    JOptionPane.showMessageDialog(frame, "File selected: " + fileChooser.getSelectedFile().getName());
                }
            }
        });

        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Logic for uploading the selected file (Not implemented in this example)
                // For demonstration purposes, display a success message
                JOptionPane.showMessageDialog(frame, "Assignment uploaded successfully!");
            }
        });
    }

   /* public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SubmitAssignmentGUI();
            }
        });
    }*/
}
