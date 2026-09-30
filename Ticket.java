
public class Ticket {

    private int ticketId;
    private int trainNumber;
    private int passengerId;
    private String journeyDate;
    private String journeyTime;
    private String seatNumber;
    private String pnr;
    private String classType;

    public Ticket(
            int ticketId,
            int trainNumber,
            int passengerId,
            String journeyDate,
            String journeyTime,
            String seatNumber,
            String pnr,
            String classType
    ) {
        this.ticketId = ticketId;
        this.trainNumber = trainNumber;
        this.passengerId = passengerId;
        this.journeyDate = journeyDate;
        this.journeyTime = journeyTime;
        this.seatNumber = seatNumber;
        this.pnr = pnr;
        this.classType = classType;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getJourneyDate() {
        return journeyDate;
    }

    public String getJourneyTime() {
        return journeyTime;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getPnr() {
        return pnr;
    }

    public String getClassType() {
        return classType;
    }

    public void setTicketId(int ticketID) {
        this.ticketId = ticketID;

    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setJourneyDate(String journeyDate) {
        this.journeyDate = journeyDate;
    }

    public void setJourneyTime(String journeyTime) {
        this.journeyTime = journeyTime;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }
}
