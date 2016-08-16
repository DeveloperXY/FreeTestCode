package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.octagen.freetestcode.R;

public class ChooseCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_code);
    }

    public void onArabicSelected(View view) {
        onFrenchSelected(view);
    }

    public void onFrenchSelected(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
}
