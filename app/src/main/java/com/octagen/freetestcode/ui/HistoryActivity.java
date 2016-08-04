package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.util.Log;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.models.HistoryItem;
import com.octagen.freetestcode.utils.DatabaseAdapter;

import java.util.List;

import butterknife.ButterKnife;

public class HistoryActivity extends ActionbarActivity {

    private List<HistoryItem> mHistoryItems;
    private DatabaseAdapter mDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ButterKnife.bind(this);

        setupActionBar();

        mDatabaseAdapter = new DatabaseAdapter(this);
        mHistoryItems = mDatabaseAdapter.getAllHistoryRecords();
        Log.i("HISTORY", mHistoryItems + "");
    }
}
