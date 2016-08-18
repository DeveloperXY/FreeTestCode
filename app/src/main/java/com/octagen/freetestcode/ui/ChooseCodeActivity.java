package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.octagen.freetestcode.R;

public class ChooseCodeActivity extends SettingsAbleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_code);
    }

    public void onArabicSelected(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }

    public void onFrenchSelected(View view) {
        startActivity(new Intent(this, FrenchCodeActivity.class));
    }
}
