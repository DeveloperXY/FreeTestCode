package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.models.Answer;
import com.octagen.freetestcode.models.QContent;
import com.octagen.freetestcode.models.Question;
import com.octagen.freetestcode.utils.ParseUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 03/07/2016.
 */
public class SerieDetailsActivity extends ActionbarActivity {

    @Bind(R.id.correctionBtn)
    Button correctionBtn;
    @Bind(R.id.validationBtn)
    Button validationBtn;
    @Bind(R.id.partTwoText)
    TextView partTwoText;
    @Bind(R.id.partOneText)
    TextView partOneText;
    @Bind(R.id.choiceOne)
    TextView choiceOne;
    @Bind(R.id.choiceTwo)
    TextView choiceTwo;
    @Bind(R.id.choiceThree)
    TextView choiceThree;
    @Bind(R.id.choiceFour)
    TextView choiceFour;

    @Bind(R.id.partTwoLayout)
    LinearLayout partTwoLayout;

    /**
     * The list of questions related to the current series.
     */
    private List<Question> mQuestions;

    /**
     * The index of the currently displayed question.
     */
    private int currentQIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_details);
        ButterKnife.bind(this);

        setupActionBar();
        setupFonts();
        parseQuestionsFromAssets();
        setupUI();
    }

    private void setupFonts() {
        correctionBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
        validationBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
    }

    private void parseQuestionsFromAssets() {
        try {
            JSONObject object = new JSONObject(ParseUtils.loadJSONFromAsset(this, "test.json"));
            Log.i("JSON", object.toString());
            JSONArray questions = object.getJSONArray("questions");
            mQuestions = ParseUtils.parseQuestions(questions);

            Log.i("JSON", "Parsed: " + mQuestions);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setupUI() {
        currentQIndex = 0;

        Question currentQ = mQuestions.get(currentQIndex);
        List<QContent> contents = currentQ.getContents();
        QContent first = contents.get(0);
        partOneText.setText(first.getText());

        if (contents.size() > 1) {
            QContent second = contents.get(1);
            partTwoText.setText(second.getText());

            choiceThree.setVisibility(View.VISIBLE);
            choiceFour.setVisibility(View.VISIBLE);
            partTwoText.setVisibility(View.VISIBLE);

            List<Answer> answers = currentQ.getAnswers();
            for (int i = 0; i < answers.size(); i++) {
                Answer answer = answers.get(i);
                TextView target = null;
                String suffix = "";
                switch (i) {
                    case 0:
                        target = choiceOne;
                        suffix = "A";
                        break;
                    case 1:
                        target = choiceTwo;
                        suffix = "B";
                        break;
                    case 2:
                        target = choiceThree;
                        suffix = "C";
                        break;
                    case 3:
                        target = choiceFour;
                        suffix = "D";
                        break;
                }

                target.setText(String.format("%s .%s", answer.getText(), suffix));
            }
        }
        else {
            partTwoLayout.setVisibility(View.GONE);

            List<Answer> answers = currentQ.getAnswers();
            Log.i("SIZE", answers.size() + "-#");
            for (int i = 0; i < answers.size(); i++) {
                Log.i("SIZE", "I is: " + i);
                Answer answer = answers.get(i);
                TextView target = null;
                String suffix = "";
                switch (i) {
                    case 0:
                        target = choiceOne;
                        suffix = "A";
                        break;
                    case 1:
                        target = choiceTwo;
                        suffix = "B";
                        break;
                }

                Log.i("SIZE", "Target is NULL: " + (target == null));
                target.setText(String.format("%s .%s", answer.getText(), suffix));
            }
        }
    }
}
