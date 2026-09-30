
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainDAO {

    public void addTrain(Train train) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO trains(train_number, train_name, source, destination, date, time) Values(?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, train.getTrainNumber());
                pstmt.setString(2, train.getTrainName());
                pstmt.setString(3, train.getSource());
                pstmt.setString(4, train.getDestination());
                pstmt.setString(5, train.getDate());
                pstmt.setString(6, train.getTime());
                pstmt.executeUpdate();
                System.out.println("Train added successfully");
            }
        }
    }

    public void getALLTrains() throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM trains ";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        int trainNumber = rs.getInt("train_number");
                        String trainName = rs.getString("train_name");
                        String source = rs.getString("source");
                        String destination = rs.getString("destination");
                        String date = rs.getString("date");
                        String time = rs.getString("time");
                        System.out.println(trainNumber + " | " + trainName + " | " + source + " | " + destination + " | " + date + " | " + time);
                    }
                }
            }
        }

    }

    public Train getTrainByNumber(int trainNumber) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = " SELECT * FROM  trains WHERE train_number = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setInt(1, trainNumber);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    return new Train(
                            rs.getInt("train_Number"),
                            rs.getString("train_name"),
                            rs.getString("source"),
                            rs.getString("destination"),
                            rs.getString("date"),
                            rs.getString("time")
                    );
                } else {
                    return null;
                }

            }
        }

    }
}
