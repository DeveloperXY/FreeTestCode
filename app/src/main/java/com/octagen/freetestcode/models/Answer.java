package com.octagen.freetestcode.models;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class Answer implements Comparable<Answer> {
    private int id;
    private String text;
    private boolean isValid;

    public Answer(int id, String text, boolean isValid) {
        this.id = id;
        this.text = text;
        this.isValid = isValid;
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

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "isValid=" + isValid +
                ", text='" + text + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Answer another) {
        return id - another.id;
    }
}
