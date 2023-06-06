import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Main() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // Create main panel with a border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create title panel with a centered label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(titleLabel);

        // Create form panel with a grid layout
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        // Create form components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        // Add form components to the panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        // Create button panel with a centered button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        buttonPanel.add(loginButton);

        // Add panels to the main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add main panel to the frame's content pane
        getContentPane().add(mainPanel);

        // Set the default button to be the login button
        getRootPane().setDefaultButton(loginButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);

            // Perform your login logic here, such as validating credentials
            // For simplicity, let's assume the username is "admin" and the password is "password"
            if (username.equals("admin") && password.equals("password")) {
                // Navigate to the Dashboard page
                DashboardPage dashboardPage = new DashboardPage();
                dashboardPage.setVisible(true);
                dispose(); // Close the login page
            } else {
                // Display an error message for invalid credentials
                JOptionPane.showMessageDialog(this, "Invalid username or password");

                // Clear the fields after login attempt
                usernameField.setText("");
                passwordField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main loginUI = new Main();
            loginUI.setVisible(true);
        });
    }
}


class DashboardPage extends JFrame implements ActionListener {
    private JTextField carNameField;
    private JTextField carModelField;
    private JTextField carYearField;
    private JTextField carValueField; // Added field for vehicle value
    private JButton searchButton;
    private JPanel mainPanel; // Declare mainPanel as a class-level field

    public DashboardPage() {
        setTitle("Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Create main panel with a border layout
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 50, 20));

        // Create title panel with a centered label
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel titleLabel = new JLabel("Dashboard");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        // Create form panel with a grid layout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        // Create GridBagConstraints for flexible positioning
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Create form components
        JLabel carNameLabel = new JLabel("Vehicle Type:");
        carNameField = new JTextField(25);
        JLabel carModelLabel = new JLabel("Vehicle Model:");
        carModelField = new JTextField(25);
        JLabel carYearLabel = new JLabel("Year:");
        carYearField = new JTextField(25);
        JLabel carValueLabel = new JLabel("Value:"); // Label for vehicle value
        carValueField = new JTextField(25); // Field for vehicle value

        // Add form components to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(carNameLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(carNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(carModelLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(carModelField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(carYearLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(carYearField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(carValueLabel, gbc);

        gbc.gridx = 1;
        formPanel.add(carValueField, gbc);

        // Create button panel with a centered button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);
        buttonPanel.add(searchButton);

        // Add panels to the main panel
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add main panel to the frame's content pane
        getContentPane().add(mainPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            String carName = carNameField.getText();
            String carModel = carModelField.getText();
            String carYear = carYearField.getText();
            String carValueText = carValueField.getText();
            int carValue = Integer.parseInt(carValueText);

            // Perform search logic here based on the entered values
            // For example, you can display the search results in a table or perform any other action
            // This is just a placeholder to show a message with the entered values
            String message = "Search Results:\n";
            message += "Car Name: " + carName + "\n";
            message += "Car Model: " + carModel + "\n";
            message += "Car Year: " + carYear + "\n";

            // Calculate the premium based on vehicle value
            int year = Integer.parseInt(carYear);
            int premium = calculatePremium(carValue, year);
            message += "Premium: $" + premium + "\n";

            JOptionPane.showMessageDialog(this, message);
        }
    }

    public int calculatePremium(int value, int year) {
        int premium = 0;
        int age = 2023 - year;
        if (age < 5) {
            premium = (int) (value * 0.03);
        } else if (age < 10) {
            premium = (int) (value * 0.05);
        } else {
            premium = (int) (value * 0.07);
        }
        return premium;
    }
}
