import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;

public class StudentDashboard extends JFrame {
    private JLabel headerLabel;
    private JButton viewAssignmentsButton;
    private JButton viewGradesButton;
    private JButton submitAssignmentButton;
    private JButton logoutButton;
    private JLabel scheduleLabel;
    private JTextArea scheduleTextArea;
    private JButton downloadScheduleButton;

    public StudentDashboard() {
        setTitle("Student Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        setupListeners();
        setupLayout();
    }

    private void initComponents() {
        headerLabel = new JLabel("Welcome, " + "John Doe");

        viewAssignmentsButton = createButton("View Assignments");
        viewGradesButton = createButton("View Grades");
        submitAssignmentButton = createButton("Submit Assignment");
        logoutButton = createButton("Logout");

        scheduleLabel = new JLabel("Schedule:");
        scheduleTextArea = new JTextArea(10, 20);
        scheduleTextArea.setEditable(false);
        scheduleTextArea.setText(generateTimetable());

        downloadScheduleButton = createButton("Download Timetable");
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setBackground(Color.LIGHT_GRAY);

        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setForeground(Color.BLACK);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.BLUE);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(Color.BLACK);
            }
        });

        return button;
    }

    private void setupListeners() {
        viewAssignmentsButton.addActionListener(e -> viewAssignments());
        viewGradesButton.addActionListener(e -> viewGrades());
        submitAssignmentButton.addActionListener(e -> submitAssignment());
        logoutButton.addActionListener(e -> logout());
        downloadScheduleButton.addActionListener(e -> downloadTimetable());
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel headerPanel = new JPanel();
        headerPanel.add(headerLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.add(viewAssignmentsButton);
        buttonPanel.add(viewGradesButton);
        buttonPanel.add(submitAssignmentButton);
        buttonPanel.add(logoutButton);

        JPanel schedulePanel = new JPanel(new BorderLayout());
        JPanel scheduleHeaderPanel = new JPanel();
        scheduleHeaderPanel.add(scheduleLabel);
        scheduleHeaderPanel.add(downloadScheduleButton);
        schedulePanel.add(scheduleHeaderPanel, BorderLayout.NORTH);
        schedulePanel.add(new JScrollPane(scheduleTextArea), BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(schedulePanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    // Dummy methods for action listeners
    private void viewAssignments() {
        JOptionPane.showMessageDialog(this, "View Assignments functionality goes here.");
    }

    private void viewGrades() {
        JOptionPane.showMessageDialog(this, "View Grades functionality goes here.");
    }

    private void submitAssignment() {
        JOptionPane.showMessageDialog(this, "Submit Assignment functionality goes here.");
    }

    private void logout() {
        setVisible(false);
        JOptionPane.showMessageDialog(this, "Successfully Logged Out");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginGUI();
            }
        });
    }

    private void downloadTimetable() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".txt")) {
                    filePath += ".txt";
                }

                FileOutputStream fileOutputStream = new FileOutputStream(filePath);
                String timetableContent = generateTimetable();
                fileOutputStream.write(timetableContent.getBytes());
                fileOutputStream.close();

                JOptionPane.showMessageDialog(this, "Timetable downloaded successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error downloading timetable: " + ex.getMessage());
            }
        }
    }

    // Dummy method to generate timetable content
    private String generateTimetable() {
        return "Day 1:\nMathematics - 9:15 AM - 10:45 AM\nPhysics - 11:00 AM - 12:30 PM\n...";
    }
}
