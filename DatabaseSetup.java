
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseSetup {

    public static void main(String[] args) {
        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            System.out.println("database connected");
           
           
           
            String sql = "CREATE TABLE IF NOT EXISTS trains("
                    + "train_name TEXT, "
                    + "train_number INTEGER PRIMARY KEY, "
                    + "source TEXT, "
                    + "destination TEXT, "
                    + "date TEXT, "
                    + "time TEXT)";
            stmt.executeUpdate(sql);
            System.out.println("Trains table created successfully");
           
           
            String passengerSql = "CREATE TABLE IF NOT EXISTS passengers ("
                    + "passenger_id INTEGER PRIMARY KEY,"
                    + "name TEXT, "
                    + "age INTEGER, "
                    + "gender TEXT)";
            stmt.executeUpdate(passengerSql);
            System.out.println("Passenger table created successfully");
           
           
            String userSql = "CREATE TABLE IF NOT EXISTS users("
                    + "user_id INTEGER PRIMARY KEY,"
                    + "username TEXT,"
                    + "password TEXT)";
            stmt.executeUpdate(userSql);
            String insertUserSql = "INSERT INTO users (username,password) VALUES ('admin','1234')";
            stmt.executeUpdate(insertUserSql);
           
            stmt.executeUpdate("DROP TABLE IF EXISTS tickets");          
            String ticketSql = "CREATE TABLE IF NOT EXISTS tickets ("
                    + "ticket_id INTEGER PRIMARY KEY, "
                    + "train_number INTEGER, "
                    + "passenger_id INTEGER, "
                    + "journey_date TEXT, "
                    + "journey_time TEXT, "
                    + "seat_number TEXT,"
                    + "pnr TEXT UNIQUE,"
                    + "class_type TEXT)";
            stmt.executeUpdate(ticketSql);
            System.out.println("Tickets table created successfully");
        } catch (Exception e) {
            System.out.println(" Database connection failed");
            e.printStackTrace();
        }
    }
}
