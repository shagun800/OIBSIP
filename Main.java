
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            ApiTrainService apiTrainService = new ApiTrainService();
            System.out.println("Enter source station: ");
            String from = sc.nextLine();
            System.out.println("Enter destination station: ");
            String to = sc.nextLine();
            ArrayList<Train> trains = apiTrainService.searchTrains(from, to);
            if (trains.isEmpty()) {
                System.out.println("No trains found. ");
                return;
            }
            System.out.println("\nAvailable Trains: ");

            for (int i = 0; i < trains.size(); i++) {
                Train train = trains.get(i);
                System.out.println((i + 1) + ". " + train.getTrainNumber() + " - " + train.getTrainName() + " | " + train.getSource() + " -> " + train.getDestination() + " | Departure: " + train.getTime());
            }
            System.out.println("\nSelect train number: ");
            int choice = Integer.parseInt(sc.nextLine());
            Train selectedTrain = trains.get(choice - 1);

            System.out.println("\nSelected train: ");
            System.out.println("Train number: " + selectedTrain.getTrainNumber());
            System.out.println("Train name: " + selectedTrain.getTrainName());
            System.out.println("From: " + selectedTrain.getSource());
            System.out.println("To : " + selectedTrain.getDestination());

            System.out.println("\n___Passenger Details___");
            sc.nextLine();
            System.out.println("Enter passenger name: ");
            String passengerName = sc.nextLine();
            System.out.println("Enter passenger age: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("Enter gender: ");
            String gender = sc.nextLine();
            System.out.println("Enter journey date(YYYY-MM-DD): ");
            String journeyDate = sc.nextLine();

            System.out.println("Enter seat number:");
            String seatNumber = sc.nextLine();
            System.out.println("Enter class type:");
            String classType = sc.nextLine();

            BookingService bookingService = new BookingService();

            String pnr = bookingService.bookTicket(selectedTrain, passengerName, age, gender, journeyDate, seatNumber, classType);

            System.out.println("\n====BOOKING CONFIRMED====");
            System.out.println("Passenger: " + passengerName);
            System.out.println("Train: " + selectedTrain.getTrainName());
            System.out.println("Train number: " + selectedTrain.getTrainNumber());
            System.out.println("From: " + selectedTrain.getSource());
            System.out.println("To: " + selectedTrain.getDestination());
            System.out.println("Date:" + journeyDate);
            System.out.println("Time: " + selectedTrain.getTime());
            System.out.println("class: " + classType);
            System.out.println("Seat: " + seatNumber);
            System.out.println("PNR: " + pnr);

            TicketDAO ticketDAO = new TicketDAO();

            System.out.println("Do you want to cancel this ticket(yes/no): ");
            String cancelChoice = sc.nextLine();

            if (cancelChoice.equalsIgnoreCase("yes")) {
                ticketDAO.getTicketByPnr(pnr);

                System.out.println("Are you sure you want to cancel this ticket(yes/no): ");
                String confirmCancel = sc.nextLine();
                if (confirmCancel.equalsIgnoreCase("yes")) {
                    ticketDAO.cancelTicketByPnr(pnr);

                    System.out.println("\n____After Cancellation____");
                    ticketDAO.getTicketByPnr(pnr);
                } else {
                    System.out.println("Cancellation cancelled by user.");
                }

            } else {
                System.out.println("Ticket remains booked.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
