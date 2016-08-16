package com.octagen.freetestcode.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.octagen.freetestcode.ui.dialogs.SettingsDialog;

/**
 * Created by Mohammed Aouf ZOUAG on 16/08/2016.
 */
public abstract class SettingsAbleActivity extends AppCompatActivity {
    public void onSettingsPressed(View view) {
        SettingsDialog settingsDialog = new SettingsDialog(this);
        settingsDialog.show();
    }
}
