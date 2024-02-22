package com.example.retrofit_fetchdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class mydatabaseHalper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;

    // Define your table and column names
    private static final String TABLE_NAME = "login_table";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    private static final String CREATE_TABLE =
            "CREATE TABLE if not exists " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT," + COLUMN_EMAIL + " TEXT," + COLUMN_PASSWORD + " TEXT);";

    public mydatabaseHalper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertdata(String name,String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("email",email);
        values.put("password",password);
        long newRowId = db.insert("login_table", null, values);

        if (newRowId != -1) {
            return false;
        } else {
           return true;
        }
    }

    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;


    }
}
