package com.bennyjrxyz.fourhands.geoffery;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by bennyjr on 4/25/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "Inventory.db";
    public static final String TABLE_NAME = "food_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "ITEM_NAME";
    public static final String COL_3 = "ITEM_CALORIES";
    public static final String COL_4 = "ITEM_PRICE";
    public static final String COL_5 = "DAILY_USAGE";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table" + TABLE_NAME + "( ID PRIMARY KEY AUTOINCREMENT, ITEM_NAME TEXT, ITEM_CALORIES INTEGER, ITEM_PRICE VARCHAR, DAILY_USAGE INTEGER )");
        Log.d("Database", "Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
