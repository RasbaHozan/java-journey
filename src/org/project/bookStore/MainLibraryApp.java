package org.project.bookStore;

public class MainLibraryApp {
    public static void main(String[] args) {
 // Create mediaObjects
        BookMedia book1 = new BookMedia("Brave New World", 200);
        Movie movie1 = new Movie("Inception", 400);
        BookMedia book2 = new BookMedia("1984", 1050);
        Movie movie2 = new Movie("Interstellar", 800);

 // Create library and add observers
        Library<Media> library = new Library<>();

 //Creating users       
        User user1 = new User("Sarah");
        User user2 = new User("Ali");
        User user3 = new User("Ahmed");

 // Add observers to the library
        library.addObserver(user1);
        library.addObserver(user2);
        library.addObserver(user3);

// Add media to the library
        library.addMedia(book1);  
        library.addMedia(movie1);
        library.addMedia(book2); 
        library.addMedia(movie2);

 // Update price
        library.updatePrice(book1, 12.99);  
        library.updatePrice(movie1, 18.99);
        library.updatePrice(book2, 10.49);  
        library.updatePrice(movie2, 19.99);
    }
}
