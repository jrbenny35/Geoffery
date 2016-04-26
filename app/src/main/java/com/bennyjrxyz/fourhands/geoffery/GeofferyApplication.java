package com.bennyjrxyz.fourhands.geoffery;

import android.app.Application;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by bennyjr on 4/25/16.
 */
public class GeofferyApplication extends Application {

    private SQLiteDatabase myDB;

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseHelper inventoryDB = new DatabaseHelper (this);
        myDB = inventoryDB.getWritableDatabase();

    }

    public boolean insertData(String itemName, String itemCalories, String itemPrice){


        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, itemName);
        contentValues.put(DatabaseHelper.COL_3, itemCalories);
        contentValues.put(DatabaseHelper.COL_4, itemPrice);

        long result = myDB.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

        Log.d("Inventory DB", "Inserted record" +itemName +  itemCalories + itemPrice);

        if(result == -1)
            return false;
        else
            return true;

    }

}
