package com.example.contactexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbContact extends SQLiteOpenHelper {

    public static String dbName="MyDbContact.db";
    public static String TABLE_NAME="contact";
    public static String col1="name";
    public static String col2="gender";
    public static String col3="number";
    public static String col4="picture";



    public MyDbContact(Context c){
        super(c,dbName,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table " + TABLE_NAME + "(" +col1+" TEXT,"+col2+" TEXT,"+col3+" text primary key ,"+col4+" integer)";
        sqLiteDatabase.execSQL(sql);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql= "DROP TABLE " + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public static long insert_contact(SQLiteDatabase sqLiteDatabase, Contact c){
        ContentValues ct = new ContentValues();
        ct.put(col1,c.getName());
        ct.put(col2,c.getGender());
        ct.put(col3,c.getNumber());
        ct.put(col4,c.getPicture());
        return sqLiteDatabase.insert(TABLE_NAME,null,ct);
    }

    public static ArrayList<Contact> getAllcontacts(SQLiteDatabase sqLiteDatabase){
        ArrayList<Contact> cts = new ArrayList<>();

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        while(cur.moveToNext()){
            Contact c = new Contact();
            c.setName(cur.getString(0));
            c.setGender(cur.getString(1));
            c.setNumber(cur.getString(2));
            c.setPicture(cur.getInt(3));
            cts.add(c);
        }

        return cts;
    }

    public static Contact getOnecontact(SQLiteDatabase sqLiteDatabase, String number){
        Contact c = null;

        Cursor cur = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE number = " + number,null);

        if(cur.moveToNext()){
            c = new Contact();
            c.setName(cur.getString(0));
            c.setGender(cur.getString(1));
            c.setNumber(cur.getString(2));
            c.setPicture(cur.getInt(3));
        }

        return c;
    }




}
