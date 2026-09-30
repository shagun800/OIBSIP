
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PassengerDAO {

    public void addPassenger(Passenger passenger) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO passengers(passenger_id, name, age, gender)VALUES(?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, passenger.getPassengerId());
                pstmt.setString(2, passenger.getName());
                pstmt.setInt(3, passenger.getAge());
                pstmt.setString(4, passenger.getGender());
                pstmt.executeUpdate();
                System.out.println("Passenger added successfully");
            }
        }

    }

    public int getNextPassengerId() {
        String sql = "SELECT MAX(passenger_id) FROM passengers";
        try (Connection con = DatabaseConnection.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public void getALLPassenger() throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM passengers";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int passengerId = rs.getInt("passenger_id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    System.out.println(passengerId + " | " + name + " | " + " | " + age + " | " + gender);

                }

            }
        }
    }
public Passenger getPassengerById(int passengerId) throws SQLException {

    try (Connection con = DatabaseConnection.getConnection()) {

        String sql = "SELECT * FROM passengers WHERE passenger_id = ?";

        try (PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, passengerId);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Passenger(
                        rs.getInt("passenger_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender")
                );
            }

            return null;
        }
    }
}

}
