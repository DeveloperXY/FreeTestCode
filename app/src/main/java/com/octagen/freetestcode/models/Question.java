package com.octagen.freetestcode.models;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class Question {
    private int id;
    private List<QContent> contents;
    private List<Answer> answers;
    /**
     * The file name of the intro sound of the question.
     */
    private String introSound;
    /**
     * The file name of the question's audio.
     */
    private String sound;

    public Question(int id, List<QContent> contents, List<Answer> answers, String introSound, String sound) {
        this.id = id;
        this.contents = contents;
        this.answers = answers;
        this.introSound = introSound;
        this.sound = sound;
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

    public String getIntroSound() {
        return introSound;
    }

    public void setIntroSound(String introSound) {
        this.introSound = introSound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Set<Answer> getCorrectAnswers() {
        Set<Answer> answerSet = new TreeSet<>();

        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);

            if (answer.isValid())
                answerSet.add(answer);
        }

        return answerSet;
    }

    public boolean isCorrect(Set<Integer> answerIDs) {
        if (answerIDs == null || answerIDs.size() == 0 ||
                getCorrectAnswers().size() != answerIDs.size())
            return false;

        Iterator<Integer> iterator = answerIDs.iterator();
        List<Answer> answerList = new ArrayList<>(getCorrectAnswers());
        int i = 0;
        while (iterator.hasNext()) {
            if (iterator.next() != answerList.get(i++).getId()) {
                Log.i("isCorrect", "AnswerList: " + answerList);
                Log.i("isCorrect", "Returning false...");
                return false;
            }
        }

        Log.i("isCorrect", "Returning true...");
        return true;
    }

    public Set<Integer> getValidAnswers() {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < answers.size(); i++) {
            Answer answer = answers.get(i);
            if (answer.isValid())
                set.add(i + 1);
        }

        return set;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", contents=" + contents +
                ", answers=" + answers +
                ", introSound='" + introSound + '\'' +
                ", sound='" + sound + '\'' +
                '}';
    }
}
