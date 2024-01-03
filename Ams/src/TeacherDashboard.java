import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherDashboard extends JFrame {
    private JLabel headerLabel;
    private JButton createAssignmentButton;
    private JButton editAssignmentButton;
    private JButton uploadAssignmentButton;
    private JButton setDeadlineButton;
    private JButton viewSubmittedAssignmentsButton;
    private JButton viewScheduleButton;
    private JButton logoutButton;
    private JTextArea submittedAssignmentsArea;

    public TeacherDashboard() {
        setTitle("Teacher Dashboard");
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();
        setupListeners();
        setupLayout();
    }

    private void setLoggedInUsername() {
        headerLabel.setText("Welcome, " + LoginGUI.getUserName() + "!");
    }

    private void initComponents() {
        headerLabel = new JLabel("Welcome, " + LoginGUI.getUserName());
        setLoggedInUsername();
        createAssignmentButton = new JButton("Create Assignment");
        editAssignmentButton = new JButton("Edit Assignment");
        uploadAssignmentButton = new JButton("Upload Assignment File");
        setDeadlineButton = new JButton("Set Assignment Deadline");
        viewSubmittedAssignmentsButton = new JButton("View Submitted Assignments");
        viewScheduleButton = new JButton("View Schedule");
        logoutButton = new JButton("Logout");
        submittedAssignmentsArea = new JTextArea(15, 20);
        submittedAssignmentsArea.setEditable(false);
        submittedAssignmentsArea.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Cursor change on hover
    }

    private void setupListeners() {
        createAssignmentButton.addActionListener(e -> createAssignment());
        editAssignmentButton.addActionListener(e -> editAssignment());
        uploadAssignmentButton.addActionListener(e -> uploadAssignment());
        setDeadlineButton.addActionListener(e -> setDeadline());
        viewSubmittedAssignmentsButton.addActionListener(e -> viewSubmittedAssignments());
        viewScheduleButton.addActionListener(e -> viewSchedule());
        logoutButton.addActionListener(e -> logout());

        submittedAssignmentsArea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Perform actions when the submitted assignments area is clicked
                JOptionPane.showMessageDialog(TeacherDashboard.this, "Clicked on submitted assignments area!");
            }
        });
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel headerPanel = new JPanel();
        headerPanel.add(headerLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(createPaddedButton(createAssignmentButton));
        buttonPanel.add(createPaddedButton(editAssignmentButton));
        buttonPanel.add(createPaddedButton(uploadAssignmentButton));
        buttonPanel.add(createPaddedButton(setDeadlineButton));
        buttonPanel.add(createPaddedButton(viewSubmittedAssignmentsButton));
        buttonPanel.add(createPaddedButton(viewScheduleButton));
        buttonPanel.add(createPaddedButton(logoutButton));
        customizeButton(createAssignmentButton);
        customizeButton(editAssignmentButton);
        customizeButton(uploadAssignmentButton);
        customizeButton(setDeadlineButton);
        customizeButton(viewSubmittedAssignmentsButton);
        customizeButton(viewScheduleButton);
        customizeButton(logoutButton);
        JPanel assignmentsPanel = new JPanel(new BorderLayout());
        assignmentsPanel.setBorder(BorderFactory.createTitledBorder("Submitted Assignments"));
        JScrollPane scrollPane = new JScrollPane(submittedAssignmentsArea);
        assignmentsPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.WEST);
        mainPanel.add(assignmentsPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }
    private void customizeButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY); // Change background color on hover
                button.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(null); // Reset background color on exit
                button.setForeground(Color.BLACK);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(Color.GRAY); // Change background color on click
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(null); // Reset background color after click

            }
        });
    }
    private Component createPaddedButton(JButton button) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(button);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding to buttons
        return panel;
    }

    private void createAssignment() {
        // Action for creating an assignment
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AssignmentUploadGUI();
            }
        });
    }

    private void editAssignment() {
        // Action for editing an assignment
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EditAssignmentGUI();
            }
        });
    }

    private void uploadAssignment() {
        JOptionPane.showMessageDialog(this, "Upload Assignment File functionality goes here.");
    }

    private void setDeadline() {
        JOptionPane.showMessageDialog(this, "Set Assignment Deadline functionality goes here.");
    }

    private void viewSubmittedAssignments() {
        // Fetch and display submitted assignments from the database
        submittedAssignmentsArea.setText("List of Submitted Assignments:\n\n");
        submittedAssignmentsArea.append("- Assignment 1\n");
        submittedAssignmentsArea.append("- Assignment 2\n");
        submittedAssignmentsArea.append("- Assignment 3\n");
        submittedAssignmentsArea.append("- Assignment 4\n");
    }

    private void viewSchedule() {
        JOptionPane.showMessageDialog(this, "View Schedule functionality goes here.");
    }

    private void logout() {
        setVisible(false);
        LoginGUI logout = new LoginGUI();
        logout.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(this, "Successfully Logged Out");
    }
}
