package com.octagen.freetestcode.models;

import java.util.List;
import java.util.Map;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class Question {
    private int id;
    private Map<Integer, String> contents;
    private List<Answer> answers;

    public Question(int id, Map<Integer, String> contents, List<Answer> answers) {
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

    public Map<Integer, String> getContents() {
        return contents;
    }

    public void setContents(Map<Integer, String> contents) {
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
