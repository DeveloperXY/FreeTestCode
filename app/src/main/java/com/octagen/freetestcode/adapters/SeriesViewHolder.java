package com.octagen.freetestcode.adapters;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    @Bind(R.id.startTestButton)
    Button startTestButton;
    @Bind(R.id.star1)
    ImageView star1;
    @Bind(R.id.star2)
    ImageView star2;
    @Bind(R.id.star3)
    ImageView star3;

    public SeriesViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        startTestButton.setTypeface(TypeFaces.getTypeFace(context, "fonts/cent.TTF"));
        ratingLabel.setTypeface(TypeFaces.getTypeFace(context, "fonts/cent.TTF"));
    }

    @Override
    public void bind(Serie item) {
        serieID.setText(item.getId() + "");
        serieLabel.setText(item.getLabel());

        int ratingValue = item.getRating();
        String rating = item.getRating() == 0 ? "../40" : String.format("%d/40", item.getRating());
        ratingLabel.setText(rating);

        if (ratingValue == 0)
            colorizeNone();
        else if (ratingValue < 30)
            colorizeRed();
        else if (ratingValue < 36)
            colorizeYellow();
        else
            colorizeGreen();
    }

    private void colorizeNone() {
        star1.setImageResource(R.drawable.ic_star_off);
        star2.setImageResource(R.drawable.ic_star_off);
        star3.setImageResource(R.drawable.ic_star_off);
    }

    private void colorizeRed() {
        star1.setImageResource(R.drawable.ic_red_star);
        star2.setImageResource(R.drawable.ic_red_star);
        star3.setImageResource(R.drawable.ic_red_star);
    }

    private void colorizeGreen() {
        star1.setImageResource(R.drawable.ic_green_star);
        star2.setImageResource(R.drawable.ic_green_star);
        star3.setImageResource(R.drawable.ic_green_star);
    }

    private void colorizeYellow() {
        star1.setImageResource(R.drawable.ic_yellow_star);
        star2.setImageResource(R.drawable.ic_yellow_star);
        star3.setImageResource(R.drawable.ic_yellow_star);
    }
}
