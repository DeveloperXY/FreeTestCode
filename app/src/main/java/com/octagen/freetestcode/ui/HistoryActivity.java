package com.octagen.freetestcode.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.HistoryAdapter;
import com.octagen.freetestcode.models.HistoryItem;
import com.octagen.freetestcode.utils.DatabaseAdapter;
import com.octagen.freetestcode.utils.decorations.SpacesItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HistoryActivity extends ActionbarActivity {

    @Bind(R.id.historyRecyclerView)
    RecyclerView historyRecyclerView;

    private List<HistoryItem> mHistoryItems;
    private DatabaseAdapter mDatabaseAdapter;
    private HistoryAdapter mHistoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        mDatabaseAdapter = new DatabaseAdapter(this);

        setupActionBar();
        setupRecyclerView();
        populateRecyclerView();
    }

    private void setupRecyclerView() {
        mHistoryItems = mDatabaseAdapter.getAllHistoryRecords();
        Log.i("HISTORY", mHistoryItems + "");
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        historyRecyclerView.addItemDecoration(new SpacesItemDecoration(8));
    }

    private void populateRecyclerView() {
        if (mHistoryAdapter == null) {
            mHistoryAdapter = new HistoryAdapter(this, mHistoryItems);
            mHistoryAdapter.setHistoryListener(new HistoryAdapter.HistoryListener() {
                @Override
                public void onItemSelected(HistoryItem item) {
                    Intent intent = new Intent(HistoryActivity.this, ResultsActivity.class);
                    intent.putExtra("historyID", item.getId());
                    intent.putExtra("color", actionbarColor);
                    intent.putExtra("image", item.getImage());
                    intent.putExtra("title", item.getSerie());
                    startActivity(intent);
                }
            });
            historyRecyclerView.setAdapter(mHistoryAdapter);
        } else
            mHistoryAdapter.animateTo(mHistoryItems);
    }
}
