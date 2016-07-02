package com.octagen.freetestcode.custom.ActionBarWithText;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.octagen.freetestcode.R;

public class ActionBar extends RelativeLayout {

    Context context;
    ImageView Image;
    TextView Libelle;

    ActionBarListener Listener;

    ImageView Back;

    public ActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.MATCH_PARENT));

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View Layout = inflater.inflate(R.layout.action_bar_wt, null);

        Image = (ImageView) Layout.findViewById(R.id.Image);
        Back = (ImageView) Layout.findViewById(R.id.Back);
        Libelle = (TextView) Layout.findViewById(R.id.Libelle);

        Back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Listener != null) {
                    getListener().onReturnPressed();
                }
            }
        });

        addView(Layout);
    }

    public void setImage(int Source) {
        Image.setImageResource(Source);
    }

    public ActionBarListener getListener() {
        return this.Listener;
    }

    public ActionBar setListener(ActionBarListener Listener) {
        this.Listener = Listener;
        return this;
    }

    public void setLibelle(String Text) {
        Libelle.setText(Text);
    }

}
