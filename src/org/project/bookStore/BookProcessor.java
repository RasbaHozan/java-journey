package org.project.bookStore;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class BookProcessor {

    // Method to read and parse the book list from JSON file
    public BookList readBookListFromFile(String filePath) throws FileNotFoundException, JsonSyntaxException {
    	
        Gson gson = new Gson();
        
        FileReader reader = new FileReader(filePath);
        return gson.fromJson(reader, BookList.class);
    }

    // Find books by a specific author
    public List<Book> findBooksByAuthor(BookList bookList, String author) {
        return bookList.getBooks().stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .toList();
    }

    // Display average price of all books
    public void displayAveragePrice(BookList bookList) {
        double averagePrice = bookList.getBooks().stream()
            .mapToDouble(book -> book.getMetadata().getPrice())
            .average()
            .orElse(0);
        System.out.println("Average Price: " + averagePrice);
    }

    // Display book with the highest price
    public void displayBookWithHighestPrice(BookList bookList) {
        Book bookWithHighestPriced = bookList.getBooks().get(0);

        for (Book book : bookList.getBooks()) {
            if (book.getMetadata().getPrice() > bookWithHighestPriced.getMetadata().getPrice()) {
                bookWithHighestPriced = book;
            }
        }

        System.out.println("Book with Highest Price: " + bookWithHighestPriced.getTitle());
    }


    // Find books by category
    public List<Book> findBooksByCategory(BookList bookList, String category) {
        return bookList.getBooks().stream()
            .filter(book -> book.getMetadata().getCategories().contains(category))
            .toList();
    }
}