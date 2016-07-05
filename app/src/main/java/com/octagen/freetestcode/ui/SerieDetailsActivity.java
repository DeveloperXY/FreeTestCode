package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.utils.FileUtils;

import org.json.JSONException;
import org.json.JSONObject;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_details);
        ButterKnife.bind(this);

        setupActionBar();
        setupFonts();

        try {
            JSONObject object = new JSONObject(FileUtils.loadJSONFromAsset(this, "test.json"));
            Log.i("JSON", object.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setupFonts() {
        correctionBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
        validationBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
    }
}
