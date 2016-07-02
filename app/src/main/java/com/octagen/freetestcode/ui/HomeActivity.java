package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.utils.CalculateScreenSize;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 01/07/2016.
 *
 * This is the main activity of the application, that shows the main menu.
 */
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

    /**
     * Invoked when an item is selected off the main menu.
     * @param view that was pressed
     */
    public void onMenuItemSelected(View view) {
        String title = "";
        @DrawableRes int image = -1;

        switch (view.getId()) {
            case R.id.motocycle:
                title = "Motocycle";
                image = R.drawable.ic_white_motocycle;
                break;
            case R.id.vehicle:
                title = "Véhicule";
                image = R.drawable.ic_vehicle;
                break;
            case R.id.camion:
                title = "Camion";
                image = R.drawable.ic_camion;
                break;
            case R.id.bus:
                title = "Bus";
                image = R.drawable.ic_bus;
                break;
        }

        Intent intent = new Intent(this, SeriesActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("image", image);
        startActivity(intent);
    }
}
