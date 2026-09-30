
public class BookingService {

    private PassengerDAO passengerDAO;
    private TicketDAO ticketDAO;

    public BookingService() {
        passengerDAO = new PassengerDAO();
        ticketDAO = new TicketDAO();
    }

    public String bookTicket(
            Train train,
            String passengerName,
            int age,
            String gender,
            String journeyDate,
            String seatNumber,
            String ClassType
    ) throws Exception {
        int passengerId = passengerDAO.getNextPassengerId();

        Passenger passenger = new Passenger(
                passengerId,
                passengerName,
                age,
                gender
        );
        passengerDAO.addPassenger(passenger);

        int ticketId = ticketDAO.getNextTicketId();
        if (ticketDAO.isSeatBooked(train.getTrainNumber(), journeyDate, seatNumber)) {
            throw new Exception("This seat is already booked.");
        }
        String pnr = ticketDAO.generatePNR();

        Ticket ticket = new Ticket(
                ticketId,
                train.getTrainNumber(),
                passengerId,
                journeyDate,
                train.getTime(),
                seatNumber,
                pnr,
                ClassType
        );
        ticketDAO.addTicket(ticket);

        return pnr;

    }

}
