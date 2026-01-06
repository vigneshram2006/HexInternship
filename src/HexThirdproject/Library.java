package HexThirdproject;
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
        for (Book b : books) {
            if (b.issued) {
                System.out.println(
                    b.name + " issued to member id " + b.issuedTo
                );
            }
        }
    }
}
