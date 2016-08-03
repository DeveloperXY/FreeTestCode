package com.octagen.freetestcode.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.base.BaseSearchAdapter;
import com.octagen.freetestcode.adapters.base.BinderViewHolder;
import com.octagen.freetestcode.models.HistoryItem;

import java.util.List;

/**
 * Created by Mohammed Aouf ZOUAG on 03/08/2016.
 */
public class HistoryAdapter extends BaseSearchAdapter<HistoryAdapter.HistoryViewHolder, HistoryItem> {

    private Context mContext;

    public HistoryAdapter(Context context, List<HistoryItem> items) {
        super(context, items);
        mContext = context;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item_layout, parent, false);

        return new HistoryViewHolder(v);
    }

    public class HistoryViewHolder extends BinderViewHolder<HistoryItem> {

        public HistoryViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(HistoryItem item) {
            
        }
    }
}
