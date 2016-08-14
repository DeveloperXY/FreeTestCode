package com.octagen.freetestcode.adapters;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.TextView;

import com.octagen.customviews.TypeFaces;
import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.base.BinderViewHolder;
import com.octagen.freetestcode.models.Serie;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 02/07/2016.
 */
public class SeriesViewHolder extends BinderViewHolder<Serie> {

    @Bind(R.id.serieID)
    TextView serieID;
    @Bind(R.id.serieLabel)
    TextView serieLabel;
    @Bind(R.id.ratingLabel)
    TextView ratingLabel;

    private SeriesAdapter.SeriesListener mListener;
    private Context mContext;
    @ColorRes private int actionbarColor;

    public SeriesViewHolder(View itemView, Context context,
                            SeriesAdapter.SeriesListener listener,
                            @ColorRes int actionbarColor) {
        super(itemView);
        mListener = listener;
        mContext = context;
        this.actionbarColor = actionbarColor;
        ButterKnife.bind(this, itemView);

        ratingLabel.setTypeface(TypeFaces.getTypeFace(context, "fonts/cent.TTF"));

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null)
                    mListener.onSerieSelected(getAdapterPosition());
            }
        });
    }

    @Override
    public void bind(Serie item) {
        serieID.setText(item.getId() + "");
        serieLabel.setText(item.getLabel());

        String rating = item.getRating() == 0 ? "../40" : String.format("%d/40", item.getRating());
        ratingLabel.setText(rating);

        @DrawableRes int drawable = -1;
        switch (actionbarColor) {
            case R.color.redActionbar:
                drawable = R.drawable.red_ellipse;
                break;
            case R.color.yellowActionbar:
                drawable = R.drawable.yellow_ellipse;
                break;
        }

        serieID.setBackgroundDrawable(
                mContext.getResources().getDrawable(drawable));
    }
}
