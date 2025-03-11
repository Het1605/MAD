package com.tcs.college_project;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Orders.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "SelectedItems";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "item_name";
    private static final String COLUMN_COUNT = "item_count";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE orders (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "item_name TEXT, item_email TEXT, item_image INTEGER, item_count INTEGER)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert selected item
    public void insertOrder(String name, String email, int image, int count) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("item_name", name);
        values.put("item_email", email);
        values.put("item_image", image);
        values.put("item_count", count);
        db.insert("orders", null, values);
        db.close();
    }

    // Retrieve all selected items
    public List<String> getAllItems() {
        List<String> itemsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                String itemName = cursor.getString(1);
                int itemCount = cursor.getInt(2);
                itemsList.add(itemName + " - " + itemCount);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return itemsList;
    }
}