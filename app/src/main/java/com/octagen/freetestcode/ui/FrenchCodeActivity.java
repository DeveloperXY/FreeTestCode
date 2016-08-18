package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.octagen.freetestcode.R;

public class FrenchCodeActivity extends SettingsAbleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_code);
    }

    public void onPanelsSelected(View view) {
        Intent intent = new Intent(this, PanelsActivity.class);
        intent.putExtra("title", "Les panneaux");
        intent.putExtra("color", R.color.redActionbar);
        startActivity(intent);
    }
}
