package org.project.bookStore;

public class Book {
	private String title;
	private String author;
	
	private BookMetadata metadata = new BookMetadata();

	public String getTitle() {
		return title;
	}

	public void setTitle(String newTitle) {
		this.title = newTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String newAuthor) {
		this.author = newAuthor;
	}

	public BookMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(BookMetadata newMetadata) {
		this.metadata = newMetadata;
	}

	public Book(String title, String author, BookMetadata metadata) {
		this.title = title;
		this.author = author;
		this.metadata = metadata;
	}
public Book() {
}
    // Method to display book details
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + metadata.getPrice());
        System.out.println("Categories: " + metadata.getCategories());
        System.out.println("ISBN: " + metadata.getIsbn());
        System.out.println("Pages: " + metadata.getPages());
    }
}