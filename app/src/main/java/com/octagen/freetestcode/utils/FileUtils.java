package com.octagen.freetestcode.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mohammed Aouf ZOUAG on 05/07/2016.
 */
public class FileUtils {
    public static String loadJSONFromAsset(Context context, String filename) {
        String json;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
