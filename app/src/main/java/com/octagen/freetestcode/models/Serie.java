package com.octagen.freetestcode.models;

/**
 * Created by Mohammed Aouf ZOUAG on 02/07/2016.
 */
public class Serie {
    private int id;
    private String label;
    private int rating; // */40

    public Serie(int id, String label, int rating) {
        this.id = id;
        this.label = label;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", rating=" + rating +
                '}';
    }
}
