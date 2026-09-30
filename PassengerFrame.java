
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.*;

public class PassengerFrame extends JFrame {

    public PassengerFrame(Train selectedTrain1) {
        setTitle("Passenger details");
        setSize(500, 400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        JLabel titleLabel = new JLabel("Passenger Details");

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(15);

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField(15);

        JLabel genderLabel = new JLabel("Gender:");
        String[] genders = {"Male", "Female", "Other"};
        JComboBox<String> genderBox = new JComboBox<>(genders);

        JLabel DateLabel = new JLabel("Journey Date:");
        JTextField DateField = new JTextField(15);

        JLabel classLabel = new JLabel("Class:");
        String[] classes = {"Sleeper", "AC 3 Tier", "AC 2 Tier", " AC First Class"};
        JComboBox<String> classBox = new JComboBox<>(classes);

        JButton continueButton = new JButton("Continue");

        JButton backButton = new JButton("Back");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(ageLabel, gbc);

        gbc.gridx = 1;
        panel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(genderLabel, gbc);

        gbc.gridx = 1;
        panel.add(genderBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(DateLabel, gbc);

        gbc.gridx = 1;
        panel.add(DateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(classLabel, gbc);

        gbc.gridx = 1;
        panel.add(classBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(backButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(continueButton, gbc);
        continueButton.addActionListener((e) -> {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String gender = (String) genderBox.getSelectedItem();
            String JourneyDate = DateField.getText();
            String classType = (String) classBox.getSelectedItem();

            name = name.trim();
            ageText = ageText.trim();
            JourneyDate = JourneyDate.trim();
            if (name.isEmpty() || ageText.isEmpty() || JourneyDate.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields.");
                return;
            }

            try {
                int age = Integer.parseInt(ageText);
                if (age <= 0 || age > 120) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid age.");
                    return;
                }
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate.parse(JourneyDate, formatter);

                } catch (DateTimeParseException ex) {

                    JOptionPane.showMessageDialog(this, "Please enter date in YYYY-MM-DD format.");
                    return;
                }
                new SeatSelectionFrame(selectedTrain1, name, age, gender, JourneyDate, classType).setVisible(true);
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Age must be a number.");
            }
        });

        backButton.addActionListener(e -> {
            new HomeFrame().setVisible(true);
            dispose();
        });

        add(panel);

    }

}
