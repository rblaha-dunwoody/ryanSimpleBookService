package com.example.ryansimplebookservice;

public class Movie {

    private int id;
    private String title;
    private String director;
    private String publisher;
    private double price;

    public Movie() {

    }

    public Movie(
            int id,
            String title,
            String director,
            String publisher,
            double price
    ) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.publisher = publisher;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
