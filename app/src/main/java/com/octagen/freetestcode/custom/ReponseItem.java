package com.octagen.freetestcode.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.octagen.customviews.CustomCarreLayout;
import com.octagen.customviews.ScreenSize;
import com.octagen.customviews.ScreenSizeModel;
import com.octagen.freetestcode.R;

/**
 * Created by Ismail Amrani on 08/03/2016.
 */
public class ReponseItem extends RelativeLayout {

    int height, width;

    CustomCarreLayout Item;
    TextView NumQuestion, User, Correcte;

    int ID;

    public ReponseItem(final Context context, AttributeSet attrs) {
        super(context, attrs);

        ScreenSize size = new ScreenSize(context);
        ScreenSizeModel H = size.GetSize(1);
        height = H.getHEIGHT();
        width = H.getWIDTH();

        setLayoutParams(new LayoutParams(width * 44 / 144, height * 50 / 246));

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View Layout = inflater.inflate(R.layout.reponse_item, null);

        Item = (CustomCarreLayout) Layout.findViewById(R.id.Item);
        NumQuestion = (TextView) Layout.findViewById(R.id.NumQuestion);
        User = (TextView) Layout.findViewById(R.id.User);
        Correcte = (TextView) Layout.findViewById(R.id.Correcte);

        addView(Layout);
    }

    public void SetItemId(int Id) {
        this.ID = Id;
    }

    public void IsCorrect(String Q, String Reponse) {
        NumQuestion.setText(Q);
        Correcte.setText(Reponse);
        User.setText(Reponse);
        Item.setBackgroundResource(R.drawable.rep_valide);
    }

    public void Isfalse(String Q, String Valide, String user) {
        NumQuestion.setText(Q);
        Correcte.setText(Valide);
        User.setText(user);
        Item.setBackgroundResource(R.drawable.rep_faux);
    }

}
