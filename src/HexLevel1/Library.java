package HexLevel1;
import java.util.*;

class Book {
    int bookId;
    String name;
    String author;
    boolean issued;
    int issuedTo;

    Book(int bookId, String name, String author) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        issued = false;
        issuedTo = -1;
    }
}

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Library {

    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Member> members = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added");
    }

    void addMember(Member m) {
        members.add(m);
        System.out.println("Member added");
    }

    void issueBook(int bookId, int memberId) {

        Book book = null;
        for (Book b : books) {
            if (b.bookId == bookId) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found");
            return;
        }

        if (book.issued) {
            System.out.println("Book already issued");
            return;
        }

        boolean memberExists = false;
        for (Member m : members) {
            if (m.id == memberId) {
                memberExists = true;
                break;
            }
        }

        if (!memberExists) {
            System.out.println("Member not found");
            return;
        }

        book.issued = true;
        book.issuedTo = memberId;
        System.out.println("Book issued");
    }

    void returnBook(int bookId) {

        for (Book b : books) {
            if (b.bookId == bookId) {
                if (!b.issued) {
                    System.out.println("Book not issued");
                } else {
                    b.issued = false;
                    b.issuedTo = -1;
                    System.out.println("Book returned");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    void showIssued() {
        boolean found = false;
        for (Book b : books) {
            if (b.issued) {
                System.out.println(b.name + " issued to member id " + b.issuedTo);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently issued");
        }
    }

   
    public static void main(String[] args) {

        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Issued Books");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Book Name: ");
                    String bname = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(bid, bname, author));
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Member Name: ");
                    String mname = sc.nextLine();
                    library.addMember(new Member(mid, mname));
                    break;

                case 3:
                    System.out.print("Book ID: ");
                    int issueBid = sc.nextInt();
                    System.out.print("Member ID: ");
                    int issueMid = sc.nextInt();
                    library.issueBook(issueBid, issueMid);
                    break;

                case 4:
                    System.out.print("Book ID: ");
                    int returnBid = sc.nextInt();
                    library.returnBook(returnBid);
                    break;

                case 5:
                    library.showIssued();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
