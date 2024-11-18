package org.project.bookStore;

import java.util.ArrayList;

public class BookMetadata {
	private int price;
	private ArrayList<String> categories = new ArrayList<String>();
	private String isbn;
	private int pages;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int newPrice) {
		this.price = newPrice;
	}
	public ArrayList<String> getCategories() {
		return categories;
	}
	public void setCategories(ArrayList<String> newCategories) {
		this.categories = newCategories;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String newIsbn) {
		this.isbn = newIsbn;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int newPages) {
		this.pages = newPages;
	}
	public BookMetadata(int price, ArrayList<String> categories, String isbn, int pages) {
	
		this.price = price;
		this.categories = categories;
		this.isbn = isbn;
		this.pages = pages;
	}
	public BookMetadata() {
	}
}
