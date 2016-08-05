package com.octagen.freetestcode.adapters;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.base.BaseSearchAdapter;
import com.octagen.freetestcode.adapters.base.BinderViewHolder;
import com.octagen.freetestcode.models.HistoryItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 03/08/2016.
 */
public class HistoryAdapter extends BaseSearchAdapter<HistoryAdapter.HistoryViewHolder, HistoryItem> {

    private Context mContext;
    private HistoryListener mHistoryListener;

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

        @Bind(R.id.historyImg)
        ImageView historyImg;
        @Bind(R.id.timeLabel)
        TextView timeLabel;
        @Bind(R.id.dateLabel)
        TextView dateLabel;
        @Bind(R.id.categoryLabel)
        TextView categoryLabel;
        @Bind(R.id.serieLabel)
        TextView serieLabel;
        @Bind(R.id.ratioLabel)
        TextView ratioLabel;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mHistoryListener != null) {
                        mHistoryListener.onItemSelected(
                                mItems.get(getAdapterPosition()),
                                new Pair<View, String>(historyImg, "catImgAnim"),
                                new Pair<View, String>(serieLabel, "serieAnim"),
                                new Pair<View, String>(ratioLabel, "ratioAnim"));
                    }
                }
            });
        }

        @Override
        public void bind(HistoryItem item) {
            historyImg.setImageResource(item.getImage());
            timeLabel.setText(item.getTime());
            dateLabel.setText(item.getDate());
            categoryLabel.setText(item.getCategory());
            serieLabel.setText(item.getSerie());
            ratioLabel.setText(item.getRatio());
        }
    }

    public void setHistoryListener(HistoryListener historyListener) {
        mHistoryListener = historyListener;
    }

    public interface HistoryListener {
        void onItemSelected(HistoryItem item, Pair<View, String>... animatedViews);
    }
}
