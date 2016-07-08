package com.octagen.freetestcode.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.octagen.customviews.CustomTextView;
import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.models.Answer;
import com.octagen.freetestcode.models.QContent;
import com.octagen.freetestcode.models.Question;
import com.octagen.freetestcode.utils.ParseUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Bind(R.id.selectedOne)
    CustomTextView selectedOne;
    @Bind(R.id.selectedTwo)
    CustomTextView selectedTwo;
    @Bind(R.id.selectedThree)
    CustomTextView selectedThree;
    @Bind(R.id.selectedFour)
    CustomTextView selectedFour;

    @Bind(R.id.partTwoLayout)
    LinearLayout partTwoLayout;

    /**
     * The list of questions related to the current series.
     */
    private List<Question> mQuestions;

    /**
     * A map representing the list of selected choices, indexed by question ID.
     */
    private Map<Integer, Set<Integer>> mSelectedMap;

    /**
     * The list of currently selected choices.
     */
    private Set<Integer> mSelectedSet;

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

    public void onValidate(View view) {
        if (mSelectedSet.size() == 0)
            Toast.makeText(this, "Choose at least 1 answer.", Toast.LENGTH_SHORT).show();
        else {
            Log.i("SELECTED", "Currently selected: " + mSelectedSet);
            mSelectedMap.put(currentQIndex, mSelectedSet);
            currentQIndex++;

            if (currentQIndex >= mQuestions.size())
                finish();
            else {
                toggleUI();
                reset();
            }
        }
    }

    public void onCorrect(View view) {
        reset();
    }

    private void reset() {
        mSelectedSet = new TreeSet<>();

        int color = getResources().getColor(R.color.notselectedNumberColor);
        selectedOne.setBackgroundColor(color);
        selectedTwo.setBackgroundColor(color);
        selectedThree.setBackgroundColor(color);
        selectedFour.setBackgroundColor(color);
        selectedOne.setTextColor(getResources().getColor(android.R.color.primary_text_light));
        selectedTwo.setTextColor(getResources().getColor(android.R.color.primary_text_light));
        selectedThree.setTextColor(getResources().getColor(android.R.color.primary_text_light));
        selectedFour.setTextColor(getResources().getColor(android.R.color.primary_text_light));
    }

    @OnClick({R.id.answerOne, R.id.answerTwo, R.id.answerThree, R.id.answerFour})
    public void onAnswerSelected(View view) {
        CustomTextView target = null;

        switch (view.getId()) {
            case R.id.answerOne:
                mSelectedSet.add(1);
                target = selectedOne;
                break;
            case R.id.answerTwo:
                mSelectedSet.add(2);
                target = selectedTwo;
                break;
            case R.id.answerThree:
                mSelectedSet.add(3);
                target = selectedThree;
                break;
            case R.id.answerFour:
                mSelectedSet.add(4);
                target = selectedFour;
                break;
        }

        if (target != null) {
            target.setBackgroundColor(getResources().getColor(R.color.selectedNumberColor));
            target.setTextColor(Color.parseColor("#ffffff"));
        }
    }

    private void setupUI() {
        currentQIndex = 0;
        mSelectedMap = new HashMap<>();
        mSelectedSet = new TreeSet<>();

        toggleUI();
    }

    /**
     * Sets the stage for the currently viewed question.
     */
    private void toggleUI() {
        Question currentQ = mQuestions.get(currentQIndex);
        List<QContent> contents = currentQ.getContents();
        QContent first = contents.get(0);
        partOneText.setText(first.getText());

        if (contents.size() > 1) {
            QContent second = contents.get(1);
            partTwoText.setText(second.getText());

            partTwoLayout.setVisibility(View.VISIBLE);
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
        } else {
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
