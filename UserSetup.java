
import java.sql.*;

public class UserSetup {

    public void addUser() throws SQLException {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO users(user_id, username, password)VALUES(101,'admin' ,'1234')";
            try (Statement stmt = con.createStatement()){
                stmt.executeUpdate(sql);
                System.out.println("User added successfully");
            }
        }
    }
    public static void main(String[] args) {
        try{
            new UserSetup().addUser();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
