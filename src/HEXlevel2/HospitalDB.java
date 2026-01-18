package HEXlevel2;

import java.sql.*;
import java.util.Scanner;

public class HospitalDB {

    static String url = "jdbc:mysql://localhost:3306/hospital";
    static String user = "root";
    static String password = "9345659341";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nHOSPITAL MANAGEMENT SYSTEM");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                addPatient(sc);
            } else if (choice == 2) {
                viewPatients();
            } else if (choice == 3) {
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

            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter disease: ");
            String disease = sc.nextLine();

            String sql = "INSERT INTO patient(name, age, disease) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
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
}
