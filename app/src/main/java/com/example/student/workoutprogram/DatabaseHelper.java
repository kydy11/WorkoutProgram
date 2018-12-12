package com.example.student.workoutprogram;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DBNAME ="Routine.db";
    public static final String TBNAME ="routine_table";
    public static final String RNAME ="RNAME";




    public DatabaseHelper( Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table IF NOT EXISTS "+ TBNAME +" (RNAME TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBNAME);
        onCreate(db);

    }

    public boolean insertData(String routineName){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RNAME, routineName);
        long result = db.insert(TBNAME, null, contentValues);
        if (result == -1) {
            return false;
        }else{
            return true;
        }

    }
}
