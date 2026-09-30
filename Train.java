
public class Train {

    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private String date;
    private String time;

    public Train(int trainNumber, String trainName, String source, String destination, String date, String time) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.time = time;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;

    }

    public void setSource(String source) {
        this.source = source;

    }

    public void setDestination(String detination) {
        this.destination = detination;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
