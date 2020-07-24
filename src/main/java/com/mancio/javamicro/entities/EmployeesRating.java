package com.mancio.javamicro.entities;

public class EmployeesRating {

    private long id;

    private int rating;

    public EmployeesRating(long id, int rating) {
        this.id = id;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
