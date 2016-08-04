package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBar;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBarListener;

import butterknife.Bind;

/**
 * Created by Mohammed Aouf ZOUAG on 04/07/2016.
 */
public abstract class ActionbarActivity extends AppCompatActivity
        implements ActionBarListener {

    @Bind(R.id.ActionBar)
    protected ActionBar mActionBar;

    @ColorRes
    protected int actionbarColor;
    @DrawableRes
    protected int actionbarImage;
    protected String actionbarTitle;

    @Override
    public void onReturnPressed() {
        finish();
    }

    protected void setupActionBar() {
        Intent intent = getIntent();
        actionbarColor = intent.getIntExtra("color", -1);
        actionbarImage = intent.getIntExtra("image", -1);
        actionbarTitle = intent.getStringExtra("title");

        if (actionbarColor == -1) {
            throw new IllegalArgumentException(
                    "You need to pass a color for the custom action bar.");
        }

        mActionBar.setListener(this);
        mActionBar.setLibelle(actionbarTitle);
        mActionBar.setColor(actionbarColor);

        if (actionbarImage != -1)
            mActionBar.setImage(actionbarImage);
        else
            mActionBar.hideImage();
    }
}
