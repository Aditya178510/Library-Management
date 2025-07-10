package com.aditya.library;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private double price;
    private boolean available;

    public Book(int id, String title, String author, String genre, double price, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.available = available;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }

    @Override
    public String toString() {
        return String.format("Book{id=%d, title='%s', author='%s', genre='%s', price=%.2f, available=%s}",
                id, title, author, genre, price, available ? "Yes" : "No");
    }
}
