package com.octagen.freetestcode.adapters;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.base.BaseSearchAdapter;
import com.octagen.freetestcode.models.Serie;

import java.util.List;

/**
 * Created by Mohammed Aouf ZOUAG on 02/07/2016.
 */
public class SeriesAdapter extends BaseSearchAdapter<SeriesViewHolder, Serie> {

    private Context mContext;
    private SeriesListener mListener;
    @ColorRes private int actionbarColor;

    public SeriesAdapter(Context context, List<Serie> items, @ColorRes int actionbarColor) {
        super(context, items);
        mContext = context;
        this.actionbarColor = actionbarColor;
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.serie_item_layout, parent, false);

        return new SeriesViewHolder(v, mContext, mListener, actionbarColor);
    }

    public void setSeriesListener(SeriesListener listener) {
        mListener = listener;
    }

    public interface SeriesListener {
        void onSerieSelected(int position);
    }
}
