package com.aditya.library;

import java.util.List;
import java.util.Scanner;

public class MainFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDBManager manager = new BookDBManager();
        boolean runningLoop = true;

        while (runningLoop) {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine().trim();
                    if (title.isEmpty()) {
                        System.out.println("Title can't be empty.");
                        break;
                    }

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine().trim();
                    if (author.isEmpty()) {
                        System.out.println("Author can't be empty.");
                        break;
                    }

                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine().trim();

                    System.out.print("Enter Price: ");
                    double price;
                    try {
                        price = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price.");
                        break;
                    }

                    System.out.print("Is Available? (true/false): ");
                    boolean available;
                    try {
                        available = Boolean.parseBoolean(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid input for availability.");
                        break;
                    }

                    Book newBook = new Book(0, title, author, genre, price, available);
                    manager.addBook(newBook);
                    new BookDBLogger("Added book: " + title).start();
                    break;

                case 2:
                    List<Book> books = manager.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId;
                    try {
                        searchId = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    Book found = manager.getBookById(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId;
                    try {
                        updateId = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine().trim();

                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine().trim();

                    System.out.print("Enter New Genre: ");
                    String newGenre = sc.nextLine().trim();

                    System.out.print("Enter New Price: ");
                    double newPrice;
                    try {
                        newPrice = Double.parseDouble(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid price.");
                        break;
                    }

                    System.out.print("Is Available? (true/false): ");
                    boolean newAvailable;
                    try {
                        newAvailable = Boolean.parseBoolean(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Invalid input for availability.");
                        break;
                    }

                    Book updatedBook = new Book(updateId, newTitle, newAuthor, newGenre, newPrice, newAvailable);
                    boolean updated = manager.updateBook(updatedBook);
                    if (updated) {
                        System.out.println("Book updated.");
                        new BookDBLogger("Updated book ID: " + updateId).start();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId;
                    try {
                        deleteId = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID.");
                        break;
                    }

                    boolean deleted = manager.deleteBook(deleteId);
                    if (deleted) {
                        System.out.println("Book deleted.");
                        new BookDBLogger("Deleted book ID: " + deleteId).start();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    runningLoop = false;
                    System.out.println("Thank you for using the Library Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}
