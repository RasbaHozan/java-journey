package org.project.bookStore;
import java.io.FileNotFoundException;

import com.google.gson.JsonSyntaxException;

public class MainApp {

    public static void main(String[] args) {
        String filePath = "src/org/project/bookStore/books.json";
        BookProcessor bookProcessor = new BookProcessor();

        try {
            BookList bookList = bookProcessor.readBookListFromFile(filePath);

            // Display all books
            System.out.println("\nAll Books:");
            for (Book book : bookList.getBooks()) {
                book.displayBookInfo();
            }
            
            System.out.println("\nBooks by J.K. Rowling:");
            bookProcessor.findBooksByAuthor(bookList, "J.K. Rowling")
            .forEach(Book::displayBookInfo);
            
            System.out.println("\nAverage Price of Books:");
            bookProcessor.displayAveragePrice(bookList);

            System.out.println("\nBook with the Highest Price:");
            bookProcessor.displayBookWithHighestPrice(bookList);

            System.out.println("\nBooks in the Fantasy Category:");
            bookProcessor.findBooksByCategory(bookList, "fantasy")
            .forEach(Book::displayBookInfo);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.out.println("Error: Invalid JSON format. " + e.getMessage());
        } 
    }
}
