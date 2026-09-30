import java.awt.*;
import javax.swing.*;

public class CancellationFrame extends JFrame{

public CancellationFrame(){
    
    setTitle("Cancel Ticket");
    setSize(500,350);
    
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

    gbc.insets = new Insets(10, 10, 10, 10);
    

    JLabel titleLabel = new JLabel("Cancel Ticket");
    JLabel pnrLabel = new JLabel("Enter PNR: ");
    JTextField pnrField = new JTextField(15);

    JButton searchButton = new JButton("Search Ticket");
    JButton backButton =new JButton("Back");

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    panel.add(titleLabel,gbc);
    gbc.gridwidth = 1;

    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(pnrLabel,gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    panel.add(pnrField,gbc);
    
    gbc.gridx = 1;
    gbc.gridy = 2;
    panel.add(searchButton,gbc);
    searchButton.addActionListener(e->{
        String pnr = pnrField.getText().trim();

        if(pnr.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter PNR");
            return;
        }
        try {
            TicketDAO ticketDAO = new TicketDAO();
            Ticket ticket = ticketDAO.getTicketByPnr(pnr);
            PassengerDAO passengerDAO = new PassengerDAO();
            Passenger passenger =passengerDAO.getPassengerById(ticket.getPassengerId());

            if(ticket == null){
                JOptionPane.showMessageDialog(this, "No ticket found for this PNR.");
                return;
            }
            int choice = JOptionPane.showConfirmDialog(this, 
            "Ticket Found!\n\n"
            +"\nPNR: " + pnr 
            +"\nTicket ID: " + ticket.getTicketId()
            +"\nTrainNumber: " + ticket.getTrainNumber()
            +"\nPassenger ID: " + ticket.getPassengerId()
            +"\nPassenger Name: " + passenger.getName()
            +"\nPassenger Age: " + passenger.getAge()
            +"\nGender: " + passenger.getGender()
            +"\nJourney Date: " + ticket.getJourneyDate()
            +"\nJourney Time: " + ticket.getJourneyTime()
            +"\nSeat: " + ticket.getSeatNumber()
            +"\nClass: " + ticket.getClassType()
            +"\n\nDo you want to cancel this ticket?",
            "Cancel Ticket",
            JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION){
                ticketDAO.cancelTicketByPnr(pnr);

                JOptionPane.showMessageDialog(this, "Ticket cancelled successfully!");
                pnrField.setText("");
            } 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    });

    gbc.gridy++;
    panel.add(backButton,gbc);

    backButton.addActionListener(e->{
        new HomeFrame().setVisible(true);
        dispose();
    });

    add(panel);

}
public static void main(String[] args) {
    new CancellationFrame().setVisible(true);
}
    
}