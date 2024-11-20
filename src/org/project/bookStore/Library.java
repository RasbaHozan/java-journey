package org.project.bookStore;
import java.util.ArrayList;
import java.util.List;

public class Library<T extends Media> {
    private List<T> mediaItems = new ArrayList<>();
    private List<LibraryObserver> observers = new ArrayList<>();

    // Add media and notify observers
    public void addMedia(T media) {
        mediaItems.add(media);
        LibraryEvent event = new LibraryEvent("New media added: " + media.getClass().getSimpleName());
        notifyObservers(event);  // Notifying observers when new media is added
    }

    // Update price and notify observers
    public void updatePrice(T media, double newPrice) {
        media.updatePrice(newPrice);
        LibraryEvent event = new LibraryEvent("Price updated for: " + media.getClass().getSimpleName());
        notifyObservers(event);  // Notifying observers when price is updated
    }

    // Add observer
    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    // Notify observers with events
    private void notifyObservers(LibraryEvent event) {
        for (LibraryObserver observer : observers) {
            observer.updateEvent(event);
        }
    }
}

