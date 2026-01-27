package HexLevel3;
import java.util.ArrayList;
import java.util.Scanner;

class Booking {
    int bookingId;
    String customerName;
    String serviceType; 
    String details;
    double amount;

    Booking(int bookingId, String customerName, String serviceType, String details, double amount) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.details = details;
        this.amount = amount;
    }
}

public class TravelBookingSystem {

    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int bookingCounter = 1001;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Travel Booking System ---");
            System.out.println("1. Book Flight");
            System.out.println("2. Book Hotel");
            System.out.println("3. Book Transport");
            System.out.println("4. View Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bookFlight();
                    break;
                case 2:
                    bookHotel();
                    break;
                case 3:
                    bookTransport();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    System.out.println("Thank you for using Travel Booking System");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void bookFlight() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter From City: ");
        String from = sc.nextLine();

        System.out.print("Enter To City: ");
        String to = sc.nextLine();

        System.out.print("Enter Ticket Price: ");
        double price = sc.nextDouble();
        sc.nextLine();

        String details = from + " to " + to;

        bookings.add(new Booking(
                bookingCounter++, name, "Flight", details, price
        ));

        System.out.println("Flight booked successfully");
    }

    static void bookHotel() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Hotel Name: ");
        String hotel = sc.nextLine();

        System.out.print("Enter Number of Days: ");
        int days = sc.nextInt();

        System.out.print("Enter Price per Day: ");
        double pricePerDay = sc.nextDouble();
        sc.nextLine();

        double total = days * pricePerDay;
        String details = hotel + " (" + days + " days)";

        bookings.add(new Booking(
                bookingCounter++, name, "Hotel", details, total
        ));

        System.out.println("Hotel booked successfully");
    }

    static void bookTransport() {
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Transport Type (Cab/Bus): ");
        String type = sc.nextLine();

        System.out.print("Enter Distance (km): ");
        int distance = sc.nextInt();

        System.out.print("Enter Price per km: ");
        double pricePerKm = sc.nextDouble();
        sc.nextLine();

        double total = distance * pricePerKm;
        String details = type + " for " + distance + " km";

        bookings.add(new Booking(
                bookingCounter++, name, "Transport", details, total
        ));

        System.out.println("Transport booked successfully");
    }

    static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found");
            return;
        }

        System.out.println("\nID\tName\tService\t\tDetails\t\tAmount");
        for (Booking b : bookings) {
            System.out.println(
                b.bookingId + "\t" +
                b.customerName + "\t" +
                b.serviceType + "\t\t" +
                b.details + "\t" +
                b.amount
            );
        }
    }
}
