package com.octagen.freetestcode.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.utils.CalculateScreenSize;

import butterknife.ButterKnife;

/**
 * Created by Mohammed Aouf ZOUAG on 02/08/2016.
 */
public class SettingsDialog extends Dialog {

    private Context context;

    public SettingsDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settings_dialog);
        ButterKnife.bind(this);

        setupWindow();
    }

    private void setupWindow() {
        Point point = new Point();
        new CalculateScreenSize().calculateScreenSize(context, point);
        getWindow().setLayout((int) (point.x - point.x * 0.1), (int) (point.y - point.y * 0.5));
    }
}
