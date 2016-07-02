package com.octagen.freetestcode.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.base.BaseSearchAdapter;
import com.octagen.freetestcode.adapters.base.BinderViewHolder;
import com.octagen.freetestcode.models.Serie;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 02/07/2016.
 */
public class SeriesAdapter extends BaseSearchAdapter<SeriesAdapter.ViewHolder, Serie> {

    public SeriesAdapter(Context context, List<Serie> items) {
        super(context, items);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.serie_item_layout, parent, false);

        return new ViewHolder(v);
    }

    public class ViewHolder extends BinderViewHolder<Serie> {

        @Bind(R.id.serieID)
        TextView serieID;
        @Bind(R.id.serieLabel)
        TextView serieLabel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(Serie item) {
            serieID.setText(item.getId() + "");
            serieLabel.setText(item.getLabel());
        }
    }
}