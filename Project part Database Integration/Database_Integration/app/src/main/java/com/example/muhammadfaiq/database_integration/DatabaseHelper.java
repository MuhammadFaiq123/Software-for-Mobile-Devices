package com.example.muhammadfaiq.database_integration;

/**
 * Created by Muhammad Faiq on 10/13/2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String TAG = "DatabaseHelper";

    //Userinfo Table
    private static final String DATABASE_NAME = "Userinfo.db";
    private static final String TABLE_NAME = "Userinfo";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_PASSWORD = "password";


    // Timeline Table
    private static final String TABLE_NAME_2 = "Timeline";
    private static final String COLUMN_ID_2 = "id";
    private static final String COLUMN_MESSAGE = "message";

    SQLiteDatabase db;


    private static final String TABLE_CREATE = "create table Userinfo(id integer primary key not null , " +
            "name text not null , password text not null);";
    private static final String TABLE_CREATE_2 = "create table Timeline(id integer primary key not null , " +
            "message text not nul);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE_2);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.w(TAG, "upgrading database from version" + i + " to " + i1);
        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);


        String query2 = "DROP TABLE IF EXISTS " + TABLE_NAME_2;
        db.execSQL(query2);
        this.onCreate(db);
    }

    //User related Functions

    public void insertUser(UserInfo obj) {
        db = this.getWritableDatabase();
        ContentValues Values = new ContentValues();

        String query = "select * from Userinfo";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        Values.put(COLUMN_ID, count);
        Values.put(COLUMN_NAME, obj.getName());
        Values.put(COLUMN_PASSWORD, obj.getPassword());

        db.insert(TABLE_NAME, null, Values);
        db.close();

    }

    public String searchPassword(String name) {
        db = this.getReadableDatabase();
        String query = "select name, password from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String temp_username;
        String temp_pasword;
        temp_pasword = "not found";
        if (cursor.moveToFirst()) {
            do {
                temp_username = cursor.getString(0);

                if (temp_username.equals(name)) {
                    temp_pasword = cursor.getString(1);
                    break;
                }

            }
            while (cursor.moveToNext());
        }
        return temp_pasword;
    }

// Timeline Related Functions

    public List<String> getMessages()
    {
        List<String> userList = new ArrayList<String>();

        userList.add("* Ahmad majid send you a dare 'Send me a picture of you childhood.' ");
        userList.add("* Hamza usman responded to your activity ..  ");
        userList.add("* Abu talha send you a dare 'Tell me your nick name' ");
        userList.add("* Mansoor hassan answered to your dare.");
        userList.add("* Zain zaheer answered to your dare");

        return userList;
    }


}

