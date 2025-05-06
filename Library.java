package Libraray;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String bookname, author;
    double price;
    Boolean available = true;

    Scanner sc = new Scanner(System.in);

    void Bookentries() {
        System.out.println("Enter id of book: ");
        bookId = sc.nextInt();

        sc.nextLine();  
        
        System.out.println("Enter name of book: ");
        bookname = sc.nextLine();

        System.out.println("Enter author of book: ");
        author = sc.nextLine();

        System.out.println("Enter price of book: ");
        price = sc.nextDouble();
    }

    void display() {
        System.out.println("ID: " + bookId + "\nBook Name: " + bookname + "\nAuthor name: " + author + "\nPrice: " + price);
    }

    ArrayList<Book> books = new ArrayList<>();

    void addBook() {
        Book newBook = new Book();
        newBook.Bookentries();
        books.add(newBook);
        System.out.println("Book added Successfully.");
    }

    void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books.");
        } else {
            for (Book b : books) {
                b.display();
            }
        }
    }

    void issueBook() {
        System.out.println("Enter book Id: ");
        int bookId = sc.nextInt();

        Book issue = null;
        for (Book b : books) {
            if (b.bookId == bookId) {
                issue = b;
            }
        }

        if (issue == null) {
            System.out.println("Book Id: " + bookId + " not found.");
        } else if (issue.available) {
            issue.available = false;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not available.");
        }
    }

    void returnBook() {
        System.out.println("Enter book Id: ");
        int bookId = sc.nextInt();

        Book returnBook = null;
        for (Book b : books) {
            if (b.bookId == bookId) {
                returnBook = b;
            }
        }

        if (returnBook == null) {
            System.out.println("Book Id: " + bookId + " not found.");
        } else if (!returnBook.available) {
            returnBook.available = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }
}

public class Library {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book b1 = new Book();

        while (true) {
        	
        	System.out.println("");
            System.out.println("Library Management System.");
            System.out.println("1. Add Book.");
            System.out.println("2. View Book.");
            System.out.println("3. Issue Book.");
            System.out.println("4. Return Book.");
            System.out.println("5. Exit.");
            System.out.print("Select the option: ");

            int select = sc.nextInt();
            sc.nextLine();  
            
            switch (select) {
                case 1:
                    b1.addBook();
                    break;
                case 2:
                    b1.viewBooks();
                    break;
                case 3:
                    b1.issueBook();
                    break;
                case 4:
                    b1.returnBook();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}




































