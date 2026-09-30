
import java.awt.*;
import javax.swing.*;

public class HomeFrame extends JFrame {

    public HomeFrame() {
        setTitle("Online Train Reservation System");
        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titleLabel = new JLabel("Search Trains");
        JLabel fromLabel = new JLabel("From:");
        JTextField fromField = new JTextField(15);

        JLabel toLabel = new JLabel("To:");
        JTextField toField = new JTextField(15);

        JButton searchButton = new JButton("Search Trains");
        JButton cancelButton = new JButton("Cancel Ticket");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;

        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(fromLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(fromField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(toLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(toField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(searchButton, gbc);
        searchButton.addActionListener(e -> {
            String from = fromField.getText();
            String to = toField.getText();

            from = from.trim();
            to = to.trim();
            if (from.isEmpty() || to.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both sourse or destination.");
                return;
            }
            try {
                ApiTrainService apiTrainService = new ApiTrainService();
                var trains = apiTrainService.searchTrains(from, to);
                if (trains.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No trains found");
                    return;
                }
                String[] trainOption = new String[trains.size()];
                for (int i = 0; i < trains.size(); i++) {
                    Train train = trains.get(i);

                    trainOption[i] = train.getTrainNumber() + " - " + train.getTrainName();
                }
                String selectedTrain = (String) JOptionPane.showInputDialog(this, "Select a train:", "Available trains", JOptionPane.PLAIN_MESSAGE, null, trainOption, trainOption[0]);

                if (selectedTrain == null) {
                    return;
                }

                int selectedIndex = 0;
                for (int i = 0; i < trainOption.length; i++) {
                    if (trainOption[i].equals(selectedTrain)) {
                        selectedIndex = i;
                        break;
                    }

                }
                Train selectedTrain1 = trains.get(selectedIndex);
                new PassengerFrame(selectedTrain1).setVisible(true);
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error:" + ex.getClass().getName());
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(cancelButton, gbc);
        cancelButton.addActionListener(e -> {
            new CancellationFrame().setVisible(true);
        });

        add(panel);

    }

    public static void main(String[] args) {
        new HomeFrame().setVisible(true);
    }

}
