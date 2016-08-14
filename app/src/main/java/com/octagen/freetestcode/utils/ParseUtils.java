package com.octagen.freetestcode.utils;

import android.content.Context;

import com.octagen.freetestcode.models.Answer;
import com.octagen.freetestcode.models.QContent;
import com.octagen.freetestcode.models.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class ParseUtils {
    public static String loadJSONFromAsset(Context context, String filename) {
        String json;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static List<Question> parseQuestions(JSONArray questionsArray) {
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < questionsArray.length(); i++) {
            try {
                JSONObject question = questionsArray.getJSONObject(i);

                // 1- Parse answers
                JSONArray answers = question.getJSONArray("Reponses");
                List<Answer> answerList = new ArrayList<>();

                for (int j = 0; j < answers.length(); j++) {
                    JSONObject answer = answers.getJSONObject(j);
                    answerList.add(new Answer(
                            answer.getInt("id"),
                            answer.getString("Choix"),
                            answer.getBoolean("IsValide")
                    ));
                }

                // 2- Parse question content
                JSONArray contents = question.getJSONArray("QuestionItem");
                List<QContent> contentList = new ArrayList<>();

                for (int j = 0; j < contents.length(); j++) {
                    JSONObject content = contents.getJSONObject(j);
                    contentList.add(new QContent(
                            -1,
                            content.getString("Question")
                    ));
                }

                String intro = question.getString("intro");
                String audio = question.getString("Audio");

                questions.add(
                        new Question(
                                question.getInt("ID"),
                                contentList,
                                answerList,
                                intro,
                                audio
                        ));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return questions;
    }

    public static String parseAnswers(Set<Integer> answers) {
        Iterator<Integer> iterator = answers.iterator();
        StringBuilder sb = new StringBuilder("");

        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext())
                sb.append("-");
        }

        return sb.toString();
    }
}
