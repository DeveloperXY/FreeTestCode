package com.octagen.freetestcode.ui;

import android.os.Bundle;

import com.octagen.freetestcode.R;

import butterknife.ButterKnife;

public class PanelsActivity extends ActionbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panels);
        ButterKnife.bind(this);

        setupActionBar();
    }

    @Override
    protected void setupActionBar() {
        super.setupActionBar();

        mActionBar.isHelpEnabled(true);
    }
}
