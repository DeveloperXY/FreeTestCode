package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.SeriesAdapter;
import com.octagen.freetestcode.models.Serie;
import com.octagen.freetestcode.utils.decorations.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 02/07/2016.
 */
public class SeriesActivity extends ActionbarActivity {

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

    private void setupRecyclerView() {
        mSeries = new ArrayList<>();
        seriesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        seriesRecyclerView.addItemDecoration(new SpacesItemDecoration(8));
    }

    private void populateRecyclerView() {
        mSeries.add(new Serie(1, "Serie 1", 0));
        mSeries.add(new Serie(2, "Serie 2", 37));
        mSeries.add(new Serie(3, "Serie 3", 31));
        mSeries.add(new Serie(4, "Serie 4", 26));

        if (mSeriesAdapter == null) {
            mSeriesAdapter = new SeriesAdapter(this, mSeries, actionbarColor);
            mSeriesAdapter.setSeriesListener(new SeriesAdapter.SeriesListener() {
                @Override
                public void onSerieSelected(int position) {
                    Intent intent = new Intent(SeriesActivity.this, SerieDetailsActivity.class);
                    intent.putExtra("color", actionbarColor);
                    intent.putExtra("image", actionbarImage);
                    intent.putExtra("category", actionbarTitle);
                    intent.putExtra("title", mSeries.get(position).getLabel());
                    startActivity(intent);
                }
            });
            seriesRecyclerView.setAdapter(mSeriesAdapter);
        } else
            mSeriesAdapter.animateTo(mSeries);
    }
}
