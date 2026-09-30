
import java.sql.*;

public class UserDAO {

    public boolean login(String username, String password) throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
}
