package com.octagen.freetestcode.models;

import java.util.List;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class Question {
    private int id;
    private List<QContent> contents;
    private List<Answer> answers;

    public Question(int id, List<QContent> contents, List<Answer> answers) {
        this.id = id;
        this.contents = contents;
        this.answers = answers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<QContent> getContents() {
        return contents;
    }

    public void setContents(List<QContent> contents) {
        this.contents = contents;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", contents=" + contents +
                ", answers=" + answers +
                '}';
    }
}
