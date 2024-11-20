package org.project.bookStore;

public class BookMedia implements Media {
    private String title;
    private double price;

    public BookMedia(String title, double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
