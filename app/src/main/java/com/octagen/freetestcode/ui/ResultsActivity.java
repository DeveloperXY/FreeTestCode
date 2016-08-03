package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.custom.ReponseItem;
import com.octagen.freetestcode.utils.History;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultsActivity extends ActionbarActivity {

    @Bind(R.id.answersGrid)
    GridLayout answersGrid;
    @Bind(R.id.ratioLabel)
    TextView ratioLabel;
    @Bind(R.id.homeLabel)
    TextView homeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        ButterKnife.bind(this);

        setupActionBar();

        History h = new History(this);
        try {
            JSONObject data = new JSONObject(h.GetLastHistorique());
            JSONArray questions = data.getJSONArray("details");
            int qCount = questions.length();
            int validCount = 0; // the number of correctly answered questions

            for (int i = 0; i < qCount; i++) {
                JSONObject question = questions.getJSONObject(i);
                boolean isValid = question.getBoolean("isValid");
                String validAnswers = question.getString("validAnswers");
                String selectedAnswers = question.getString("selectedAnswers");
                ReponseItem item = new ReponseItem(this, null);
                int questionNumber = question.getInt("questionID");

                if (isValid) {
                    validCount++;
                    item.IsCorrect("Question " + questionNumber, validAnswers);
                }
                else
                    item.Isfalse("Question " + questionNumber, validAnswers, selectedAnswers);

                answersGrid.addView(item);
            }

            ratioLabel.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
            homeLabel.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
            ratioLabel.setText(String.format("%d/%d", validCount, qCount));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onHomePressed(View view) {
        finish();
    }
}
