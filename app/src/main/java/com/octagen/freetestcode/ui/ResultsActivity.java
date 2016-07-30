package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.custom.ReponseItem;
import com.octagen.freetestcode.utils.History;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends AppCompatActivity {

    @Bind(R.id.answersGrid)
    GridLayout answersGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        History h = new History(this);
        try {
            JSONObject data = new JSONObject(h.GetLastHistorique());
            JSONArray questions = data.getJSONArray("details");
            int qCount = questions.length();

            for (int i = 0; i < qCount; i++) {
                JSONObject question = questions.getJSONObject(i);
                boolean isValid = question.getBoolean("isValid");
                String validAnswers = question.getString("validAnswers");
                String selectedAnswers = question.getString("selectedAnswers");
                ReponseItem item = new ReponseItem(this, null);
                int questionNumber = question.getInt("questionID");

                if (isValid)
                    item.IsCorrect("Question " + questionNumber + ": ", validAnswers);
                else
                    item.Isfalse("Question " + questionNumber + ": ", validAnswers, selectedAnswers);

                answersGrid.addView(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
