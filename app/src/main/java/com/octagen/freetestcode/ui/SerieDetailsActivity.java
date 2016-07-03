package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SerieDetailsActivity extends AppCompatActivity {

    @Bind(R.id.correctionBtn)
    Button correctionBtn;
    @Bind(R.id.validationBtn)
    Button validationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_details);
        ButterKnife.bind(this);

        correctionBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
        validationBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
    }
}
