package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBar;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBarListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 03/07/2016.
 */
public class SerieDetailsActivity extends AppCompatActivity implements ActionBarListener {

    @Bind(R.id.ActionBar)
    ActionBar mActionBar;

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

        correctionBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
        validationBtn.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
    }

    private void setupActionBar() {
        Intent intent = getIntent();
        int actionbarColor = intent.getIntExtra("color", -1);
        int actionbarImage = intent.getIntExtra("image", -1);
        String actionbarTitle = intent.getStringExtra("title");

        mActionBar.setListener(this);
        mActionBar.setLibelle(actionbarTitle);
        mActionBar.setImage(actionbarImage);
        mActionBar.setColor(actionbarColor);
    }

    @Override
    public void onReturnPressed() {
        finish();
    }
}
