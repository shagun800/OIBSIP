
import java.awt.*;
import javax.swing.*;

public class SeatSelectionFrame extends JFrame {

    public SeatSelectionFrame(
            Train selectedTrain1,
            String passengerName,
            int age,
            String gender,
            String journeyDate,
            String classType) {
        setTitle("Seat Selection");
        setSize(500, 450);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel titleLabel = new JLabel(
                "Select Your Seat",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel seatPanel = new JPanel(
                new GridLayout(5, 4, 10, 10)
        );

        ButtonGroup seatGroup = new ButtonGroup();

        for (int i = 1; i <= 20; i++) {

            String seatNumber = ("S1-" + String.format("%02d", i));
            JRadioButton seatButton = new JRadioButton(seatNumber);
            seatButton.setActionCommand(seatNumber);

            seatButton.setHorizontalAlignment(
                    SwingConstants.CENTER
            );
            try {
                TicketDAO ticketDAO = new TicketDAO();
                if (ticketDAO.isSeatBooked(selectedTrain1.getTrainNumber(), journeyDate, seatNumber)) {
                    seatButton.setEnabled(false);
                    seatButton.setText(seatNumber +"Booked");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error ckecking seat availibility: " + ex.getMessage());
            }

            seatGroup.add(seatButton);
            seatPanel.add(seatButton);
        }

        panel.add(seatPanel, BorderLayout.CENTER);

        JButton continueButton = new JButton("Continue");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(continueButton);
        buttonPanel.add(backButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        continueButton.addActionListener(e -> {

            if (seatGroup.getSelection() == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please select a seat."
                );

                return;
            }

            String selectedSeat
                    = seatGroup.getSelection().getActionCommand();
            try {
                BookingService bookingService = new BookingService();

                String pnr = bookingService.bookTicket(selectedTrain1, passengerName, age, gender, journeyDate, selectedSeat, classType);
                JOptionPane.showMessageDialog(this, "Booking successful!\n\n"
                        + "Passenger: " + passengerName
                        + "\nTrain: " + selectedTrain1.getTrainName()
                        + "\nSeat: " + selectedSeat
                        + "\nClass: " + classType
                        + "\nPNR: " + pnr);
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Booking failed: " + ex.getMessage());
            }

        });

        backButton.addActionListener(e->{
            new PassengerFrame(selectedTrain1).setVisible(true);
            dispose();
        });

        add(panel);
    }
}
