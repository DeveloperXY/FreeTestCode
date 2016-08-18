package com.octagen.freetestcode.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.base.BaseSearchAdapter;
import com.octagen.freetestcode.adapters.base.BinderViewHolder;
import com.octagen.freetestcode.models.PanelItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 18/08/2016.
 */
public class PanelAdapter extends BaseSearchAdapter<PanelAdapter.TopPanelHolder, PanelItem> {

    private Context mContext;

    public PanelAdapter(Context context, List<PanelItem> items) {
        super(context, items);
        mContext = context;
    }

    @Override
    public TopPanelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.panel_item_layout, parent, false);

        return new TopPanelHolder(v);
    }

    public class TopPanelHolder extends BinderViewHolder<PanelItem> {

        @Bind(R.id.signImage)
        ImageView signImage;

        public TopPanelHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(PanelItem item) {
            signImage.setImageResource(item.getImage());
        }
    }
}
