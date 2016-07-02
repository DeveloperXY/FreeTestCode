package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBar;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBarListener;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 02/07/2016.
 */
public class SeriesActivity extends AppCompatActivity implements ActionBarListener {

    @Bind(R.id.ActionBar)
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motocycle);
        ButterKnife.bind(this);

        setupActionBar();
    }

    private void setupActionBar() {
        Intent intent = getIntent();
        String actionbarTitle = intent.getStringExtra("title");
        @DrawableRes int actionbarImage = intent.getIntExtra("image", -1);

        if (actionbarImage == -1) {
            throw new IllegalArgumentException(
                    "You need to pass an image for the custom action bar.");
        }

        mActionBar.setListener(this);
        mActionBar.setLibelle(actionbarTitle);
        mActionBar.setImage(actionbarImage);
    }

    @Override
    public void onReturnPressed() {
        finish();
    }
}
