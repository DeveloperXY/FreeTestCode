package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.utils.CalculateScreenSize;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @Bind(R.id.historyButton)
    Button historyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new CalculateScreenSize().calculateScreenSize(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Set the font of the history button
        historyButton.setTypeface(TypeFaces.getTypeFace(this, "fonts/cent.TTF"));
    }

    public void onMotocycle(View view) {
        startActivity(new Intent(this, MotocycleActivity.class));
    }
}
