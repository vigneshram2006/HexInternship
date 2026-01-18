package HEXlevel2;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {

    static String url = "jdbc:mysql://localhost:3306/hospital";
    static String user = "root";
    static String password = "your_password";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. View Doctors");
            System.out.println("4. Book Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addPatient(sc);
            } else if (choice == 2) {
                viewPatients();
            } else if (choice == 3) {
                viewDoctors();
            } else if (choice == 4) {
                bookAppointment(sc);
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void addPatient(Scanner sc) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.print("Enter patient name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter disease: ");
            String disease = sc.nextLine();

            String query = "INSERT INTO patient(name, age, disease) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, disease);
            ps.executeUpdate();

            System.out.println("Patient added successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error adding patient.");
        }
    }

    static void viewPatients() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM patient");

            System.out.println("\nID  Name  Age  Disease");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "  " +
                        rs.getString("name") + "  " +
                        rs.getInt("age") + "  " +
                        rs.getString("disease")
                );
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error fetching patients.");
        }
    }

    static void viewDoctors() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM doctor");

            System.out.println("\nID  Name  Specialization");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "  " +
                        rs.getString("name") + "  " +
                        rs.getString("specialization")
                );
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error fetching doctors.");
        }
    }

    static void bookAppointment(Scanner sc) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.print("Enter patient ID: ");
            int pid = sc.nextInt();
            System.out.print("Enter doctor ID: ");
            int did = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter appointment date: ");
            String date = sc.nextLine();

            String query = "INSERT INTO appointment(patient_id, doctor_id, appointment_date) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, pid);
            ps.setInt(2, did);
            ps.setString(3, date);
            ps.executeUpdate();

            System.out.println("Appointment booked successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Error booking appointment.");
        }
    }
}
