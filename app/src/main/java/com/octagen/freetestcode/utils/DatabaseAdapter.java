package com.octagen.freetestcode.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.octagen.freetestcode.models.HistoryItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ismail Amrani on 11/03/2016.
 */
public class DatabaseAdapter extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HISTORIQUE";

    private static final String TABLE = "HISTORIQUE";
    private static final String KEY_ID = "ID";
    private static final String JSON = "JSON";

    public DatabaseAdapter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_HISTORIQUE_TABLE = "CREATE TABLE " + TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + JSON + " TEXT" + ")";
        db.execSQL(CREATE_HISTORIQUE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);

    }

    public void AddHistorique(String json) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(JSON, json);

        db.insert(TABLE, null, values);
        db.close();
    }

    public String GetLastHistorique() {
        int count;
        String countQuery = "SELECT  * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor CursorCount = db.rawQuery(countQuery, null);
        count = CursorCount.getCount();
        CursorCount.close();

        Cursor cursor = db.query(TABLE, new String[]{KEY_ID, JSON}, KEY_ID + "=?",
                new String[]{String.valueOf(count)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        return cursor.getString(1);
    }

    public List<HistoryItem> getAllHistoryRecords() {
        List<HistoryItem> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE,
                new String[]{KEY_ID, JSON}, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                try {
                    JSONObject data = new JSONObject(cursor.getString(1));

                    itemList.add(new HistoryItem(
                            id,
                            data.getInt("image"),
                            data.getString("time"),
                            data.getString("date"),
                            data.getString("category"),
                            data.getString("serie"),
                            data.getString("ratio")
                    ));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } while (cursor.moveToNext());
        }

        return itemList;
    }
}
