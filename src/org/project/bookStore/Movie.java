package org.project.bookStore;

	public class Movie implements Media {
	    private String title;
	    private double price;

	    public Movie(String title, double price) {
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

