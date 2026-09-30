
import java.sql.SQLException;

public class TrainDataSetup {

    public static void main(String[] args) {
        TrainDAO trainDAO = new TrainDAO();
        System.out.println("Train data setup started");
        Train[] trains = {
       new Train(
                12301,
                "Rajdhani express",
                "New Delhi",
                "Howrah",
                "Daily",
                "16:55"
        ),
         new Train(
                123002,
                "shatabdi express",
                "New Delhi",
                "bhopal",
                "Daily",
                "06:00")
        };
        try {
            for(Train train :trains){
            if (trainDAO.getTrainByNumber(train.getTrainNumber()) == null) {
                trainDAO.addTrain(train);
            }else{
                System.out.println("train"+ train.getTrainNumber() +" already exist");
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
