package com.octagen.freetestcode.ui;

import android.os.Bundle;
import android.util.Log;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.models.HistoryItem;
import com.octagen.freetestcode.utils.DatabaseAdapter;

import java.util.List;

public class HistoryActivity extends ActionbarActivity {

    private DatabaseAdapter mDatabaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mDatabaseAdapter = new DatabaseAdapter(this);
        List<HistoryItem> historyItems = mDatabaseAdapter.getAllHistoryRecords();
        Log.i("HISTORY", historyItems + "");
    }
}
