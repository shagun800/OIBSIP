
import java.sql.*;

public class TicketDAO {

    public void addTicket(Ticket ticket) throws SQLException {

        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO tickets(ticket_id, train_number, passenger_id, journey_date, journey_time, seat_number, pnr, class_type)VALUES(?, ?, ?, ?, ?, ?, ?, ? )";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, ticket.getTicketId());
                pstmt.setInt(2, ticket.getTrainNumber());
                pstmt.setInt(3, ticket.getPassengerId());
                pstmt.setString(4, ticket.getJourneyDate());
                pstmt.setString(5, ticket.getJourneyTime());
                pstmt.setString(6, ticket.getSeatNumber());
                pstmt.setString(7, ticket.getPnr());
                pstmt.setString(8, ticket.getClassType());
                pstmt.executeUpdate();
                System.out.println("Ticket booked successfully");
            }
        }

    }

    public void getALLTickets() throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM tickets";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int ticketId = rs.getInt("ticket_id");
                    int trainNumber = rs.getInt("train_number");
                    int passengerId = rs.getInt("passenger_id");
                    String journeyDate = rs.getString("journey_date");
                    String journeyTime = rs.getString("journey_time");
                    String seatNumber = rs.getString("seat_number");
                    String pnr = rs.getString("pnr");
                    String classType = rs.getString("class_type");

                    System.out.println(ticketId + " | " + trainNumber + " | " + passengerId + " | " + journeyDate + " | " + journeyTime + " | " + seatNumber + " | " + pnr + " | " + classType);
                }
            }
        }
    }

    public Ticket getTicketByPnr(String pnr) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM tickets WHERE pnr = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, pnr);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return new Ticket(
                    
                     rs.getInt("ticket_id"),
                     rs.getInt("train_number"),
                     rs.getInt("passenger_id"),
                    rs.getString("journey_date"),
                    rs.getString("journey_time"),
                    rs.getString("seat_number"),
                     rs.getString("pnr"),
                     rs.getString("class_type")
                    );

                } else {
                    return null;
                }
            }
        }
    }

    public void cancelTicketByPnr(String pnr) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM tickets WHERE pnr = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, pnr);
                int rowAffected = pstmt.executeUpdate();
                if (rowAffected > 0) {
                    System.out.println("Ticket cancelled successfully");
                } else {
                    System.out.println("No ticket found with this PNR");
                }
            }
        }
    }


    public String generatePNR() {
        int prnNumber = (int) (Math.random() * 900000) + 100000;
        return String.valueOf(prnNumber);

    }

    public int getNextTicketId(){
        String sql = "SELECT MAX(ticket_id)  FROM tickets";
          try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;

    }
    public boolean isSeatBooked(int trainNumber, String journeyDate, String seatNumber) throws SQLException{
        try(Connection con = DatabaseConnection.getConnection() ){
            String sql = "SELECT COUNT(*) FROM tickets " 
            +"WHERE train_number = ?"
            +"AND journey_date = ?"
            +"AND seat_number = ?";
            try(PreparedStatement pstmt = con.prepareStatement(sql)){
                pstmt.setInt(1, trainNumber);
                pstmt.setString(2, journeyDate);
                pstmt.setString(3, seatNumber);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                    return rs.getInt(1) > 0;
                }
                return false;
            }
        }
    }
}