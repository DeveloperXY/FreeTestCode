package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.SeriesAdapter;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBar;
import com.octagen.freetestcode.custom.ActionBarWithText.ActionBarListener;
import com.octagen.freetestcode.models.Serie;
import com.octagen.freetestcode.utils.decorations.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 02/07/2016.
 */
public class SeriesActivity extends AppCompatActivity implements ActionBarListener {

    @Bind(R.id.ActionBar)
    ActionBar mActionBar;

    @Bind(R.id.seriesRecyclerView)
    RecyclerView seriesRecyclerView;

    private SeriesAdapter mSeriesAdapter;
    private List<Serie> mSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series);
        ButterKnife.bind(this);

        setupActionBar();
        setupRecyclerView();
        populateRecyclerView();
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

    private void setupRecyclerView() {
        mSeries = new ArrayList<>();
        seriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        seriesRecyclerView.addItemDecoration(new SpacesItemDecoration(8));
    }

    private void populateRecyclerView() {
        mSeries.add(new Serie(1, "Serie 1", 39));
        mSeries.add(new Serie(2, "Serie 2", 37));
        mSeries.add(new Serie(3, "Serie 3", 25));
        mSeries.add(new Serie(4, "Serie 4", 26));

        if (mSeriesAdapter == null) {
            mSeriesAdapter = new SeriesAdapter(this, mSeries);
            seriesRecyclerView.setAdapter(mSeriesAdapter);
        }
        else
            mSeriesAdapter.animateTo(mSeries);
    }

    @Override
    public void onReturnPressed() {
        finish();
    }
}
