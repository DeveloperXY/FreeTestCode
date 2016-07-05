package com.octagen.freetestcode.models;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class QContent {
    private int id;
    private String text;

    public QContent(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "QContent{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
