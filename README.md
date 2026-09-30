🚆 Online Train Reservation System

A Java-based Online Train Reservation System developed as part of the Oasis Infobyte Internship (OIBSIP).

The application provides a simple interface for users to log in, search/select train details, enter passenger information, book tickets, generate a unique PNR, select seats, and cancel booked tickets.

✨ Features

- 🔐 User Login & Authentication
- 🚆 Train Information Management
- 👤 Passenger Details Management
- 🎫 Online Ticket Booking
- 💺 Seat Selection
- 🔢 Automatic Unique PNR Generation
- ❌ Ticket Cancellation using PNR
- 📋 Booking Details Display
- 🗄️ SQLite Database Integration
- 🌐 Train Data Fetching through API
- ✅ Basic Input Validation
- 🖥️ Java Swing Graphical User Interface

🛠️ Technologies Used

- Java
- Java Swing — Graphical User Interface
- JDBC — Database Connectivity
- SQLite — Database
- Gson — JSON/API Data Processing
- REST API — Train Data
- Git & GitHub — Version Control

📂 Project Structure

OnlineTrainReservationSystem/
│
├── ApiTest.java
├── ApiTrainService.java
├── BookingService.java
├── CancellationFrame.java
├── DatabaseConnection.java
├── DatabaseSetup.java
├── HomeFrame.java
├── LoginFrame.java
├── Main.java
│
├── Passenger.java
├── PassengerDAO.java
├── PassengerFrame.java
│
├── SeatSelectionFrame.java
│
├── Ticket.java
├── TicketDAO.java
│
├── Train.java
├── TrainDAO.java
├── TrainDataSetup.java
│
├── User.java
├── UserDAO.java
├── UserSetup.java
│
└── lib/
    ├── gson-2.14.0.jar
    └── sqlite-jdbc-3.53.4.0.jar

🔄 Application Flow

Login
  ↓
Home Screen
  ↓
Train Selection
  ↓
Passenger Details
  ↓
Seat Selection
  ↓
Ticket Booking
  ↓
Unique PNR Generated
  ↓
Booking Confirmation

For cancellation:

Enter PNR
   ↓
Fetch Ticket Details
   ↓
Confirm Cancellation
   ↓
Ticket Cancelled

🗄️ Database

The application uses SQLite as its database.

The database stores information related to:

- Users
- Trains
- Passengers
- Tickets
- PNR details
- Seat information
- Journey details

Database connectivity is handled using JDBC.

🌐 API Integration

The project also integrates an online API to retrieve train-related information in JSON format.

The Gson library is used to process the JSON response received from the API.

▶️ How to Run

1. Clone the Repository

git clone https://github.com/shagun800/OIBSIP.git

2. Open the Project

Open the project folder in VS Code or any Java-compatible IDE.

3. Add Required Libraries

The required ".jar" files are available inside the "lib" folder:

gson-2.14.0.jar
sqlite-jdbc-3.53.4.0.jar

Make sure these libraries are included in the Java classpath.

4. Configure API Key

If the project uses an API key, configure it through the environment configuration rather than exposing the key publicly.

«Never commit private API keys, passwords, or other credentials to GitHub.»

5. Run the Application

Run:

Main.java

The application will initialize the required database tables and launch the reservation system.

🔒 Security

Sensitive information such as API keys and credentials should be stored in environment variables or a ".env" file.

The ".env" file is excluded from Git using ".gitignore".

🎯 Learning Outcomes

Through this project, I gained practical experience with:

- Java Object-Oriented Programming
- Java Swing GUI development
- JDBC and SQLite
- DAO architecture
- Database CRUD operations
- REST API integration
- JSON data handling
- Authentication
- Git and GitHub
- Project structure and version control

👩‍💻 Internship

Oasis Infobyte Internship — OIBSIP

This project was developed as an internship project to gain hands-on experience in Java application development, database connectivity, API integration, and software project development.

📌 Future Improvements

- Online payment integration
- Improved UI/UX
- Admin dashboard
- Real-time seat availability
- Email/SMS booking confirmation
- Better error handling and validation
- Deployment as a web-based application

---

⭐ Project: Online Train Reservation System

Developed using Java, Swing, JDBC, SQLite & REST API

Made with 💻 and ☕
