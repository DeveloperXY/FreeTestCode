package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBar;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBarListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MotocycleActivity extends AppCompatActivity implements ActionBarListener {

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
        mActionBar.setListener(this);
        mActionBar.setLibelle("Motocycle");
        mActionBar.setImage(R.drawable.ic_white_motocycle);
    }

    @Override
    public void onReturnPressed() {
        finish();
    }
}
