package org.project.bookStore;


public class User implements LibraryObserver {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void updateEvent(LibraryEvent event) {
        System.out.println("Notification for " + name + ": " + event.getEvent());
    }
}
