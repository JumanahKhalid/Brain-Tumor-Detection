package com.example.app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public DBHelper(Context context) {
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table users(name TEXT, email TEXT PRIMARY KEY,  pass TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //drop older table
        db.execSQL("drop table if exists users");
        onCreate(db);
    }

    //three methods used for Sign in and Sign up

    // 1. insert new user (Sign Up)
    public boolean insertUser(String name, String email, String pass){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("email", email);
        values.put("pass", pass);

        long res = db.insert("users", null, values);

        if (res == -1)
            return false;
        else
            return true;
    }

    //2. check if the user is in the system already or he/she need to sign up first
    public boolean checkUser(String email){
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Users where email = ?", new String[] {email});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    //3. check the user sign in information (if the email match the password or not)
    public boolean checkUserInfo(String email, String pass){
        db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from Users where email = ? and pass = ? ", new String[] {email,pass});

        if (cursor.getCount() > 0) //if there actually a user or not
            return true;
        else
            return false;
    }

    //4. get the name of the user to display it in the screen (by sharedPreference)
    @SuppressLint("Range")
    public String getName(String email){
        String user_name = null;
        db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("select * from users where email = ? ", new String[] {email});

        if (cursor.moveToFirst())
            do {
                user_name = cursor.getString(cursor.getColumnIndex("name"));
            }while(cursor.moveToNext());

        return user_name;
    }


}