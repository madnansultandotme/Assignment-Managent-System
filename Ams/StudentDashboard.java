import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentDashboard extends JFrame {
    private JLabel headerLabel;
    private JButton viewAssignmentsButton;
    private JButton viewGradesButton;
    private JButton submitAssignmentButton;
    private JButton logoutButton;
    private JPanel schedulePanel;
    private JPanel currentDaySchedulePanel;
    private JButton updateAssignmentButton;

    public StudentDashboard() {
        setTitle("Student Dashboard");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
        setupListeners();
        setupLayout();
        setupSchedule(); // Initialize the schedule panel
    }

    private void initComponents() {
        headerLabel = new JLabel("Welcome, " + LoginGUI.getUserName());

        viewAssignmentsButton = new JButton("View Assignments");
        viewGradesButton = new JButton("View Grades");
        submitAssignmentButton = new JButton("Submit Assignment");
        logoutButton = new JButton("Logout");

        // Add padding and margin to the buttons
        Insets buttonInsets = new Insets(10, 15, 10, 15); // Padding for the button text
        viewAssignmentsButton.setMargin(buttonInsets);
        viewGradesButton.setMargin(buttonInsets);
        submitAssignmentButton.setMargin(buttonInsets);
        updateAssignmentButton = new JButton("Update Assignment"); // Initialize the new button
        logoutButton.setMargin(buttonInsets);

    }

    private void setupListeners() {
        viewAssignmentsButton.addActionListener(e -> viewAssignments());
        viewGradesButton.addActionListener(e -> viewGrades());
        submitAssignmentButton.addActionListener(e -> submitAssignment());
        updateAssignmentButton.addActionListener(e -> updateAssignment()); // Add listener for the new button
        logoutButton.addActionListener(e -> logout());
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel headerPanel = new JPanel();
        headerPanel.add(headerLabel);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1; // Set weighty to occupy vertical space
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10, 10); // Adding insets for padding

        buttonsPanel.add(viewAssignmentsButton, gbc);
        gbc.gridy++;
        buttonsPanel.add(viewGradesButton, gbc);
        gbc.gridy++;
        buttonsPanel.add(submitAssignmentButton, gbc);
        gbc.gridy++;
        buttonsPanel.add(updateAssignmentButton, gbc);
        gbc.gridy++;
        buttonsPanel.add(logoutButton, gbc);

        schedulePanel = new JPanel(new GridLayout(0, 1, 10, 10));
        schedulePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel rightPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.gridx = 0;
        gbcRight.gridy = 0;
        gbcRight.anchor = GridBagConstraints.WEST;

        Map<String, ArrayList<String>> daySchedule = new HashMap<>();
        //... (rest of your schedule setup code)

        for (Map.Entry<String, ArrayList<String>> entry : daySchedule.entrySet()) {
            JButton dayButton = new JButton(entry.getKey());
            dayButton.addActionListener(e -> displayDaySchedule(entry.getKey(), entry.getValue()));
            rightPanel.add(dayButton, gbcRight);
            gbcRight.gridy++;
        }

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(schedulePanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.WEST); // Changed to BorderLayout.WEST for left panel
        mainPanel.add(rightPanel, BorderLayout.EAST);

        add(mainPanel);
        setVisible(true);
    }


    private void setupSchedule() {
        schedulePanel.removeAll();

        Map<String, ArrayList<String>> daySchedule = new HashMap<>();

        String[] subjects = { "Mathematics", "Physics", "Chemistry", "Biology", "History" };
        String[] timeSlots = { "9:15 AM - 10:45 AM", "11:00 AM - 12:30 PM", "1:15 PM - 2:45 PM", "3:00 PM - 4:30 PM" };

        for (int i = 0; i < 5; i++) {
            ArrayList<String> dailySchedule = new ArrayList<>();
            for (String subject : subjects) {
                for (String timeSlot : timeSlots) {
                    dailySchedule.add(subject + " - " + timeSlot);
                }
            }
            daySchedule.put("Day " + (i + 1), dailySchedule);
        }

        for (Map.Entry<String, ArrayList<String>> entry : daySchedule.entrySet()) {
            JButton dayButton = new JButton(entry.getKey());
            dayButton.addActionListener(e -> displayDaySchedule(entry.getKey(), entry.getValue()));
            schedulePanel.add(dayButton);
        }

        revalidate();
        repaint();
    }

    private void displayDaySchedule(String day, ArrayList<String> schedule) {
        if (currentDaySchedulePanel != null) {
            schedulePanel.remove(currentDaySchedulePanel);
            revalidate();
            repaint();
        }

        currentDaySchedulePanel = new JPanel(new GridLayout(0, 1, 10, 10));
        currentDaySchedulePanel.setBorder(BorderFactory.createTitledBorder(day));

        for (String item : schedule) {
            JLabel scheduleLabel = new JLabel(item);
            currentDaySchedulePanel.add(scheduleLabel);
        }

        schedulePanel.add(currentDaySchedulePanel);
        revalidate();
        repaint();
    }

    private void viewAssignments() {
        JOptionPane.showMessageDialog(this, "View Assignments functionality goes here.");
    }

    private void viewGrades() {
        JOptionPane.showMessageDialog(this, "View Grades functionality goes here.");
    }

    private void submitAssignment() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SubmitAssignmentGUI();
            }
        });
        //  JOptionPane.showMessageDialog(this, "Submit Assignment functionality goes here.");
    }
    private void updateAssignment() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UpdateAssignmentGUI();
            }
        });
        //JOptionPane.showMessageDialog(this, "Update Assignment functionality goes here.");
    }

    private void logout() {
        setVisible(false);
        LoginGUI logout = new LoginGUI();
        logout.setVisible(true);
        dispose();
        JOptionPane.showMessageDialog(this, "Successfully Logged Out");
    }
}
